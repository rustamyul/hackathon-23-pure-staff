package ru.smbr.hackathon.api.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {

    private String name;

    private Double rating;

    private Integer foundation;

    private String specialization;

    private String description;

    private String url;
}
