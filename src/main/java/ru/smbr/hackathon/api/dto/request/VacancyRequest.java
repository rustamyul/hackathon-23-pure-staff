package ru.smbr.hackathon.api.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacancyRequest {

    private String jobTitle;

    private String specialization;

    private String[] requirements;

    private Integer payFork;
}
