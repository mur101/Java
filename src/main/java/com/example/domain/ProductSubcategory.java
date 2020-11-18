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
@Table(name = "product_subcategory")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class ProductSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_subcategory_id")
    private Long productSubcategoryId;

    @Column(name = "product_subcategory_name")
    private String productSubcategoryName;

    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "productSubcategory")
    private List<Products> products;
}
