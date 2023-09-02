package ru.smbr.hackathon.util.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.smbr.hackathon.api.dto.request.StaffRequest;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.model.StaffEntity;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    StaffResponse toStaffResponse(StaffEntity staff);

    List<StaffResponse> toStaffResponseList(Collection<StaffEntity> staff);

    StaffEntity toStaffEntity(StaffRequest request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateStaffEntity(@MappingTarget StaffEntity entity, StaffRequest request);
}
