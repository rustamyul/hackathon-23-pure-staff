package ru.smbr.hackathon.util.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.smbr.hackathon.api.dto.request.CompanyRequest;
import ru.smbr.hackathon.api.dto.response.CompanyResponse;
import ru.smbr.hackathon.model.CompanyEntity;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyResponse toCompanyResponse(CompanyEntity company);

    List<CompanyResponse> toСompanyResponseList(Collection<CompanyEntity> companies);

    CompanyEntity toCompanyEntity(CompanyRequest request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS,
            nullValuePropertyMappingStrategy = IGNORE)
    void updateCompanyEntity(@MappingTarget CompanyEntity entity, CompanyRequest request);

}
