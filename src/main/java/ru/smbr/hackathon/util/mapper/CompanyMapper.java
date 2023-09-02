package ru.smbr.hackathon.util.mapper;

import org.mapstruct.Mapper;
import ru.smbr.hackathon.api.dto.response.CompanyResponse;
import ru.smbr.hackathon.model.CompanyEntity;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyResponse toCompanyResponse(CompanyEntity company);
}
