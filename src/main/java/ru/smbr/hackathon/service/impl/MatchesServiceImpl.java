package ru.smbr.hackathon.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smbr.hackathon.api.dto.response.MatchesResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.exception.ApplicationNotFoundException;
import ru.smbr.hackathon.model.MatchesEntity;
import ru.smbr.hackathon.model.MatchesKey;
import ru.smbr.hackathon.model.StaffEntity;
import ru.smbr.hackathon.model.VacancyEntity;
import ru.smbr.hackathon.repository.MatchesRepository;
import ru.smbr.hackathon.repository.StaffRepository;
import ru.smbr.hackathon.repository.VacancyRepository;
import ru.smbr.hackathon.service.MatchesService;
import ru.smbr.hackathon.util.mapper.StaffMapper;
import ru.smbr.hackathon.util.mapper.VacancyMapper;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchesServiceImpl implements MatchesService {

    private final MatchesRepository matchesRepository;
    private final StaffRepository staffRepository;
    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;
    private final StaffMapper staffMapper;

    @Transactional
    @Override
    public MatchesResponse<VacancyResponse> getResultWithVacancy(UUID staffId, UUID vacancyId) {

        log.info("#getResultWithVacancy: Get matches result with vacancy, staff-id - {}, vacancy-id - {}", staffId, vacancyId);
        VacancyEntity vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new ApplicationNotFoundException("getResultWithVacancy",
                        "VacancyEntity not found, vacancy-id - " + vacancyId));

        if (!staffRepository.existsById(staffId)) {
            throw new ApplicationNotFoundException("getResultWithVacancy",
                    "StaffEntity not found, staff-id - " + staffId);
        }

        Optional<MatchesEntity> matchesEntity = getMatchesEntity(vacancyId, staffId);

        MatchesEntity matches;
        if (matchesEntity.isPresent()) {
            matches = matchesEntity.get();
            matches.setVacancyIsLike(true);
        } else {
            matches = MatchesEntity.builder()
                    .matchesKey(MatchesKey.builder()
                            .vacancyId(vacancyId)
                            .staffId(staffId)
                            .build())
                    .vacancyIsLike(true)
                    .build();
            matchesRepository.save(matches);
        }

        return MatchesResponse.<VacancyResponse>builder()
                .entity(vacancyMapper.toVacancyResponse(vacancy))
                .isMatches(isMutualSympathy(matches))
                .build();
    }

    @Transactional
    @Override
    public MatchesResponse<StaffResponse> getResultWithStaff(UUID vacancyId, UUID staffId) {

        log.info("#getResultWithStaff: Get matches result with staff, staff-id - {}, vacancy-id - {}", staffId, vacancyId);
        StaffEntity staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ApplicationNotFoundException("getResultWithStaff",
                        "StaffEntity not found, staff-id - " + staffId));

        if (!vacancyRepository.existsById(vacancyId)) {
            throw new ApplicationNotFoundException("getResultWithStaff",
                    "VacancyEntity not found, vacancy-id - " + vacancyId);
        }

        Optional<MatchesEntity> matchesEntity = getMatchesEntity(vacancyId, staffId);

        MatchesEntity matches;
        if (matchesEntity.isPresent()) {
            matches = matchesEntity.get();
            matches.setStaffIsLike(true);
        } else {
            matches = MatchesEntity.builder()
                    .matchesKey(MatchesKey.builder()
                            .vacancyId(vacancyId)
                            .staffId(staffId)
                            .build())
                    .staffIsLike(true)
                    .build();
            matchesRepository.save(matches);
        }

        return MatchesResponse.<StaffResponse>builder()
                .entity(staffMapper.toStaffResponse(staff))
                .isMatches(isMutualSympathy(matches))
                .build();
    }

    @Override
    public Optional<MatchesEntity> getMatchesEntity(UUID vacancyId, UUID staffId) {

        log.info("#getMatchesEntity: Get MatchesEntity by matches-key, staff-id - {}, vacancy-id - {}", staffId, vacancyId);
        MatchesKey key = MatchesKey.builder()
                .staffId(staffId)
                .vacancyId(vacancyId)
                .build();
        return matchesRepository.findById(key);
    }

    @Override
    public boolean isMutualSympathy(MatchesEntity matches) {
        return (matches.isStaffIsLike() == matches.isVacancyIsLike()) && matches.isVacancyIsLike();
    }
}
