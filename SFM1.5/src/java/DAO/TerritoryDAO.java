/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.Territories;
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
public class TerritoryDAO {

    public ArrayList<Territories> ViewAllTerritories() {
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from territories order by TerritoryId");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Territories> result = new ArrayList<>();
            while (rs.next()) {
                Territories territory = new Territories();
                territory.setArea(rs.getString("Area"));
                territory.setRegion(rs.getString("Region"));
                territory.setTerritoryCode(rs.getString("TerritoryCode"));
                territory.setTerritoryId(rs.getInt("TerritoryId"));
                territory.setZipCode(rs.getString("ZipCode"));
                result.add(territory);
            }
            conn.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(TerritoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addTerritory(Territories te) {
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("Insert into Territories(TerritoryCode, Region, Area, ZipCode) values (?,?,?,?)");
            pstmt.setString(1, te.getTerritoryCode());
            pstmt.setString(2, te.getRegion());
            pstmt.setString(3, te.getArea());
            pstmt.setString(4, te.getZipCode());
            int count = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return count == 1;
        } catch (SQLException ex) {
            Logger.getLogger(Territories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
