package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.request.VacancyReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.VacancyRespDTO;

import java.util.List;
import java.util.UUID;

//@RequestMapping("/api/v1/vacancies")
@RequestMapping("/vacancy")
public interface VacancyApi {

    @PostMapping
    VacancyRespDTO create(@RequestBody VacancyReqDTO vacancyDTO);

    @GetMapping("/{id}")
    VacancyRespDTO getById(@PathVariable("id") UUID id);

    @GetMapping
    List<VacancyRespDTO> getAll(@RequestParam(value = "page") int page,
                                @RequestParam(value = "size") int size);

    @PutMapping("/{id}")
    VacancyRespDTO update(@RequestBody VacancyReqDTO vacancyDTO,
                          @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    DeleteResponse delete(@PathVariable("id") UUID id);

}
