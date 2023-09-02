package ru.smbr.hackathon.util.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.smbr.hackathon.api.dto.request.CompanyReqDTO;
import ru.smbr.hackathon.api.dto.request.VacancyReqDTO;
import ru.smbr.hackathon.api.dto.response.CompanyRespDTO;
import ru.smbr.hackathon.model.CompanyEntity;
import ru.smbr.hackathon.model.VacancyEntity;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyRespDTO toCompanyRespDTO(CompanyEntity entity);

    List<CompanyRespDTO> toСompanyResponses(Collection<CompanyEntity> companies);

    CompanyEntity toCompanyEntity(CompanyReqDTO request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateCompanyEntity(@MappingTarget CompanyEntity entity, CompanyReqDTO request);
}
