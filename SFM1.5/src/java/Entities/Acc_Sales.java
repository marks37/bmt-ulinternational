/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author Mark
 */
public class Acc_Sales {
    
    private int SalesId;
    private int Amount;
    private String Date;
    private int ProductId;
    private String AccountId;
    
    
    /**
     * @return the SalesId
     */
    public String getAccountId() {
        return AccountId;
    }

    /**
     * @param SalesId the SalesId to set
     */
    public void setAccountId(String AccountId) {
        this.AccountId = AccountId;
    }

    /**
     * @return the Amount
     */
    

    /**
     * @return the SalesId
     */
    public int getSalesId() {
        return SalesId;
    }

    /**
     * @param SalesId the SalesId to set
     */
    public void setSalesId(int SalesId) {
        this.SalesId = SalesId;
    }

    /**
     * @return the Amount
     */
    public int getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
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
    
    
    
}
