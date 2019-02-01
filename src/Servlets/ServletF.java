package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Class.WorkWithDB;

public class ServletF extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(WorkWithDB.ff.equals("yes")){
            request.getRequestDispatcher("WEB-INF/jsps/contact.jsp").forward(request, response);
            WorkWithDB.ff = "no";
        }
        String param = request.getParameter("par");
        switch (param){
            case "save":
                try {
                    WorkWithDB.insertContact(request.getParameter("name"), request.getParameter("number"));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("WEB-INF/jsps/contact.jsp").forward(request, response);
                break;
            case "back":
                request.getRequestDispatcher("WEB-INF/jsps/contact.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("WEB-INF/jsps/Add.jsp").forward(request, response);
                break;
        }
        if(param.matches("\\d+")){
            try {
                WorkWithDB.deleteContact(Integer.parseInt(param));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("WEB-INF/jsps/contact.jsp").forward(request, response);
        }
    }
}
