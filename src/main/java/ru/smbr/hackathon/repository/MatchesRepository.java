package ru.smbr.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smbr.hackathon.model.MatchesEntity;
import ru.smbr.hackathon.model.MatchesKey;

@Repository
public interface MatchesRepository extends JpaRepository<MatchesEntity, MatchesKey> {
}
