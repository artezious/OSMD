package controller;

import dao.ServiceDAO;
import model.ServiceEntity;
import org.apache.commons.lang3.StringUtils;
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

@ManagedBean(name = "serviceDataTableBean")
@ViewScoped
public class ServiceDataTableBean extends DataTableSearchBean implements Serializable {

    private static final long serialVersionUID = 8378097393814723738L;

    Logger logger = Logger.getLogger(ServiceDataTableBean.class.getName());
    private List<ServiceEntity> serviceEntityList = new ArrayList();
    private ServiceDAO serviceDAO = new ServiceDAO();
    private ServiceEntity serviceDetails;
    private boolean detailsHidden = true;

    @PostConstruct
    public void init() {
        serviceEntityList.addAll(serviceDAO.getService());
    }

    public void find(javax.faces.event.ActionEvent e) {
        find(this);
    }

    public void save() {
        if (!StringUtils.isEmpty(serviceDetails.getServicename())) {
            serviceDAO.saveService(getServiceDetails());
            serviceEntityList = serviceDAO.getService();
        }
    }

    public void selectionListener(SelectEvent event) {
        ServiceEntity temp = (ServiceEntity) event.getObject();
        setServiceDetails(temp);
        detailsHidden = false;
    }

    public void changeListener(AjaxBehaviorEvent event) {
        Object source = event.getSource();
        if (source != null && source.getClass().equals(HtmlInputText.class)) {
            logger.info("change ---> THE FIELD " + ((HtmlInputText) source).getId());
        }
    }

    public List<ServiceEntity> getServiceEntityList() {
        return serviceEntityList;
    }

    public void setServiceEntityList(List<ServiceEntity> serviceEntityList) {
        this.serviceEntityList = serviceEntityList;
    }

    public ServiceDAO getServiceDAO() {
        return serviceDAO;
    }

    public void setServiceDAO(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public ServiceEntity getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(ServiceEntity serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public boolean isDetailsHidden() {
        return detailsHidden;
    }

    public void setDetailsHidden(boolean detailsHidden) {
        this.detailsHidden = detailsHidden;
    }
}
