package com.data_management.projectx.repos;

import com.data_management.projectx.entities.Lifestyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifestyleRepo extends JpaRepository<Lifestyle, Long> {
}
