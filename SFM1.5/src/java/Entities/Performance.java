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
public class Performance {

    private int PerformanceId;
    private String MonthTarget;
    private String ActualSales;
    private String Date;
    private String Performance;
    private String SalesRepId;
    private String SalesGrowth;
    private String MissedCalls;
    private String CompletedCalls;

    /**
     * @return the PerformanceId
     */
    public int getPerformanceId() {
        return PerformanceId;
    }

    /**
     * @param PerformanceId the PerformanceId to set
     */
    public void setPerformanceId(int PerformanceId) {
        this.PerformanceId = PerformanceId;
    }

    /**
     * @return the MonthTarget
     */
    public String getMonthTarget() {
        return MonthTarget;
    }

    /**
     * @param MonthTarget the MonthTarget to set
     */
    public void setMonthTarget(String MonthTarget) {
        this.MonthTarget = MonthTarget;
    }

    /**
     * @return the ActualSales
     */
    public String getActualSales() {
        return ActualSales;
    }

    /**
     * @param ActualSales the ActualSales to set
     */
    public void setActualSales(String ActualSales) {
        this.ActualSales = ActualSales;
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
     * @return the Performance
     */
    public String getPerformance() {
        return Performance;
    }

    /**
     * @param Performance the Performance to set
     */
    public void setPerformance(String Performance) {
        this.Performance = Performance;
    }

    /**
     * @return the SalesRepId
     */
    public String getSalesRepId() {
        return SalesRepId;
    }

    /**
     * @param SalesRepId the SalesRepId to set
     */
    public void setSalesRepId(String SalesRepId) {
        this.SalesRepId = SalesRepId;
    }

    /**
     * @return the SalesGrowth
     */
    public String getSalesGrowth() {
        return SalesGrowth;
    }

    /**
     * @param SalesGrowth the SalesGrowth to set
     */
    public void setSalesGrowth(String SalesGrowth) {
        this.SalesGrowth = SalesGrowth;
    }

    /**
     * @return the Missedcalls
     */
    public String getMissedCalls() {
        return MissedCalls;
    }

    /**
     * @param Missedcalls the Missedcalls to set
     */
    public void setMissedCalls(String MissedCalls) {
        this.MissedCalls = MissedCalls;
    }

    /**
     * @return the CompleteCalls
     */
    public String getCompletedCalls() {
        return CompletedCalls;
    }

    /**
     * @param CompleteCalls the CompleteCalls to set
     */
    public void setCompletedCalls(String CompletedCalls) {
        this.CompletedCalls = CompletedCalls;
    }
    
}
