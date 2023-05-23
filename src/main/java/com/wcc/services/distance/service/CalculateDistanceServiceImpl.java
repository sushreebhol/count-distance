package com.wcc.services.distance.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.wcc.services.distance.repository.CalculateDistanceRepository;
import com.wcc.services.distance.repository.entities.UkPostalCode;
import com.wcc.services.distance.util.Constants;
import com.wcc.services.distance.util.MathUtil;

@Service
public class CalculateDistanceServiceImpl implements CalculateDistanceService {

	@Autowired
	private CalculateDistanceRepository calculateRepository;
	
	@Override
	public UkPostalCode findByPostalCode(String postalCode) {
		return calculateRepository.findByPostalCode(postalCode);
	}

	@Override
	public double calculateDistance(double sourceLongitude,double sourceLatitude, double destinationLongitude, double destinationLatitude) {

		double sourceLonRadians = Math.toRadians(sourceLongitude);
		double sourceLatRadians = Math.toRadians(sourceLatitude);
		double destinationLonRadians = Math.toRadians(destinationLongitude);
		double destinationLatRadians = Math.toRadians(destinationLatitude);

		double latitudeRadians = MathUtil.haversine(sourceLatRadians, destinationLatRadians);
		double longitudeRadians = MathUtil.haversine(sourceLonRadians, destinationLonRadians);

		double distanceWithRadians = latitudeRadians
				+ Math.cos(sourceLatRadians) * Math.cos(destinationLatRadians) * longitudeRadians;
		double distance = 2 * Math.atan2(Math.sqrt(distanceWithRadians), Math.sqrt(1 - distanceWithRadians));

		return Constants.EARTH_RADIUS * distance;
	}

	public void loadObjectList() {
		List<List<String>> records = new ArrayList<List<String>>();

		Resource resource = new ClassPathResource("classpath:ukpostcodes_subset.csv");
		File file = null;
		try {
			file = resource.getFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				records.add(Arrays.asList(values));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		}

		/*
		 * try { CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
		 * CsvMapper mapper = new CsvMapper(); File file = new
		 * ClassPathResource(fileName).getFile(); MappingIterator<T> readValues =
		 * mapper.reader(type).with(bootstrapSchema).readValues(file);
		 * readValues.readAll(); } catch (Exception e) {
		 * //logger.error("Error occurred while loading object list from file " +
		 * fileName, e); Collections.emptyList(); }
		 */
	}
}