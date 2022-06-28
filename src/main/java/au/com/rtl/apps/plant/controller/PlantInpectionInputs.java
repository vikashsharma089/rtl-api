package au.com.rtl.apps.plant.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantInpectionInputs {

	@JsonProperty("data")
	private List<PlantInpectionInput> data;

	public List<PlantInpectionInput> getData() {
		return data;
	}

	public void setData(List<PlantInpectionInput> data) {
		this.data = data;
	}
	
	
}
