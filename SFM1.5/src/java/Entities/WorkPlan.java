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
public class WorkPlan {
 
    private int WorkPlanId;
    private String WorkPlanNo;
    private String AssignedTo;
    private String Status;
    private String Year;
    private String Month;

    /**
     * @return the WorkPlanId
     */
    public int getWorkPlanId() {
        return WorkPlanId;
    }

    /**
     * @param WorkPlanId the WorkPlanId to set
     */
    public void setWorkPlanId(int WorkPlanId) {
        this.WorkPlanId = WorkPlanId;
    }

    /**
     * @return the WorkPlanNo
     */
    public String getWorkPlanNo() {
        return WorkPlanNo;
    }

    /**
     * @param WorkPlanNo the WorkPlanNo to set
     */
    public void setWorkPlanNo(String WorkPlanNo) {
        this.WorkPlanNo = WorkPlanNo;
    }

    /**
     * @return the AssignedTo
     */
    public String getAssignedTo() {
        return AssignedTo;
    }

    /**
     * @param AssignedTo the AssignedTo to set
     */
    public void setAssignedTo(String AssignedTo) {
        this.AssignedTo = AssignedTo;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
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
