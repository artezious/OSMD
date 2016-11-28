package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created by WEO on 9/12/16.
 */

@Entity
@Table(name = "PAYMENT")
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID = -198030189311564206L;
    private int id;
    private Double paid;
    private Date paymentDate;
    private ConsumptionEntity consumptionEntity;
    private Set<StatementEntity> statementEntity;

    public PaymentEntity() {
    }

    @OneToMany(mappedBy = "paymentEntity")
    public Set<StatementEntity> getStatementEntity() {
        return statementEntity;
    }

    public void setStatementEntity(Set<StatementEntity> statementEntity) {
        this.statementEntity = statementEntity;
    }

    @ManyToOne
    @JoinColumn(name = "Consumption_ID")
    public ConsumptionEntity getConsumptionEntity() {
        return consumptionEntity;
    }

    public void setConsumptionEntity(ConsumptionEntity consumptionEntities) {
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
    @Column(name = "PAID", nullable = true, precision = 0)
    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    @Basic
    @Column(name = "PAYMENT_DATE", nullable = true)
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}
