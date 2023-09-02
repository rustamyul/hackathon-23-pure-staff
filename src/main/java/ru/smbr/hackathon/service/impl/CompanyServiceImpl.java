package ru.smbr.hackathon.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.smbr.hackathon.api.dto.request.CompanyRequest;
import ru.smbr.hackathon.api.dto.response.CompanyResponse;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.api.dto.response.PageOfListResponse;
import ru.smbr.hackathon.exception.ApplicationNotFoundException;
import ru.smbr.hackathon.model.CompanyEntity;
import ru.smbr.hackathon.repository.CompanyRepository;
import ru.smbr.hackathon.service.CompanyService;
import ru.smbr.hackathon.util.mapper.CompanyMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse create(CompanyRequest companyRequest) {

        CompanyEntity newCompany = companyMapper.toCompanyEntity(companyRequest);
        companyRepository.save(newCompany);
        return companyMapper.toCompanyResponse(newCompany);
    }

    @Override
    public CompanyResponse getById(UUID id) {

        CompanyEntity company = companyRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "CompanyEntity not found, company-id - " + id));

        return companyMapper.toCompanyResponse(company);
    }

    @Override
    public PageOfListResponse<CompanyResponse> getAll(int page, int size) {

        Page<CompanyEntity> pageOfCompanies = companyRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<CompanyResponse>builder()
                .elements(companyMapper.toСompanyResponseList(pageOfCompanies.getContent()))
                .size(size)
                .totalPage(pageOfCompanies.getTotalPages())
                .build();
    }

    @Override
    public CompanyResponse update(CompanyRequest companyRequest, UUID id) {

        CompanyEntity companyToUpdate = companyRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "CompanyEntity not found, company-id - " + id));

        companyMapper.updateCompanyEntity(companyToUpdate, companyRequest);
        return companyMapper.toCompanyResponse(companyToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {
        //БД на запрос удалить несущ строку даст ошибку -ее и перехватывать (1 запрос вместо 2) update()- то же самое
        CompanyEntity companyToDelete = companyRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("delete",
                        "CompanyEntity not found, company-id - " + id));

        companyRepository.delete(companyToDelete);
        return new DeleteResponse();
    }
}
