package com.prosigmaka.backendjobapplication.repository;

import com.prosigmaka.backendjobapplication.entity.biodata.PendidikanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendidikanRepo extends JpaRepository<PendidikanEntity, Integer> {
}
