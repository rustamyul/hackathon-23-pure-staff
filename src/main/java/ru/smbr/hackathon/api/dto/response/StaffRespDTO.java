package ru.smbr.hackathon.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffRespDTO {

    private UUID id;

    private String name;

    private String specialization;

    private String aboutMe;

    private String photo;

    private String technologyStack;
}
