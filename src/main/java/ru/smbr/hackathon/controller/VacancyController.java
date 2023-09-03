package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.VacancyApi;
import ru.smbr.hackathon.api.dto.request.VacancyRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.VacancyResponse;
import ru.smbr.hackathon.service.VacancyService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class VacancyController implements VacancyApi {

    private final VacancyService vacancyService;

    @Override
    public ResponseEntity<VacancyResponse> create(VacancyRequest vacancyDTO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(vacancyService.create(vacancyDTO));
    }

    @Override
    public ResponseEntity<VacancyResponse> getById(UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(vacancyService.getById(id));
    }

    @Override
    public ResponseEntity<PageOfListResponse<VacancyResponse>> getAll(int page, int size) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(vacancyService.getAll(page, size));
    }

    @Override
    public ResponseEntity<VacancyResponse> update(VacancyRequest vacancyDTO, UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(vacancyService.update(vacancyDTO, id));
    }

    @Override
    public ResponseEntity<DeleteResponse> delete(UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(vacancyService.delete(id));
    }
}
