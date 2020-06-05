package com.tofix.kidmall.repo;

import com.tofix.kidmall.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/
public interface GoodsRepo extends JpaRepository<Goods, String> {
}
