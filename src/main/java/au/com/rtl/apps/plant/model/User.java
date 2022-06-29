package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "USER_NAME", nullable = false, length = 20)
    private String userName;

    @Column(name = "EMAIL_ID", nullable = false, length = 45)
    private String emailId;

    @Column(name = "PASSWORD", nullable = false, length = 16)
    private String password;

    @Column(name = "MOBILE_NO", nullable = false, length = 15)
    private String mobileNo;
    
    @Column(name = "ROLE_ID", nullable = false)
    private Integer roleId;
    
    }
