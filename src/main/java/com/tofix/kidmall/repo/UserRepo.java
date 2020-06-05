package com.tofix.kidmall.repo;

import com.tofix.kidmall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author duskry ren
 * @description 用户
 * @date 2020/6/4
 **/
public interface UserRepo extends JpaRepository<User, String> {
}
