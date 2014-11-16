/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servets;

import DAO.CallDAO;
import DAO.CallPerformanceDAO;
import DAO.SalesForecastDAO;
import DAO.SalesRepDAO;
import Entities.CallProgress;
import Entities.DailyObjectives;
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
@WebServlet(name = "initializeCustomerEngagement", urlPatterns = {"/initializeCustomerEngagement"})
public class initializeCustomerEngagement extends HttpServlet {

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

            //Gets current date
            SimpleDateFormat sdfDate = new SimpleDateFormat("MMM. d, yyyy");//dd/MM/yyyy
            Date now = new Date();
            String strDate = sdfDate.format(now);
            session.setAttribute("CurrentDate", strDate);

            //Gets salesrep or user info
            User user = (User) session.getAttribute("UserAccount");
            int SalesRepId = user.getSalesRepId();
            SalesRepDAO SalDAO = new SalesRepDAO();
            SalesReps rep = SalDAO.getUserInfo(SalesRepId);
            String SalesRepCode = rep.getSalesRepCode();
            session.setAttribute("SalesRepInfo", rep);
            session.setAttribute("SalesRepName", rep.getFullName());
            session.setAttribute("SalesRepCode", SalesRepCode);
            //System.out.println(rep.getFullName()+" Success!"+rep.getSalesRepId()+" = "+SalesRepId); for debugging purposes

            //Gets daily objectives
            CallDAO CallDAO = new CallDAO();
            ArrayList<DailyObjectives> objectives = CallDAO.getDailyObjectives(SalesRepCode);
            int ObjectivesCount = CallDAO.getObjectivesCount(SalesRepCode);
            session.setAttribute("Objectives", objectives);
            session.setAttribute("ObjectivesCount", ObjectivesCount);
            
            //Gets Sales performance
            CallPerformanceDAO CallPerformanceDAO = new CallPerformanceDAO();
            double MTDSales = CallPerformanceDAO.getActualSales(SalesRepCode);
            double MonthTarget = CallDAO.getMonthSalesTarget(SalesRepCode);
            long MTDSales2 = Math.round(MTDSales);
            long MonthTarget2 = Math.round(MonthTarget);
            long SalesPerformance = Math.round((MTDSales * 100.0f) / MonthTarget);
            session.setAttribute("MTDSales", MTDSales2);
            session.setAttribute("MonthTarget", MonthTarget2);
            session.setAttribute("SalesPerformance", SalesPerformance);
            
            //Gets SalesProgress
            ArrayList<SalesProgress> SalesProgress = CallDAO.getSalesProgress(SalesRepCode);
            session.setAttribute("SalesProgress", SalesProgress);
            
            //Gets Call performace
            int CoveredCalls = CallDAO.getCoveredCallsCount(SalesRepCode);
            int TotalCalls = CallDAO.getTotalCallsCount(SalesRepCode);
            int MissedCalls = CallDAO.getMissedCallsCount(SalesRepCode);
            int NewCalls = CallDAO.getNewCallsCount(SalesRepCode);
            int CallPerformance = Math.round((CoveredCalls * 100.0f) / TotalCalls);
            session.setAttribute("CoveredCalls", CoveredCalls);
            session.setAttribute("TotalCalls", TotalCalls);
            session.setAttribute("MissedCalls", MissedCalls);
            session.setAttribute("NewCalls", NewCalls);
            session.setAttribute("CallPerformance", CallPerformance);
            
            //Gets Call progress
            ArrayList<CallProgress> CallProgress = CallDAO.getCallProgress(SalesRepCode);
            session.setAttribute("CallProgress", CallProgress);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ce_review_plans.jsp");
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
