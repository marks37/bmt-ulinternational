/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.Accounts;
import Entities.Performance;
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
public class PerformanceDAO {

    public Performance ViewLatestPerformance(int SalesRepId) {
        Performance perf = new Performance();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT \n"
                    + "    t1 . *\n"
                    + "FROM\n"
                    + "    performance t1\n"
                    + "WHERE\n"
                    + "    t1.Performanceid = (SELECT \n"
                    + "            t2.PerformanceId\n"
                    + "        FROM\n"
                    + "            performance t2\n"
                    + "        WHERE\n"
                    + "            t2.SalesReps_SalesRepId = t1.SalesReps_SalesRepId\n"
                    + "        ORDER BY t2.SalesReps_SalesRepId desc\n"
                    + "        LIMIT 1)\n"
                    + "        And SalesReps_SalesRepId = ?");
            pstmt.setInt(1, SalesRepId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                perf.setPerformanceId(rs.getInt("PerformanceId"));
                perf.setMonthTarget(rs.getString("MonthTarget"));
                perf.setActualSales(rs.getString("ActualSales"));
                perf.setDate(rs.getString("Date"));
                perf.setPerformance(rs.getString("%Performance"));
                perf.setSalesRepId(rs.getString("SalesReps_SalesRepId"));
                perf.setSalesGrowth(rs.getString("SalesGrowth"));
                perf.setMissedCalls(rs.getString("MissedCalls"));
                perf.setCompletedCalls(rs.getString("CompletedCalls"));
            }
            conn.close();
            return perf;
        } catch (SQLException ex) {
            Logger.getLogger(PerformanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
