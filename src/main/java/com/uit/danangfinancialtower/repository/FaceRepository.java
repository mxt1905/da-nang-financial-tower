package com.uit.danangfinancialtower.repository;

import com.uit.danangfinancialtower.entity.FaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FaceRepository
 */
@Repository
public interface FaceRepository extends JpaRepository<FaceEntity, Long> {
}
