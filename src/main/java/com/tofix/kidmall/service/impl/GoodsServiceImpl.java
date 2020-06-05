package com.tofix.kidmall.service.impl;

import com.tofix.kidmall.entity.Goods;
import com.tofix.kidmall.entity.GoodsCate;
import com.tofix.kidmall.entity.Source;
import com.tofix.kidmall.repo.GoodsCateRepo;
import com.tofix.kidmall.repo.GoodsRepo;
import com.tofix.kidmall.repo.SourceRepo;
import com.tofix.kidmall.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsCateRepo goodsCateRepo;
    @Autowired
    private GoodsRepo goodsRepo;
    @Autowired
    private SourceRepo sourceRepo;

    @Override
    public Goods getGoods(String id) {
        Optional<Goods> byId = goodsRepo.findById(id);
        return byId.orElseGet(Goods::new);
    }

    @Override
    public Goods addGoods(Goods goods) {
        // 添加一个商品首先把商品的所有资源添加上去
        Set<Source> sourceSet = goods.getSourceSet();
        sourceSet.forEach(source -> {
            source.setGoods(goods);
        });
        Set<GoodsCate> goodsCateSet = goods.getGoodsCateSet();

        goodsCateSet.forEach(goodsCate -> {
            GoodsCate serach = goodsCateRepo.findGoodsCateByCateName(goodsCate.getCateName());
            // 库里有这个类别
            if (serach != null) {
                goodsCate.setCateId(serach.getCateId());
            }
            goodsCate.getGoods().add(goods);
        });
        goodsRepo.save(goods);
        sourceSet.forEach(source -> sourceRepo.save(source));
        goodsCateSet.forEach(goodsCate -> goodsCateRepo.save(goodsCate));
        return goods;
    }

    @Override
    public Integer deleteGoods(String id) {
        Optional<Goods> byId = goodsRepo.findById(id);
        if (byId.isPresent()) {
            goodsRepo.deleteById(byId.get().getGoodsId());
            return 1;
        } else {
            logger.debug(id + "删除失败没有该id或者其他");
            return 0;
        }
    }

    @Override
    public Goods updateGoods(Goods goods) {
        Optional<Goods> byId = goodsRepo.findById(goods.getGoodsId());
        if (byId.isPresent()) {
            Goods save = goodsRepo.save(goods);
            return save;
        } else {
            logger.debug(goods.toString() + "更新失败没有该id或者其他");
            return null;
        }
    }

    @Override
    public Page<Goods> getGoodsListByPage(Integer currentPage, Integer pageSize) {
        return goodsRepo.findAll(PageRequest.of(currentPage, pageSize));
    }
}
