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
public class User {
 
    private int UserId;
    private String Username;
    private String Password;
    private int SalesRepId;

    /**
     * @return the UserId
     */
    public int getUserId() {
        return UserId;
    }

    /**
     * @param UserId the UserId to set
     */
    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
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
