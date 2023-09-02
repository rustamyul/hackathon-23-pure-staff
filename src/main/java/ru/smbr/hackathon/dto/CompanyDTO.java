package ru.smbr.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    private String name;

    private Double rating;

    private Integer foundation;

    private String specialization;

    private String description;

    private String url;
}
