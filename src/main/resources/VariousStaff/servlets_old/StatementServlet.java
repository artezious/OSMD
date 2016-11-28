package VariousStaff.servlets_old;

import dao.StatementDAO;
import model.StatementEntity;

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

public class StatementServlet extends HttpServlet{

    private static final long serialVersionUID = 315308419458263751L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        StatementDAO statementDAO = new StatementDAO();
        List<StatementEntity> statements = statementDAO.getStatement();

        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<table border='2'>");
        writer.write("<tr>");
        writer.write("<td>");
        writer.write("Statement ID");
        writer.write("</td>");
        writer.write("<td>");
        writer.write("Name");
        writer.write("</td>");
        writer.write("<td>");
        writer.write("Surname");
        writer.write("</td>");
        writer.write("<td>");
        writer.write("Service name");
        writer.write("</td>");
        writer.write("<td>");
        writer.write("Consumed");
        writer.write("</td>");
        writer.write("<td>");
        writer.write("Last paid");
        writer.write("</td>");
        writer.write("<td>");
        writer.write("Payment date");
        writer.write("</td>");
        writer.write("<td>");
        writer.write("Debt");
        writer.write("</td>");

        for (StatementEntity statement : statements) {
            writer.write("<tr>");
            writer.write("<td>");
            writer.write("" + statement.getId());
            writer.write("</td>");
            writer.write("<td>");
            writer.write("" + statement.getUserEntity().getName());
            writer.write("</td>");
            writer.write("<td>");
            writer.write("" + statement.getUserEntity().getSurname());
            writer.write("</td>");
            writer.write("<td>");
            writer.write("" + statement.getPaymentEntity().getConsumptionEntity().getServiceEntity().getServicename());
            writer.write("</td>");
            writer.write("<td>");
            writer.write("" + statement.getPaymentEntity().getConsumptionEntity().getConsumed());
            writer.write("</td>");
            writer.write("<td>");
            writer.write("" + statement.getPaymentEntity().getPaid());
            writer.write("</td>");
            writer.write("<td>");
            writer.write("" + statement.getPaymentEntity().getPaymentDate());
            writer.write("</td>");
            writer.write("<td>");
            writer.write(Double.toString(statement.getDebt()));
            writer.write("</td>");
            writer.write("</tr>");
        }
        writer.write("</tr>");
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</html>");
    }
}

