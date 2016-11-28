package dto;

import model.ServiceEntity;
import model.UserEntity;

/**
 * Created by WEO on 11/2/16.
 */
public class ConsumptionEntityDTO {

    private int consumptionId;
    private Integer consumptionLV;
    private Integer consumptionRTV;
    private Integer consumptionConsumed;
    private Integer consumptionTotalConsumed;


    private UserEntity userEntity;
    private int userId;
    private String userName;
    private String userSurname;
    private String userAddress;
    private String userEmail;
    private String userTelephone;

    private ServiceEntity serviceEntity;
    private int serviceId;
    private String serviceName;
    private Double serviceTariff;

    public ConsumptionEntityDTO() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public int getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(int consumptionId) {
        this.consumptionId = consumptionId;
    }

    public Integer getConsumptionLV() {
        return consumptionLV;
    }

    public void setConsumptionLV(Integer consumptionLV) {
        this.consumptionLV = consumptionLV;
    }

    public Integer getConsumptionRTV() {
        return consumptionRTV;
    }

    public void setConsumptionRTV(Integer consumptionRTV) {
        this.consumptionRTV = consumptionRTV;
    }

    public Integer getConsumptionConsumed() {
        return consumptionConsumed;
    }

    public void setConsumptionConsumed(Integer consumptionConsumed) {
        this.consumptionConsumed = consumptionConsumed;
    }

    public Integer getConsumptionTotalConsumed() {
        return consumptionTotalConsumed;
    }

    public void setConsumptionTotalConsumed(Integer consumptionTotalConsumed) {
        this.consumptionTotalConsumed = consumptionTotalConsumed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceTariff() {
        return serviceTariff;
    }

    public void setServiceTariff(Double serviceTariff) {
        this.serviceTariff = serviceTariff;
    }
}
