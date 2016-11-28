package model;

import org.dozer.Mapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by WEO on 9/12/16.
 */

@Entity
@Table(name = "SERVICE")
public class ServiceEntity implements Serializable {

    private static final long serialVersionUID = -7554164565613278171L;
    @Mapping("serviceId")
    private int id;
    @Mapping("serviceName")
    private String servicename;
    @Mapping("serviceTariff")
    private double tariff;
    private Set<ConsumptionEntity> consumptionEntity;

    public ServiceEntity() {
    }

    @OneToMany(mappedBy = "serviceEntity", cascade = CascadeType.ALL)
    public Set<ConsumptionEntity> getConsumptionEntity() {
        return consumptionEntity;
    }

    public void setConsumptionEntity(Set<ConsumptionEntity> consumptionEntities) {
        this.consumptionEntity = consumptionEntities;
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
    @Column(name = "SERVICENAME", nullable = false, length = 30)
    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    @Basic
    @Column(name = "TARIFF", nullable = false, precision = 0)
    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }


}
