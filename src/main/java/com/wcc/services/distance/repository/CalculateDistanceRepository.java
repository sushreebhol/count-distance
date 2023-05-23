package com.wcc.services.distance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wcc.services.distance.repository.entities.UkPostalCode;

@Repository
public interface CalculateDistanceRepository extends CrudRepository<UkPostalCode, Integer> {
	UkPostalCode findByPostalCode(String postalCode);
}
