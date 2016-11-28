package controller;

/**
 * Created by WEO on 10/4/16.
 */

import org.icefaces.ace.component.tooltip.Tooltip;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;


@ManagedBean(name= DelegateTooltipBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class DelegateTooltipBean implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String BEAN_NAME = "delegateTooltipBean";

    public DelegateTooltipBean() {
    }

    public String getBeanName() {
        return BEAN_NAME;
    }

    private Object data;
    private Tooltip tooltip;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }
}
/*

    private boolean cancelListener = false;

    public boolean isCancelListener() {
        return cancelListener;
    }

    public void setCancelListener(boolean cancelListener) {
        this.cancelListener = cancelListener;
    }

 public void listener(org.icefaces.ace.event.TooltipDelegateDisplayEvent event) {

        int index = extractIndex();

        if(cancelListener != false) {
            if (index%2==0){
                //odd rows
                event.cancelDisplay();
            }
            else {
                //even rows
                //do nothing
            }
        }
    }

    private int extractIndex() {
        //extract 'form:tooltip_activeComponent' request parameter, which has the client id of the component that triggered the tooltip
        String reqParam = FacesUtils.getRequestParameter(tooltip.getClientId()+"_activeComponent");

        //expected format is 'form:carTable:7:carName'
        // and for portlets it's '_delegateTooltip_WAR_showcaseportlet_:form:carTable:7:carName'
        int startIndex = reqParam.indexOf("form:consumptions:") + "form:consumptions:".length();
        int endIndex = reqParam.lastIndexOf(":");
        int index = 0;

        try {
            index = Integer.parseInt(reqParam.substring(startIndex, endIndex).trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return index;
    }


}
*/
