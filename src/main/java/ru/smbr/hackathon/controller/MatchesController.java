package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MatchesResponse<VacancyResponse>> getResultWithVacancy(UUID staffId, UUID vacancyId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(matchesService.getResultWithVacancy(staffId, vacancyId));
    }

    @Override
    public ResponseEntity<MatchesResponse<StaffResponse>> getResultWithStaff(UUID vacancyId, UUID staffId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(matchesService.getResultWithStaff(vacancyId, staffId));
    }
}
