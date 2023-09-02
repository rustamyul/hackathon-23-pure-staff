package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.*;
import ru.smbr.hackathon.api.dto.request.StaffReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.StaffRespDTO;

import java.util.List;
import java.util.UUID;

//@RequestMapping("/api/v1/staff")
@RequestMapping("/staff")
public interface StaffApi {

    @PostMapping
    StaffRespDTO create(@RequestBody StaffReqDTO staffDTO);

    @GetMapping("/{id}")
    StaffRespDTO getById(@PathVariable("id") UUID id);

    @GetMapping
    List<StaffRespDTO> getAll(@RequestParam(value = "page") int page,
                              @RequestParam(value = "size")int size);

    @PutMapping("/{id}")
    StaffRespDTO update(@RequestBody StaffReqDTO staffDTO,
                        @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    DeleteResponse delete(@PathVariable("id") UUID id);

}
