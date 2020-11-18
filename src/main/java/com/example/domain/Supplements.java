package com.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "supplements")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class Supplements{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="supplement_id")
    private long supplementId;

    @Column(name ="supplement_code")
    private String supplementCode;

    @Column(name ="supplement_name")
    private String supplementName;

    @Column(name ="feature")
    private String feature;

    @Column(name ="effect_on_body")
    private String effectOnBody;

    @ManyToOne @JoinColumn(name = "supplement_category_id")
    private SupplementCategories supplementCategories ;

    @ManyToOne @JoinColumn(name = "risk_id")
    private Risks risks;
}
