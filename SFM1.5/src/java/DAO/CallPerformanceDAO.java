/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class CallPerformanceDAO {
    
    public double getActualSales(String SalesRepCode) {
        double Sales = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT sum(Sales_act) as Sales FROM call_performance\n" +
"where Month(Date) = Month(curdate()) and SalesRepAssigned = ?");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Sales = rs.getDouble("Sales");
            }
            conn.close();
            return Sales;
        } catch (SQLException ex) {
            Logger.getLogger(CallPerformanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Sales;

    }
    
}
