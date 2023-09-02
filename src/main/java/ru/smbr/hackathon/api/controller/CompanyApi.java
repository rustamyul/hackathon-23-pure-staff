package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.request.CompanyReqDTO;
import ru.smbr.hackathon.api.dto.response.CompanyRespDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;

import java.util.List;
import java.util.UUID;

//@RequestMapping("/api/v1/companies")
@RequestMapping("/company")
public interface CompanyApi {

    @PostMapping
    CompanyRespDTO create(@RequestBody CompanyReqDTO companyDTO);

    @GetMapping("/{id}")
    CompanyRespDTO getById(@PathVariable("id") UUID id);

    @GetMapping
    List<CompanyRespDTO> getAll(@RequestParam(value = "page") int page,
                                @RequestParam(value = "size") int size);

    @PutMapping("/{id}")
    CompanyRespDTO update(@RequestBody CompanyReqDTO companyDTO,
                          @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    DeleteResponse delete(@PathVariable("id") UUID id);

}
