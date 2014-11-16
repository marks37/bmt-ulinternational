/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servets;

import DAO.CallDAO;
import DAO.CallPerformanceDAO;
import DAO.SalesDAO;
import DAO.SalesRepDAO;
import Entities.CallProgress;
import Entities.DailyObjectives;
import Entities.Sales;
import Entities.SalesProgress;
import Entities.SalesReps;
import Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mark
 */
@WebServlet(name = "initializeSalesAnalysis", urlPatterns = {"/initializeSalesAnalysis"})
public class initializeSalesAnalysis extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(-1);
            
            String SalesRepCode = (String) session.getAttribute("SalesRepCode");
            
            //gets total sales for analysis
            SalesDAO SalesDAO = new SalesDAO();
            Sales TotalSales = SalesDAO.getTotalSales(SalesRepCode);
            session.setAttribute("TotalSales", TotalSales);
            
            ArrayList<Sales> TotalSalesByAccount = SalesDAO.getTotalSalesByAccount(SalesRepCode);
            ArrayList<Sales> TotalSalesByProduct = SalesDAO.getTotalSalesByProduct(SalesRepCode);
            session.setAttribute("TotalSalesByAccount", TotalSalesByAccount);
            session.setAttribute("TotalSalesByProduct", TotalSalesByProduct);
            
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("sa_total_sales.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
