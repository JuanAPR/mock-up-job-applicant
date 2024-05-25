package com.prosigmaka.backendjobapplication.repository;

import com.prosigmaka.backendjobapplication.entity.biodata.BiodataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BiodataRepo extends JpaRepository<BiodataEntity, Integer> {
    Optional<BiodataEntity> findByNama(String name);
    BiodataEntity deleteByNama(String name);
}
