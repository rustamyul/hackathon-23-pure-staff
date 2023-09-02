package ru.smbr.hackathon.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRespDTO {

    private UUID id;

    private String name;

    private Double rating;

    private Integer foundation;

    private String specialization;

    private String description;

    private String url;
}
