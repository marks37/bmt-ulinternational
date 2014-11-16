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
public class Uni_Inventory {
 
    private int InventoryId;
    private String StockCount;
    private int ProductId;
    private String Date;
    private String Status;

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
     * @return the StockCount
     */
    public String getStockCount() {
        return StockCount;
    }

    /**
     * @param StockCount the StockCount to set
     */
    public void setStockCount(String StockCount) {
        this.StockCount = StockCount;
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
    
}
