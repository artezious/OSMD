package controller;

/**
 * Created by WEO on 9/20/16.
 */

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = MenuButtonBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class MenuButtonBean implements Serializable {
    public static final String BEAN_NAME = "menuButtonBean";
    public final String DEFAULT_MESSAGE = "please click on a button and select any menu item without icon";
    public final int MAX_LIST_SIZE = 5;
    private Format formatter;
    private String message;
    private List<String> list;

    /////////////---- CONSTRUCTORS BEGIN
    public MenuButtonBean() {
        formatter = new SimpleDateFormat("HH:mm:ss");
        list = new ArrayList<String>(MAX_LIST_SIZE);
        list.add(DEFAULT_MESSAGE);
    }

    public String getBeanName() {
        return BEAN_NAME;
    }

    /////////////---- ACTION LISTENERS BEGIN
    public void fireAction(ActionEvent event) {
        String[] results = event.getComponent().getParent().getClientId().split(":");
        message = results[results.length - 1].toUpperCase() + " > ";
        results = event.getComponent().getClientId().split(":");
        message += results[results.length - 1].toUpperCase();
        message += " - selected @ " + formatter.format(new Date()) + " (server time)";

        if (list.get(0).equals(DEFAULT_MESSAGE)) {
            list.clear();
        }
        if (list.size() < MAX_LIST_SIZE) {
            list.add(message);
        } else {
            list.clear();
            list.add(message);
        }
    }

    /////////////---- GETTERS & SETTERS BEGIN
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}