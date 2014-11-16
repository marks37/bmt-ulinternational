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
public class CallForecast {

    private int CallForecastId;
    private String ItemCode;
    private String Descripion;
    private double StoreCheckForecast;
    private double OrderForecast;
    private double SalesForecast;
    private String DateForecast;
    private int CallId;

    /**
     * @return the CallForecastId
     */
    public int getCallForecastId() {
        return CallForecastId;
    }

    /**
     * @param CallForecastId the CallForecastId to set
     */
    public void setCallForecastId(int CallForecastId) {
        this.CallForecastId = CallForecastId;
    }

   /**
     * @return the DateForecast
     */
    public String getDateForecast() {
        return DateForecast;
    }

    /**
     * @param DateForecast the DateForecast to set
     */
    public void setDateForecast(String DateForecast) {
        this.DateForecast = DateForecast;
    }

    /**
     * @return the CallId
     */
    public int getCallId() {
        return CallId;
    }

    /**
     * @param CallId the CallId to set
     */
    public void setCallId(int CallId) {
        this.CallId = CallId;
    }

    /**
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    /**
     * @return the Descripion
     */
    public String getDescripion() {
        return Descripion;
    }

    /**
     * @param Descripion the Descripion to set
     */
    public void setDescripion(String Descripion) {
        this.Descripion = Descripion;
    }

    /**
     * @return the StoreCheckForecast
     */
    public double getStoreCheckForecast() {
        return StoreCheckForecast;
    }

    /**
     * @param StoreCheckForecast the StoreCheckForecast to set
     */
    public void setStoreCheckForecast(double StoreCheckForecast) {
        this.StoreCheckForecast = StoreCheckForecast;
    }

    /**
     * @return the OrderForecast
     */
    public double getOrderForecast() {
        return OrderForecast;
    }

    /**
     * @param OrderForecast the OrderForecast to set
     */
    public void setOrderForecast(double OrderForecast) {
        this.OrderForecast = OrderForecast;
    }

    /**
     * @return the SalesForecast
     */
    public double getSalesForecast() {
        return SalesForecast;
    }

    /**
     * @param SalesForecast the SalesForecast to set
     */
    public void setSalesForecast(double SalesForecast) {
        this.SalesForecast = SalesForecast;
    }
    
}
