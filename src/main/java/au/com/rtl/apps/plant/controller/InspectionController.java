package au.com.rtl.apps.plant.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InspectionController {
    @PutMapping("/inspection/{id}")
    public String createInspectionInstance(@PathVariable(value = "id") Integer inspectionId){
        return "Ispection with Inspection Id "+inspectionId+ "Created";
    }
}
