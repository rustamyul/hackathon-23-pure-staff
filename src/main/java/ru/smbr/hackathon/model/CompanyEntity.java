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
    private String name;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "foundation")
    private Integer foundation;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;
}
