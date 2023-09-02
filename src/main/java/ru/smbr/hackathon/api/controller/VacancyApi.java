package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;

import java.util.UUID;

@RequestMapping("/api/v1/vacancies")
public interface VacancyApi {

    @PostMapping
    VacancyResponse create(@RequestBody VacancyRequest vacancyDTO);

    @GetMapping("/{id}")
    VacancyResponse getById(@PathVariable("id") UUID id);

    @GetMapping
    PageOfListResponse<VacancyResponse> getAll(@RequestParam(value = "page") int page,
                                               @RequestParam(value = "size") int size);

    @PutMapping("/{id}")
    VacancyResponse update(@RequestBody VacancyRequest vacancyDTO,
                           @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    DeleteResponse delete(@PathVariable("id") UUID id);

}
