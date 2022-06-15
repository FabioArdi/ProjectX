package com.data_management.projectx.repos;

import com.data_management.projectx.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepo extends JpaRepository<Opinion, Long> {
}
