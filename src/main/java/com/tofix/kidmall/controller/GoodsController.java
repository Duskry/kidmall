package com.tofix.kidmall.controller;

import com.tofix.kidmall.common.CommonPage;
import com.tofix.kidmall.common.CommonResult;
import com.tofix.kidmall.entity.Goods;
import com.tofix.kidmall.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/5
 **/
@RestController
@RequestMapping("/goods")
@Api(tags = "商品添加 api展示")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Autowired
    GoodsService goodsService;


    @GetMapping("/{id}")
    @ApiOperation("根据id获得一个商品的信息")
    CommonResult<Goods> getGoods(@PathVariable String id) {
        return CommonResult.success(goodsService.getGoods(id));
    }

    @PostMapping("")
    @ApiOperation("添加一个商品")
    CommonResult<Goods> addGoods(@RequestBody Goods goods) {
        return CommonResult.success(goodsService.addGoods(goods));
    }

    @PutMapping("/{id}")
    @ApiOperation("更新一个商品的基本信息")
    CommonResult<Goods> updateGoods(@PathVariable String id, @RequestBody Goods goods) {
        goods.setGoodsId(id);
        return CommonResult.success(goodsService.updateGoods(goods));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除一个商品")
    CommonResult<Goods> deleteGoods(@PathVariable String id) {
        Integer code = goodsService.deleteGoods(id);
        if (code == 1) {
            return CommonResult.success();
        } else {
            return CommonResult.failed("没有找到该商品或其他");
        }
    }

    @GetMapping("/allbypage")
    CommonResult<CommonPage<Goods>> getallByPage(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonResult.success(CommonPage.restPage(goodsService.getGoodsListByPage(currentPage, pageSize)));
    }
}
