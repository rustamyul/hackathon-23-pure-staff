package ru.smbr.hackathon.service;

import ru.smbr.hackathon.api.dto.request.StaffRequest;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.api.dto.response.StaffResponse;

import java.util.UUID;

public interface StaffService {

    StaffResponse create(StaffRequest staffDTO);

    StaffResponse getById(UUID id);

    PageOfListResponse<StaffResponse> getAll(int page, int size);

    StaffResponse update(StaffRequest staffDTO, UUID id);

    DeleteResponse delete(UUID id);

}
