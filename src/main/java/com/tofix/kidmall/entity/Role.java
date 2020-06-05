package com.tofix.kidmall.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/
@Entity
@Table(name = "t_role")
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -499493118372264107L;

    @Id
    @GenericGenerator(name = "roleid", strategy = "uuid")
    @GeneratedValue(generator = "roleid")
    private String roleId;

    private Integer roleCode;

    private String roleName;

    @ManyToOne()
    private User user;
}
