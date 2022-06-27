package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "PLANT_INSPECTION_TX")
@Getter
@Setter
public class PlantInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANT_INSPECTION_TX_ID", nullable = false)
    private Integer plantInspectionId;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LOCATION", length = 100)
    private String location;

    @Column(name = "INSPECTION_DATE_AND_TIME")
    private Instant inspectionDateAndTime;

    @Column(name = "START_METER")
    private Integer startMeter;

    @Column(name = "END_METER")
    private Integer endMeter;

    @Column(name = "ROSTER", length = 20)
    private String roster;

    @Column(name = "SHIFT", length = 20)
    private String shift;


}
