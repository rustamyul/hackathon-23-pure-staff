package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.CompanyApi;
import ru.smbr.hackathon.api.dto.request.CompanyRequest;
import ru.smbr.hackathon.api.dto.response.CompanyResponse;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.service.CompanyService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {

    private final CompanyService companyService;

    @Override
    public ResponseEntity<CompanyResponse> create(CompanyRequest companyDTO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(companyService.create(companyDTO));
    }

    @Override
    public ResponseEntity<CompanyResponse> getById(UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(companyService.getById(id));
    }

    @Override
    public ResponseEntity<PageOfListResponse<CompanyResponse>> getAll(int page, int size) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(companyService.getAll(page, size));
    }

    @Override
    public ResponseEntity<CompanyResponse> update(CompanyRequest companyDTO, UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(companyService.update(companyDTO, id));
    }

    @Override
    public ResponseEntity<DeleteResponse> delete(UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(companyService.delete(id));
    }
}
