package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "PLANTS")
@Getter
@Setter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANT_ID", nullable = false)
    private Integer plantId;
    @Column(name = "PLANT_NAME", nullable = false, length = 60)
    private String plantName;
    @Column(name = "PLANT_MODEL", length = 45)
    private String plantModel;

    @Column(name = "IS_WORKING")
    private Integer isWorking;

    @Column(name = "CREATED_ON")
    private Instant createdOn;

    @Column(name = "UPDATED_ON")
    private Instant updatedOn;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plant_type_id", referencedColumnName = "plant_type_id")
    private PlantType plantType;
	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantName=" + plantName + ", plantModel=" + plantModel + ", isWorking="
				+ isWorking + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", plantType=" + plantType
				+ "]";
	}

    
    
    }
