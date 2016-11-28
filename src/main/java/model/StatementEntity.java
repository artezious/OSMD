package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by WEO on 9/12/16.
 */

@Entity
@Table(name = "STATEMENT")
public class StatementEntity implements Serializable {

    private static final long serialVersionUID = 3162663495332691934L;
    private int id;
    private Double debt;
    private PaymentEntity paymentEntity;
    private ConsumptionEntity consumptionEntity;

    public StatementEntity() {
    }

    @ManyToOne
    @JoinColumn(name = "Payment_ID")
    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }
    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    @ManyToOne
    @JoinColumn(name = "Consumption_ID")
    public ConsumptionEntity getConsumptionEntity(){
        return consumptionEntity;
    }

    public void setConsumptionEntity(ConsumptionEntity consumptionEntityID) {
        this.consumptionEntity = consumptionEntityID;
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
    @Column(name = "DEBT", nullable = true, precision = 0)
    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }

}
