package ru.smbr.hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.smbr.hackathon.api.controller.CompanyApi;
import ru.smbr.hackathon.api.dto.request.CompanyRequest;
import ru.smbr.hackathon.api.dto.response.CompanyResponse;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.service.CompanyService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {

    private final CompanyService companyService;

    @Override
    public CompanyResponse create(CompanyRequest companyDTO) {
        return companyService.create(companyDTO);
    }

    @Override
    public CompanyResponse getById(UUID id) {
        return companyService.getById(id);
    }

    @Override
    public PageOfListResponse<CompanyResponse> getAll(int page, int size) {
        return companyService.getAll(page, size);
    }

    @Override
    public CompanyResponse update(CompanyRequest companyDTO, UUID id) {
        return companyService.update(companyDTO, id);
    }

    @Override
    public DeleteResponse delete(UUID id) {
        return companyService.delete(id);
    }
}
