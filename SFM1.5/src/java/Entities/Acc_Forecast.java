/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author BIR
 */
public class Acc_Forecast {
    private int idAcc_Forecast;
    private String InventoryForecast;
    private String DemandForecast;
    private int ProductId;
    private int AccountId;
    private String Date;

    /**
     * @return the idAcc_Forecast
     */
    public int getIdAcc_Forecast() {
        return idAcc_Forecast;
    }

    /**
     * @param idAcc_Forecast the idAcc_Forecast to set
     */
    public void setIdAcc_Forecast(int idAcc_Forecast) {
        this.idAcc_Forecast = idAcc_Forecast;
    }

    /**
     * @return the InventoryForecast
     */
    public String getInventoryForecast() {
        return InventoryForecast;
    }

    /**
     * @param InventoryForecast the InventoryForecast to set
     */
    public void setInventoryForecast(String InventoryForecast) {
        this.InventoryForecast = InventoryForecast;
    }

    /**
     * @return the DemandForecast
     */
    public String getDemandForecast() {
        return DemandForecast;
    }

    /**
     * @param DemandForecast the DemandForecast to set
     */
    public void setDemandForecast(String DemandForecast) {
        this.DemandForecast = DemandForecast;
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
    
}
