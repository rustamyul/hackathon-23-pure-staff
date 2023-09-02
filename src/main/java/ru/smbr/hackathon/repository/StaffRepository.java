package ru.smbr.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smbr.hackathon.model.StaffEntity;

import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, UUID> {
}
