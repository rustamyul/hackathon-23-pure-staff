package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.VacancyApi;
import ru.smbr.hackathon.api.dto.request.VacancyReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.VacancyRespDTO;
import ru.smbr.hackathon.service.CompanyService;
import ru.smbr.hackathon.service.VacancyService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class VacancyController implements VacancyApi {

    private final VacancyService vacancyService;
    @Override
    public VacancyRespDTO create(VacancyReqDTO vacancyDTO) {
        return vacancyService.create(vacancyDTO);
    }

    @Override
    public VacancyRespDTO getById(UUID id) {
        return vacancyService.getById(id);
    }

    @Override
    public List<VacancyRespDTO> getAll(int page, int size) {
        return vacancyService.getAll(page, size);
    }

    @Override
    public VacancyRespDTO update(VacancyReqDTO vacancyDTO, UUID id) {
        return vacancyService.update(vacancyDTO, id);
    }

    @Override
    public DeleteResponse delete(UUID id) {
        return vacancyService.delete(id);
    }
}
