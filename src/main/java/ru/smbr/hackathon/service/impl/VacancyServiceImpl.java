package ru.smbr.hackathon.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.model.VacancyEntity;
import ru.smbr.hackathon.repository.VacancyRepository;
import ru.smbr.hackathon.service.VacancyService;
import ru.smbr.hackathon.util.mapper.VacancyMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;

    @Override
    public VacancyResponse create(VacancyRequest vacancyRequest) {

        VacancyEntity newVacancy = vacancyMapper.toVacancyEntity(vacancyRequest);
        vacancyRepository.save(newVacancy);
        return vacancyMapper.toVacancyResponse(newVacancy);

    }

    @Override
    public VacancyResponse getById(UUID id) {

        VacancyEntity vacancy = vacancyRepository
                .findById(id)
                .orElseThrow();

        return vacancyMapper.toVacancyResponse(vacancy);
    }

    @Override
    public PageOfListResponse<VacancyResponse> getAll(int page, int size) {

        Page<VacancyEntity> pageOfVacancies = vacancyRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<VacancyResponse>builder()
                .elements(vacancyMapper.toVacancyResponseList(pageOfVacancies.getContent()))
                .size(size)
                .totalPage(pageOfVacancies.getTotalPages())
                .build();
    }

    @Override
    public VacancyResponse update(VacancyRequest vacancyRequest, UUID id) {

        VacancyEntity vacancyToUpdate = vacancyRepository
                .findById(id)
                .get();
        vacancyMapper.updateVacancyEntity(vacancyToUpdate, vacancyRequest);
        return vacancyMapper.toVacancyResponse(vacancyToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {

        VacancyEntity vacancyToDelete = vacancyRepository
                .findById(id)
                .orElseThrow();

        vacancyRepository.delete(vacancyToDelete);
        return new DeleteResponse();
    }
}
