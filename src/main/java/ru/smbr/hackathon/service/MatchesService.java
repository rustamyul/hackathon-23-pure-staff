package ru.smbr.hackathon.service;

import ru.smbr.hackathon.api.dto.response.MatchesResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.model.MatchesEntity;

import java.util.Optional;
import java.util.UUID;

public interface MatchesService {

    MatchesResponse<VacancyResponse> getResultWithVacancy(UUID staffId, UUID vacancyId);

    MatchesResponse<StaffResponse> getResultWithStaff(UUID vacancyId, UUID staffId);

    Optional<MatchesEntity> getMatchesEntity(UUID vacancyId, UUID staffId);

    boolean isMutualSympathy(MatchesEntity matches);
}
