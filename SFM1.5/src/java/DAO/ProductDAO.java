/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.Products;
import Entities.Sales_Forecast;
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
public class ProductDAO {

    public ArrayList<Products> getProductList() {
        ArrayList<Products> Products = new ArrayList<>();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from products\n"
                    + "left join \n"
                    + "(SELECT *, MAX(EffectiveDate)\n"
                    + "FROM product_pricing\n"
                    + "GROUP BY itemcode DESC) as product_pricing \n"
                    + "on product_pricing.ItemCode = products.ItemCode");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Products product = new Products();
                product.setProductId(rs.getInt("ProductId"));
                product.setRecNo(rs.getString("RecNo"));
                product.setItemCode(rs.getString("ItemCode"));
                product.setItemName(rs.getString("ItemName"));
                product.setDescription(rs.getString("Description"));
                product.setItemClass(rs.getString("ItemClass"));
                product.setBrand(rs.getString("Brand"));
                product.setSubBrand(rs.getString("SubBrand"));
                product.setUnitsOfMeasure(rs.getString("UnitsOfMeasure"));
                product.setCasePack(rs.getString("CasePack"));
                product.setAvailability(rs.getString("Availability"));
                product.setProductPricingId(rs.getInt("ProductPricingId"));
                product.setProductPricingNo(rs.getString("ProductPricingNo"));
                product.setPriceNoVat(rs.getDouble("PriceNoVat"));
                product.setPriceWithVat(rs.getDouble("PriceWithVat"));
                product.setEffectiveDate(rs.getString("EffectiveDate"));
                Products.add(product);
            }

            rs.close();
            pstmt.close();
            conn.close();
            return Products;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Products;
    }

}
