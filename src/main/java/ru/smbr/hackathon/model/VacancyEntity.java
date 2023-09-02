package ru.smbr.hackathon.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vacancy")
public class VacancyEntity extends AbstractEntity{

    @Column(name = "key_empl_sum")
    Integer keyEmplSum;

    @Column(name = "key_self")
    Integer keySelf;

    @Column(name = "job_title")
    String jobTitle;

    @Column(name = "specialization")
    String specialization;


    String[] requirements;

    @Column(name = "pay_fork")
    Integer payFork;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;
}
