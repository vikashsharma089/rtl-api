package au.com.rtl.apps.plant.repository;

import au.com.rtl.apps.plant.model.PlantInspectionTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PlantInspectionTemplateRepository extends JpaRepository<PlantInspectionTemplate, Integer> {
   
	
	  @Query(value = "SELECT * FROM plant_inspection_template WHERE plant_id=?1",
	  nativeQuery = true) 
	  Collection<PlantInspectionTemplate> findByPlantId(Integer plantId);
	

}
