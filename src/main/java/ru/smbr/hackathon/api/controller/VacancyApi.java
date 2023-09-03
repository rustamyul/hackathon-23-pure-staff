package ru.smbr.hackathon.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;

import java.util.UUID;

@RequestMapping("/api/v1/vacancies")
public interface VacancyApi {

    @PostMapping
    ResponseEntity<VacancyResponse> create(@RequestBody VacancyRequest vacancyDTO);

    @GetMapping("/{id}")
    ResponseEntity<VacancyResponse> getById(@PathVariable("id") UUID id);

    @GetMapping
    ResponseEntity<PageOfListResponse<VacancyResponse>> getAll(@RequestParam(value = "page") int page,
                                               @RequestParam(value = "size") int size);

    @PutMapping("/{id}")
    ResponseEntity<VacancyResponse> update(@RequestBody VacancyRequest vacancyDTO,
                           @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteResponse> delete(@PathVariable("id") UUID id);

}
