package com.infy.healthdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.healthdata.entity.HealthSheet;

public interface HealthDataRepository extends JpaRepository<HealthSheet, Integer> {

}
