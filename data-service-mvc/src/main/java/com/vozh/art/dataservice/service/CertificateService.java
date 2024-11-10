package com.vozh.art.dataservice.service;

import com.vozh.art.dataservice.entity.Certificate;
import com.vozh.art.dataservice.repository.CertificateRepository;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;

    public Certificate getById(Long certificateID){
        Optional<Certificate> cert = certificateRepository.findById(certificateID);
        if(cert.isPresent()){
            return cert.get();
        }
        throw new PersistenceException("Cant find certificate by id");
    }

    public Certificate save(Certificate certificate){
        try {
            return certificateRepository.save(certificate);
        }
        catch (Exception e){
            throw new PersistenceException("Failed to save into DB");
        }
    }


}
