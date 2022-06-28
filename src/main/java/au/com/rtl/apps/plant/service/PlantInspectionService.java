package au.com.rtl.apps.plant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.rtl.apps.plant.model.PlantInspection;
import au.com.rtl.apps.plant.repository.PlantInspectionServiceRepository;

@Service
public class PlantInspectionService {

	@Autowired
	private PlantInspectionServiceRepository plantInspectionServiceRepository;
	
	public void  save(List<PlantInspection> plantInspections) {
		plantInspectionServiceRepository.saveAll(plantInspections);
	}
	
	public PlantInspection  save(PlantInspection model) {
		model = plantInspectionServiceRepository.save(model);
		return model;
	}
}
