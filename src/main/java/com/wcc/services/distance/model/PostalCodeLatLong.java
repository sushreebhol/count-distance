package com.wcc.services.distance.model;

public class PostalCodeLatLong {
	
	private String sourcePostalCode;
	private String sourceLatitude;
	private String sourceLongitude;
	
	private String destinationPostalCode;
	private String destinationLatitude;
	private String destinationLongitude;
	
	private String unit;

	public PostalCodeLatLong(String sourcePostalCode, String sourceLatitude, String sourceLongitude,
			String destinationPostalCode, String destinationLatitude, String destinationLongitude, String unit) {
		super();
		this.sourcePostalCode = sourcePostalCode;
		this.sourceLatitude = sourceLatitude;
		this.sourceLongitude = sourceLongitude;
		this.destinationPostalCode = destinationPostalCode;
		this.destinationLatitude = destinationLatitude;
		this.destinationLongitude = destinationLongitude;
		this.unit = unit;
	}

	public String getSourcePostalCode() {
		return sourcePostalCode;
	}

	public void setSourcePostalCode(String sourcePostalCode) {
		this.sourcePostalCode = sourcePostalCode;
	}

	public String getSourceLatitude() {
		return sourceLatitude;
	}

	public void setSourceLatitude(String sourceLatitude) {
		this.sourceLatitude = sourceLatitude;
	}

	public String getSourceLongitude() {
		return sourceLongitude;
	}

	public void setSourceLongitude(String sourceLongitude) {
		this.sourceLongitude = sourceLongitude;
	}

	public String getDestinationPostalCode() {
		return destinationPostalCode;
	}

	public void setDestinationPostalCode(String destinationPostalCode) {
		this.destinationPostalCode = destinationPostalCode;
	}

	public String getDestinationLatitude() {
		return destinationLatitude;
	}

	public void setDestinationLatitude(String destinationLatitude) {
		this.destinationLatitude = destinationLatitude;
	}

	public String getDestinationLongitude() {
		return destinationLongitude;
	}

	public void setDestinationLongitude(String destinationLongitude) {
		this.destinationLongitude = destinationLongitude;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Distance [sourcePostalCode=" + sourcePostalCode + ", sourceLatitude=" + sourceLatitude
				+ ", sourceLongitude=" + sourceLongitude + ", destinationPostalCode=" + destinationPostalCode
				+ ", destinationLatitude=" + destinationLatitude + ", destinationLongitude=" + destinationLongitude
				+ ", unit=" + unit + "]";
	}
	
}
