/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.CallProgress;
import Entities.Trending_Products;
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
public class TrendingProductsDAO {

    public ArrayList<Trending_Products> getSuggestedOrders(String AccountCode, String SalesRepCode) {
        ArrayList<Trending_Products> Trending_Products = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description, PriceWithVat, PriceNoVat,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Units else 0 end) P3TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Units else 0 end) P3AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Amount else 0 end) P3TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Amount else 0 end) P3AveAmount,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Units else 0 end) P6TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Units else 0 end) P6AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Amount else 0 end) P6TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Amount else 0 end) P6AveAmount,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Units else 0 end) P9TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Units else 0 end) P9AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Amount else 0 end) P9TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Amount else 0 end) P9AveAmount,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Units else 0 end) P12TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Units else 0 end) P12AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Amount else 0 end) P12TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Amount else 0 end) P12AveAmount\n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "left join \n"
                    + "(SELECT *, MAX(EffectiveDate)\n"
                    + "FROM product_pricing\n"
                    + "GROUP BY itemcode DESC) as \n"
                    + "product_pricing on product_pricing.ItemCode = products.itemcode\n"
                    + "where accountcode = ? and salesrepcode = ? and EffectiveDate <= curdate()\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having P12TotalAmount !=0\n"
                    + "order by Description asc");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Trending_Products Trending_Product = new Trending_Products();
                Trending_Product.setAccountCode(rs.getString("AccountCode"));
                Trending_Product.setSalesRepCode(rs.getString("SalesRepCode"));
                Trending_Product.setItemCode(rs.getString("ItemCode"));
                Trending_Product.setDescription(rs.getString("Description"));
                Trending_Product.setP3TotalAmount(rs.getDouble("P3TotalAmount"));
                Trending_Product.setP3TotalUnits(rs.getDouble("P3TotalUnits"));
                Trending_Product.setP3AveAmount(rs.getDouble("P3AveAmount"));
                Trending_Product.setP3AveUnits(rs.getDouble("P3AveUnits"));
                Trending_Product.setP6TotalAmount(rs.getDouble("P6TotalAmount"));
                Trending_Product.setP6TotalUnits(rs.getDouble("P6TotalUnits"));
                Trending_Product.setP6AveAmount(rs.getDouble("P6AveAmount"));
                Trending_Product.setP6AveUnits(rs.getDouble("P6AveUnits"));
                Trending_Product.setP9TotalAmount(rs.getDouble("P9TotalAmount"));
                Trending_Product.setP9TotalUnits(rs.getDouble("P9TotalUnits"));
                Trending_Product.setP9AveAmount(rs.getDouble("P9AveAmount"));
                Trending_Product.setP9AveUnits(rs.getDouble("P9AveUnits"));
                Trending_Product.setP12TotalAmount(rs.getDouble("P12TotalAmount"));
                Trending_Product.setP12TotalUnits(rs.getDouble("P12TotalUnits"));
                Trending_Product.setP12AveAmount(rs.getDouble("P12AveAmount"));
                Trending_Product.setP12AveUnits(rs.getDouble("P12AveUnits"));
                Trending_Product.setPriceWithVat(rs.getDouble("PriceWithVat"));
                Trending_Product.setPriceNoVat(rs.getDouble("PriceNoVat"));
                Trending_Products.add(Trending_Product);
            }
            conn.close();
            return Trending_Products;
        } catch (SQLException ex) {
            Logger.getLogger(TrendingProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Trending_Products;
    }

    public ArrayList<Trending_Products> getThisMonthTrending(String AccountCode, String SalesRepCode) {
        ArrayList<Trending_Products> Trending_Products = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -30 day) then Units else 0 end) ThisMonthTotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -30 day) then Units else 0 end) ThisMonthAveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -30 day) then Amount else 0 end) ThisMonthTotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -30 day) then Amount else 0 end) ThisMonthAveAmount\n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "where accountcode = ? and salesrepcode = ?\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -30 day) then Amount else 0 end)\n"
                    + "order by ThisMonthTotalAmount desc");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Trending_Products Trending_Product = new Trending_Products();
                Trending_Product.setAccountCode(rs.getString("AccountCode"));
                Trending_Product.setSalesRepCode(rs.getString("SalesRepCode"));
                Trending_Product.setItemCode(rs.getString("ItemCode"));
                Trending_Product.setDescription(rs.getString("Description"));
                Trending_Product.setThisMonthTotalAmount(rs.getDouble("ThisMonthTotalAmount"));
                Trending_Product.setThisMonthTotalUnits(rs.getDouble("ThisMonthTotalUnits"));
                Trending_Product.setThisMonthAveAmount(rs.getDouble("ThisMonthAveAmount"));
                Trending_Product.setThisMonthAveUnits(rs.getDouble("ThisMonthAveUnits"));
                Trending_Products.add(Trending_Product);
            }
            conn.close();
            return Trending_Products;
        } catch (SQLException ex) {
            Logger.getLogger(TrendingProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Trending_Products;
    }

    public ArrayList<Trending_Products> getThisYearTrending(String AccountCode, String SalesRepCode) {
        ArrayList<Trending_Products> Trending_Products = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -1 year) then Units else 0 end) ThisYearTotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -1 year) then Units else 0 end) ThisYearAveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -1 year) then Amount else 0 end) ThisYearTotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -1 year) then Amount else 0 end) ThisYearAveAmount\n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "where accountcode = ? and salesrepcode = ?\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -1 year) then Amount else 0 end)\n"
                    + "order by ThisYearTotalAmount desc");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Trending_Products Trending_Product = new Trending_Products();
                Trending_Product.setAccountCode(rs.getString("AccountCode"));
                Trending_Product.setSalesRepCode(rs.getString("SalesRepCode"));
                Trending_Product.setItemCode(rs.getString("ItemCode"));
                Trending_Product.setDescription(rs.getString("Description"));
                Trending_Product.setThisYearTotalAmount(rs.getDouble("ThisYearTotalAmount"));
                Trending_Product.setThisYearTotalUnits(rs.getDouble("ThisYearTotalUnits"));
                Trending_Product.setThisYearAveAmount(rs.getDouble("ThisYearAveAmount"));
                Trending_Product.setThisYearAveUnits(rs.getDouble("ThisYearAveUnits"));
                Trending_Products.add(Trending_Product);
            }
            conn.close();
            return Trending_Products;
        } catch (SQLException ex) {
            Logger.getLogger(TrendingProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Trending_Products;
    }

    public ArrayList<Trending_Products> getP6Trending(String AccountCode, String SalesRepCode) {
        ArrayList<Trending_Products> Trending_Products = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Units else 0 end) P6TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Units else 0 end) P6AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Amount else 0 end) P6TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Amount else 0 end) P6AveAmount\n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "where accountcode = ? and salesrepcode = ?\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -6 month) then Amount else 0 end)\n"
                    + "order by P6TotalAmount desc");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Trending_Products Trending_Product = new Trending_Products();
                Trending_Product.setAccountCode(rs.getString("AccountCode"));
                Trending_Product.setSalesRepCode(rs.getString("SalesRepCode"));
                Trending_Product.setItemCode(rs.getString("ItemCode"));
                Trending_Product.setDescription(rs.getString("Description"));
                Trending_Product.setP6TotalAmount(rs.getDouble("P6TotalAmount"));
                Trending_Product.setP6TotalUnits(rs.getDouble("P6TotalUnits"));
                Trending_Product.setP6AveAmount(rs.getDouble("P6AveAmount"));
                Trending_Product.setP6AveUnits(rs.getDouble("P6AveUnits"));
                Trending_Products.add(Trending_Product);
            }
            conn.close();
            return Trending_Products;
        } catch (SQLException ex) {
            Logger.getLogger(TrendingProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Trending_Products;
    }

    public ArrayList<Trending_Products> getP3Trending(String AccountCode, String SalesRepCode) {
        ArrayList<Trending_Products> Trending_Products = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Units else 0 end) P3TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Units else 0 end) P3AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Amount else 0 end) P3TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Amount else 0 end) P3AveAmount\n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "where accountcode = ? and salesrepcode = ?\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -3 month) then Amount else 0 end)\n"
                    + "order by P3TotalAmount desc");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Trending_Products Trending_Product = new Trending_Products();
                Trending_Product.setAccountCode(rs.getString("AccountCode"));
                Trending_Product.setSalesRepCode(rs.getString("SalesRepCode"));
                Trending_Product.setItemCode(rs.getString("ItemCode"));
                Trending_Product.setDescription(rs.getString("Description"));
                Trending_Product.setP3TotalAmount(rs.getDouble("P3TotalAmount"));
                Trending_Product.setP3TotalUnits(rs.getDouble("P3TotalUnits"));
                Trending_Product.setP3AveAmount(rs.getDouble("P3AveAmount"));
                Trending_Product.setP3AveUnits(rs.getDouble("P3AveUnits"));
                Trending_Products.add(Trending_Product);
            }
            conn.close();
            return Trending_Products;
        } catch (SQLException ex) {
            Logger.getLogger(TrendingProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Trending_Products;
    }

    public ArrayList<Trending_Products> getP9Trending(String AccountCode, String SalesRepCode) {
        ArrayList<Trending_Products> Trending_Products = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Units else 0 end) P9TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Units else 0 end) P9AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Amount else 0 end) P9TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Amount else 0 end) P9AveAmount\n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "where accountcode = ? and salesrepcode = ?\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -9 month) then Amount else 0 end)\n"
                    + "order by P9TotalAmount desc");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Trending_Products Trending_Product = new Trending_Products();
                Trending_Product.setAccountCode(rs.getString("AccountCode"));
                Trending_Product.setSalesRepCode(rs.getString("SalesRepCode"));
                Trending_Product.setItemCode(rs.getString("ItemCode"));
                Trending_Product.setDescription(rs.getString("Description"));
                Trending_Product.setP9TotalAmount(rs.getDouble("P9TotalAmount"));
                Trending_Product.setP9TotalUnits(rs.getDouble("P9TotalUnits"));
                Trending_Product.setP9AveAmount(rs.getDouble("P9AveAmount"));
                Trending_Product.setP9AveUnits(rs.getDouble("P9AveUnits"));
                Trending_Products.add(Trending_Product);
            }
            conn.close();
            return Trending_Products;
        } catch (SQLException ex) {
            Logger.getLogger(TrendingProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Trending_Products;
    }

    public ArrayList<Trending_Products> getP12Trending(String AccountCode, String SalesRepCode) {
        ArrayList<Trending_Products> Trending_Products = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select accountcode, salesrepcode, sales_items.itemcode, Description,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Units else 0 end) P12TotalUnits, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Units else 0 end) P12AveUnits,\n"
                    + "sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Amount else 0 end) P12TotalAmount, avg(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Amount else 0 end) P12AveAmount\n"
                    + "from sales_items\n"
                    + "join products on sales_items.itemCode = products.ItemCode\n"
                    + "where accountcode = ? and salesrepcode = ?\n"
                    + "group by sales_items.ItemCode, salesrepcode, accountcode\n"
                    + "having sum(case when Date > DATE_ADD(CURDATE(), INTERVAL -12 month) then Amount else 0 end)\n"
                    + "order by P12TotalAmount desc");
            pstmt.setString(1, AccountCode);
            pstmt.setString(2, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Trending_Products Trending_Product = new Trending_Products();
                Trending_Product.setAccountCode(rs.getString("AccountCode"));
                Trending_Product.setSalesRepCode(rs.getString("SalesRepCode"));
                Trending_Product.setItemCode(rs.getString("ItemCode"));
                Trending_Product.setDescription(rs.getString("Description"));
                Trending_Product.setP12TotalAmount(rs.getDouble("P12TotalAmount"));
                Trending_Product.setP12TotalUnits(rs.getDouble("P12TotalUnits"));
                Trending_Product.setP12AveAmount(rs.getDouble("P12AveAmount"));
                Trending_Product.setP12AveUnits(rs.getDouble("P12AveUnits"));
                Trending_Products.add(Trending_Product);
            }
            conn.close();
            return Trending_Products;
        } catch (SQLException ex) {
            Logger.getLogger(TrendingProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Trending_Products;
    }

}
