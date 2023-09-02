package ru.smbr.hackathon.util.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.model.VacancyEntity;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface VacancyMapper {

    VacancyResponse toVacancyResponse(VacancyEntity vacancy);

    List<VacancyResponse> toVacancyResponseList(Collection<VacancyEntity> vacancy);

    VacancyEntity toVacancyEntity(VacancyRequest request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateVacancyEntity(@MappingTarget VacancyEntity entity, VacancyRequest request);
}
