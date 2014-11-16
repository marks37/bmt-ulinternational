/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servets;

import DAO.AccountDAO;
import DAO.CallDAO;
import DAO.CallForecastDAO;
import DAO.CallPerformanceDAO;
import DAO.ProductDAO;
import DAO.PurchaseHistoryDAO;
import DAO.SalesDAO;
import DAO.SalesForecastDAO;
import DAO.SalesRepDAO;
import DAO.TrendingProductsDAO;
import Entities.Accounts;
import Entities.CallForecast;
import Entities.CallProgress;
import Entities.Calls;
import Entities.DailyObjectives;
import Entities.Products;
import Entities.Purchases;
import Entities.SalesProgress;
import Entities.SalesReps;
import Entities.Sales_Forecast;
import Entities.Sales_Forecast_Items;
import Entities.Trending_Products;
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
@WebServlet(name = "initiateCustomerEngagement", urlPatterns = {"/initiateCustomerEngagement"})
public class initiateCustomerEngagement extends HttpServlet {

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

            //Gets Call Details
            CallDAO CallDAO = new CallDAO();
            String AccountCode = request.getParameter("AccountCode");
            String CallNo = request.getParameter("CallNo");
            Calls Call = CallDAO.getCallDetails(CallNo);
            session.setAttribute("CallDetails", Call);
            
            //Gets account info
            AccountDAO accountDAO = new AccountDAO();
            Accounts account = accountDAO.viewAccountDetails(AccountCode);
            session.setAttribute("Account", account);
            int AccountId = account.getAccountId();
            
            //Gets sales and call peformance
            SalesDAO SalesDAO = new SalesDAO();
            double CallTarget = CallDAO.getCallTarget(Call.getCallId());
            double MTDSales_Account = SalesDAO.getMTDSales_Account(AccountCode, SalesRepCode);
            double MonthTarget_Account = CallDAO.getMonthSalesTarget_Account(AccountCode, SalesRepCode);
            long CallTarget2 = Math.round(CallTarget);
            long MTDSales2 = Math.round(MTDSales_Account);
            long MonthTarget2 = Math.round(MonthTarget_Account);
            long SalesPerformance = Math.round((MTDSales_Account * 100.0f) / MonthTarget_Account);
            session.setAttribute("CallTarget", CallTarget2);
            session.setAttribute("MTDSales_Account", MTDSales2);
            session.setAttribute("MonthTarget_Account", MonthTarget2);
            session.setAttribute("SalesPerformance_Account", SalesPerformance);
            
            int CoveredCalls = CallDAO.getCoveredCallsCount_Account(SalesRepCode, AccountCode);
            int TotalCalls = CallDAO.getTotalCallsCount_Account(SalesRepCode, AccountCode);
            int CallPerformance = Math.round((CoveredCalls * 100.0f) / TotalCalls);
            session.setAttribute("CoveredCalls_Account", CoveredCalls);
            session.setAttribute("TotalCalls_Account", TotalCalls);
            session.setAttribute("CallPerformance_Account", CallPerformance);
            
            //Gets call forecast
            CallForecastDAO CallForecastDAO = new CallForecastDAO();
            ArrayList<CallForecast> callForecast = CallForecastDAO.getCallForecast(Call.getCallId());
            session.setAttribute("CallForecast", callForecast);
            
            //Gets sales forecast
            SalesForecastDAO SalesForecastDAO = new SalesForecastDAO();
            ArrayList<Sales_Forecast> sales_forecast = SalesForecastDAO.getSalesForecast_Account(AccountCode, SalesRepCode);
            
            String month;
            Sales_Forecast Jan = new Sales_Forecast();
            Sales_Forecast Feb = new Sales_Forecast();
            Sales_Forecast Mar = new Sales_Forecast();
            Sales_Forecast Apr = new Sales_Forecast();
            Sales_Forecast May = new Sales_Forecast();
            Sales_Forecast Jun = new Sales_Forecast();
            Sales_Forecast Jul = new Sales_Forecast();
            Sales_Forecast Aug = new Sales_Forecast();
            Sales_Forecast Sep = new Sales_Forecast();
            Sales_Forecast Oct = new Sales_Forecast();
            Sales_Forecast Nov = new Sales_Forecast();
            Sales_Forecast Dec = new Sales_Forecast();
            double total1 = 0;
            double total2= 0;
            double total3= 0;
            for(int a=0;a<sales_forecast.size();a++){
                month = sales_forecast.get(a).getMonth();
                if(month.equalsIgnoreCase("January")){
                    Jan = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("February")){
                    Feb = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("March")){
                    Mar = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("April")){
                    Apr = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("May")){
                    May = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("June")){
                    Jun = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("July")){
                    Jul = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("August")){
                    Aug = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("September")){
                    Sep = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("October")){
                    Oct = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("November")){
                    Nov = sales_forecast.get(a);
                } else if(month.equalsIgnoreCase("December")){
                    Dec = sales_forecast.get(a);
                }
                total1 = total1 + sales_forecast.get(a).getSalesForecast();
                total2 = total2 + sales_forecast.get(a).getPastYearSales();
                total3 = total3 + sales_forecast.get(a).getActualSales();
            }
            long SalesForecastTotal = Math.round(total1);
            long PastYearSalesTotal = Math.round(total2);
            long ActualSalesTotal = Math.round(total3);
            
            session.setAttribute("SalesForecastTotal", SalesForecastTotal);
            session.setAttribute("PastYearSalesTotal", PastYearSalesTotal);
            session.setAttribute("ActualSalesTotal", ActualSalesTotal);
            session.setAttribute("Jan", Jan);
            session.setAttribute("Feb", Feb);
            session.setAttribute("Mar", Mar);
            session.setAttribute("Apr", Apr);
            session.setAttribute("May", May);
            session.setAttribute("Jun", Jun);
            session.setAttribute("Jul", Jul);
            session.setAttribute("Aug", Aug);
            session.setAttribute("Sep", Sep);
            session.setAttribute("Oct", Oct);
            session.setAttribute("Nov", Nov);
            session.setAttribute("Dec", Dec);
            session.setAttribute("SalesForecast", sales_forecast);
            
            //Gets This Year purchases
            PurchaseHistoryDAO PurchaseHistoryDAO = new PurchaseHistoryDAO();
            ArrayList<Purchases> Purchases = PurchaseHistoryDAO.getPurchases(AccountCode, SalesRepCode);
            session.setAttribute("Purchases", Purchases);
            
            //Gets this month (Last 30 days) trending products
            TrendingProductsDAO TrendingProductsDAO = new TrendingProductsDAO();
            ArrayList<Trending_Products> ThisMonthTrending = TrendingProductsDAO.getThisMonthTrending(AccountCode, SalesRepCode);
            session.setAttribute("ThisMonthTrending", ThisMonthTrending);
            
            //Gets this year (This year) trending products
            ArrayList<Trending_Products> ThisYearTrending = TrendingProductsDAO.getThisYearTrending(AccountCode, SalesRepCode);
            session.setAttribute("ThisYearTrending", ThisYearTrending);
            
            //Gets p3 (p3) trending products
            ArrayList<Trending_Products> P3Trending = TrendingProductsDAO.getP3Trending(AccountCode, SalesRepCode);
            session.setAttribute("P3Trending", P3Trending);
            
            //Gets p6 (p6) trending products
            ArrayList<Trending_Products> P6Trending = TrendingProductsDAO.getP6Trending(AccountCode, SalesRepCode);
            session.setAttribute("P6Trending", P6Trending);
            
            //Gets p9 (p9) trending products
            ArrayList<Trending_Products> P9Trending = TrendingProductsDAO.getP9Trending(AccountCode, SalesRepCode);
            session.setAttribute("P9Trending", P9Trending);
            
            //Gets p12 (p12) trending products
            ArrayList<Trending_Products> P12Trending = TrendingProductsDAO.getP12Trending(AccountCode, SalesRepCode);
            session.setAttribute("P12Trending", P12Trending);
            
            //Gets product list
            ProductDAO ProductsDAO = new ProductDAO();
            ArrayList<Products> Products = ProductsDAO.getProductList();
            session.setAttribute("ProductList", Products);
            
            //Gets suggested orders
            ArrayList<Trending_Products> SuggestedOrders = TrendingProductsDAO.getSuggestedOrders(AccountCode, SalesRepCode);
            session.setAttribute("SuggestedOrders", SuggestedOrders);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("ce_forecast.jsp");
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
