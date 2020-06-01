package com.tofix.kidmall.common;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author duskry ren
 * @description 将分页的信息转换成一个类
 * @date 2020/6/1
 **/
@Data
public class CommonPage<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private Long totalSize;
    private List<T> list;

    public static <T> CommonPage<T> restPage(Page<T> page) {
        CommonPage<T> result = new CommonPage<T>();
        result.setCurrentPage(page.getNumber());
        result.setPageSize(page.getSize());
        result.setTotalPage(page.getTotalPages());
        result.setTotalSize(page.getTotalElements());
        result.setList(page.getContent());
        return result;
    }
}
