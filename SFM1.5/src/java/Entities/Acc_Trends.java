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
public class Acc_Trends {
    
    private int TrendId;
    private int ProductId;
    private String Month;
    private String Year;
    private int AccountId;
    private int Sales;
    private String Period;
    private String ActualSales;
            
    
      public String getActualSales(){
        return ActualSales;
    }
    
      public void setActualSales(String ActualSales) {
        this.ActualSales = ActualSales;
    }
    
    
    public String getPeriod(){
        return Period;
    }
    
      public void setPeriod(String Period) {
        this.Period = Period;
    }

    /**
     * @return the TrendId
     */
    public int getTrendId() {
        return TrendId;
    }

    /**
     * @param TrendId the TrendId to set
     */
    public void setTrendId(int TrendId) {
        this.TrendId = TrendId;
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

    /**
     * @return the Year
     */
    public String getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(String Year) {
        this.Year = Year;
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
     * @return the Sales
     */
    public int getSales() {
        return Sales;
    }

    /**
     * @param Sales the Sales to set
     */
    public void setSales(int Sales) {
        this.Sales = Sales;
    }
    
    
}
