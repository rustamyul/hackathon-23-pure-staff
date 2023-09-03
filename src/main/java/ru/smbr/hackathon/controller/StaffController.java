package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
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
    public StaffResponse create(StaffRequest staffDTO) {
        return staffService.create(staffDTO);
    }

    @Override
    public StaffResponse getById(UUID id) {
        return staffService.getById(id);
    }

    @Override
    public PageOfListResponse<StaffResponse> getAll(int page, int size) {
        return staffService.getAll(page, size);
    }

    @Override
    public StaffResponse update(StaffRequest staffDTO, UUID id) {
        return staffService.update(staffDTO, id);
    }

    @Override
    public DeleteResponse delete(UUID id) {
        return staffService.delete(id);
    }
}
