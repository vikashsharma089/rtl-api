package au.com.rtl.apps.plant.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import au.com.rtl.apps.plant.model.PlantInspection;
import au.com.rtl.apps.plant.model.PlantInspectionResult;

@Repository
public interface PlantInspectionResultRepository extends JpaRepository<PlantInspectionResult, Integer>  {
	
	@Query(value = "SELECT p FROM PlantInspectionResult p  where p.plantInspection.plantInspectionId=?1") 
	Page<PlantInspectionResult> findAllByPlantInspection(Integer plantInspection,PageRequest pageRequest );
	
	@Query(value = "SELECT p.plantInspection.plantInspectionId  FROM PlantInspectionResult p  where p.plantInspection.plantInspectionId in ?1 and p.hasDefect=?2") 
	List<Integer> getallinpectionByDefectStatus(List<Integer> plantInspection, Boolean hasDefect );
	
	

}
