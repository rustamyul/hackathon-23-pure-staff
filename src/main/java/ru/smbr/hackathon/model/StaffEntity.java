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
@Table(name = "staff")
public class StaffEntity extends AbstractEntity {

    @Column(name = "key_comp_sum")
    Integer keyCompSum;

    @Column(name = "key_self")
    Integer keySelf;

    @Column(name = "name")
    String name;

    @Column(name = "specialization")
    String specialization;

    @Column(name = "about_me")
    String aboutMe;

    @Column(name = "photo")
    String photo;
}
