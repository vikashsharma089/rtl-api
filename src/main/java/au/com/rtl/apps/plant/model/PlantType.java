package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PLANT_TYPE")
@Getter
@Setter
public class PlantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Plant_TYPE_ID", nullable = false)
    private Integer plantTypeId;

    @Column(name = "PLANT_TYPE", length = 45)
    private String plantType;

    @Column(name = "Decription", length = 45)
    private String decription;
}
