package au.com.rtl.apps.plant.controller;

import au.com.rtl.apps.plant.model.PlantInspectionTemplate;
import au.com.rtl.apps.plant.service.PlantInspectionTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/operations/jobs/plant/prestart")
public class TemplateController {
    @Autowired
    PlantInspectionTemplateService plantInspectionTemplateService;
   
    
    @RequestMapping(value = "/template", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<List<PlantInspectionTemplate>> getTemplate() {
        return new ResponseEntity<>(plantInspectionTemplateService.getAllTemplates(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/template/{plantId}", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<List<PlantInspectionTemplate>> getTemplatePlantWise(@PathVariable("plantId") Integer plantId) {
    	List<PlantInspectionTemplate> jsonResponse = plantInspectionTemplateService.getSelectedTemplate(plantId);
    	System.out.print("json response {}"+jsonResponse);
    	 return new ResponseEntity<>(jsonResponse, HttpStatus.OK); 
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
