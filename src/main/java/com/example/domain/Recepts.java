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
@Table(name = "recepts")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class Recepts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="recept_Id")
    private long receptId;

    @ApiModelProperty(notes = "Название рецепта")
    @Column(name ="recept_name")
    private String receptName;

    @ApiModelProperty(notes = "Краткое описание рецепта")
    @Column(name ="description")
    private String description;

    @ApiModelProperty(notes = "Основной фото")
    @Column(name ="main_photo_path")
    private String mainPhotoPath;

    @ApiModelProperty(notes = "Рубрика")
    @Column(name ="rubric_name")
    private String rubricName;

    @ApiModelProperty(notes = "Тэги")
    @Column(name ="json_tags", columnDefinition ="JSONB")
    private String jsonTags;

    @ApiModelProperty(notes = "Время приготовления в минутах")
    @Column(name ="time_preparing")
    private Integer timePreparing;

    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "recepts")
    private List<Ingridients> ingridients;

    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "recepts")
    private List<ReceptSteps> receptSteps;

}
