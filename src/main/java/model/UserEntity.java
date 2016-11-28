package model;

import org.dozer.Mapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by WEO on 9/12/16.
 */

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -278687281884895116L;
    @Mapping("userId")
    private int userId;
    @Mapping("userName")
    private String userName;
    @Mapping("userSurname")
    private String userSurname;
    @Mapping("userAddress")
    private String userAddress;
    @Mapping("userTelephone")
    private String userTelephone;
    @Mapping("userEmail")
    private String userEmail;

    private Set<ConsumptionEntity> consumptionEntity;

    public UserEntity() {
    }

    @OneToMany(mappedBy = "userEntity")
    public Set<ConsumptionEntity> getConsumptionEntity() {
        return consumptionEntity;
    }

    public void setConsumptionEntity(Set<ConsumptionEntity> consumptionEntity) {
        this.consumptionEntity = consumptionEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    @Basic
    @Column(name = "SURNAME", nullable = false, length = 30)
    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String surname) {
        this.userSurname = surname;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = false, length = 50)
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String address) {
        this.userAddress = address;
    }

    @Basic
    @Column(name = "TELEPHONE", nullable = false, length = 30)
    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String telephone) {
        this.userTelephone = telephone;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

}
