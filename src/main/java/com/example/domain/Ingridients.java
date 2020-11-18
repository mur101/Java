package com.example.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "ingridients")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class Ingridients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ingridient_id")
    private long ingridientId;

    @ManyToOne @JoinColumn(name = "recept_id")
    private Recepts recepts;

    @ApiModelProperty(notes = "Количество ингридиента")
    @Column(name ="count_value")
    private String countValue;

    @ManyToOne @JoinColumn(name = "measure_id")
    private Measures measures;


}
