package com.tofix.kidmall.controller;

import com.tofix.kidmall.common.CommonPage;
import com.tofix.kidmall.common.CommonResult;
import com.tofix.kidmall.entity.Demo;
import com.tofix.kidmall.exception.ApiExcetion;
import com.tofix.kidmall.service.DemoService;
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
@RequestMapping("/demo")
public class DemoContrller {
    Logger logger = LoggerFactory.getLogger(DemoContrller.class);

    @Autowired
    DemoService demoService;

    @GetMapping("/{id}")
    CommonResult<Demo> getById(@PathVariable Integer id) {
        return CommonResult.success(demoService.getById(id).orElseGet(Demo::new));
    }

    @PostMapping("/")
    CommonResult<Demo> insertDemo(@RequestBody Demo demo) {
        return CommonResult.success(demoService.insertDemo(demo));
    }

    @DeleteMapping("/{id}")
    CommonResult deleteDemo(@PathVariable Integer id) {
        try {
            demoService.deleteDemo(id);
            return CommonResult.success();
        } catch (ApiExcetion excetion) {
            logger.debug("delete demo/" + id + "error");
            CommonResult.failed("删除组件错误");
        }
        return CommonResult.failed();
    }

    @PutMapping("/{id}")
    CommonResult<Demo> updatedemo(@PathVariable Integer id, @RequestBody Demo demo) {
        //demo.setDemoId(id);
        return CommonResult.success(demoService.saveDemo(demo));
    }

    @GetMapping("/all")
    CommonResult<List<Demo>> getAll() {
        return demoService.getall();
    }

    /**
     * 简单的分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/allbypage")
    CommonResult<CommonPage<Demo>> getAllByPage(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        return CommonResult.success(demoService.getAllByPage(currentPage, pageSize));
    }
}
