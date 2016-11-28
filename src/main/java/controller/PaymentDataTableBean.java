package controller;

import dao.PaymentDAO;
import model.ConsumptionEntity;
import model.PaymentEntity;
import org.icefaces.ace.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by WEO on 9/19/16.
 */

@ManagedBean(name = "paymentDataTableBean")
@ViewScoped
public class PaymentDataTableBean extends DataTableSearchBean implements Serializable {


    private static final long serialVersionUID = 2603053600123272619L;

    private Logger logger = Logger.getLogger(PaymentDataTableBean.class.getName());
    private List<PaymentEntity> paymentEntityList = new ArrayList();
    private ConsumptionEntity consumptionEntity = new ConsumptionEntity();
    private PaymentDAO paymentDAO = new PaymentDAO();
    private PaymentEntity paymentDetails;
    private boolean detailsHidden = true;

    @PostConstruct
    public void init() {
        paymentEntityList.addAll(paymentDAO.getPayment());
    }

    public void save() {
        paymentDAO.savePayment(paymentDetails);
        paymentEntityList = paymentDAO.getPayment();
    }

    public void selectionListener(SelectEvent event) {
        PaymentEntity temp = (PaymentEntity) event.getObject();
        setPaymentDetails(temp);
        detailsHidden = false;
    }

    public void changeListener(AjaxBehaviorEvent event) {
        Object source = event.getSource();
        if (source != null && source.getClass().equals(HtmlInputText.class)) {
            logger.info("change ---> THE FIELD " + ((HtmlInputText) source).getId());
        }
    }

    public void find(javax.faces.event.ActionEvent e) {
        find(this);
    }

    public List<PaymentEntity> getPaymentEntityList() {
        return paymentEntityList;
    }

    public void setPaymentEntityList(List<PaymentEntity> paymentEntityList) {
        this.paymentEntityList = paymentEntityList;
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public void setPaymentDAO(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public PaymentEntity getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentEntity paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public boolean isDetailsHidden() {
        return detailsHidden;
    }

    public void setDetailsHidden(boolean detailsHidden) {
        this.detailsHidden = detailsHidden;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public ConsumptionEntity getConsumptionEntity() {
        return consumptionEntity;
    }

    public void setConsumptionEntity(ConsumptionEntity consumptionEntity) {
        this.consumptionEntity = consumptionEntity;
    }
}
