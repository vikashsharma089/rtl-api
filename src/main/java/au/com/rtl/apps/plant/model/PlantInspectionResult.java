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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLANT_INSPECTION_TX_ID", referencedColumnName = "PLANT_INSPECTION_TX_ID")
    private PlantInspection plantInspection;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEFECT_ID", referencedColumnName = "PLANT_INSPECTION_DEFECTS_TX_ID", nullable = true)
    private PlantInspectionDefects defects;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "PLANT_INSPECTION_TEMPLATE_ID", nullable = true)
    private PlantInspectionTemplate plantInspectionTemplateId;

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

	
	public PlantInspection getPlantInspection() {
		return plantInspection;
	}

	public void setPlantInspection(PlantInspection plantInspection) {
		this.plantInspection = plantInspection;
	}

	

	public PlantInspectionTemplate getPlantInspectionTemplateId() {
		return plantInspectionTemplateId;
	}

	public void setPlantInspectionTemplateId(PlantInspectionTemplate plantInspectionTemplateId) {
		this.plantInspectionTemplateId = plantInspectionTemplateId;
	}

	public PlantInspectionDefects getDefects() {
		return defects;
	}

	public void setDefects(PlantInspectionDefects defects) {
		this.defects = defects;
	}
    
	
    

}
