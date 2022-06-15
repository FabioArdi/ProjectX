package com.data_management.projectx.repos;

import com.data_management.projectx.entities.Attitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttitudeRepo extends JpaRepository<Attitude, Long> {
}
