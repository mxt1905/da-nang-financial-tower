package com.uit.danangfinancialtower.repository;

import com.uit.danangfinancialtower.entity.BodyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * BodyRepository
 */
@Repository
public interface BodyRepository extends JpaRepository<BodyEntity, String> {

    List<BodyEntity> findByBuildingId(String buildingId);
}
