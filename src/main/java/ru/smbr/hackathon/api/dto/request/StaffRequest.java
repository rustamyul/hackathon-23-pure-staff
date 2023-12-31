package ru.smbr.hackathon.api.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffRequest {

    private String name;

    private String specialization;

    private String aboutMe;

    private String photo;

    private List<String> technologyStack;
}
