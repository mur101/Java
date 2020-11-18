package com.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "products")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_Id")
/*    @ApiModelProperty(notes = "Таблица с продуктами")*/
    private long productId;

    @Column(name ="product_name")
    private String productName;

    @Column(name ="calorie_value")
    private float calorieValue;

    @Column(name ="squirrels_value")
    private float squirrelsValue;

    @Column(name ="fats_value")
    private float fatsValue;

    @Column(name ="carbohydrates_value")
    private float carbohydratesValue;

    @Column(name ="glycemic_index")
    private Integer glycemicIndex;

    @ManyToOne @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @ManyToOne @JoinColumn(name = "product_subcategory_id")
    private ProductSubcategory productSubcategory;

    @Column(name ="ready_meal")
    private int readyMeal;
}
