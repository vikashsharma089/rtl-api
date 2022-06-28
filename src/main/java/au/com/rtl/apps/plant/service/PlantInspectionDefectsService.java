package au.com.rtl.apps.plant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.rtl.apps.plant.model.PlantInspectionDefects;
import au.com.rtl.apps.plant.repository.PlantInspectionDefectsRepository;

@Service 
public class PlantInspectionDefectsService {
	
	@Autowired
	private PlantInspectionDefectsRepository plantInspectionDefectsRepository;
	
	public PlantInspectionDefects save(PlantInspectionDefects model) {
		
		model = plantInspectionDefectsRepository.save(model);
		return model;
	}

}
