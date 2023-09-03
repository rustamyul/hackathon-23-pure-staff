package ru.smbr.hackathon.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
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

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse create(CompanyRequest companyRequest) {

        log.info("#create: Create company, company-title - {}", companyRequest.getName());
        CompanyEntity newCompany = companyMapper.toCompanyEntity(companyRequest);
        companyRepository.save(newCompany);
        return companyMapper.toCompanyResponse(newCompany);
    }

    @Override
    public CompanyResponse getById(UUID id) {

        log.info("#getById: Get company by id, id - {}", id);
        CompanyEntity company = companyRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "CompanyEntity not found, company-id - " + id));

        return companyMapper.toCompanyResponse(company);
    }

    @Override
    public PageOfListResponse<CompanyResponse> getAll(int page, int size) {

        log.info("#getAll: Get all companies, page - {}, size - {}", page, size);
        Page<CompanyEntity> pageOfCompanies = companyRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<CompanyResponse>builder()
                .elements(companyMapper.toСompanyResponseList(pageOfCompanies.getContent()))
                .size(size)
                .totalPage(pageOfCompanies.getTotalPages())
                .build();
    }

    @Override
    public CompanyResponse update(CompanyRequest companyRequest, UUID id) {

        log.info("#update: Update company, id - {}", id);
        CompanyEntity companyToUpdate = companyRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "CompanyEntity not found, company-id - " + id));

        companyMapper.updateCompanyEntity(companyToUpdate, companyRequest);
        return companyMapper.toCompanyResponse(companyToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {

        log.info("#delete: Delete company by id, id - {}", id);
        try {
            companyRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "Vacancy not found, vacancy-id - " + id);
        }
        return new DeleteResponse();
    }
}
