/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.Sales_Forecast;
import Entities.Sales_Forecast_Items;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class SalesForecastDAO {
    
    public ArrayList<Sales_Forecast> getSalesForecast_Account(String AccountCode, String SalesRepCode) {
        ArrayList<Sales_Forecast> Sales_Forecast = new ArrayList<>();
        
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from sales_forecast\n"
                    + "where AccountCode = ? and AssignedSalesRep = ? and Year(DateCreated) = Year(curdate()) \n"
                    + "Order by Month");
            
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Sales_Forecast sales_forecast = new Sales_Forecast();
                sales_forecast.setSalesForecastId(rs.getInt("SalesForecastId"));
                sales_forecast.setSalesForecast(rs.getDouble("SalesForecast"));
                sales_forecast.setOrderFrecast(rs.getDouble("OrderForecast"));
                sales_forecast.setPastYearOrder(rs.getDouble("PastYearOrder"));
                sales_forecast.setPastYearSales(rs.getDouble("PastYearSales"));
                sales_forecast.setActualSales(rs.getDouble("ActualSales"));
                sales_forecast.setDateCreated(rs.getString("DateCreated"));
                sales_forecast.setMonth(rs.getString("Month"));
                sales_forecast.setAssignedSalesRep(rs.getString("AssignedSalesRep"));
                sales_forecast.setAccountCode(rs.getString("AccountCode"));
                Sales_Forecast.add(sales_forecast);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            return Sales_Forecast;
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesForecastDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Sales_Forecast;
    }
    
    public ArrayList<Sales_Forecast_Items> getSalesForecastItems_Account(int SalesForecastId) {
        ArrayList<Sales_Forecast_Items> sales_forecast_items = new ArrayList<>();
        
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select products.ItemCode, products.Description, SalesForecastItemsId, SalesForecast, OrderForecast, ActualSales, PastYearSales, PastYearOrder, Date, SalesForecastId from Sales_Forecast_items\n"
                    + "join products on Sales_Forecast_items.ItemCode = products.ItemCode\n"
                    + "where SalesForecastId = ?\n"
                    + "order by products.itemCode");
            pstmt.setInt(1, SalesForecastId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Sales_Forecast_Items sales_forecast = new Sales_Forecast_Items();
                sales_forecast.setSalesForecastItemsId(rs.getInt("SalesForecastItemsId"));
                sales_forecast.setSalesForecastId(rs.getInt("SalesForecastId"));
                sales_forecast.setSalesForecast(rs.getDouble("SalesForecast"));
                sales_forecast.setOrderForecast(rs.getDouble("OrderForecast"));
                sales_forecast.setActualSales(rs.getDouble("ActualSales"));
                sales_forecast.setPastYearSales(rs.getDouble("PastYearSales"));
                sales_forecast.setPastYearOrder(rs.getDouble("PastYearOrder"));
                sales_forecast.setDate(rs.getString("Date"));
                sales_forecast.setItemCode(rs.getString("products.ItemCode"));
                sales_forecast.setDescription(rs.getString("products.Description"));
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            return sales_forecast_items;
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesForecastDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sales_forecast_items;
    }
    
    public void createSalesForecast_Account() {
        
    }
    
}
