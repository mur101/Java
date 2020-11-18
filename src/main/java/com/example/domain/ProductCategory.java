package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_category")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_category_id" )
    private Long productCategoryId;

    @Column(name ="product_category_name" )
    private String productCategoryName;

    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "productCategory")
    private List<Products> products;


}
