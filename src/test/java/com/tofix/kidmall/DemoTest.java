package com.tofix.kidmall;

import com.tofix.kidmall.entity.Demo;
import com.tofix.kidmall.repo.DemoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author duskry ren
 * @description demo 测试类的编写 一般是测试dao
 * @date 2020/6/2
 **/
@SpringBootTest
public class DemoTest {
    @Autowired
    DemoRepo demoRepo;

    @Test
    void test1() {
        System.out.println(demoRepo.findAll());
    }

    @Test
    void test2() {
        Demo demo = new Demo();
        String name = "大傻子";
        demo.setName(name);
        Assertions.assertEquals(demoRepo.save(demo).getName(), name);
    }
}
