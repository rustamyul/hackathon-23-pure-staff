package ru.smbr.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smbr.hackathon.model.VacancyEntity;

import java.util.UUID;

public interface VacancyRepository extends JpaRepository<VacancyEntity, UUID> {
}
