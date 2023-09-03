package ru.smbr.hackathon.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vacancy")
public class VacancyEntity extends AbstractEntity{

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "specialization")
    private String specialization;

    @ElementCollection
    @Column(name = "requirements")
    private List<String> requirements;

    @Column(name = "pay_fork")
    private Integer payFork;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;
}
