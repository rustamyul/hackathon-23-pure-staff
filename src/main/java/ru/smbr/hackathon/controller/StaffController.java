package ru.smbr.hackathon.controller;

import io.swagger.v3.oas.annotations.headers.Header;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.StaffApi;
import ru.smbr.hackathon.api.dto.request.StaffRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;
import ru.smbr.hackathon.service.StaffService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StaffController implements StaffApi {

    private final StaffService staffService;

    @Override
    public ResponseEntity<StaffResponse> create(StaffRequest staffDTO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(staffService.create(staffDTO));
    }

    @Override
    public ResponseEntity<StaffResponse> getById(UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(staffService.getById(id));
    }

    @Override
    public ResponseEntity<PageOfListResponse<StaffResponse>> getAll(int page, int size) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(staffService.getAll(page, size));
    }

    @Override
    public ResponseEntity<StaffResponse> update(StaffRequest staffDTO, UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(staffService.update(staffDTO, id));
    }

    @Override
    public ResponseEntity<DeleteResponse> delete(UUID id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(staffService.delete(id));
    }
}
