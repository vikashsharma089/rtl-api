package au.com.rtl.apps.plant.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.rtl.apps.plant.model.DigitalAsset;
import au.com.rtl.apps.plant.model.Employee;
import au.com.rtl.apps.plant.model.Plant;
import au.com.rtl.apps.plant.model.PlantInspection;
import au.com.rtl.apps.plant.model.PlantInspectionDefects;
import au.com.rtl.apps.plant.model.PlantInspectionResult;
import au.com.rtl.apps.plant.model.PlantInspectionTemplate;
import au.com.rtl.apps.plant.service.DigitalAssetService;
import au.com.rtl.apps.plant.service.PlantInspectionDefectsService;
import au.com.rtl.apps.plant.service.PlantInspectionResultService;
import au.com.rtl.apps.plant.service.PlantInspectionService;

@RestController
@Validated
@CrossOrigin("*")
@RequestMapping("/api/v1/operations/jobs/plant/prestart")
public class InspectionController {
	
	Logger logger = LoggerFactory.getLogger(InspectionController.class);
	
	@Autowired
	private PlantInspectionService plantInspectionService;
	
	@Autowired
	private PlantInspectionResultService plantInspectionResultService;
   
	@Autowired
	private PlantInspectionDefectsService plantInspectionDefectsService;
	
	@Autowired 
	private DigitalAssetService digitalAssetService;
	
	
	
	
	@RequestMapping(value = "/inpection" , method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE  })
    public ResponseEntity<Map<String,Object>> submitInspection(@Valid @NotBlank @RequestParam String inputJsonString, @RequestParam(value="files") MultipartFile[] filse) throws IOException{
		
		Map<String,Object> response = new HashMap ();
		ObjectMapper  mapper  = new ObjectMapper();
		Map<String, MultipartFile> imageData = new HashMap();
		for (MultipartFile file : filse) {
			String fileName = file.getOriginalFilename();
			imageData.put(fileName, file);
		}
		
	
		try {
		
		PlantInpectionInputs inputJson = mapper.readValue(inputJsonString, PlantInpectionInputs.class);
		
		PlantInspection  plantInspectionModel = new PlantInspection();
		List<PlantInpectionInput> allInput = inputJson.getData();
		plantInspectionModel.setEndMeter(inputJson.getEndMeter());
		plantInspectionModel.setStartMeter(inputJson.getStartMeter());
		plantInspectionModel.setLatitude(inputJson.getLatitude());
		plantInspectionModel.setLongitude(inputJson.getLongitude());
		plantInspectionModel.setLocation(inputJson.getLocation());
		plantInspectionModel.setInspectionDateAndTime(Instant.now());
		plantInspectionModel.setPlant(new Plant(inputJson.getPlantId()));
		plantInspectionModel.setRoster(inputJson.getRoster());
		plantInspectionModel.setShift(inputJson.getShift());
		plantInspectionModel.setEmployee(new Employee(inputJson.getEmployeId()));
		
		if(imageData.get(inputJson.getEmployeImageFileName()) != null) {
			DigitalAsset empDigitalAsset  = digitalAssetService.save(imageData.get(inputJson.getEmployeImageFileName()));
			plantInspectionModel.setEmployeeImage(empDigitalAsset);
		}
		
		
		
		plantInspectionModel = plantInspectionService.save(plantInspectionModel);
		
		  
		for(PlantInpectionInput data : allInput) { 
		  PlantInspectionResult resultModel  = new PlantInspectionResult();
		  resultModel.setHasDefect(data.getHasDefect());
		  resultModel.setPlantInspection(plantInspectionModel);
		  resultModel.setPlantInspectionTemplateId( new PlantInspectionTemplate(data.getPlantInspectionTemplateId()));
		  resultModel.setResult(data.getResult());
		  
		  
		  
		 if( data.getHasDefect()) {
			 PlantInspectionDefects defectesModel = new PlantInspectionDefects();
			 defectesModel.setDefectObservation(data.getDefectObservation());
			
			if(imageData.get(data.getFileName()) != null) {
			 DigitalAsset defectDigitalAsset  = digitalAssetService.save(imageData.get(data.getFileName()));
			 defectesModel.setDefectImage(defectDigitalAsset);
			}
			 
			 if(data.getFileName() != null) {
				 defectesModel.setHasMedia(true);
			 }else {
				 defectesModel.setHasMedia(false);
			 }
			 
			 defectesModel.setPlantInspectionId(plantInspectionModel.getPlantInspectionId());
			 defectesModel.setPlantInspectionTemplateId(data.getPlantInspectionTemplateId());
			 defectesModel = plantInspectionDefectsService.save(defectesModel);
			 resultModel.setDefects(defectesModel);
		 }
		 
		 plantInspectionResultService.save(resultModel);
		  
		 }
		 
		response.put("status", 200);
		response.put("plantInspectionId", plantInspectionModel.getPlantInspectionId());
		
		}catch(Exception e) {
			response.put("status", 500);
			response.put("error", e.getMessage());
			 return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
       return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getInspection", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<Map<String,Object>> getInspection(
    		@RequestParam(value ="page", defaultValue = "0") int page,
            @RequestParam(value ="size", defaultValue = "3") int size) {
		 Map<String, Object> response = new HashMap();
		try {
		List<Integer> inspectionIds = new ArrayList<Integer>();
		List<PlantInspection> jsonResponse = new ArrayList<PlantInspection>();
		 Page<PlantInspection> requestedPage = plantInspectionService.findAllSortByInspectionDate(page, size);
		 requestedPage.getContent().forEach(jsonResponse::add);
		
		 inspectionIds = requestedPage.getContent().stream().map(e-> e.getPlantInspectionId()).collect(Collectors.toList());
		List<Integer> allInspectinWithDefect =  plantInspectionResultService.findAllinpectionByDefectStatus(inspectionIds, true);
		
		 Map<Integer, Integer> defectsWithCount = allInspectinWithDefect
	                .stream()
	                .collect(
	                        Collectors.toMap(Function.identity(), defect -> 1, Integer::sum)
	                        );
		response.put("totalElement", requestedPage.getTotalElements());
		response.put("totalPage", requestedPage.getTotalPages());
		response.put("numberOfelement", requestedPage.getNumberOfElements());
		response.put("currentPageNmber", requestedPage.getNumber());
		response.put("defectsDetails", defectsWithCount);
		response.put("data", jsonResponse);
	}catch(Exception e) {
		
		response.put("status", 500);
		response.put("error", e.getMessage());
		 return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    	 return new ResponseEntity<>(response, HttpStatus.OK); 
    }

	@RequestMapping(value = "/getInspectionDetail/{plantId}", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<Map<String,Object>> getInspectionDetail(
    		@PathVariable("plantId") Integer plantId,
    		@RequestParam(value ="page", defaultValue = "0") int page,
            @RequestParam(value ="size", defaultValue = "3") int size) {
		 Map<String, Object> response = new HashMap();
		try {
		List<PlantInspection> jsonResponse = new ArrayList<PlantInspection>();
		 Page<PlantInspection> requestedPage = plantInspectionService.findAllByPlantSortByInspectionDate(plantId,page, size);
		 requestedPage.getContent().forEach(jsonResponse::add);
		
		response.put("totalElement", requestedPage.getTotalElements());
		response.put("totalPage", requestedPage.getTotalPages());
		response.put("numberOfelement", requestedPage.getNumberOfElements());
		response.put("currentPageNmber", requestedPage.getNumber());
		response.put("data", jsonResponse);
	}catch(Exception e) {
		
		response.put("status", 500);
		response.put("detail", e.getMessage());
		 return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
    	 return new ResponseEntity<>(response, HttpStatus.OK); 
    }
	
	
	@RequestMapping(value = "/getResultByInspection/{inspectionId}", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<Map<String,Object>> getResultByInspection(
    		@PathVariable("inspectionId") Integer inspection,
    		@RequestParam(value ="page", defaultValue = "0") int page,
            @RequestParam(value ="size", defaultValue = "3") int size) {
		 Map<String, Object> response = new HashMap();
		try {
		List<PlantInspectionResult> jsonResponse = new ArrayList<PlantInspectionResult>();
		 Page<PlantInspectionResult> requestedPage = plantInspectionResultService.findAllResultByInspectionSorBytPlant(inspection,page, size);
		 requestedPage.getContent().forEach(jsonResponse::add);
		
		response.put("totalElement", requestedPage.getTotalElements());
		response.put("totalPage", requestedPage.getTotalPages());
		response.put("numberOfelement", requestedPage.getNumberOfElements());
		response.put("currentPageNmber", requestedPage.getNumber());
		response.put("data", jsonResponse);
	}catch(Exception e) {
		response.put("status", 500);
		response.put("error", e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    	 return new ResponseEntity<>(response, HttpStatus.OK); 
    }

}
