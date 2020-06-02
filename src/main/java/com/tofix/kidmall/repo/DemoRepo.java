package com.tofix.kidmall.repo;

import com.tofix.kidmall.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DemoRepo extends JpaRepository<Demo, String> {
    /**
     * 重写的查询方法 库中没有实现的基本查询 简单的连接查询和条件都是可以做到的
     *
     * @param id
     * @param name
     * @return demo
     */
    Optional<Demo> findByDemoIdAndName(String id, String name);


    /**
     * 使用 jpql查询  在hibernate中叫做hql 面向对象的思想
     *
     * @param id
     * @return demo
     */
    @Query("select d from Demo d where d.demoId=:id")
    Demo get(String id);

    /**
     * 原生查询
     *
     * @param id
     * @return
     */
    @Query(value = "select * from t_demo where demoId=:id", nativeQuery = true)
    Demo gethh(@Param("id") String id);

}
