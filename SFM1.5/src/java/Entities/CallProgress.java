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
public class CallProgress {
    
    private String AccountCode;
    private String EnglishName;
    private int Completed;
    private int Missed;
    private int New;
    private int Total;

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
     * @return the Completed
     */
    public int getCompleted() {
        return Completed;
    }

    /**
     * @param Completed the Completed to set
     */
    public void setCompleted(int Completed) {
        this.Completed = Completed;
    }

    /**
     * @return the Missed
     */
    public int getMissed() {
        return Missed;
    }

    /**
     * @param Missed the Missed to set
     */
    public void setMissed(int Missed) {
        this.Missed = Missed;
    }

    /**
     * @return the New
     */
    public int getNew() {
        return New;
    }

    /**
     * @param New the New to set
     */
    public void setNew(int New) {
        this.New = New;
    }

    /**
     * @return the Total
     */
    public int getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(int Total) {
        this.Total = Total;
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
    
}
