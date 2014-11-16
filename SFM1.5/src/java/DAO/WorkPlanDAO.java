/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.Accounts;
import Entities.WorkPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class WorkPlanDAO {

    public WorkPlan getMonthlyWorkPlan(int SalesRepId) {
        WorkPlan workplan = new WorkPlan();
        java.util.Date d = Calendar.getInstance().getTime();
        String month = new SimpleDateFormat("MMMM").format(d);
        String year = new SimpleDateFormat("YYYY").format(d);
        //String period = month + " " + year;
        
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from workplan\n"
                    + "where AssignedTo = ? and month=? and year=? and status ='Approved'");
            pstmt.setInt(1, SalesRepId);
            pstmt.setString(2, month);
            pstmt.setString(3, year);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
                workplan.setWorkPlanId(rs.getInt("WorkPlanId"));
                workplan.setWorkPlanNo(rs.getString("WorkPlanNo"));
                workplan.setStatus(rs.getString("Status"));
                workplan.setAssignedTo(rs.getString("AssignedTo"));
                workplan.setMonth(rs.getString("Month"));
                workplan.setYear(rs.getString("Year"));
                
            }
            conn.close();
            return workplan;
        } catch (SQLException ex) {
            Logger.getLogger(WorkPlanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
