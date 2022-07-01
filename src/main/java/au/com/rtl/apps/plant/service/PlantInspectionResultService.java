package au.com.rtl.apps.plant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import au.com.rtl.apps.plant.model.PlantInspection;
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
	
		public Page<PlantInspectionResult> findAllResultByInspectionSorBytPlant(Integer InspectionId,Integer page , Integer size ){
		
		PageRequest pageble  = PageRequest.of(page, size, Sort.by("plantInspection.plant.plantId").ascending());
		return plantInspectionResultRepository.findAllByPlantInspection(InspectionId,  pageble);
		
	}

}
