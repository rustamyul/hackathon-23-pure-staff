package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.response.MatchesResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/api/v1/matches")
public interface MatchesApi {

    @GetMapping("/result-with-vacancy/{vacancy_id}")
    @ResponseStatus(OK)
    MatchesResponse<VacancyResponse> getResultWithVacancy(@RequestHeader("staff_id") UUID staffId,
                                                          @PathVariable("vacancy_id") UUID vacancyId);

    @GetMapping("/result-with-staff/{staff_id}")
    @ResponseStatus(OK)
    MatchesResponse<StaffResponse> getResultWithStaff(@RequestHeader("vacancy_id") UUID vacancyId,
                                                      @PathVariable("staff_id") UUID staffId);
}
