package com.vozh.art.dataservice.repository;

import com.vozh.art.dataservice.entity.CertificateParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateParticipantRepo extends JpaRepository<CertificateParticipant, Long> {
}
