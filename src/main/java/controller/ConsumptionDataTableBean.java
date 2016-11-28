package controller;

import dao.ConsumptionDAO;
import dto.ConsumptionEntityDTO;
import model.ConsumptionEntity;
import model.ServiceEntity;
import model.UserEntity;
import org.dozer.DozerBeanMapper;
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

@ManagedBean(name = "consumptionDataTableBean")
@ViewScoped
public class ConsumptionDataTableBean extends DataTableSearchBean implements Serializable {

    private static final long serialVersionUID = 3064725258383686472L;

    private Logger logger = Logger.getLogger(ServiceDataTableBean.class.getName());
    private List<ConsumptionEntity> consumptionEntityList = new ArrayList();
    private ConsumptionDAO consumptionDAO = new ConsumptionDAO();
    private ConsumptionEntityDTO consumptionDetailsDTO;
    private ServiceEntity serviceEntity = new ServiceEntity();
    private UserEntity userEntity = new UserEntity();
    private boolean detailsHidden = true;
    private List<ConsumptionEntityDTO> consumptionEntityDTOList = new ArrayList();
    private DozerBeanMapper mapper = new DozerBeanMapper();

    @PostConstruct
    public void init() {
        consumptionEntityList.addAll(consumptionDAO.getConsumptions());
        consumptionEntityDTOList = DozerHelper.map(mapper, consumptionEntityList, ConsumptionEntityDTO.class);
    }

    public void find(javax.faces.event.ActionEvent e) {
        find(this);
    }

    public void addNew(javax.faces.event.ActionEvent e) {

        if (checkUserPresence() && checkServicePresence()) {

            ConsumptionEntity consumptionEntity = new ConsumptionEntity();

            consumptionEntity.setUserEntity(consumptionDetailsDTO.getUserEntity());
            consumptionEntity.setServiceEntity(consumptionDetailsDTO.getServiceEntity());
            consumptionEntity.setLv(consumptionDetailsDTO.getConsumptionLV());
            consumptionEntity.setRtv((consumptionDetailsDTO.getConsumptionRTV()));
            consumptionEntity.setConsumed(consumptionDetailsDTO.getConsumptionConsumed());
            consumptionEntity.setTotalConsumed(consumptionDetailsDTO.getConsumptionTotalConsumed());

            consumptionDAO.saveConsumption(consumptionEntity);
        }

    }

    private boolean checkServicePresence() {

        boolean isPresent = false;
        ServiceDataTableBean serviceDataTableBean = new ServiceDataTableBean();
        for (ServiceEntity serviceId : serviceDataTableBean.getServiceEntityList()){
            if ((consumptionDetailsDTO.getServiceId()) == serviceId.getId()) {
                consumptionDetailsDTO.setServiceEntity(serviceId);
                break;
            }
        }
        return isPresent;
    }


    private boolean checkUserPresence() {

        boolean isPresent = false;
        UserDataTableBean userDataTableBean = new UserDataTableBean();
        for (UserEntity userId : userDataTableBean.getUserEntityList()){
            if ((consumptionDetailsDTO.getUserId()) == userId.getUserId()) {
                consumptionDetailsDTO.setUserEntity(userId);
                break;
            }
        }
        return isPresent;
    }

    public void selectionListener(SelectEvent event) {
        ConsumptionEntityDTO temp = (ConsumptionEntityDTO) event.getObject();
        setConsumptionDetailsDTO(temp);
        detailsHidden = false;
    }

    public void changeListener(AjaxBehaviorEvent event) {
        Object source = event.getSource();
        if (source != null && source.getClass().equals(HtmlInputText.class)) {
            logger.info("change ---> THE FIELD " + ((HtmlInputText) source).getId());
        }
    }

    public List<ConsumptionEntity> getConsumptionEntityList() {
        return consumptionEntityList;
    }

    public void setConsumptionEntityList(List<ConsumptionEntity> consumptionEntityList) {
        this.consumptionEntityList = consumptionEntityList;
    }

    public ConsumptionDAO getConsumptionDAO() {
        return consumptionDAO;
    }

    public void setConsumptionDAO(ConsumptionDAO consumptionDAO) {
        this.consumptionDAO = consumptionDAO;
    }

    public boolean isDetailsHidden() {
        return detailsHidden;
    }

    public void setDetailsHidden(boolean detailsHidden) {
        this.detailsHidden = detailsHidden;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public ConsumptionEntityDTO getConsumptionDetailsDTO() {
        return consumptionDetailsDTO;
    }

    public void setConsumptionDetailsDTO(ConsumptionEntityDTO consumptionDetailsDTO) {
        this.consumptionDetailsDTO = consumptionDetailsDTO;
    }

    public List<ConsumptionEntityDTO> getConsumptionEntityDTOList() {
        return consumptionEntityDTOList;
    }

    public void setConsumptionEntityDTOList(List<ConsumptionEntityDTO> consumptionEntityDTOList) {
        this.consumptionEntityDTOList = consumptionEntityDTOList;
    }
}
