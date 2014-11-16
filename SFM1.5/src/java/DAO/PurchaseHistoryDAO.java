/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.DailyObjectives;
import Entities.Purchases;
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
public class PurchaseHistoryDAO {

    public ArrayList<Purchases> getPurchases(String AccountCode, String SalesRepCode) {
        ArrayList<Purchases> purchases = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description,\n"
                    + "sum(case when Month(Date) = 1 and Year(Date)=Year(curdate()) then Amount else 0 end) JanThisYearAmount, sum(case when Month(Date) = 1 and Year(Date)=Year(curdate()) then Units else 0 end) JanThisYearUnits,\n"
                    + "sum(case when Month(Date) = 1 and Year(Date)<Year(curdate()) then Amount else 0 end) JanPastYearAmount, sum(case when Month(Date) = 1 and Year(Date)<Year(curdate()) then Units else 0 end) JanPastYearUnits,\n"
                    + "sum(case when Month(Date) = 2 and Year(Date)=Year(curdate()) then Amount else 0 end) FebThisYearAmount, sum(case when Month(Date) = 2 and Year(Date)=Year(curdate()) then Units else 0 end) FebThisYearUnits,\n"
                    + "sum(case when Month(Date) = 2 and Year(Date)<Year(curdate()) then Amount else 0 end) FebPastYearAmount, sum(case when Month(Date) = 2 and Year(Date)<Year(curdate()) then Units else 0 end) FebPastYearUnits,\n"
                    + "sum(case when Month(Date) = 3 and Year(Date)=Year(curdate()) then Amount else 0 end) MarThisYearAmount, sum(case when Month(Date) = 3 and Year(Date)=Year(curdate()) then Units else 0 end) MarThisYearUnits,\n"
                    + "sum(case when Month(Date) = 3 and Year(Date)<Year(curdate()) then Amount else 0 end) MarPastYearAmount, sum(case when Month(Date) = 3 and Year(Date)<Year(curdate()) then Units else 0 end) MarPastYearUnits,\n"
                    + "sum(case when Month(Date) = 4 and Year(Date)=Year(curdate()) then Amount else 0 end) AprThisYearAmount, sum(case when Month(Date) = 4 and Year(Date)=Year(curdate()) then Units else 0 end) AprThisYearUnits,\n"
                    + "sum(case when Month(Date) = 4 and Year(Date)<Year(curdate()) then Amount else 0 end) AprPastYearAmount, sum(case when Month(Date) = 4 and Year(Date)<Year(curdate()) then Units else 0 end) AprPastYearUnits,\n"
                    + "sum(case when Month(Date) = 5 and Year(Date)=Year(curdate()) then Amount else 0 end) MayThisYearAmount, sum(case when Month(Date) = 5 and Year(Date)=Year(curdate()) then Units else 0 end) MayThisYearUnits,\n"
                    + "sum(case when Month(Date) = 5 and Year(Date)<Year(curdate()) then Amount else 0 end) MayPastYearAmount, sum(case when Month(Date) = 5 and Year(Date)<Year(curdate()) then Units else 0 end) MayPastYearUnits,\n"
                    + "sum(case when Month(Date) = 6 and Year(Date)=Year(curdate()) then Amount else 0 end) JunThisYearAmount, sum(case when Month(Date) = 6 and Year(Date)=Year(curdate()) then Units else 0 end) JunThisYearUnits,\n"
                    + "sum(case when Month(Date) = 6 and Year(Date)<Year(curdate()) then Amount else 0 end) JunPastYearAmount, sum(case when Month(Date) = 6 and Year(Date)<Year(curdate()) then Units else 0 end) JunPastYearUnits,\n"
                    + "sum(case when Month(Date) = 7 and Year(Date)=Year(curdate()) then Amount else 0 end) JulThisYearAmount, sum(case when Month(Date) = 7 and Year(Date)=Year(curdate()) then Units else 0 end) JulThisYearUnits,\n"
                    + "sum(case when Month(Date) = 7 and Year(Date)<Year(curdate()) then Amount else 0 end) JulPastYearAmount, sum(case when Month(Date) = 7 and Year(Date)<Year(curdate()) then Units else 0 end) JulPastYearUnits,\n"
                    + "sum(case when Month(Date) = 8 and Year(Date)=Year(curdate()) then Amount else 0 end) AugThisYearAmount, sum(case when Month(Date) = 8 and Year(Date)=Year(curdate()) then Units else 0 end) AugThisYearUnits,\n"
                    + "sum(case when Month(Date) = 8 and Year(Date)<Year(curdate()) then Amount else 0 end) AugPastYearAmount, sum(case when Month(Date) = 8 and Year(Date)<Year(curdate()) then Units else 0 end) AugPastYearUnits,\n"
                    + "sum(case when Month(Date) = 9 and Year(Date)=Year(curdate()) then Amount else 0 end) SepThisYearAmount, sum(case when Month(Date) = 9 and Year(Date)=Year(curdate()) then Units else 0 end) SepThisYearUnits,\n"
                    + "sum(case when Month(Date) = 9 and Year(Date)<Year(curdate()) then Amount else 0 end) SepPastYearAmount, sum(case when Month(Date) = 9 and Year(Date)<Year(curdate()) then Units else 0 end) SepPastYearUnits,\n"
                    + "sum(case when Month(Date) = 10 and Year(Date)=Year(curdate()) then Amount else 0 end) OctThisYearAmount, sum(case when Month(Date) = 10 and Year(Date)=Year(curdate()) then Units else 0 end) OctThisYearUnits,\n"
                    + "sum(case when Month(Date) = 10 and Year(Date)<Year(curdate()) then Amount else 0 end) OctPastYearAmount, sum(case when Month(Date) = 10 and Year(Date)<Year(curdate()) then Units else 0 end) OctPastYearUnits,\n"
                    + "sum(case when Month(Date) = 11 and Year(Date)=Year(curdate()) then Amount else 0 end) NovThisYearAmount, sum(case when Month(Date) = 11 and Year(Date)=Year(curdate()) then Units else 0 end) NovThisYearUnits,\n"
                    + "sum(case when Month(Date) = 11 and Year(Date)<Year(curdate()) then Amount else 0 end) NovPastYearAmount, sum(case when Month(Date) = 11 and Year(Date)<Year(curdate()) then Units else 0 end) NovPastYearUnits,\n"
                    + "sum(case when Month(Date) = 12 and Year(Date)=Year(curdate()) then Amount else 0 end) DecThisYearAmount, sum(case when Month(Date) = 12 and Year(Date)=Year(curdate()) then Units else 0 end) DecThisYearUnits,\n"
                    + "sum(case when Month(Date) = 12 and Year(Date)<Year(curdate()) then Amount else 0 end) DecPastYearAmount, sum(case when Month(Date) = 12 and Year(Date)<Year(curdate()) then Units else 0 end) DecPastYearUnits,\n"
                    + "sum(case when Year(Date)=Year(curdate()) then Amount else 0 end) TotalThisYearAmount, sum(case when Year(Date)=Year(curdate()) then Units else 0 end) TotalThisYearUnits,\n"
                    + "sum(case when Year(Date)<Year(curdate()) then Amount else 0 end) TotalPastYearAmount, sum(case when Year(Date)<Year(curdate()) then Units else 0 end) TotalPastYearUnits  \n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "where accountcode = ? and salesrepcode = ?\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having sum(amount) !=0");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Purchases purchase = new Purchases();
                purchase.setItemCode(rs.getString("ItemCode"));
                purchase.setDescription(rs.getString("Description"));
                purchase.setAccountCode(rs.getString("AccountCode"));

                purchase.setJanThisYearUnits(rs.getDouble("JanThisYearUnits"));
                purchase.setFebThisYearUnits(rs.getDouble("FebThisYearUnits"));
                purchase.setMarThisYearUnits(rs.getDouble("MarThisYearUnits"));
                purchase.setAprThisYearUnits(rs.getDouble("AprThisYearUnits"));
                purchase.setMayThisYearUnits(rs.getDouble("MayThisYearUnits"));
                purchase.setJunThisYearUnits(rs.getDouble("JunThisYearUnits"));
                purchase.setJulThisYearUnits(rs.getDouble("JulThisYearUnits"));
                purchase.setAugThisYearUnits(rs.getDouble("AugThisYearUnits"));
                purchase.setSepThisYearUnits(rs.getDouble("SepThisYearUnits"));
                purchase.setOctThisYearUnits(rs.getDouble("OctThisYearUnits"));
                purchase.setNovThisYearUnits(rs.getDouble("NovThisYearUnits"));
                purchase.setDecThisYearUnits(rs.getDouble("DecThisYearUnits"));
                purchase.setTotalThisYearUnits(rs.getDouble("TotalThisYearUnits"));

                purchase.setJanPastYearUnits(rs.getDouble("JanPastYearUnits"));
                purchase.setFebPastYearUnits(rs.getDouble("FebPastYearUnits"));
                purchase.setMarPastYearUnits(rs.getDouble("MarPastYearUnits"));
                purchase.setAprPastYearUnits(rs.getDouble("AprPastYearUnits"));
                purchase.setMayPastYearUnits(rs.getDouble("MayPastYearUnits"));
                purchase.setJunPastYearUnits(rs.getDouble("JunPastYearUnits"));
                purchase.setJulPastYearUnits(rs.getDouble("JulPastYearUnits"));
                purchase.setAugPastYearUnits(rs.getDouble("AugPastYearUnits"));
                purchase.setSepPastYearUnits(rs.getDouble("SepPastYearUnits"));
                purchase.setOctPastYearUnits(rs.getDouble("OctPastYearUnits"));
                purchase.setNovPastYearUnits(rs.getDouble("NovPastYearUnits"));
                purchase.setDecPastYearUnits(rs.getDouble("DecPastYearUnits"));
                purchase.setTotalPastYearUnits(rs.getDouble("TotalPastYearUnits"));

                purchase.setJanThisYearAmount(rs.getDouble("JanThisYearAmount"));
                purchase.setFebThisYearAmount(rs.getDouble("FebThisYearAmount"));
                purchase.setMarThisYearAmount(rs.getDouble("MarThisYearAmount"));
                purchase.setAprThisYearAmount(rs.getDouble("AprThisYearAmount"));
                purchase.setMayThisYearAmount(rs.getDouble("MayThisYearAmount"));
                purchase.setJunThisYearAmount(rs.getDouble("JunThisYearAmount"));
                purchase.setJulThisYearAmount(rs.getDouble("JulThisYearAmount"));
                purchase.setAugThisYearAmount(rs.getDouble("AugThisYearAmount"));
                purchase.setSepThisYearAmount(rs.getDouble("SepThisYearAmount"));
                purchase.setOctThisYearAmount(rs.getDouble("OctThisYearAmount"));
                purchase.setNovThisYearAmount(rs.getDouble("NovThisYearAmount"));
                purchase.setDecThisYearAmount(rs.getDouble("DecThisYearAmount"));
                purchase.setTotalThisYearAmount(rs.getDouble("TotalThisYearAmount"));

                purchase.setJanPastYearAmount(rs.getDouble("JanPastYearAmount"));
                purchase.setFebPastYearAmount(rs.getDouble("FebPastYearAmount"));
                purchase.setMarPastYearAmount(rs.getDouble("MarPastYearAmount"));
                purchase.setAprPastYearAmount(rs.getDouble("AprPastYearAmount"));
                purchase.setMayPastYearAmount(rs.getDouble("MayPastYearAmount"));
                purchase.setJunPastYearAmount(rs.getDouble("JunPastYearAmount"));
                purchase.setJulPastYearAmount(rs.getDouble("JulPastYearAmount"));
                purchase.setAugPastYearAmount(rs.getDouble("AugPastYearAmount"));
                purchase.setSepPastYearAmount(rs.getDouble("SepPastYearAmount"));
                purchase.setOctPastYearAmount(rs.getDouble("OctPastYearAmount"));
                purchase.setNovPastYearAmount(rs.getDouble("NovPastYearAmount"));
                purchase.setDecPastYearAmount(rs.getDouble("DecPastYearAmount"));
                purchase.setTotalPastYearAmount(rs.getDouble("TotalPastYearAmount"));

                purchases.add(purchase);
            }
            conn.close();
            return purchases;
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return purchases;
    }

    public ArrayList<Purchases> getMonthPurchases(int AccountId) {
        ArrayList<Purchases> purchases = new ArrayList<>();

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select Products.ProductId as ProductId, IFNULL(ItemCode,'none') as ItemCode, IFNULL(ItemName,'none') as Description, \n"
                    + "IFNULL(MTDSales,0) as MTDSales, IFNULL(MTDQuantity,0) as MTDQty, \n"
                    + "IFNULL(P3Sales,0) as P3Sales, IFNULL(P3Quantity,0) as P3Qty, \n"
                    + "IFNULL(P6Sales,0) as P6Sales, IFNULL(P6Quantity,0) as P6Qty, \n"
                    + "IFNULL(P9Sales,0) as P9Sales, IFNULL(P9Quantity,0) as P9Qty,\n"
                    + "IFNULL(P12Sales,0) as P12Sales, IFNULL(P12Quantity,0) as P12Qty,\n"
                    + "IFNULL(YTDSales,0) as YTDSales, IFNULL(YTDQuantity,0) as YTDQty,\n"
                    + "IFNULL(PYSales,0) as PYSales, IFNULL(PYQuantity,0) as PYQty\n"
                    + "from sales_items\n"
                    + "left join sales on sales_items.SalesId = sales.SalesId\n"
                    + "left join products on sales_items.ProductId = products.ProductId\n"
                    + "left join\n"
                    + "(select *,sum(sales_items.Sales) as MTDSales, sum(sales_items.Quantity) as MTDQuantity \n"
                    + "from sales_items\n"
                    + "where Month(Sales_items.Date) =  Month(Curdate()) and Year(Sales_items.Date) = Year(Curdate())\n"
                    + "group by ProductId)\n"
                    + "as MTD ON sales_items.SalesItemsId = MTD.SalesItemsId\n"
                    + "left join\n"
                    + "(select *,sum(sales_items.Sales) as P3Sales, sum(sales_items.Quantity) as P3Quantity \n"
                    + "from sales_items\n"
                    + "where Sales_items.Date >= last_day(Curdate())-interval 3 month\n"
                    + "group by ProductId)\n"
                    + "as P3 ON sales_items.SalesItemsId = P3.SalesItemsId\n"
                    + "left join\n"
                    + "(select *,sum(sales_items.Sales) as P6Sales, sum(sales_items.Quantity) as P6Quantity \n"
                    + "from sales_items\n"
                    + "where Sales_items.Date >= last_day(Curdate())-interval 6 month\n"
                    + "group by ProductId)\n"
                    + "as P6 ON sales_items.SalesItemsId = P6.SalesItemsId\n"
                    + "left join\n"
                    + "(select *,sum(sales_items.Sales) as P9Sales, sum(sales_items.Quantity) as P9Quantity \n"
                    + "from sales_items\n"
                    + "where Sales_items.Date >= last_day(Curdate())-interval 9 month\n"
                    + "group by ProductId)\n"
                    + "as P9 ON sales_items.SalesItemsId = P9.SalesItemsId\n"
                    + "left join\n"
                    + "(select *,sum(sales_items.Sales) as P12Sales, sum(sales_items.Quantity) as P12Quantity \n"
                    + "from sales_items\n"
                    + "where Sales_items.Date >= last_day(Curdate())-interval 12 month\n"
                    + "group by ProductId)\n"
                    + "as P12 ON sales_items.SalesItemsId = P12.SalesItemsId\n"
                    + "left join\n"
                    + "(select *,sum(sales_items.Sales) as YTDSales, sum(sales_items.Quantity) as YTDQuantity \n"
                    + "from sales_items\n"
                    + "where Year(Sales_items.Date) = Year(Curdate())\n"
                    + "group by ProductId)\n"
                    + "as YTD ON sales_items.SalesItemsId = YTD.SalesItemsId\n"
                    + "left join\n"
                    + "(select *,sum(sales_items.Sales) as PYSales, sum(sales_items.Quantity) as PYQuantity \n"
                    + "from sales_items\n"
                    + "where Year(Sales_items.Date) >= Year(Curdate())-interval 1 year\n"
                    + "group by ProductId)\n"
                    + "as PY ON sales_items.SalesItemsId = PY.SalesItemsId        \n"
                    + "where AccountId = ? \n"
                    + "group by products.ProductId\n"
                    + "order by ItemCode");
            pstmt.setInt(1, AccountId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Purchases purchase = new Purchases();
                purchase.setProductId(rs.getInt("ProductId"));
                purchase.setItemCode(rs.getString("ItemCode"));
                purchase.setDescription(rs.getString("Description"));
                purchase.setMTDSales(rs.getDouble("MTDSales"));
                purchase.setMTDQuantity(rs.getDouble("MTDQty"));
                purchase.setP3Sales(rs.getDouble("P3Sales"));
                purchase.setP3Quantity(rs.getDouble("P3Qty"));
                purchase.setP6Sales(rs.getDouble("P6Sales"));
                purchase.setP6Quantity(rs.getDouble("P6Qty"));
                purchase.setP9Sales(rs.getDouble("P9Sales"));
                purchase.setP9Quantity(rs.getDouble("P9Qty"));
                purchase.setP12Sales(rs.getDouble("P12Sales"));
                purchase.setP12Quantity(rs.getDouble("p12Qty"));
                purchase.setYTDSales(rs.getDouble("YTDSales"));
                purchase.setYTDQuantity(rs.getDouble("YTDQty"));
                purchase.setPYSales(rs.getDouble("PYSales"));
                purchase.setPYQuantity(rs.getDouble("PYQty"));
                purchases.add(purchase);
            }
            conn.close();
            return purchases;
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return purchases;
    }

}
