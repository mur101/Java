package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "measures")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class Measures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="measure_id")
    private long measureId;

    @ApiModelProperty(notes = "Мера веса")
    @Column(name ="measure_name")
    private String measureName;

    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "measures")
    private List<Ingridients> ingridients;
}
