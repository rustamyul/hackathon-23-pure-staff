package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.smbr.hackathon.api.dto.request.VacancyReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.VacancyRespDTO;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/vacancies")
public interface VacancyApi {

    VacancyRespDTO create(VacancyReqDTO vacancyDTO);

    VacancyRespDTO getById(UUID id);

    List<VacancyRespDTO> getAll(int page, int size);

    VacancyRespDTO update(VacancyReqDTO vacancyDTO, UUID id);

    DeleteResponse delete(UUID id);

}
