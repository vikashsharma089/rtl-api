package au.com.rtl.apps.plant.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import au.com.rtl.apps.plant.model.PlantInspection;
import au.com.rtl.apps.plant.model.PlantInspectionTemplate;


@Repository
public interface PlantInspectionRepository  extends JpaRepository<PlantInspection, Integer> {

	@Query(value = "SELECT p FROM PlantInspection p  where p.plant.plantId=?1") 
	Page<PlantInspection> findByPlantId(Integer plantId,PageRequest pageRequest );
}
