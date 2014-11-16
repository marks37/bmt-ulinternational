/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.Accounts;
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
public class AccountDAO {

    public ArrayList<Accounts> ViewAllAccounts() {
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from Accounts \n"
                    + "order by AccountId");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Accounts> result = new ArrayList<>();
            while (rs.next()) {
                Accounts account = new Accounts();
                account.setAccountId(rs.getInt("AccountId"));
                account.setAccountCode(rs.getString("AccountCode"));
                account.setAccountName(rs.getString("AccountName"));
                account.setStatus(rs.getString("Status"));
                account.setFrequency(rs.getString("Frequency"));
                account.setPreferredDays(rs.getString("PreferredDays"));
                account.setTerritoryCode(rs.getString("Territories_TerritoryId"));
                result.add(account);
            }
            conn.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addAccount(Accounts ac) {
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("Insert into Accounts(AccountCode, AccountName, Status, Frequency, CompanyName, PreferredDays, Territories_TerritoryId) values (?,?,?,?,?,?,?)");
            pstmt.setString(1, ac.getAccountCode());
            pstmt.setString(2, ac.getAccountName());
            pstmt.setString(3, ac.getStatus());
            pstmt.setString(4, ac.getFrequency());
            pstmt.setString(6, ac.getPreferredDays());
            pstmt.setString(7, ac.getTerritoryCode());
            int count = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return count == 1;
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Accounts viewAccountDetails(String AccountCode) {
        Accounts account = new Accounts();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from accounts\n"
                    + "where AccountCode = ?");
            pstmt.setString(1, AccountCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                account.setAccountId(rs.getInt("AccountId"));
                account.setAccountCode(rs.getString("AccountCode"));
                account.setAccountName(rs.getString("AccountName"));
                account.setType(rs.getString("Type"));
                account.setStatus(rs.getString("Status"));
                account.setChannelType(rs.getString("ChannelType"));
                account.setCustomerClass(rs.getString("CustomerClass"));
                account.setCustomerSubClass(rs.getString("CustomerSubClass"));
                account.setSalesRepAssigned(rs.getString("SalesRepAssigned"));
                account.setFrequency(rs.getString("Frequency"));
                account.setPreferredDays(rs.getString("PreferredDays"));
                account.setEnglishName(rs.getString("EnglishName"));
                account.setTerritoryCode(rs.getString("TerritoryCode"));
                account.setRegion(rs.getString("Region"));
                account.setArea(rs.getString("Area"));
                account.setContact(rs.getString("Contact"));
            }
            conn.close();
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

}
