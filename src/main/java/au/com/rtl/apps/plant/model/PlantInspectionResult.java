package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PLANT_INSPECTION_RESULT_TX")
@Getter
@Setter
public class PlantInspectionResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANT_INSPECTION_RESULT_TX_ID", nullable = false)
    private Integer plantInspectionReultId;

    @Column(name = "RESULT")
    private Boolean result;

    @Column(name = "HAS_DEFECT")
    private Boolean hasDefect;
    
    @Column(name = "PLANT_INSPECTION_TX_ID", nullable = false)
    private Integer plantInspectionId;
    
    @Column(name = "PLANT_INSPECTION_TEMPLATE_ID", nullable = false)
    private Integer plantInspectionTemplateId;

	public Integer getPlantInspectionReultId() {
		return plantInspectionReultId;
	}

	public void setPlantInspectionReultId(Integer plantInspectionReultId) {
		this.plantInspectionReultId = plantInspectionReultId;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Boolean getHasDefect() {
		return hasDefect;
	}

	public void setHasDefect(Boolean hasDefect) {
		this.hasDefect = hasDefect;
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
