package ru.smbr.hackathon.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacancyReqDTO {

    private String jobTitle;

    private String specialization;

    private String[] requirements;

    private Integer payFork;
}
