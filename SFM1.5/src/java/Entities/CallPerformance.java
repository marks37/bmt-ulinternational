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
public class CallPerformance {
    private int PerformanceId;
    private String CalNo;
    private String Sales_Act;
    private String Sales_Perf;
    private String Avail_Act;
    private String Avail_Perf;
    private String Date;
    private String SalesRepAssigned;

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
     * @return the CalNo
     */
    public String getCalNo() {
        return CalNo;
    }

    /**
     * @param CalNo the CalNo to set
     */
    public void setCalNo(String CalNo) {
        this.CalNo = CalNo;
    }

    /**
     * @return the Sales_Act
     */
    public String getSales_Act() {
        return Sales_Act;
    }

    /**
     * @param Sales_Act the Sales_Act to set
     */
    public void setSales_Act(String Sales_Act) {
        this.Sales_Act = Sales_Act;
    }

    /**
     * @return the Sales_Perf
     */
    public String getSales_Perf() {
        return Sales_Perf;
    }

    /**
     * @param Sales_Perf the Sales_Perf to set
     */
    public void setSales_Perf(String Sales_Perf) {
        this.Sales_Perf = Sales_Perf;
    }

    /**
     * @return the Avail_Act
     */
    public String getAvail_Act() {
        return Avail_Act;
    }

    /**
     * @param Avail_Act the Avail_Act to set
     */
    public void setAvail_Act(String Avail_Act) {
        this.Avail_Act = Avail_Act;
    }

    /**
     * @return the Avail_Perf
     */
    public String getAvail_Perf() {
        return Avail_Perf;
    }

    /**
     * @param Avail_Perf the Avail_Perf to set
     */
    public void setAvail_Perf(String Avail_Perf) {
        this.Avail_Perf = Avail_Perf;
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
     * @return the SalesRepAssigned
     */
    public String getSalesRepAssigned() {
        return SalesRepAssigned;
    }

    /**
     * @param SalesRepAssigned the SalesRepAssigned to set
     */
    public void setSalesRepAssigned(String SalesRepAssigned) {
        this.SalesRepAssigned = SalesRepAssigned;
    }
}
