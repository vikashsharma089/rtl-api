package au.com.rtl.apps.plant.service;

import au.com.rtl.apps.plant.model.PlantInspectionTemplate;
import au.com.rtl.apps.plant.repository.PlantInspectionTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantInspectionTemplateService {
    @Autowired
    private PlantInspectionTemplateRepository plantInspectionTemplateRepository;

    public List<PlantInspectionTemplate> getAllTemplates(){
        List<PlantInspectionTemplate> plantInspectionTemplates= new ArrayList<>();
        plantInspectionTemplateRepository.findAll().forEach(plantInspectionTemplates::add);
        return plantInspectionTemplates;

    }
//    public List<PlantInspectionTemplate> getSelectedTemplate(Integer plantId){
//        List<PlantInspectionTemplate> plantInspectionTemplates= new ArrayList<>();
//        plantInspectionTemplateRepository.findByPlantId(plantId).forEach(plantInspectionTemplates::add);
//        return plantInspectionTemplates;
//
//    }
////    public List<PlantInspectionTemplate> getSelectedTemplatebyModel(String plantModel){
//        List<PlantInspectionTemplate> plantInspectionTemplates= new ArrayList<>();
//        plantInspectionTemplateRepository.findByPlantModel(plantModel).forEach(plantInspectionTemplates::add);
//        return plantInspectionTemplates;
//
//    }
}
