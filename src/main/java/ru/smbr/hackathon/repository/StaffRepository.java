package ru.smbr.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smbr.hackathon.model.StaffEntity;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {
}
