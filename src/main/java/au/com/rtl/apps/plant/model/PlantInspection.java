package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "PLANT_INSPECTION_TX")
public class PlantInspection {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANT_INSPECTION_TX_ID", nullable = false)
    private Integer plantInspectionId;

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
  //  plant


	public Integer getPlantInspectionId() {
		return plantInspectionId;
	}

	public void setPlantInspectionId(Integer plantInspectionId) {
		this.plantInspectionId = plantInspectionId;
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

	
    
    
    

}
