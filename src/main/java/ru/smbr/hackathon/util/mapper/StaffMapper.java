package ru.smbr.hackathon.util.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.smbr.hackathon.api.dto.request.StaffReqDTO;
import ru.smbr.hackathon.api.dto.response.StaffRespDTO;
import ru.smbr.hackathon.model.StaffEntity;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    StaffRespDTO toStaffRespDTO(StaffEntity entity);

    List<StaffRespDTO> toStaffResponseList(Collection<StaffEntity> staff);

    StaffEntity toStaffEntity(StaffReqDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateStaffEntity(@MappingTarget StaffEntity entity, StaffReqDTO request);

    StaffResponse toStaffResponse(StaffEntity staff);
}
