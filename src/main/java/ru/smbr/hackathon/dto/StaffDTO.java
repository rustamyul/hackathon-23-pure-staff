package ru.smbr.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {

    private String name;

    private String specialization;

    private String aboutMe;

    private String photo;
}
