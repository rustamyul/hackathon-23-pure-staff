package ru.smbr.hackathon.service;

import ru.smbr.hackathon.api.dto.response.VacancyRespDTO;
import ru.smbr.hackathon.api.dto.request.VacancyReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;

import java.util.List;
import java.util.UUID;

public interface VacancyService {

    VacancyRespDTO create(VacancyReqDTO vacancyDTO);

    VacancyRespDTO getById(UUID id);

    List<VacancyRespDTO> getAll(int page, int size);

    VacancyRespDTO update(VacancyReqDTO vacancyDTO, UUID id);

    DeleteResponse delete(UUID id);

}
