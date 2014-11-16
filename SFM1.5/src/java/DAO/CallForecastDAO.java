/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.CallForecast;
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
public class CallForecastDAO {
    
    public ArrayList<CallForecast> getCallForecast(int CallId) {
        ArrayList<CallForecast> CallForecasts = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from Call_Forecast\n"
                    + "where CallId = ?\n"
                    + "order by ItemCode");
            pstmt.setInt(1, CallId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CallForecast callforecast = new CallForecast();
                callforecast.setCallForecastId(rs.getInt("CallForecastId"));
                callforecast.setItemCode(rs.getString("ItemCode"));
                callforecast.setDescripion(rs.getString("Description"));
                callforecast.setStoreCheckForecast(rs.getDouble("StoreCheckForecast"));
                callforecast.setOrderForecast(rs.getDouble("OrderForecast"));
                callforecast.setSalesForecast(rs.getDouble("SalesForecast"));
                callforecast.setDateForecast(rs.getString("Date"));
                callforecast.setCallId(rs.getInt("CallId"));
                CallForecasts.add(callforecast);
            }
            conn.close();
            return CallForecasts;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CallForecasts;
    }
    
}
