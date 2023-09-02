package ru.smbr.hackathon.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class CompanyEntity extends AbstractEntity{

    @Column(name = "name")
    String name;

    @Column(name = "rating")
    Double rating;

    @Column(name = "foundation")
    Integer foundation;

    @Column(name = "specialization")
    String specialization;

    @Column(name = "description")
    String description;

    @Column(name = "url")
    String url;
}
