package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.VacancyApi;
import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.service.VacancyService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class VacancyController implements VacancyApi {

    private final VacancyService vacancyService;

    @Override
    public VacancyResponse create(VacancyRequest vacancyDTO) {
        return vacancyService.create(vacancyDTO);
    }

    @Override
    public VacancyResponse getById(UUID id) {
        return vacancyService.getById(id);
    }

    @Override
    public PageOfListResponse<VacancyResponse> getAll(int page, int size) {
        return vacancyService.getAll(page, size);
    }

    @Override
    public VacancyResponse update(VacancyRequest vacancyDTO, UUID id) {
        return vacancyService.update(vacancyDTO, id);
    }

    @Override
    public DeleteResponse delete(UUID id) {
        return vacancyService.delete(id);
    }
}
