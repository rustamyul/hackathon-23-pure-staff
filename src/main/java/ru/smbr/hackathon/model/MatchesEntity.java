package ru.smbr.hackathon.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class MatchesEntity {

    @EmbeddedId
    private MatchesKey matchesKey;

    @Column(name = "staff_is_like")
    private boolean staffIsLike;

    @Column(name = "vacancy_is_like")
    private boolean vacancyIsLike;

}
