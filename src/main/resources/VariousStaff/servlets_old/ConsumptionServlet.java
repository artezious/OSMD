package VariousStaff.servlets_old;

import dao.ConsumptionDAO;
import model.ConsumptionEntity;

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

public class ConsumptionServlet extends HttpServlet{

    private static final long serialVersionUID = 283048943694953214L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ConsumptionDAO consumptionDAO = new ConsumptionDAO();
        List<ConsumptionEntity> consumptions = consumptionDAO.getConsumptions();

        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<table border='2'>");


        for (ConsumptionEntity consumption : consumptions) {
            writer.write("<tr>");
                writer.write("<td>");
                writer.write("" + consumption.getId());
                writer.write("</td>");
                writer.write("<td>");
                writer.write("" + consumption.getLv());
                writer.write("</td>");
                writer.write("<td>");
                writer.write("" + consumption.getRtv());
                writer.write("</td>");
                writer.write("<td>");
                writer.write("" + consumption.getConsumed());
                writer.write("</td>");
                writer.write("<td>");
                writer.write("" + consumption.getTotalConsumed());
                writer.write("</td>");
                writer.write("<td>");
                writer.write(consumption.getServiceEntity().getServicename());
                writer.write("</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</html>");

    }
}
