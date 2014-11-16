/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author BIR
 */
public class Acc_AveProducts {
    
    private int idAve_Products;
    private String Period;
    private String AverageSales;
    private int ProductId;
    private int AccountId;

    /**
     * @return the idAve_Products
     */
    public int getIdAve_Products() {
        return idAve_Products;
    }

    /**
     * @param idAve_Products the idAve_Products to set
     */
    public void setIdAve_Products(int idAve_Products) {
        this.idAve_Products = idAve_Products;
    }

    /**
     * @return the Period
     */
    public String getPeriod() {
        return Period;
    }

    /**
     * @param Period the Period to set
     */
    public void setPeriod(String Period) {
        this.Period = Period;
    }

    /**
     * @return the AverageSales
     */
    public String getAverageSales() {
        return AverageSales;
    }

    /**
     * @param AverageSales the AverageSales to set
     */
    public void setAverageSales(String AverageSales) {
        this.AverageSales = AverageSales;
    }

    /**
     * @return the ProductId
     */
    public int getProductId() {
        return ProductId;
    }

    /**
     * @param ProductId the ProductId to set
     */
    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    /**
     * @return the AccountId
     */
    public int getAccountId() {
        return AccountId;
    }

    /**
     * @param AccountId the AccountId to set
     */
    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    
}
