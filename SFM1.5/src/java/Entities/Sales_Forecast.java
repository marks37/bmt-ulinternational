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
public class Sales_Forecast {
    
    private int SalesForecastId;
    private double SalesForecast;
    private double OrderFrecast;
    private double PastYearSales;
    private double PastYearOrder;
    private double ActualSales;
    private String DateCreated;
    private String Month;
    private String AssignedSalesRep;
    private String AccountCode;

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
     * @return the OrderFrecast
     */
    public double getOrderFrecast() {
        return OrderFrecast;
    }

    /**
     * @param OrderFrecast the OrderFrecast to set
     */
    public void setOrderFrecast(double OrderFrecast) {
        this.OrderFrecast = OrderFrecast;
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
     * @return the DateCreated
     */
    public String getDateCreated() {
        return DateCreated;
    }

    /**
     * @param DateCreated the DateCreated to set
     */
    public void setDateCreated(String DateCreated) {
        this.DateCreated = DateCreated;
    }

    /**
     * @return the AssignedSalesRep
     */
    public String getAssignedSalesRep() {
        return AssignedSalesRep;
    }

    /**
     * @param AssignedSalesRep the AssignedSalesRep to set
     */
    public void setAssignedSalesRep(String AssignedSalesRep) {
        this.AssignedSalesRep = AssignedSalesRep;
    }

    /**
     * @return the AccountCode
     */
    public String getAccountCode() {
        return AccountCode;
    }

    /**
     * @param AccountCode the AccountCode to set
     */
    public void setAccountCode(String AccountCode) {
        this.AccountCode = AccountCode;
    }

    /**
     * @return the Month
     */
    public String getMonth() {
        return Month;
    }

    /**
     * @param Month the Month to set
     */
    public void setMonth(String Month) {
        this.Month = Month;
    }
    
    
}
