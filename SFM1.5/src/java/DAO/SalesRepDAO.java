/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.SalesReps;
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
public class SalesRepDAO {

    public SalesReps getUserInfo(int SalesRepId) {
        SalesReps sales = new SalesReps();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from salesreps where SalesRepId=?");
            pstmt.setInt(1, SalesRepId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                sales.setSalesRepId(rs.getInt("SalesRepId"));
                sales.setSalesRepCode(rs.getString("SalesRepCode"));
                sales.setLastName(rs.getString("LastName"));
                sales.setFirstName(rs.getString("FirstName"));
                sales.setFullName(rs.getString("LastName")+", "+rs.getString("FirstName"));
            }

            rs.close();
            pstmt.close();
            conn.close();
            return sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesRepDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sales;
    }

}
