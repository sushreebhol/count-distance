package com.wcc.services.distance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcc.services.distance.model.PostalCodeLatLong;
import com.wcc.services.distance.repository.entities.UkPostalCode;
import com.wcc.services.distance.service.CalculateDistanceService;
import com.wcc.services.distance.util.Constants;

@RestController
public class CalculateDistanceController implements Constants {
	
	@Autowired
	private CalculateDistanceService calculateDistanceService;

	@GetMapping(path = "/distance")
	public PostalCodeLatLong distance(@RequestBody PostalCodeLatLong postalCodeLatLong) {

		String sourcePostalCode = postalCodeLatLong.getSourcePostalCode();
		String destinationPostalCode = postalCodeLatLong.getDestinationPostalCode();
		
		UkPostalCode ukPostalCodeForSource = calculateDistanceService.findByPostalCode(sourcePostalCode);
		UkPostalCode ukPostalCodeForDestination = calculateDistanceService.findByPostalCode(destinationPostalCode);
		
		String sourceLongitude = removeDots(ukPostalCodeForSource.getLongitude());
		String sourceLatitude = removeDots(ukPostalCodeForSource.getLatitude());
		String destinationLongitude = removeDots(ukPostalCodeForDestination.getLongitude());
		String destinationLatitude = removeDots(ukPostalCodeForDestination.getLatitude());
		
		System.out.print("SourceLongitude : " + sourceLongitude + "  " + sourceLatitude + "  " + destinationLongitude + "  " + destinationLatitude);
		
		double distance = calculateDistanceService.calculateDistance(Double.parseDouble(sourceLongitude), Double.parseDouble(sourceLatitude), 
				Double.parseDouble(destinationLongitude), Double.parseDouble(destinationLatitude));
		
		return new PostalCodeLatLong(sourcePostalCode, sourceLongitude, sourceLatitude, 
				destinationPostalCode, destinationLongitude, destinationLatitude, String.format("%.3f", distance) + " KM");
	}

	private String removeDots(String value) {
		String[] valuesArray = value.split("[.]", 0);
		String newValue = "";
		boolean isFirst = true;
		for(int i = 0; i < valuesArray.length ; i++) {
			newValue += valuesArray[i];
			if(isFirst) {
				newValue += ".";
				isFirst = false;	
			}
		}
		return newValue;
	}
}
