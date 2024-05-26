package com.prosigmaka.backendjobapplication.repository;

import com.prosigmaka.backendjobapplication.entity.biodata.BiodataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BiodataRepo extends JpaRepository<BiodataEntity, Integer> {
    Optional<BiodataEntity> findByNama(String name);
    BiodataEntity deleteByNama(String name);

    @Query("SELECT b FROM BiodataEntity b WHERE b.user.id = :userId")
    Optional<BiodataEntity> findByUserId(@Param("userId") Integer userId);
}
