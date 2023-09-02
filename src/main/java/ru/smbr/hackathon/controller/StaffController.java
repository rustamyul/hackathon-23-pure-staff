package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.StaffApi;
import ru.smbr.hackathon.api.dto.request.StaffReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.StaffRespDTO;
import ru.smbr.hackathon.service.StaffService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StaffController implements StaffApi {

    private final StaffService staffService;

    @Override
    public StaffRespDTO create(StaffReqDTO staffDTO) {

        return staffService.create(staffDTO);
    }

    @Override
    public StaffRespDTO getById(UUID id) {

        return staffService.getById(id);
    }

    @Override
    public List<StaffRespDTO> getAll(int page, int size) {

        return staffService.getAll(page, size);
    }

    @Override
    public StaffRespDTO update(StaffReqDTO staffDTO, UUID id) {

        return staffService.update(staffDTO, id);
    }

    @Override
    public DeleteResponse delete(UUID id) {

        return staffService.delete(id);
    }
}
