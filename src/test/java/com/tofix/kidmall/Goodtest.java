package com.tofix.kidmall;

import com.tofix.kidmall.entity.Goods;
import com.tofix.kidmall.entity.GoodsCate;
import com.tofix.kidmall.entity.Source;
import com.tofix.kidmall.repo.GoodsCateRepo;
import com.tofix.kidmall.repo.GoodsRepo;
import com.tofix.kidmall.repo.SourceRepo;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/
@SpringBootTest
public class Goodtest {

    @Autowired
    GoodsRepo goodsRepo;
    @Autowired
    GoodsCateRepo goodsCateRepo;

    @Autowired
    SourceRepo sourceRepo;

    @Test
    void test() {
        Goods goods = new Goods();
        goods.setGoodsName("好东55");

//        Source source = new Source();
//        source.setSourceName("big");
//        Source source1 = new Source();
//        source1.setSourceName("smamll");
//        source.setGoods(goods);
//        source1.setGoods(goods);


//        GoodsCate goodsCate = new GoodsCate();
//        goodsCate.setCateName("水果");
//        goodsCate.getGoods().add(goods);

        GoodsCate goodsCate = goodsCateRepo.findGoodsCateByCateName("水果");
        if (goodsCate != null) {
            goodsCate.getGoods().add(goods);
        } else {
            goodsCate = new GoodsCate();
            goodsCate.setCateName("水果");
            goodsCate.getGoods().add(goods);
        }

        GoodsCate goodsCate1 = goodsCateRepo.findGoodsCateByCateName("蔬菜");

        if (goodsCate1 != null) {
            goodsCate1.getGoods().add(goods);
        } else {
            goodsCate1 = new GoodsCate();
            goodsCate1.setCateName("水果");
            goodsCate1.getGoods().add(goods);
        }

        goodsRepo.save(goods);
        //        sourceRepo.save(source1);
        goodsCateRepo.save(goodsCate);
        goodsCateRepo.save(goodsCate1);


        /** source 引用了 goods 所以一定要先有goods才能插入 source
         *
         */
//        sourceRepo.save(source);

    }
}
