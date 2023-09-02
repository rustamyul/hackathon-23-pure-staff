package ru.smbr.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacancyDTO {

    private String jobTitle;

    private String specialization;

    private String[] requirements;

    private Integer payFork;
}
