package ru.smbr.hackathon.service;

import ru.smbr.hackathon.api.dto.response.CompanyRespDTO;
import ru.smbr.hackathon.api.dto.request.CompanyReqDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    CompanyRespDTO create(CompanyReqDTO companyDTO);

    CompanyRespDTO getById(UUID id);

    List<CompanyRespDTO> getAll(int page, int size);

    CompanyRespDTO update(CompanyReqDTO companyDTO, UUID id);

    DeleteResponse delete(UUID id);
}
