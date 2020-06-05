package com.tofix.kidmall.service;


import com.tofix.kidmall.common.CommonPage;
import com.tofix.kidmall.common.CommonResult;
import com.tofix.kidmall.entity.Demo;
import com.tofix.kidmall.exception.ApiExcetion;

import java.util.List;
import java.util.Optional;

public interface DemoService {

    /**
     * 获取demo  查询失败是返回null
     *
     * @param id
     * @return
     */
    Optional<Demo> getById(String id);

    /**
     * 添加demo
     *
     * @return demo
     */
    Demo insertDemo(Demo demo);

    /**
     * 删除 demo
     *
     * @param id
     */
    void deleteDemo(String id) throws ApiExcetion;

    /**
     * 保存demo
     *
     * @param demo
     * @return
     */
    Demo saveDemo(Demo demo);

    /**
     * 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return
     */
    CommonPage<Demo> getAllByPage(Integer currentPage, Integer pageSize);

    /**
     * 查询全部
     *
     * @return
     */
    CommonResult<List<Demo>> getAll();
}
