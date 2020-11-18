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
@Table(name = "recept_steps")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class ReceptSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="recept_step_id")
    private long receptStepId;

    @ManyToOne @JoinColumn(name = "recept_id")
    private Recepts recepts;

    @ApiModelProperty(notes = "Описание шага")
    @Column(name ="recept_step_description")
    private String receptStepDescription;

    @ApiModelProperty(notes = "Фото")
    @Column(name ="step_photo")
    private String stepPhoto;
}
