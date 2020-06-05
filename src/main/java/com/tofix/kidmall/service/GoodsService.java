package com.tofix.kidmall.service;

import com.tofix.kidmall.entity.Goods;
import org.springframework.data.domain.Page;

public interface GoodsService {

    Goods getGoods(String id);

    /**
     * 添加商品
     *
     * @param goods
     * @return goods
     */
    Goods addGoods(Goods goods);

    /**
     * 删除商品
     *
     * @param id
     * @return 1 成功 0 失败
     */
    Integer deleteGoods(String id);

    /**
     * 更新商品 更新商品只能更新固有属性，不能更改类型 和 资源
     *
     * @param goods
     * @return 更新后的商品
     */
    Goods updateGoods(Goods goods);

    /**
     * 分页获取商品
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<Goods> getGoodsListByPage(Integer currentPage, Integer pageSize);
}
