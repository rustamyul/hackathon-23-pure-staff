package ru.smbr.hackathon.service;

import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;

import java.util.UUID;

public interface VacancyService {

    VacancyResponse create(VacancyRequest vacancyDTO);

    VacancyResponse getById(UUID id);

    PageOfListResponse<VacancyResponse> getAll(int page, int size);

    VacancyResponse update(VacancyRequest vacancyDTO, UUID id);

    DeleteResponse delete(UUID id);

}
