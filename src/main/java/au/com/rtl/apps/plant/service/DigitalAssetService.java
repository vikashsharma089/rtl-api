package au.com.rtl.apps.plant.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import au.com.rtl.apps.plant.model.DigitalAsset;
import au.com.rtl.apps.plant.repository.DigitalAssetRepository;

@Service
public class DigitalAssetService {
	
	@Autowired 
	private DigitalAssetRepository digitalAssetRepository;
	
	public DigitalAsset save(MultipartFile multipartFile) throws IOException {
		
		DigitalAsset model  = new DigitalAsset();
		
		model.setAssetDescription(multipartFile.getOriginalFilename());
		model.setAssetStorageLocation("");
		model.setAssetData(multipartFile.getBytes());
		model.setAssetTitle("");
		model.setMediaType(multipartFile.getContentType());
		model = digitalAssetRepository.save(model);
		
		return model ;
	}

}
