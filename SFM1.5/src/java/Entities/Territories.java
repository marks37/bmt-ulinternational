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
public class Territories {
    
    private int TerritoryId;
    private String TerritoryCode;
    private String Region;
    private String Area;
    private String ZipCode;

    /**
     * @return the TerritoryId
     */
    public int getTerritoryId() {
        return TerritoryId;
    }

    /**
     * @param TerritoryId the TerritoryId to set
     */
    public void setTerritoryId(int TerritoryId) {
        this.TerritoryId = TerritoryId;
    }

    /**
     * @return the TerritoryCode
     */
    public String getTerritoryCode() {
        return TerritoryCode;
    }

    /**
     * @param TerritoryCode the TerritoryCode to set
     */
    public void setTerritoryCode(String TerritoryCode) {
        this.TerritoryCode = TerritoryCode;
    }

    /**
     * @return the Region
     */
    public String getRegion() {
        return Region;
    }

    /**
     * @param Region the Region to set
     */
    public void setRegion(String Region) {
        this.Region = Region;
    }

    /**
     * @return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     * @return the ZipCode
     */
    public String getZipCode() {
        return ZipCode;
    }

    /**
     * @param ZipCode the ZipCode to set
     */
    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }
    
    
    
}
