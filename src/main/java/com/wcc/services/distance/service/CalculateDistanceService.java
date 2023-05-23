package com.wcc.services.distance.service;

import com.wcc.services.distance.repository.entities.UkPostalCode;

public interface CalculateDistanceService {

	public UkPostalCode findByPostalCode(String postalCode);

	public double calculateDistance(double sourceLongitude, double sourceLatitude, double destinationLongitude, double destinationLatitude);
}
