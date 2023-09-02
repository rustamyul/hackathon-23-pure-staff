package ru.smbr.hackathon.api.dto.response;

import lombok.*;

import javax.persistence.Column;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffResponse {

    private UUID id;

    private String name;

    private String specialization;

    private String aboutMe;

    private String photo;

    private String[] technologyStack;
}
