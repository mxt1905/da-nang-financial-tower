package com.uit.danangfinancialtower.repository;

import com.uit.danangfinancialtower.entity.BodyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BodyRepository
 */
@Repository
public interface BodyRepository extends JpaRepository<BodyEntity, String> {
}
