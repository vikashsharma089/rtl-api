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

}
