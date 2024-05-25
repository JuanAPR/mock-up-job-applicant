package com.prosigmaka.backendjobapplication.repository;

import com.prosigmaka.backendjobapplication.entity.biodata.PelatihanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelatihanRepo extends JpaRepository<PelatihanEntity, Integer> {
}
