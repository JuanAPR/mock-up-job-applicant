package com.prosigmaka.backendjobapplication.repository;

import com.prosigmaka.backendjobapplication.entity.biodata.BiodataEntity;
import com.prosigmaka.backendjobapplication.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BiodataRepo extends JpaRepository<BiodataEntity, Integer> {
    Optional<BiodataEntity> findByNama(String name);
    BiodataEntity deleteByNama(String name);
    Optional<BiodataEntity> findByUserId(UserEntity userId);
}
