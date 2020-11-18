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
@Table(name = "risks")
@EqualsAndHashCode(of = "ID")
@Getter @Setter
@DynamicUpdate @DynamicInsert @SelectBeforeUpdate
public class Risks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="risk_id" )
    private Long supplementCategoryId;

    @Column(name ="risk_name" )
    private String supplementCategoryName;

    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "risks")
    private List<Supplements> supplements;
}
