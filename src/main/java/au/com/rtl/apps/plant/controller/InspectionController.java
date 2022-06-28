package au.com.rtl.apps.plant.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.rtl.apps.plant.model.PlantInspection;
import au.com.rtl.apps.plant.model.PlantInspectionDefects;
import au.com.rtl.apps.plant.model.PlantInspectionResult;
import au.com.rtl.apps.plant.service.PlantInspectionDefectsService;
import au.com.rtl.apps.plant.service.PlantInspectionResultService;
import au.com.rtl.apps.plant.service.PlantInspectionService;

@RestController
@RequestMapping("/api")
public class InspectionController {
	
	@Autowired
	private PlantInspectionService plantInspectionService;
	
	@Autowired
	private PlantInspectionResultService plantInspectionResultService;
   
	@Autowired
	private PlantInspectionDefectsService plantInspectionDefectsService;
	
	
	@RequestMapping(value = "/submitinpection" , method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE  })
    public ResponseEntity<Map> submitInspection(@RequestParam String inputJsonString,  @RequestParam(value="files") MultipartFile[] filse) throws IOException{
		Map<String,String> response = new HashMap ();
		ObjectMapper  mapper  = new ObjectMapper();
		Map<String, byte[]> imageData = new HashMap();
		for (MultipartFile file : filse) {
			byte filesByte [] = filse[0].getBytes();
			String fileName = filse[0].getOriginalFilename();
			imageData.put(fileName, filesByte);
		}
		PlantInpectionInputs inputJson = mapper.readValue(inputJsonString, PlantInpectionInputs.class);
		
		PlantInspection  plantInspectionModel = new PlantInspection();
		List<PlantInpectionInput> allInput = inputJson.getData();
		plantInspectionModel.setEndMeter(inputJson.getEndMeter());
		plantInspectionModel.setStartMeter(inputJson.getStartMeter());
		plantInspectionModel.setLatitude(inputJson.getLatitude());
		plantInspectionModel.setLongitude(inputJson.getLongitude());
		plantInspectionModel.setLocation(inputJson.getLocation());
		plantInspectionModel.setPlantId(inputJson.getPlantId());
		plantInspectionModel.setRoster(inputJson.getRoster());
		plantInspectionModel.setShift(inputJson.getShift());
		
		plantInspectionModel = plantInspectionService.save(plantInspectionModel);
		
		  
		for(PlantInpectionInput data : allInput) { 
		  PlantInspectionResult resultModel  = new PlantInspectionResult();
		  resultModel.setHasDefect(data.getHasDefect());
		  resultModel.setPlantInspectionId(plantInspectionModel.getPlantInspectionId());
		  resultModel.setPlantInspectionTemplateId(data.getPlantInspectionTemplateId());
		  resultModel.setResult(data.getResult());
		  
		  plantInspectionResultService.save(resultModel);
		  
		 if( data.getHasDefect()) {
			 PlantInspectionDefects defectesModel = new PlantInspectionDefects();
			 defectesModel.setDefectObservation(data.getDefectObservation());
			 defectesModel.setImages(imageData.get(data.getFileName()));
			 if(data.getFileName() != null) {
				 defectesModel.setHasMedia(true);
			 }else {
				 defectesModel.setHasMedia(false);
			 }
			 
			 defectesModel.setPlantInspectionId(plantInspectionModel.getPlantInspectionId());
			 defectesModel.setPlantInspectionTemplateId(data.getPlantInspectionTemplateId());
			 plantInspectionDefectsService.save(defectesModel);
		 }
		  
		 }
		 
		response.put("status", "success");
		
       return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
