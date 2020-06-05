package com.tofix.kidmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duskry ren
 * @description
 * @date 2020/6/4
 **/
@Entity
@Table(name = "t_goods")
@Getter
@Setter
@ToString(exclude = {"sourceSet", "goodsCateSet"})
public class Goods implements Serializable {
    private static final long serialVersionUID = -7781710173608724249L;
    @Id
    @GenericGenerator(name = "goodsid", strategy = "uuid")
    @GeneratedValue(generator = "goodsid")
    private String goodsId;

    private String goodsName;

    private Double goodsPrice;
    /**
     * 主要资源地址
     */
    private String goodsMainImage;

    private Integer goodsStatus;
    /**
     * 删除 商品时 商品的所有资源应该也被删除
     */
    @OneToMany(mappedBy = "goods", cascade = CascadeType.REMOVE)
    private Set<Source> sourceSet = new HashSet<>();

    private Integer goodsSumNumber;

    private String goodsDetail;
    @ManyToMany(mappedBy = "goods")
    private Set<GoodsCate> goodsCateSet = new HashSet<>();

    @CreationTimestamp()
    @Column(updatable = true)
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

}
