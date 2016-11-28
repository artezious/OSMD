package controller;

import dao.UserDAO;
import model.UserEntity;
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
 * Created by WEO on 9/18/16.
 */

@ManagedBean(name = "userDataTableBean")
@ViewScoped
public class UserDataTableBean extends DataTableSearchBean implements Serializable {

    private static final long serialVersionUID = 422609272394303465L;

    Logger logger = Logger.getLogger(UserDataTableBean.class.getName());
    private List<UserEntity> userEntityList = new ArrayList();
    private UserDAO userDAO = new UserDAO();
    private UserEntity userDetails;
    private boolean detailsHidden = true;


    @PostConstruct
    public void initData() {

       /* userEntityList = new ArrayList();
        UserEntity userEntity = new UserEntity();
        userEntity.setAddress("address111");
        userEntity.setEmail("kjfaksdf");
        userEntity.setName("name");
        userEntity.setTelephone("1239182398");
        userEntity.setSurname("second name");
        userEntityList.add(userEntity);


        userEntity = new UserEntity();
        userEntity.setAddress("address222");
        userEntity.setEmail("kjfaksdf2");
        userEntity.setName("name2");
        userEntity.setTelephone("1239182398");
        userEntity.setSurname("second name");
        userEntityList.add(userEntity);*/

        userEntityList.addAll(userDAO.getUsers());

        //просто проверим что поднимается нормально - дальше будешь уже щелкать и разбираться ок? ok
        /**
         * какие ошибки были - не поменял в веб хмл хом пейдл
         * + не переименовал страничку - была jsp -> xhtml
         * + проблема в выгрузкой данных - посмотришь что к чему
         * + название менедж бина - надо было как минимум с маленькой буквы
         * либо указать название контроллера в скобочках - как мы сделали с тобой здесь
         * @ManagedBean(name = "artem_data_bean"), после чего - везде artem_data_bean - фигурирует на страничке - там же проставляется биндинг
         * между бекендом и ui
         *
         */

    }

 /*   public void addNew(javax.faces.event.ActionEvent e) {

            UserEntity userEntity = new UserEntity();
            userEntity.setUserName();
        userEntity.setUserSurname();
        userEntity.

            consumptionDAO.saveConsumption(consumptionEntity);
        }
    */

    public void save() {
        if (!StringUtils.isEmpty(userDetails.getUserName()) &&
                !StringUtils.isEmpty(userDetails.getUserSurname()) &&
                !StringUtils.isEmpty(userDetails.getUserAddress())) {
            userDAO.saveUser(getUserDetails());
            userEntityList = userDAO.getUsers();
        }
    }

       public void find(javax.faces.event.ActionEvent e) {
           find(this);
       }

    public void selectionListener(SelectEvent event) {
        UserEntity temp = (UserEntity) event.getObject();
        setUserDetails(temp);
        detailsHidden = false;
    }

    public void changeListener(AjaxBehaviorEvent event) {
        Object source = event.getSource();
        if (source != null && source.getClass().equals(HtmlInputText.class)) {
            logger.info("change ---> THE FIELD " + ((HtmlInputText) source).getId());
        }
    }


    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    public boolean isDetailsHidden() {
        return detailsHidden;
    }

    public void setDetailsHidden(boolean detailsHidden) {
        this.detailsHidden = detailsHidden;
    }

}
