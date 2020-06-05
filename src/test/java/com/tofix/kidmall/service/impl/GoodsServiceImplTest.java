package com.tofix.kidmall.service.impl;

import com.tofix.kidmall.entity.Goods;
import com.tofix.kidmall.entity.GoodsCate;
import com.tofix.kidmall.entity.Source;
import com.tofix.kidmall.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsServiceImplTest {

    @Autowired
    GoodsService goodsService;

    @Test
    void getGoods() {
        Goods goods = goodsService.getGoods("402880e5728412d601728412e2d90000");
        System.out.println(goods);
        System.out.println(goods.getGoodsCateSet());
        System.out.println(goods.getSourceSet());
    }

    @Test
    void addGoods() {
        Goods goods = new Goods();
        goods.setGoodsName("小商品4");

        GoodsCate for1 = new GoodsCate();
        for1.setCateName("裤子");
        GoodsCate for2 = new GoodsCate();
        for2.setCateName("头巾");

        goods.getGoodsCateSet().add(for1);
        goods.getGoodsCateSet().add(for2);

        Source source1 = new Source();
        source1.setSourceName("img1");
        Source source2 = new Source();
        source2.setSourceName("mp44");

        goods.getSourceSet().add(source1);
        goods.getSourceSet().add(source2);

        Goods goods1 = goodsService.addGoods(goods);
        System.out.println(goods1);
    }

    @Test
    void delete() {
        String id = "402880e57283faab017283fab79e0000";
        System.out.println("goodsService.deleteGoods(id) = " + goodsService.deleteGoods(id));
    }

    @Test
    void update() {
        Goods goods = new Goods();
        goods.setGoodsId("402880e5728412d601728412e2d90000");
        goods.setGoodsName("大商品");
        GoodsCate goodsCate = new GoodsCate();
        goodsCate.setCateName("裤子");
        // goods.getGoodsCateSet().add(goodsCate);

        goodsService.updateGoods(goods);
    }
}