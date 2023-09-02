package ru.smbr.hackathon.service;

import ru.smbr.hackathon.api.dto.response.StaffRespDTO;
import ru.smbr.hackathon.api.dto.request.StaffReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;

import java.util.List;
import java.util.UUID;

public interface StaffService {

    StaffRespDTO create(StaffReqDTO staffDTO);

    StaffRespDTO getById(UUID id);

    List<StaffRespDTO> getAll(int page, int size);

    StaffRespDTO update(StaffReqDTO staffDTO, UUID id);

    DeleteResponse delete(UUID id);

}
