package au.com.rtl.apps.plant.controller;

import java.time.Instant;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PlantInpectionInput {
	
	@JsonProperty("RESULT")
    private Boolean result;

    @JsonProperty( "HAS_DEFECT")
    private Boolean hasDefect;
    
    @JsonProperty( "FILE_NAME")
    private String fileName;
  
    
    
    @JsonProperty("TEMPLATE_ID")
    private Integer plantInspectionTemplateId;
    
    @Column(name = "DEFECT_OBSERVATION", length = 60)
    private String defectObservation;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Boolean getHasDefect() {
		return hasDefect;
	}

	public void setHasDefect(Boolean hasDefect) {
		this.hasDefect = hasDefect;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	public Integer getPlantInspectionTemplateId() {
		return plantInspectionTemplateId;
	}

	public void setPlantInspectionTemplateId(Integer plantInspectionTemplateId) {
		this.plantInspectionTemplateId = plantInspectionTemplateId;
	}

	public String getDefectObservation() {
		return defectObservation;
	}

	public void setDefectObservation(String defectObservation) {
		this.defectObservation = defectObservation;
	}
    
    

}
