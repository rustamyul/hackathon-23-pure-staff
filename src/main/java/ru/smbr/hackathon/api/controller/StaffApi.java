package ru.smbr.hackathon.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.request.StaffRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;

import java.util.UUID;

@RequestMapping("/api/v1/staff")
public interface StaffApi {

    @PostMapping
    ResponseEntity<StaffResponse> create(@RequestBody StaffRequest staffDTO);

    @GetMapping("/{id}")
    ResponseEntity<StaffResponse> getById(@PathVariable("id") UUID id);

    @GetMapping
    ResponseEntity<PageOfListResponse<StaffResponse>> getAll(@RequestParam(value = "page") int page,
                                             @RequestParam(value = "size") int size);

    @PutMapping("/{id}")
    ResponseEntity<StaffResponse> update(@RequestBody StaffRequest staffDTO,
                         @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteResponse> delete(@PathVariable("id") UUID id);

}
