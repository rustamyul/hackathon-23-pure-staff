package ru.smbr.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @CreationTimestamp
    @Column(name = "create_date")
    private Instant createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Instant updateDate;
}