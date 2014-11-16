/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.Sales;
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
public class SalesDAO {

    public long getMTDSalesF(int SalesRepId) {
        long sales = 0;

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, sum(sales) as MTDSales from sales\n"
                    + "where month(Date) = month(curdate()) and SalesRepId = ?");
            pstmt.setInt(1, SalesRepId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                sales = rs.getInt("MTDSales");
            }

            rs.close();
            pstmt.close();
            conn.close();
            return sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sales;
    }

    public long getMTDTargetF(int SalesRepId) {
        long monthTarget = 0;

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, sum(target) as MonthTarget from sales\n"
                    + "where month(Date) = month(curdate()) and SalesRepId = ?");
            pstmt.setInt(1, SalesRepId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                monthTarget = rs.getInt("MonthTarget");
            }

            rs.close();
            pstmt.close();
            conn.close();
            return monthTarget;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return monthTarget;
    }

    public double getMTDSales_Account(String AccountCode, String SalesRepCode) {
        double result = 0;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select sum(Sales_Act) from calls\n"
                    + "join call_performance on calls.CallNo = call_performance.CallNo\n"
                    + "where Month(CallDate) = Month(curdate()) and SalesRepAssigned = ? and AccountCode = ?\n"
                    + "Group by AccountCode");
            pstmt.setString(1, SalesRepCode);
            pstmt.setString(2, AccountCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getDouble("sum(Sales_Act)");
            }

            rs.close();
            pstmt.close();
            conn.close();
            return result;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<Sales> getAllAccountsSales(String SalesRepCode) {
        ArrayList<Sales> Sales = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select SalesId, AccountCode, SalesRepCode,  \n"
                    + "sum(case when Year(Date) = Year(Curdate()) then Amount else 0 end) Year1Amount, sum(case when Year(Date) = Year(Curdate()) then Units else 0 end) Year1Units,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 then Amount else 0 end) Year2Amount, sum(case when Year(Date) = Year(Curdate())-1 then Units else 0 end) Year2Units,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 then Amount else 0 end) Year3Amount, sum(case when Year(Date) = Year(Curdate())-2 then Units else 0 end) Year3Units \n"
                    + "from sales\n"
                    + "where SalesRepCode = ?\n"
                    + "group by AccountCode,SalesRepCode");
            pstmt.setString(1, SalesRepCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sales sales = new Sales();
                sales.setAccountCode(rs.getString("AccountCode"));
                sales.setSalesRepCode(rs.getString("SalesRepCode"));
                sales.setYear1Amount(rs.getDouble("Year1Amount"));

            }

            rs.close();
            pstmt.close();
            conn.close();
            return Sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Sales;
    }

    public Sales getTotalSales(String SalesRepCode) {
        Sales Sales = new Sales();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select sales.SalesRepCode, \n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '1' then Amount else 0 end) JanTotalAmount, JanTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '2' then Amount else 0 end) FebTotalAmount, FebTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '3' then Amount else 0 end) MarTotalAmount, MarTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '4' then Amount else 0 end) AprTotalAmount, AprTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '5' then Amount else 0 end) MayTotalAmount, MayTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '6' then Amount else 0 end) JunTotalAmount, JunTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '7' then Amount else 0 end) JulTotalAmount, JulTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '8' then Amount else 0 end) AugTotalAmount, AugTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '9' then Amount else 0 end) SepTotalAmount, SepTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '10' then Amount else 0 end) OctTotalAmount, OctTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '11' then Amount else 0 end) NovTotalAmount, NovTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) and Month(Date) = '12' then Amount else 0 end) DecTotalAmount, DecTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) then Amount else 0 end) YearTotalAmount, YearTotalTgt\n"
                    + "from sales\n"
                    + "left join \n"
                    + "(select *,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '1' then SalesTarget else 0 end) JanTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '2' then SalesTarget else 0 end) FebTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '3' then SalesTarget else 0 end) MarTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '4' then SalesTarget else 0 end) AprTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '5' then SalesTarget else 0 end) MayTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '6' then SalesTarget else 0 end) JunTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '7' then SalesTarget else 0 end) JulTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '8' then SalesTarget else 0 end) AugTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '9' then SalesTarget else 0 end) SepTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '10' then SalesTarget else 0 end) OctTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '11' then SalesTarget else 0 end) NovTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) and Month(CallDate) = '12' then SalesTarget else 0 end) DecTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate()) then SalesTarget else 0 end) YearTotalTgt\n"
                    + "from calls\n"
                    + "group by AssignedTo) as calls\n"
                    + "on calls.AssignedTo = sales.SalesRepCode\n"
                    + "where sales.SalesRepCode = ?\n"
                    + "group by SalesRepCode ");
            pstmt.setString(1, SalesRepCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sales sales = new Sales();
                sales.setSalesRepCode(rs.getString("sales.SalesRepCode"));
                sales.setJanTotalAmount(rs.getDouble("JanTotalAmount"));
                sales.setFebTotalAmount(rs.getDouble("FebTotalAmount"));
                sales.setMarTotalAmount(rs.getDouble("MarTotalAmount"));
                sales.setAprTotalAmount(rs.getDouble("AprTotalAmount"));
                sales.setMayTotalAmount(rs.getDouble("MayTotalAmount"));
                sales.setJunTotalAmount(rs.getDouble("JunTotalAmount"));
                sales.setJulTotalAmount(rs.getDouble("JulTotalAmount"));
                sales.setAugTotalAmount(rs.getDouble("AugTotalAmount"));
                sales.setSepTotalAmount(rs.getDouble("SepTotalAmount"));
                sales.setOctTotalAmount(rs.getDouble("OctTotalAmount"));
                sales.setNovTotalAmount(rs.getDouble("NovTotalAmount"));
                sales.setDecTotalAmount(rs.getDouble("DecTotalAmount"));
                sales.setYearTotalAmount(rs.getDouble("YearTotalAmount"));

                sales.setJanTotalTarget(rs.getDouble("JanTotalTgt"));
                sales.setFebTotalTarget(rs.getDouble("FebTotalTgt"));
                sales.setMarTotalTarget(rs.getDouble("MarTotalTgt"));
                sales.setAprTotalTarget(rs.getDouble("AprTotalTgt"));
                sales.setMayTotalTarget(rs.getDouble("MayTotalTgt"));
                sales.setJunTotalTarget(rs.getDouble("JunTotalTgt"));
                sales.setJulTotalTarget(rs.getDouble("JulTotalTgt"));
                sales.setAugTotalTarget(rs.getDouble("AugTotalTgt"));
                sales.setSepTotalTarget(rs.getDouble("SepTotalTgt"));
                sales.setOctTotalTarget(rs.getDouble("OctTotalTgt"));
                sales.setNovTotalTarget(rs.getDouble("NovTotalTgt"));
                sales.setDecTotalTarget(rs.getDouble("DecTotalTgt"));
                sales.setYearTotalTarget(rs.getDouble("YearTotalTgt"));

            }

            rs.close();
            pstmt.close();
            conn.close();
            return Sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Sales;
    }

    public ArrayList<Sales> getTotalSalesByAccount(String SalesRepCode) {
        ArrayList<Sales> Sales = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select salesrepcode, sales_items.AccountCode, EnglishName,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) then Amount else 0 end) Year1Amount,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 then Amount else 0 end) Year2Amount,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 then Amount else 0 end) Year3Amount\n"
                    + "from sales_items\n"
                    + "left join accounts on accounts.AccountCode = sales_items.AccountCode\n"
                    + "where SalesRepCode = ?\n"
                    + "group by sales_items.AccountCode, SalesRepCode\n"
                    + "order by Year1Amount desc\n"
                    + " ");
            pstmt.setString(1, SalesRepCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sales sales = new Sales();
                sales.setAccountCode(rs.getString("sales_items.AccountCode"));
                sales.setSalesRepCode(rs.getString("SalesRepCode"));
                sales.setEnglishName(rs.getString("EnglishName"));
                sales.setYear1Amount(rs.getDouble("Year1Amount"));
                sales.setYear2Amount(rs.getDouble("Year2Amount"));
                sales.setYear3Amount(rs.getDouble("Year3Amount"));
                Sales.add(sales);
            }

            rs.close();
            pstmt.close();
            conn.close();
            return Sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Sales;
    }

    public ArrayList<Sales> getTotalSalesByProduct(String SalesRepCode) {
        ArrayList<Sales> Sales = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select sales_items.ItemCode, products.ItemName, salesrepcode,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) then Amount else 0 end) Year1Amount,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 then Amount else 0 end) Year2Amount,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 then Amount else 0 end) Year3Amount\n"
                    + "from sales_items\n"
                    + "left join products on products.ItemCode = sales_items.ItemCode\n"
                    + "where SalesRepCode = ?\n"
                    + "group by ItemCode,SalesRepCode\n"
                    + "order by Year1Amount desc\n"
                    + " ");
            pstmt.setString(1, SalesRepCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sales sales = new Sales();
                sales.setItemCode(rs.getString("sales_items.ItemCode"));
                sales.setItemName(rs.getString("products.ItemName"));
                sales.setSalesRepCode(rs.getString("SalesRepCode"));
                sales.setYear1Amount(rs.getDouble("Year1Amount"));
                sales.setYear2Amount(rs.getDouble("Year2Amount"));
                sales.setYear3Amount(rs.getDouble("Year3Amount"));
                Sales.add(sales);
            }

            rs.close();
            pstmt.close();
            conn.close();
            return Sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Sales;
    }

    public ArrayList<Sales> getProductSalesByAccount(String SalesRepCode, String AccountCode) {
        ArrayList<Sales> Sales = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select sales_items.ItemCode, products.ItemName, salesrepcode, accountcode,\n"
                    + "sum(case when Year(Date) = Year(Curdate()) then Amount else 0 end) Year1Amount,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 then Amount else 0 end) Year2Amount,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 then Amount else 0 end) Year3Amount\n"
                    + "from sales_items\n"
                    + "left join products on products.ItemCode = sales_items.ItemCode\n"
                    + "where SalesRepCode = ? and AccountCode = ?\n"
                    + "group by ItemCode,SalesRepCode, AccountCode\n"
                    + "order by Year1Amount desc\n"
                    + " ");
            pstmt.setString(1, SalesRepCode);
            pstmt.setString(2, AccountCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sales sales = new Sales();
                sales.setItemCode(rs.getString("sales_items.ItemCode"));
                sales.setItemName(rs.getString("products.ItemName"));
                sales.setSalesRepCode(rs.getString("salesrepcode"));
                sales.setAccountCode(rs.getString("accountcode"));
                sales.setYear1Amount(rs.getDouble("Year1Amount"));
                sales.setYear2Amount(rs.getDouble("Year2Amount"));
                sales.setYear3Amount(rs.getDouble("Year3Amount"));
                Sales.add(sales);
            }

            rs.close();
            pstmt.close();
            conn.close();
            return Sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Sales;
    }

    public ArrayList<Sales> getYear2Sales(String SalesRepCode) {
        ArrayList<Sales> Sales = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select sales.SalesRepCode, \n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '1' then Amount else 0 end) JanTotalAmount, JanTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '2' then Amount else 0 end) FebTotalAmount, FebTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '3' then Amount else 0 end) MarTotalAmount, MarTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '4' then Amount else 0 end) AprTotalAmount, AprTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '5' then Amount else 0 end) MayTotalAmount, MayTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '6' then Amount else 0 end) JunTotalAmount, JunTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '7' then Amount else 0 end) JulTotalAmount, JulTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '8' then Amount else 0 end) AugTotalAmount, AugTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '9' then Amount else 0 end) SepTotalAmount, SepTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '10' then Amount else 0 end) OctTotalAmount, OctTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '11' then Amount else 0 end) NovTotalAmount, NovTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 and Month(Date) = '12' then Amount else 0 end) DecTotalAmount, DecTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-1 then Amount else 0 end) YearTotalAmount, YearTotalTgt\n"
                    + "from sales\n"
                    + "left join \n"
                    + "(select *,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '1' then SalesTarget else 0 end) JanTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '2' then SalesTarget else 0 end) FebTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '3' then SalesTarget else 0 end) MarTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '4' then SalesTarget else 0 end) AprTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '5' then SalesTarget else 0 end) MayTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '6' then SalesTarget else 0 end) JunTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '7' then SalesTarget else 0 end) JulTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '8' then SalesTarget else 0 end) AugTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '9' then SalesTarget else 0 end) SepTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '10' then SalesTarget else 0 end) OctTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '11' then SalesTarget else 0 end) NovTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 and Month(CallDate) = '12' then SalesTarget else 0 end) DecTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-1 then SalesTarget else 0 end) YearTotalTgt\n"
                    + "from calls\n"
                    + "group by AssignedTo) as calls\n"
                    + "on calls.AssignedTo = sales.SalesRepCode\n"
                    + "where sales.SalesRepCode = ?\n"
                    + "group by SalesRepCode ");
            pstmt.setString(1, SalesRepCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sales sales = new Sales();
                sales.setAccountCode(rs.getString("AccountCode"));
                sales.setSalesRepCode(rs.getString("SalesRepCode"));
                sales.setJanTotalAmount(rs.getDouble("JanTotalAmount"));
                sales.setFebTotalAmount(rs.getDouble("FebTotalAmount"));
                sales.setMarTotalAmount(rs.getDouble("MarTotalAmount"));
                sales.setAprTotalAmount(rs.getDouble("AprTotalAmount"));
                sales.setMayTotalAmount(rs.getDouble("MayTotalAmount"));
                sales.setJunTotalAmount(rs.getDouble("JunTotalAmount"));
                sales.setJulTotalAmount(rs.getDouble("JulTotalAmount"));
                sales.setAugTotalAmount(rs.getDouble("AugTotalAmount"));
                sales.setSepTotalAmount(rs.getDouble("SepTotalAmount"));
                sales.setOctTotalAmount(rs.getDouble("OctTotalAmount"));
                sales.setNovTotalAmount(rs.getDouble("NovTotalAmount"));
                sales.setDecTotalAmount(rs.getDouble("DecTotalAmount"));
                sales.setYearTotalAmount(rs.getDouble("YearTotalAmount"));

                sales.setJanTotalAmount(rs.getDouble("JanTotalTgt"));
                sales.setFebTotalAmount(rs.getDouble("FebTotalTgt"));
                sales.setMarTotalAmount(rs.getDouble("MarTotalTgt"));
                sales.setAprTotalAmount(rs.getDouble("AprTotalTgt"));
                sales.setMayTotalAmount(rs.getDouble("MayTotalTgt"));
                sales.setJunTotalAmount(rs.getDouble("JunTotalTgt"));
                sales.setJulTotalAmount(rs.getDouble("JulTotalTgt"));
                sales.setAugTotalAmount(rs.getDouble("AugTotalTgt"));
                sales.setSepTotalAmount(rs.getDouble("SepTotalTgt"));
                sales.setOctTotalAmount(rs.getDouble("OctTotalTgt"));
                sales.setNovTotalAmount(rs.getDouble("NovTotalTgt"));
                sales.setDecTotalAmount(rs.getDouble("DecTotalTgt"));
                sales.setYearTotalTarget(rs.getDouble("YearTotalTgt"));
                Sales.add(sales);
            }

            rs.close();
            pstmt.close();
            conn.close();
            return Sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Sales;
    }

    public ArrayList<Sales> getYear3Sales(String SalesRepCode) {
        ArrayList<Sales> Sales = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select sales.SalesRepCode, \n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '1' then Amount else 0 end) JanTotalAmount, JanTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '2' then Amount else 0 end) FebTotalAmount, FebTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '3' then Amount else 0 end) MarTotalAmount, MarTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '4' then Amount else 0 end) AprTotalAmount, AprTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '5' then Amount else 0 end) MayTotalAmount, MayTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '6' then Amount else 0 end) JunTotalAmount, JunTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '7' then Amount else 0 end) JulTotalAmount, JulTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '8' then Amount else 0 end) AugTotalAmount, AugTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '9' then Amount else 0 end) SepTotalAmount, SepTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '10' then Amount else 0 end) OctTotalAmount, OctTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '11' then Amount else 0 end) NovTotalAmount, NovTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 and Month(Date) = '12' then Amount else 0 end) DecTotalAmount, DecTotalTgt,\n"
                    + "sum(case when Year(Date) = Year(Curdate())-2 then Amount else 0 end) YearTotalAmount, YearTotalTgt\n"
                    + "from sales\n"
                    + "left join \n"
                    + "(select *,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '1' then SalesTarget else 0 end) JanTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '2' then SalesTarget else 0 end) FebTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '3' then SalesTarget else 0 end) MarTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '4' then SalesTarget else 0 end) AprTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '5' then SalesTarget else 0 end) MayTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '6' then SalesTarget else 0 end) JunTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '7' then SalesTarget else 0 end) JulTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '8' then SalesTarget else 0 end) AugTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '9' then SalesTarget else 0 end) SepTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '10' then SalesTarget else 0 end) OctTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '11' then SalesTarget else 0 end) NovTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 and Month(CallDate) = '12' then SalesTarget else 0 end) DecTotalTgt,\n"
                    + "sum(case when Year(CallDate) = Year(Curdate())-2 then SalesTarget else 0 end) YearTotalTgt\n"
                    + "from calls\n"
                    + "group by AssignedTo) as calls\n"
                    + "on calls.AssignedTo = sales.SalesRepCode\n"
                    + "where sales.SalesRepCode = ?\n"
                    + "group by SalesRepCode ");
            pstmt.setString(1, SalesRepCode);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sales sales = new Sales();
                sales.setAccountCode(rs.getString("AccountCode"));
                sales.setSalesRepCode(rs.getString("SalesRepCode"));
                sales.setJanTotalAmount(rs.getDouble("JanTotalAmount"));
                sales.setFebTotalAmount(rs.getDouble("FebTotalAmount"));
                sales.setMarTotalAmount(rs.getDouble("MarTotalAmount"));
                sales.setAprTotalAmount(rs.getDouble("AprTotalAmount"));
                sales.setMayTotalAmount(rs.getDouble("MayTotalAmount"));
                sales.setJunTotalAmount(rs.getDouble("JunTotalAmount"));
                sales.setJulTotalAmount(rs.getDouble("JulTotalAmount"));
                sales.setAugTotalAmount(rs.getDouble("AugTotalAmount"));
                sales.setSepTotalAmount(rs.getDouble("SepTotalAmount"));
                sales.setOctTotalAmount(rs.getDouble("OctTotalAmount"));
                sales.setNovTotalAmount(rs.getDouble("NovTotalAmount"));
                sales.setDecTotalAmount(rs.getDouble("DecTotalAmount"));
                sales.setYearTotalAmount(rs.getDouble("YearTotalAmount"));

                sales.setJanTotalAmount(rs.getDouble("JanTotalTgt"));
                sales.setFebTotalAmount(rs.getDouble("FebTotalTgt"));
                sales.setMarTotalAmount(rs.getDouble("MarTotalTgt"));
                sales.setAprTotalAmount(rs.getDouble("AprTotalTgt"));
                sales.setMayTotalAmount(rs.getDouble("MayTotalTgt"));
                sales.setJunTotalAmount(rs.getDouble("JunTotalTgt"));
                sales.setJulTotalAmount(rs.getDouble("JulTotalTgt"));
                sales.setAugTotalAmount(rs.getDouble("AugTotalTgt"));
                sales.setSepTotalAmount(rs.getDouble("SepTotalTgt"));
                sales.setOctTotalAmount(rs.getDouble("OctTotalTgt"));
                sales.setNovTotalAmount(rs.getDouble("NovTotalTgt"));
                sales.setDecTotalAmount(rs.getDouble("DecTotalTgt"));
                sales.setYearTotalTarget(rs.getDouble("YearTotalTgt"));
                Sales.add(sales);
            }

            rs.close();
            pstmt.close();
            conn.close();
            return Sales;

        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Sales;
    }

}
