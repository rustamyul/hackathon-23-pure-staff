package ru.smbr.hackathon.service;

import ru.smbr.hackathon.api.dto.request.CompanyRequest;
import ru.smbr.hackathon.api.dto.response.CompanyResponse;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    CompanyResponse create(CompanyRequest companyDTO);

    CompanyResponse getById(UUID id);

    PageOfListResponse<CompanyResponse> getAll(int page, int size);

    CompanyResponse update(CompanyRequest companyDTO, UUID id);

    DeleteResponse delete(UUID id);
}
