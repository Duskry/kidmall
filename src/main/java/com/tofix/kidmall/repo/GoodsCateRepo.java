package com.tofix.kidmall.repo;

import com.tofix.kidmall.entity.Goods;
import com.tofix.kidmall.entity.GoodsCate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/
public interface GoodsCateRepo extends JpaRepository<GoodsCate, String> {

    /**
     * 寻找类别名
     *
     * @param cateName
     * @return
     */
    GoodsCate findGoodsCateByCateName(String cateName);

    Set<GoodsCate> findByGoods(Goods goods);

}
