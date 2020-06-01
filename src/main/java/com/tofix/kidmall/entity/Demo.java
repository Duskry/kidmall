package com.tofix.kidmall.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author duskry ren
 * @description 实体类编写规范，主键，其他键，级联关系
 * @date 2020/6/1
 **/
@Entity
@Table(name = "t_demo")
@Data
public class Demo implements Serializable {
    private static final long serialVersionUID = 2575334069130958278L;
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String demoId;

    @Column
    private String name;
}
