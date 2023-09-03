package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.MatchesApi;
import ru.smbr.hackathon.api.dto.response.MatchesResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.service.MatchesService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MatchesController implements MatchesApi {

    private final MatchesService matchesService;

    @Override
    public MatchesResponse<VacancyResponse> getResultWithVacancy(UUID staffId, UUID vacancyId) {
        return matchesService.getResultWithVacancy(staffId, vacancyId);
    }

    @Override
    public MatchesResponse<StaffResponse> getResultWithStaff(UUID vacancyId, UUID staffId) {
        return matchesService.getResultWithStaff(vacancyId, staffId);
    }
}
