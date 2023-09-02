package ru.smbr.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.smbr.hackathon.model.CompanyEntity;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
}
