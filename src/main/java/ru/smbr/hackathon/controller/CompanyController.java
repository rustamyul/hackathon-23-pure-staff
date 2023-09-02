package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.CompanyApi;
import ru.smbr.hackathon.api.dto.request.CompanyReqDTO;
import ru.smbr.hackathon.api.dto.response.CompanyRespDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.service.CompanyService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {

    private final CompanyService companyService;
    @Override
    public CompanyRespDTO create(CompanyReqDTO companyDTO) {
        return companyService.create(companyDTO);
    }

    @Override
    public CompanyRespDTO getById(UUID id) {
        return companyService.getById(id);
    }

    @Override
    public List<CompanyRespDTO> getAll(int page, int size) {
        return companyService.getAll(page, size);
    }

    @Override
    public CompanyRespDTO update(CompanyReqDTO companyDTO, UUID id) {
        return companyService.update(companyDTO, id);
    }

    @Override
    public DeleteResponse delete(UUID id) {
        return companyService.delete(id);
    }
}
