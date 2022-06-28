package au.com.rtl.apps.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.rtl.apps.plant.model.PlantInspectionDefects;


@Repository
public interface PlantInspectionDefectsRepository  extends JpaRepository<PlantInspectionDefects, Integer>  {

}
