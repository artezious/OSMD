package VariousStaff.servlets_old;

import dao.ServiceDAO;
import model.ServiceEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by WEO on 9/12/16.
 */

public class ServiceServlet extends HttpServlet{

    private static final long serialVersionUID = -6633624261456160067L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ServiceDAO serviceDAO = new ServiceDAO();
        List<ServiceEntity> service = serviceDAO.getService();

        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<table border='2'>");

        writer.write("<tr>");
            writer.write("<td");
            writer.write("Id");
            writer.write("</td>");
            writer.write("<td");
            writer.write("ServiceName");
            writer.write("</td>");
            writer.write("<td");
            writer.write("Tariff");
            writer.write("</td>");
        writer.write("</tr>");
        for (ServiceEntity services : service) {
            writer.write("<tr>");
                writer.write("<td>");
                writer.write("" + services.getId());
                writer.write("</td>");

                writer.write("<td>");
                writer.write(services.getServicename());
                writer.write("</td>");

                writer.write("<td>");
                writer.write(Double.toString(services.getTariff()));
                writer.write("</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</html>");

    }
}
