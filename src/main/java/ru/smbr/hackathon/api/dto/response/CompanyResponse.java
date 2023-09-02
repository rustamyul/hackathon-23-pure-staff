package ru.smbr.hackathon.api.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {

    private UUID id;

    private Double rating;

    private Integer foundation;

    private String specialization;

    private String description;

    private String url;
}
