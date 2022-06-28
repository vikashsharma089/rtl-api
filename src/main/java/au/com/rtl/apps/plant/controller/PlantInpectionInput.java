package au.com.rtl.apps.plant.controller;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PlantInpectionInput {
	
	@JsonProperty("RESULT")
    private Boolean result;

    @JsonProperty( "HAS_DEFECT")
    private Boolean hasDefect;
    
    @JsonProperty( "FILE_NAME")
    private String fileName;
    
    
    @JsonProperty( "PLANT_ID" )
    private Integer plantId;
  //  plant
    
    @JsonProperty("TEMPLATE_ID")
    private Integer plantInspectionTemplateId;

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

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public Integer getPlantInspectionTemplateId() {
		return plantInspectionTemplateId;
	}

	public void setPlantInspectionTemplateId(Integer plantInspectionTemplateId) {
		this.plantInspectionTemplateId = plantInspectionTemplateId;
	}
    
    

}
