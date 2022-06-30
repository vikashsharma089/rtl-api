package au.com.rtl.apps.plant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public Page<PlantInspection> findAllSortByInspectionDate(Integer page , Integer size ){
		PageRequest pageble  = PageRequest.of(page, size, Sort.by("inspectionDateAndTime").descending());
		return plantInspectionServiceRepository.findAll(pageble);
		
	}
	
	
}
