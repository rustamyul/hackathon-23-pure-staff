package ru.smbr.hackathon.api.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacancyResponse {

    private UUID id;

    private String jobTitle;

    private String specialization;

    private String[] requirements;

    private Integer payFork;

    private CompanyResponse company;
}
