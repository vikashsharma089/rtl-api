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



}
