package ru.smbr.hackathon.service.impl;

import lombok.RequiredArgsConstructor;
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
        // актуально только при matches.isPresent() (можно и функцию сделать для одиночного запроса в бд)
        VacancyEntity vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new ApplicationNotFoundException("getResultWithVacancy",
                        "VacancyEntity not found, vacancy-id - " + vacancyId));

        /*if (!staffRepository.existsById(staffId)) {
            throw new ApplicationNotFoundException("getResultWithVacancy",
                    "StaffEntity not found, staff-id - " + staffId);
        }*/

        Optional<MatchesEntity> matches = getMatchesEntity(vacancyId, staffId);

        if (matches.isPresent()) {
            matches.get().setVacancyIsLike(true);
        } else {
            // это же костыль?) ты заведомо оборачиваешь в Optional.
            matches = Optional.of(MatchesEntity.builder()
                    .matchesKey(MatchesKey.builder()
                            .vacancyId(vacancyId)
                            .staffId(staffId)
                            .build())
                    .vacancyIsLike(true)
                    .build());
            matchesRepository.save(matches.get());
        }

        return MatchesResponse.<VacancyResponse>builder()
                .entity(vacancyMapper.toVacancyResponse(vacancy))
                //риск - если разраб сделает .vacancyIsLike(false)
                .isMatches(matches.get().isVacancyIsLike() == matches.get().isStaffIsLike())
                .build();
    }

    @Transactional
    @Override
    public MatchesResponse<StaffResponse> getResultWithStaff(UUID vacancyId, UUID staffId) {

        StaffEntity staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ApplicationNotFoundException("getResultWithStaff",
                        "StaffEntity not found, staff-id - " + staffId));

        /*if (!vacancyRepository.existsById(vacancyId)) {
            throw new ApplicationNotFoundException("getResultWithStaff",
                    "VacancyEntity not found, vacancy-id - " + vacancyId);
        }*/

        Optional<MatchesEntity> matches = getMatchesEntity(vacancyId, staffId);

        if (matches.isPresent()) {
            matches.get().setStaffIsLike(true);
        } else {
            matches = Optional.of(MatchesEntity.builder()
                    .matchesKey(MatchesKey.builder()
                            .vacancyId(vacancyId)
                            .staffId(staffId)
                            .build())
                    .staffIsLike(true)
                    .build());
            matchesRepository.save(matches.get());
        }

        return MatchesResponse.<StaffResponse>builder()
                .entity(staffMapper.toStaffResponse(staff))
                //риск - если разраб сделает .vacancyIsLike(false)
                .isMatches(matches.get().isVacancyIsLike() == matches.get().isStaffIsLike())
                .build();
    }

    @Override
    public Optional<MatchesEntity> getMatchesEntity(UUID vacancyId, UUID staffId) {

        MatchesKey key = MatchesKey.builder()
                .staffId(staffId)
                .vacancyId(vacancyId)
                .build();
        return matchesRepository.findById(key);
    }
}
