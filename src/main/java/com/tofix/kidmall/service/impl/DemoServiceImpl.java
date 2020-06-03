package com.tofix.kidmall.service.impl;

import com.tofix.kidmall.common.CommonPage;
import com.tofix.kidmall.common.CommonResult;
import com.tofix.kidmall.entity.Demo;
import com.tofix.kidmall.exception.ApiExcetion;
import com.tofix.kidmall.repo.DemoRepo;
import com.tofix.kidmall.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author duskry ren
 * @description 服务层 ，组合dao层  就是repo的代码 产生事务控制   编写原则，申明式事务控制，必要回滚一定要手动回滚
 * @date 2020/6/1
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class DemoServiceImpl implements DemoService {

    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    DemoRepo demoRepo;


    @Override
    @Cacheable(cacheNames = "demo")
    public Optional<Demo> getById(String id) {
        return demoRepo.findById(id);
    }

    @Override
    public Demo insertDemo(Demo demo) {
        return demoRepo.save(demo);
    }

    @Override
    public void deleteDemo(String id) throws ApiExcetion {
        try {
            demoRepo.deleteById(id);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ApiExcetion("没有该主键");
        }
    }

    @Override
    public Demo saveDemo(Demo demo) {
        return demoRepo.save(demo);
    }

    @Override
    public CommonPage<Demo> getAllByPage(Integer currentPage, Integer pageSize) {
        return CommonPage.restPage(demoRepo.findAll(PageRequest.of(currentPage, pageSize)));
    }

    @Override
    public CommonResult<List<Demo>> getAll() {
        return CommonResult.success(demoRepo.findAll());
    }
}
