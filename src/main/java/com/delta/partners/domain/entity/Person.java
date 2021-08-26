package com.delta.partners.domain.entity;

import com.delta.partners.dto.Gender;
import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.GraphQLId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GraphQLId
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "surName", nullable = false)
    private String surName;

    @Column(name= "middleName")
    private String middleName;

    @Column(name="displayName")
    private String displayName;

    @Column(name="birthDate")
    private LocalDate birthDate;

    @Column(name= "tin")
    private String tin;

    @Column(name="passportNumber")
    private String passportNumber;

    @Column(name="passportDate")
    private LocalDate passportDate;

    @Column(name="passportIssuer")
    private String passportIssuer;

    @Column(name="refFiasAoguid")
    private String refFiasAoguid;

    @GraphQLEnumValue
    @Column(name="gender", nullable = false)
    private Gender gender;

    @Column(name="comments")
    private String comments;

//    @Column({ nullable: true, default: 0 })
//    authorId: number

    @Column(name="entryDate", nullable = false)
    private LocalDate entryDate;

    @Column(name="deleted")
    private Boolean deleted;

    @Column(name="dateDelete")
    private LocalDate dateDelete;

    @Column(name="lastUpdate", nullable = false)
    private LocalDate lastUpdate;


//    @Column(name="originalId")
//    private String originalId;
}
