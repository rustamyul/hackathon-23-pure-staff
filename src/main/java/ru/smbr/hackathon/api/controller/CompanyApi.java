package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.request.CompanyRequest;
import ru.smbr.hackathon.api.dto.response.CompanyResponse;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;

import java.util.UUID;

@RequestMapping("/api/v1/companies")
public interface CompanyApi {

    @PostMapping
    CompanyResponse create(@RequestBody CompanyRequest companyDTO);

    @GetMapping("/{id}")
    CompanyResponse getById(@PathVariable("id") UUID id);

    @GetMapping
    PageOfListResponse<CompanyResponse> getAll(@RequestParam(value = "page") int page,
                                               @RequestParam(value = "size") int size);

    @PutMapping("/{id}")
    CompanyResponse update(@RequestBody CompanyRequest companyDTO,
                           @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    DeleteResponse delete(@PathVariable("id") UUID id);

}
