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
public class Acc_Inventory {
    
    private int InventoryId;
    private int ProductId;
    private String Status;
    private int Amount;
    private String Date;
    private String AccountId;
    private int StockCount;

    /**
     * @return the InventoryId
     */
    public int getInventoryId() {
        return InventoryId;
    }

    /**
     * @param InventoryId the InventoryId to set
     */
    public void setInventoryId(int InventoryId) {
        this.InventoryId = InventoryId;
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
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
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
     * @return the AccountId
     */
    public String getAccountId() {
        return AccountId;
    }

    /**
     * @param AccountId the AccountId to set
     */
    public void setAccountId(String AccountId) {
        this.AccountId = AccountId;
    }

    /**
     * @return the StockCount
     */
    public int getStockCount() {
        return StockCount;
    }

    /**
     * @param StockCount the StockCount to set
     */
    public void setStockCount(int StockCount) {
        this.StockCount = StockCount;
    }
          
}
