package au.com.rtl.apps.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.rtl.apps.plant.model.PlantInspectionResult;

@Repository
public interface PlantInspectionResultRepository extends JpaRepository<PlantInspectionResult, Integer>  {

}
