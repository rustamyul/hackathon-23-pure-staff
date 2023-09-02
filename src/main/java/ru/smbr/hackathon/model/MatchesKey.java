package ru.smbr.hackathon.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MatchesKey implements Serializable {

    @Column(name = "staff_id")
    private UUID staffId;

    @Column(name = "vacancy_id")
    private UUID vacancyId;
}
