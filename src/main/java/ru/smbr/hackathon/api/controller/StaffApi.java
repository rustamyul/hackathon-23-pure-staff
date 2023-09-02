package ru.smbr.hackathon.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.smbr.hackathon.api.dto.request.StaffReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.StaffRespDTO;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/staff")
public interface StaffApi {

    StaffRespDTO create(StaffReqDTO staffDTO);

    StaffRespDTO getById(UUID id);

    List<StaffRespDTO> getAll(int page, int size);

    StaffRespDTO update(StaffReqDTO staffDTO, UUID id);

    DeleteResponse delete(UUID id);

}
