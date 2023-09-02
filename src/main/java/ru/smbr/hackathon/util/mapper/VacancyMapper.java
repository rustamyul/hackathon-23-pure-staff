package ru.smbr.hackathon.util.mapper;

import org.mapstruct.Mapper;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.model.VacancyEntity;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface VacancyMapper {

    VacancyResponse toVacancyResponse(VacancyEntity vacancy);
}
