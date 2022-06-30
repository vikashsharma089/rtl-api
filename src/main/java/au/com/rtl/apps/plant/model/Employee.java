package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", nullable = false)
    private Integer employeeId;

    @Column(name = "FIRST_NAME", length = 30)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 30)
    private String middleName;

    @Column(name = "LAST_NAME", length = 30)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    
	public Employee() {
		super();
	}


	public Employee(Integer employeeId) {
		super();
		this.employeeId = employeeId;
	}
    
    
}
