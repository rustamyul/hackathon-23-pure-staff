package ru.smbr.hackathon.api.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacancyRequest {

    private String jobTitle;

    private String specialization;

    private List<String> requirements;

    private Integer payFork;
}
