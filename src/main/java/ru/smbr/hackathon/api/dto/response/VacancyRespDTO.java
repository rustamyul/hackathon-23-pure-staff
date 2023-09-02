package ru.smbr.hackathon.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacancyRespDTO {

    private UUID id;

    private String jobTitle;

    private String specialization;

    private String[] requirements;

    private Integer payFork;
}
