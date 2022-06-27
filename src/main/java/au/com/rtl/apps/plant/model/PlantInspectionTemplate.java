package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "PLANT_INSPECTION_TEMPLATE")
@Getter
@Setter
public class PlantInspectionTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANT_INSPECTION_TEMPLATE_ID", nullable = false)
    private Integer plantInspectionTemplateId;

    @Lob
    @Column(name = "INSPECTION_CATEGORY")
    private String inspectionCategory;

    @Column(name = "SEQUENCE_NO")
    private Integer sequenceNo;

    @Column(name = "INSPECTION_DESCRIPTION", length = 60)
    private String inspectionDescription;

    @Column(name = "IS_ACTIVE")
    private Integer isActive;

    @Column(name = "CREATED_ON")
    private Instant createdOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plant_id", referencedColumnName = "plant_id")
    private Plant plant;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private User createBy;
}
