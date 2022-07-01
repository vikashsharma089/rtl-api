package au.com.rtl.apps.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.rtl.apps.plant.model.DigitalAsset;



@Repository
public interface DigitalAssetRepository extends JpaRepository<DigitalAsset, Integer>  {

}
