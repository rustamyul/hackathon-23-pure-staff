package ru.smbr.hackathon.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.exception.ApplicationNotFoundException;
import ru.smbr.hackathon.model.VacancyEntity;
import ru.smbr.hackathon.repository.VacancyRepository;
import ru.smbr.hackathon.service.VacancyService;
import ru.smbr.hackathon.util.mapper.VacancyMapper;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;

    @Override
    public VacancyResponse create(VacancyRequest vacancyRequest) {

        log.info("#create: Create vacancy, job-title - {}", vacancyRequest.getJobTitle());
        VacancyEntity newVacancy = vacancyMapper.toVacancyEntity(vacancyRequest);
        vacancyRepository.save(newVacancy);
        return vacancyMapper.toVacancyResponse(newVacancy);

    }

    @Override
    public VacancyResponse getById(UUID id) {

        log.info("#getById: Get vacancy by id, id - {}", id);
        VacancyEntity vacancy = vacancyRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                "VacancyEntity not found, vacancy-id - " + id));

        return vacancyMapper.toVacancyResponse(vacancy);
    }

    @Override
    public PageOfListResponse<VacancyResponse> getAll(int page, int size) {

        log.info("#getAll: Get all vacancies, page - {}, size - {}", page, size);
        Page<VacancyEntity> pageOfVacancies = vacancyRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<VacancyResponse>builder()
                .elements(vacancyMapper.toVacancyResponseList(pageOfVacancies.getContent()))
                .size(size)
                .totalPage(pageOfVacancies.getTotalPages())
                .build();
    }

    @Override
    public VacancyResponse update(VacancyRequest vacancyRequest, UUID id) {

        log.info("#update: Update vacancy, id - {}", id);
        VacancyEntity vacancyToUpdate = vacancyRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "VacancyEntity not found, vacancy-id - " + id));

        vacancyMapper.updateVacancyEntity(vacancyToUpdate, vacancyRequest);
        return vacancyMapper.toVacancyResponse(vacancyToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {

        log.info("#delete: Delete vacancy by id, id - {}", id);
        try {
            vacancyRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "VacancyEntity not found, vacancy-id - " + id);
        }
        return new DeleteResponse();
    }
}
