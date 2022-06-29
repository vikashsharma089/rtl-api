package au.com.rtl.apps.plant.controller;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantInpectionInputs {

	@JsonProperty("answer_details")
	private List<PlantInpectionInput> data;
	
	  @Column(name = "LATITUDE")
	    private Double latitude;

	    @Column(name = "LONGITUDE")
	    private Double longitude;

	    @Column(name = "LOCATION", length = 100)
	    private String location;

	    @Column(name = "INSPECTION_DATE_AND_TIME")
	    private Instant inspectionDateAndTime;

	    @Column(name = "START_METER")
	    private Integer startMeter;

	    @Column(name = "END_METER")
	    private Integer endMeter;

	    @Column(name = "ROSTER", length = 20)
	    private String roster;

	    @Column(name = "SHIFT", length = 20)
	    private String shift;

	    @Column(name = "PLANT_ID", nullable = false)
	    private Integer plantId;
	    
	    @JsonProperty("employee_id")
	    private Integer employeId;
	    
	    @JsonProperty("emp_img_fileName")
	    private String employeImageFileName;

	public List<PlantInpectionInput> getData() {
		return data;
	}

	public void setData(List<PlantInpectionInput> data) {
		this.data = data;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Instant getInspectionDateAndTime() {
		return inspectionDateAndTime;
	}

	public void setInspectionDateAndTime(Instant inspectionDateAndTime) {
		this.inspectionDateAndTime = inspectionDateAndTime;
	}

	public Integer getStartMeter() {
		return startMeter;
	}

	public void setStartMeter(Integer startMeter) {
		this.startMeter = startMeter;
	}

	public Integer getEndMeter() {
		return endMeter;
	}

	public void setEndMeter(Integer endMeter) {
		this.endMeter = endMeter;
	}

	public String getRoster() {
		return roster;
	}

	public void setRoster(String roster) {
		this.roster = roster;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
	
	

	public String getEmployeImageFileName() {
		return employeImageFileName;
	}

	public void setEmployeImageFileName(String employeImageFileName) {
		this.employeImageFileName = employeImageFileName;
	}

	public Integer getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Integer employeId) {
		this.employeId = employeId;
	}
	
	
	
}
