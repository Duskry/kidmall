package com.tofix.kidmall.repo;

import com.tofix.kidmall.entity.Goods;
import com.tofix.kidmall.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/5
 **/
public interface SourceRepo extends JpaRepository<Source, String> {
    Set<Source> findByGoods(Goods goods);
}
