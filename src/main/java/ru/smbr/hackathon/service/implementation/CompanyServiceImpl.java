package ru.smbr.hackathon.service.implementation;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smbr.hackathon.api.dto.request.CompanyReqDTO;
import ru.smbr.hackathon.api.dto.response.CompanyRespDTO;
import ru.smbr.hackathon.api.dto.response.DeleteResponse;
import ru.smbr.hackathon.model.CompanyEntity;
import ru.smbr.hackathon.repository.CompanyRepository;
import ru.smbr.hackathon.service.CompanyService;
import ru.smbr.hackathon.util.mapper.CompanyMapper;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyRespDTO create(CompanyReqDTO companyRequest) {

        CompanyEntity newCompany = companyMapper.toCompanyEntity(companyRequest);
        companyRepository.save(newCompany);
        return companyMapper.toCompanyRespDTO(newCompany);
    }

    @Override
    public CompanyRespDTO getById(UUID id) {

        CompanyEntity company = companyRepository
                .findById(id)
                .orElseThrow();

        return companyMapper.toCompanyRespDTO(company);
    }

    @Override
    public List<CompanyRespDTO> getAll(int page, int size) {

        List<CompanyEntity> companies = companyRepository.findAll();
        return companyMapper.toСompanyResponses(companies);
    }

    @Override
    public CompanyRespDTO update(CompanyReqDTO companyRequest, UUID id) {

        CompanyEntity companyToUpdate = companyRepository
                .findById(id)
                .get();
        companyMapper.updateCompanyEntity(companyToUpdate, companyRequest);
        return companyMapper.toCompanyRespDTO(companyToUpdate);
    }

    @Override
    public DeleteResponse delete(UUID id) {

        CompanyEntity companyToDelete = companyRepository
                .findById(id)
                .orElseThrow();

        companyRepository.delete(companyToDelete);
        return new DeleteResponse();
    }
}
