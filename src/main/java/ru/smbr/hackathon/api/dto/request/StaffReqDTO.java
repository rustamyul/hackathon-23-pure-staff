package ru.smbr.hackathon.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffReqDTO {

    private String name;

    private String specialization;

    private String aboutMe;

    private String photo;

    private String technologyStack;
}
