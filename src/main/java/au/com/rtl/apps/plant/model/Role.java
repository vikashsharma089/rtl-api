package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ROLE")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", nullable = false)
    private Integer roleId;

    @Lob
    @Column(name = "ROLE_TYPE", nullable = false)
    private String roleType;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Column(name = "CREATED_ON")
    private Instant createdOn;

    @Column(name = "MODIFIED_ON")
    private Instant modifiedOn;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;
}
