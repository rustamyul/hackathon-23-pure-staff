package ru.smbr.hackathon.service.implementation;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smbr.hackathon.api.dto.request.VacancyReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.VacancyRespDTO;
import ru.smbr.hackathon.model.VacancyEntity;
import ru.smbr.hackathon.repository.VacancyRepository;
import ru.smbr.hackathon.service.VacancyService;
import ru.smbr.hackathon.util.mapper.VacancyMapper;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;

    @Override
    public VacancyRespDTO create(VacancyReqDTO vacancyRequest) {

        VacancyEntity newVacancy = vacancyMapper.toVacancyEntity(vacancyRequest);
        vacancyRepository.save(newVacancy);
        return vacancyMapper.toVacancyRespDTO(newVacancy);

    }

    @Override
    public VacancyRespDTO getById(UUID id) {

        VacancyEntity vacancy = vacancyRepository
                .findById(id)
                .orElseThrow();

        return vacancyMapper.toVacancyRespDTO(vacancy);
    }

    @Override
    public List<VacancyRespDTO> getAll(int page, int size) {

        List<VacancyEntity> vacancies = vacancyRepository.findAll();
        return vacancyMapper.toVacancyResponses(vacancies);
    }

    @Override
    public VacancyRespDTO update(VacancyReqDTO vacancyRequest, UUID id) {

        VacancyEntity vacancyToUpdate = vacancyRepository
                .findById(id)
                .get();
        vacancyMapper.updateVacancyEntity(vacancyToUpdate, vacancyRequest);
        return vacancyMapper.toVacancyRespDTO(vacancyToUpdate);
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
