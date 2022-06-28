package au.com.rtl.apps.plant.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import au.com.rtl.apps.plant.model.PlantInspection;
import au.com.rtl.apps.plant.service.PlantInspectionService;

@RestController
@RequestMapping("/api")
public class InspectionController {
	
	@Autowired
	private PlantInspectionService plantInspectionService;
   
	/*
	 * @PutMapping("/inspection/{id}") public String
	 * createInspectionInstance(@PathVariable(value = "id") Integer inspectionId){
	 * 
	 * 
	 * return "Ispection with Inspection Id "+inspectionId+ "Created"; }
	 */
	
	@RequestMapping(value = "/submitinpection" , method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE  })
    public ResponseEntity<Map> submitInspection(@ModelAttribute PlantInpectionInputs inputJson,  @RequestParam(value="files") MultipartFile filse){
		
		
		  List<PlantInspection> allInspection = new ArrayList<PlantInspection>();
		  List<PlantInpectionInput> allInput = inputJson.getData();
		  
		  for(PlantInpectionInput data : allInput) { 
		  PlantInspection plantInspection =  new PlantInspection(); 
		  
		 
		  plantInspection.setEndMeter(0); plantInspection.setShift("test");
		  plantInspection.setPlantId(1); allInspection.add(plantInspection);
		  //input.getFileName(); 
		  }
		 
		
		
		
		
		//plantInspectionService.save(allInspection);
		
       return null;
    }
}
