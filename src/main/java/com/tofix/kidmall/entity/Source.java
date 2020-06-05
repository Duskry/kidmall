package com.tofix.kidmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author duskry ren
 * @description 资源
 * @date 2020/6/4
 **/
@Entity
@Table(name = "t_source")
@Data
public class Source implements Serializable {
    @Id
    @GenericGenerator(name = "sourceid", strategy = "uuid")
    @GeneratedValue(generator = "sourceid")
    private String sourceId;

    private String sourceName;

    private String sourceLocation;

    private Integer sourceType;

    @ManyToOne
    @JsonIgnore
    private Goods goods;
}
