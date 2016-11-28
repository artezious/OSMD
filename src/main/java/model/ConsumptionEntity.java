package model;

import org.dozer.Mapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by WEO on 9/12/16.
 */

@Entity
@Table(name = "CONSUMPTION")
public class ConsumptionEntity implements Serializable {

    private static final long serialVersionUID = 6141871642725084470L;
    @Mapping("consumptionId")
    private int id;
    @Mapping("consumptionLV")
    private Integer lv;
    @Mapping("consumptionRTV")
    private Integer rtv;
    @Mapping("consumptionConsumed")
    private Integer consumed;
    @Mapping("consumptionTotalConsumed")
    private Integer totalConsumed;
    private Set<PaymentEntity> paymentEntity;
    @Mapping("this")
    private UserEntity userEntity;
    @Mapping("this")
    private ServiceEntity serviceEntity;

    public ConsumptionEntity() {
    }

    @OneToMany(mappedBy = "consumptionEntity")
    public Set<PaymentEntity> getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(Set<PaymentEntity> paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "Service_ID")
    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name = "User_ID")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LV", nullable = true)
    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }

    @Basic
    @Column(name = "RTV", nullable = true)
    public Integer getRtv() {
        return rtv;
    }

    public void setRtv(Integer rtv) {
        this.rtv = rtv;
    }

    @Basic
    @Column(name = "CONSUMED", nullable = true)
    public Integer getConsumed() {
        return consumed;
    }

    public void setConsumed(Integer consumed) {
        this.consumed = consumed;
    }

    @Basic
    @Column(name = "TOTAL_CONSUMED", nullable = true)
    public Integer getTotalConsumed() {
        return totalConsumed;
    }

    public void setTotalConsumed(Integer totalConsumed) {
        this.totalConsumed = totalConsumed;
    }

}
