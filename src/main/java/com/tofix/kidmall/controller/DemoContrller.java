package com.tofix.kidmall.controller;

import com.tofix.kidmall.common.CommonPage;
import com.tofix.kidmall.common.CommonResult;
import com.tofix.kidmall.entity.Demo;
import com.tofix.kidmall.exception.ApiExcetion;
import com.tofix.kidmall.service.DemoService;
import com.tofix.kidmall.service.impl.DemoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author duskry ren
 * @description Controller 编写示范
 * @date 2020/6/1
 **/
@RestController()
@Api(tags = "DemoController api展示")
@RequestMapping("/demo")
public class DemoContrller {
    Logger logger = LoggerFactory.getLogger(DemoContrller.class);

    @Autowired
    DemoService demoService;

    @ApiOperation("根据id获取demo")
    @GetMapping("/{id}")
    CommonResult<Demo> getById(@PathVariable String id) {
        return CommonResult.success(demoService.getById(id).orElseGet(Demo::new));
    }

    @ApiOperation("添加一个demo")
    @PostMapping("")
    CommonResult<Demo> insertDemo(@RequestBody Demo demo) {
        return CommonResult.success(demoService.insertDemo(demo));
    }

    @ApiOperation("根据id删除一个demo")
    @DeleteMapping("/{id}")
    CommonResult deleteDemo(@PathVariable String id) {
        try {
            demoService.deleteDemo(id);
            return CommonResult.success();
        } catch (ApiExcetion excetion) {
            logger.debug("delete demo/" + id + "error");
            CommonResult.failed("删除组件错误");
        }
        return CommonResult.failed();
    }

    @ApiOperation("更新一个demo")
    @PutMapping("/{id}")
    CommonResult<Demo> updatedemo(@PathVariable String id, @RequestBody Demo demo) {
        demo.setDemoId(id);
        return CommonResult.success(demoService.saveDemo(demo));
    }

    @ApiOperation("获取全部demo")
    @GetMapping("/all")
    CommonResult<List<Demo>> getAll() {
        return demoService.getAll();
    }

    /**
     * 简单的分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation("分页获取demo")
    @GetMapping("/allbypage")
    CommonResult<CommonPage<Demo>> getAllByPage(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        return CommonResult.success(demoService.getAllByPage(currentPage, pageSize));
    }
}
