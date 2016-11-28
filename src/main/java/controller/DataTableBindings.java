package controller;

import org.icefaces.ace.component.datatable.DataTable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "dataTableBindings")//it's optional by default
//how do you run the tomcat? do you use run? no, theres profiles...давай попробуем сделеать немного иначе
//заставим томкат плагин самостоятельно собрать вар - не будем юзать tomcat7:run а попробуем либо run-war либо run-war-only
//цель - нагрузить сам tomcat mvn разруливать внутренние контексты и тд и тп - может это баг какой-то ...пробуем? д
@RequestScoped
//можно еще веб хмл првоерить хсд - если у тебя ниже <-2.5 можно обновить до 3 -- посмотрим пока-что так

// Created because MyFaces has id generation issues with non-request scoped
// component bindings.
public class DataTableBindings {
    // Need multiple tables to bind to, as binding to the same table
    // even if the bean is request scoped, causes id errors.
    // MyFaces component binding is very deficient.
    Map<Class, DataTable> tables = new HashMap<Class, DataTable>();

    public Map<Class, DataTable> getTables() {
        return tables;
    }

    public void setTables(Map<Class, DataTable> tables) {
        this.tables = tables;
    }

    public DataTable getTable(Class c) {
        return tables.get(c);
    }
}
