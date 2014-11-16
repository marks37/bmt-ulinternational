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
public class Call_Report {
    
    private int CallId;
    private String Missed;
    private String Completed;
    private String MonthYear;
    private int SalesRepId;

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
     * @return the Missed
     */
    public String getMissed() {
        return Missed;
    }

    /**
     * @param Missed the Missed to set
     */
    public void setMissed(String Missed) {
        this.Missed = Missed;
    }

    /**
     * @return the Completed
     */
    public String getCompleted() {
        return Completed;
    }

    /**
     * @param Completed the Completed to set
     */
    public void setCompleted(String Completed) {
        this.Completed = Completed;
    }

    /**
     * @return the MonthYear
     */
    public String getMonthYear() {
        return MonthYear;
    }

    /**
     * @param MonthYear the MonthYear to set
     */
    public void setMonthYear(String MonthYear) {
        this.MonthYear = MonthYear;
    }

    /**
     * @return the SalesRepId
     */
    public int getSalesRepId() {
        return SalesRepId;
    }

    /**
     * @param SalesRepId the SalesRepId to set
     */
    public void setSalesRepId(int SalesRepId) {
        this.SalesRepId = SalesRepId;
    }
    
    
    
}
