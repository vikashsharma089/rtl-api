package au.com.rtl.apps.plant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.rtl.apps.plant.model.PlantInspectionResult;
import au.com.rtl.apps.plant.repository.PlantInspectionResultRepository;

@Service 
public class PlantInspectionResultService {
	
	@Autowired 
	public PlantInspectionResultRepository plantInspectionResultRepository;
	
	public  PlantInspectionResult save(PlantInspectionResult model) {
		model = plantInspectionResultRepository.save(model);
		return model;
	}

}
