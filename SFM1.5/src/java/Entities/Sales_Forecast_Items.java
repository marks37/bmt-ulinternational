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
public class Sales_Forecast_Items {
    
    private int SalesForecastItemsId;
    private double SalesForecast;
    private double OrderForecast;
    private double ActualSales;
    private double PastYearSales;
    private double PastYearOrder;
    private String Date;
    private int SalesForecastId;
    private String ItemCode;
    private String Description;

    /**
     * @return the SalesForecastItemsId
     */
    public int getSalesForecastItemsId() {
        return SalesForecastItemsId;
    }

    /**
     * @param SalesForecastItemsId the SalesForecastItemsId to set
     */
    public void setSalesForecastItemsId(int SalesForecastItemsId) {
        this.SalesForecastItemsId = SalesForecastItemsId;
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
     * @return the ActualSales
     */
    public double getActualSales() {
        return ActualSales;
    }

    /**
     * @param ActualSales the ActualSales to set
     */
    public void setActualSales(double ActualSales) {
        this.ActualSales = ActualSales;
    }

    /**
     * @return the PastYearSales
     */
    public double getPastYearSales() {
        return PastYearSales;
    }

    /**
     * @param PastYearSales the PastYearSales to set
     */
    public void setPastYearSales(double PastYearSales) {
        this.PastYearSales = PastYearSales;
    }

    /**
     * @return the PastYearOrder
     */
    public double getPastYearOrder() {
        return PastYearOrder;
    }

    /**
     * @param PastYearOrder the PastYearOrder to set
     */
    public void setPastYearOrder(double PastYearOrder) {
        this.PastYearOrder = PastYearOrder;
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
     * @return the SalesForecastId
     */
    public int getSalesForecastId() {
        return SalesForecastId;
    }

    /**
     * @param SalesForecastId the SalesForecastId to set
     */
    public void setSalesForecastId(int SalesForecastId) {
        this.SalesForecastId = SalesForecastId;
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
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
