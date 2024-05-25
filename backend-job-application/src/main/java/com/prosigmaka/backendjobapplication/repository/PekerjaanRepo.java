package com.prosigmaka.backendjobapplication.repository;

import com.prosigmaka.backendjobapplication.entity.biodata.PekerjaanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PekerjaanRepo extends JpaRepository<PekerjaanEntity, Integer> {
}
