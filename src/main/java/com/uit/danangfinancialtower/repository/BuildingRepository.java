package com.uit.danangfinancialtower.repository;

import com.uit.danangfinancialtower.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BuildingRepository
 */
@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, String> {
}
