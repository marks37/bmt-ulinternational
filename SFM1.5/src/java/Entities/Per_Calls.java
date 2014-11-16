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
public class Per_Calls {
 
    private int PerformanceId;
    private String Target;
    private String ActualSales;
    private String Date;
    private String Performance;
    private String CallId;
    private String Collection;
    private String Availability;

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
     * @return the Target
     */
    public String getMonthTarget() {
        return Target;
    }

    /**
     * @param MonthTarget the Target to set
     */
    public void setMonthTarget(String MonthTarget) {
        this.Target = MonthTarget;
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
     * @return the CallId
     */
    public String getCallId() {
        return CallId;
    }

    /**
     * @param CallId the CallId to set
     */
    public void setCallId(String CallId) {
        this.CallId = CallId;
    }

    /**
     * @return the Collection
     */
    public String getCollection() {
        return Collection;
    }

    /**
     * @param Collection the Collection to set
     */
    public void setCollection(String Collection) {
        this.Collection = Collection;
    }

    /**
     * @return the Availability
     */
    public String getAvailability() {
        return Availability;
    }

    /**
     * @param Availability the Availability to set
     */
    public void setAvailability(String Availability) {
        this.Availability = Availability;
    }
    
}
