package com.tofix.kidmall.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/3
 **/
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue()
    Integer userId;
    @Column
    String userAccount;
    @Column
    String userName;
    @Column
    String userPassword;
}
