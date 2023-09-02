package ru.smbr.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smbr.hackathon.model.VacancyEntity;

import java.util.UUID;

@Repository
public interface VacancyRepository extends JpaRepository<VacancyEntity, UUID> {
}
