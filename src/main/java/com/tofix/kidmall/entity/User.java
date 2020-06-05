package com.tofix.kidmall.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/
@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -4631902321811948363L;
    @Id
    @GenericGenerator(name = "userid", strategy = "uuid")
    @GeneratedValue(generator = "userid")
    private String userId;

    private String userAccout;

    private String userName;

    private String userPassword;
    @OneToMany(mappedBy = "user")
    private Set<Role> roles;

    @CreationTimestamp
    @Column(updatable = true)
    private Date userCreateTime;

    @UpdateTimestamp
    private Date userUpdateTime;

}
