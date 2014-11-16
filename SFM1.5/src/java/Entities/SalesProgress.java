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
public class SalesProgress {
 
    private String AccountCode;
    private String EnglishName;
    private double ActualSales;
    private double SalesTarget;

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
     * @return the EnglishName
     */
    public String getEnglishName() {
        return EnglishName;
    }

    /**
     * @param EnglishName the EnglishName to set
     */
    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
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
     * @return the SalesTarget
     */
    public double getSalesTarget() {
        return SalesTarget;
    }

    /**
     * @param SalesTarget the SalesTarget to set
     */
    public void setSalesTarget(double SalesTarget) {
        this.SalesTarget = SalesTarget;
    }
    
    
    
    
}
