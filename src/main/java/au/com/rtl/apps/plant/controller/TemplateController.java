package au.com.rtl.apps.plant.controller;

import au.com.rtl.apps.plant.model.PlantInspectionTemplate;
import au.com.rtl.apps.plant.service.PlantInspectionTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/operations/jobs/plant/prestart")
public class TemplateController {
    @Autowired
    PlantInspectionTemplateService plantInspectionTemplateService;
    @GetMapping("/template")
    public List<PlantInspectionTemplate> getTemplate() {
        return plantInspectionTemplateService.getAllTemplates();
    }
//    @GetMapping("/template/{palntid}")
//    public List<PlantInspectionTemplate> getTemplatewithPlant(@PathVariable("id") Integer id) {
//        return plantInspectionTemplateService.getSelectedTemplate(id);
//    }
//    @GetMapping("/template/{palntId}")
//    public List<PlantInspectionTemplate> getSelectedTemplatebyModel(@PathVariable("plantId") Integer plantId) {
//        return plantInspectionTemplateService.getSelectedTemplate(plantId);
//    }
    @RequestMapping("/test/{id}")
    public String getSelectedModel(@PathVariable("id") Long employeeId) {
        return "Ashok has "+employeeId.toString()+" Guns";
    }
}
