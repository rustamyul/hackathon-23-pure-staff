package ru.smbr.hackathon.api.dto.response;

import lombok.*;

import java.util.List;
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

    private List<String> requirements;

    private Integer payFork;

    private String photo;

    private CompanyResponse company;
}
