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
public class SalesReps {
    
    private int AccountId;
    private int SalesRepId;
    private String SalesRepCode;
    private String LastName;
    private String FirstName;
    private String FullName;

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

    /**
     * @return the SalesRepCode
     */
    public String getSalesRepCode() {
        return SalesRepCode;
    }

    /**
     * @param SalesRepCode the SalesRepCode to set
     */
    public void setSalesRepCode(String SalesRepCode) {
        this.SalesRepCode = SalesRepCode;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the FullName
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * @param FullName the FullName to set
     */
    public void setFullName(String FullName) {
        this.FullName = FullName;
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
    
    
}
