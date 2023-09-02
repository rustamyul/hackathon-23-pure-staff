package ru.smbr.hackathon.util.mapper;

import org.mapstruct.Mapper;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.model.StaffEntity;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    StaffResponse toStaffResponse(StaffEntity staff);
}
