package com.tofix.kidmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/
@Entity
@Table(name = "t_category", uniqueConstraints = {@UniqueConstraint(columnNames = "cateName")})
@Data
public class GoodsCate implements Serializable {
    private static final long serialVersionUID = -8990216455436375344L;
    @Id
    @GenericGenerator(name = "goodscateid", strategy = "uuid")
    @GeneratedValue(generator = "goodscateid")
    private String cateId;

    private String cateName;

    /**
     * 父类别
     */
    private String parentGoodsCateId;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)

    private Set<Goods> goods = new HashSet<>();
}
