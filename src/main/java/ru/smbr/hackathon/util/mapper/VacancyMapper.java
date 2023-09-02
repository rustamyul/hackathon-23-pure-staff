package ru.smbr.hackathon.util.mapper;

import org.mapstruct.*;
import ru.smbr.hackathon.api.dto.request.VacancyReqDTO;
import ru.smbr.hackathon.api.dto.response.VacancyRespDTO;
import ru.smbr.hackathon.model.VacancyEntity;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface VacancyMapper {

    VacancyRespDTO toVacancyRespDTO(VacancyEntity entity);

    List<VacancyRespDTO> toVacancyResponseList(Collection<VacancyEntity> vacancy);

    VacancyEntity toVacancyEntity(VacancyReqDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateVacancyEntity(@MappingTarget VacancyEntity entity, VacancyReqDTO request);
}
