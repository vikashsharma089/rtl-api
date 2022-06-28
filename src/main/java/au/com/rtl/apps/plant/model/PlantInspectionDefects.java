package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PLANT_INSPECTION_DEFECTS_TX")
@Getter
@Setter
public class PlantInspectionDefects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANT_INSPECTION_DEFECTS_TX_ID", nullable = false)
    private Integer plantInspectionDefectsId;

    @Column(name = "DEFECT_OBSERVATION", length = 60)
    private String defectObservation;

    @Column(name = "HAS_MEDIA")
    private Boolean hasMedia;
    
    @Column(name = "IMAGES")
    @Lob
    private byte[] images;
    
    @Column(name = "PLANT_INSPECTION_TX_ID", nullable = false)
    private Integer plantInspectionId;
    
    @Column(name = "PLANT_INSPECTION_TEMPLATE_ID", nullable = false)
    private Integer plantInspectionTemplateId;

	public Integer getPlantInspectionDefectsId() {
		return plantInspectionDefectsId;
	}

	public void setPlantInspectionDefectsId(Integer plantInspectionDefectsId) {
		this.plantInspectionDefectsId = plantInspectionDefectsId;
	}

	public String getDefectObservation() {
		return defectObservation;
	}

	public void setDefectObservation(String defectObservation) {
		this.defectObservation = defectObservation;
	}

	public Boolean getHasMedia() {
		return hasMedia;
	}

	public void setHasMedia(Boolean hasMedia) {
		this.hasMedia = hasMedia;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public Integer getPlantInspectionId() {
		return plantInspectionId;
	}

	public void setPlantInspectionId(Integer plantInspectionId) {
		this.plantInspectionId = plantInspectionId;
	}

	public Integer getPlantInspectionTemplateId() {
		return plantInspectionTemplateId;
	}

	public void setPlantInspectionTemplateId(Integer plantInspectionTemplateId) {
		this.plantInspectionTemplateId = plantInspectionTemplateId;
	}
    
    



}
