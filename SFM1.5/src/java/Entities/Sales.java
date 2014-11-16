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
public class Sales {

    private int SalesId;
    private int AccountId;
    private String AccountName;
    private String EnglishName;
    private int Sales;
    private int Target;
    private String Date;
    private int SalesRepId;
    private int CallId;
    
    private String AccountCode;
    private String SalesRepCode;
    private double Year1Amount;
    private double Year2Amount;
    private double Year3Amount;
    
    private double Year1Units;
    private double Year2Units;
    private double Year3Units;
    
    private double JanTotalAmount;
    private double FebTotalAmount;
    private double MarTotalAmount;
    private double AprTotalAmount;
    private double MayTotalAmount;
    private double JunTotalAmount;
    private double JulTotalAmount;
    private double AugTotalAmount;
    private double SepTotalAmount;
    private double OctTotalAmount;
    private double NovTotalAmount;
    private double DecTotalAmount;
    private double YearTotalAmount;
    
    private double JanTotalTarget;
    private double FebTotalTarget;
    private double MarTotalTarget;
    private double AprTotalTarget;
    private double MayTotalTarget;
    private double JunTotalTarget;
    private double JulTotalTarget;
    private double AugTotalTarget;
    private double SepTotalTarget;
    private double OctTotalTarget;
    private double NovTotalTarget;
    private double DecTotalTarget;
    private double YearTotalTarget;
    
    private String ItemCode;
    private String ItemName;
    

    /**
     * @return the SalesId
     */
    public int getSalesId() {
        return SalesId;
    }

    /**
     * @param SalesId the SalesId to set
     */
    public void setSalesId(int SalesId) {
        this.SalesId = SalesId;
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

    /**
     * @return the Target
     */
    public int getTarget() {
        return Target;
    }

    /**
     * @param Target the Target to set
     */
    public void setTarget(int Target) {
        this.Target = Target;
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
     * @return the Year1Amount
     */
    public double getYear1Amount() {
        return Year1Amount;
    }

    /**
     * @param Year1Amount the Year1Amount to set
     */
    public void setYear1Amount(double Year1Amount) {
        this.Year1Amount = Year1Amount;
    }

    /**
     * @return the Year2Amount
     */
    public double getYear2Amount() {
        return Year2Amount;
    }

    /**
     * @param Year2Amount the Year2Amount to set
     */
    public void setYear2Amount(double Year2Amount) {
        this.Year2Amount = Year2Amount;
    }

    /**
     * @return the Year3Amount
     */
    public double getYear3Amount() {
        return Year3Amount;
    }

    /**
     * @param Year3Amount the Year3Amount to set
     */
    public void setYear3Amount(double Year3Amount) {
        this.Year3Amount = Year3Amount;
    }

    /**
     * @return the Year1Units
     */
    public double getYear1Units() {
        return Year1Units;
    }

    /**
     * @param Year1Units the Year1Units to set
     */
    public void setYear1Units(double Year1Units) {
        this.Year1Units = Year1Units;
    }

    /**
     * @return the Year2Units
     */
    public double getYear2Units() {
        return Year2Units;
    }

    /**
     * @param Year2Units the Year2Units to set
     */
    public void setYear2Units(double Year2Units) {
        this.Year2Units = Year2Units;
    }

    /**
     * @return the Year3Units
     */
    public double getYear3Units() {
        return Year3Units;
    }

    /**
     * @param Year3Units the Year3Units to set
     */
    public void setYear3Units(double Year3Units) {
        this.Year3Units = Year3Units;
    }

    /**
     * @return the JanTotalAmount
     */
    public double getJanTotalAmount() {
        return JanTotalAmount;
    }

    /**
     * @param JanTotalAmount the JanTotalAmount to set
     */
    public void setJanTotalAmount(double JanTotalAmount) {
        this.JanTotalAmount = JanTotalAmount;
    }

    /**
     * @return the FebTotalAmount
     */
    public double getFebTotalAmount() {
        return FebTotalAmount;
    }

    /**
     * @param FebTotalAmount the FebTotalAmount to set
     */
    public void setFebTotalAmount(double FebTotalAmount) {
        this.FebTotalAmount = FebTotalAmount;
    }

    /**
     * @return the MarTotalAmount
     */
    public double getMarTotalAmount() {
        return MarTotalAmount;
    }

    /**
     * @param MarTotalAmount the MarTotalAmount to set
     */
    public void setMarTotalAmount(double MarTotalAmount) {
        this.MarTotalAmount = MarTotalAmount;
    }

    /**
     * @return the AprTotalAmount
     */
    public double getAprTotalAmount() {
        return AprTotalAmount;
    }

    /**
     * @param AprTotalAmount the AprTotalAmount to set
     */
    public void setAprTotalAmount(double AprTotalAmount) {
        this.AprTotalAmount = AprTotalAmount;
    }

    /**
     * @return the MayTotalAmount
     */
    public double getMayTotalAmount() {
        return MayTotalAmount;
    }

    /**
     * @param MayTotalAmount the MayTotalAmount to set
     */
    public void setMayTotalAmount(double MayTotalAmount) {
        this.MayTotalAmount = MayTotalAmount;
    }

    /**
     * @return the JunTotalAmount
     */
    public double getJunTotalAmount() {
        return JunTotalAmount;
    }

    /**
     * @param JunTotalAmount the JunTotalAmount to set
     */
    public void setJunTotalAmount(double JunTotalAmount) {
        this.JunTotalAmount = JunTotalAmount;
    }

    /**
     * @return the JulTotalAmount
     */
    public double getJulTotalAmount() {
        return JulTotalAmount;
    }

    /**
     * @param JulTotalAmount the JulTotalAmount to set
     */
    public void setJulTotalAmount(double JulTotalAmount) {
        this.JulTotalAmount = JulTotalAmount;
    }

    /**
     * @return the AugTotalAmount
     */
    public double getAugTotalAmount() {
        return AugTotalAmount;
    }

    /**
     * @param AugTotalAmount the AugTotalAmount to set
     */
    public void setAugTotalAmount(double AugTotalAmount) {
        this.AugTotalAmount = AugTotalAmount;
    }

    /**
     * @return the SepTotalAmount
     */
    public double getSepTotalAmount() {
        return SepTotalAmount;
    }

    /**
     * @param SepTotalAmount the SepTotalAmount to set
     */
    public void setSepTotalAmount(double SepTotalAmount) {
        this.SepTotalAmount = SepTotalAmount;
    }

    /**
     * @return the OctTotalAmount
     */
    public double getOctTotalAmount() {
        return OctTotalAmount;
    }

    /**
     * @param OctTotalAmount the OctTotalAmount to set
     */
    public void setOctTotalAmount(double OctTotalAmount) {
        this.OctTotalAmount = OctTotalAmount;
    }

    /**
     * @return the NovTotalAmount
     */
    public double getNovTotalAmount() {
        return NovTotalAmount;
    }

    /**
     * @param NovTotalAmount the NovTotalAmount to set
     */
    public void setNovTotalAmount(double NovTotalAmount) {
        this.NovTotalAmount = NovTotalAmount;
    }

    /**
     * @return the DecTotalAmount
     */
    public double getDecTotalAmount() {
        return DecTotalAmount;
    }

    /**
     * @param DecTotalAmount the DecTotalAmount to set
     */
    public void setDecTotalAmount(double DecTotalAmount) {
        this.DecTotalAmount = DecTotalAmount;
    }

    /**
     * @return the JanTotalTarget
     */
    public double getJanTotalTarget() {
        return JanTotalTarget;
    }

    /**
     * @param JanTotalTarget the JanTotalTarget to set
     */
    public void setJanTotalTarget(double JanTotalTarget) {
        this.JanTotalTarget = JanTotalTarget;
    }

    /**
     * @return the FebTotalTarget
     */
    public double getFebTotalTarget() {
        return FebTotalTarget;
    }

    /**
     * @param FebTotalTarget the FebTotalTarget to set
     */
    public void setFebTotalTarget(double FebTotalTarget) {
        this.FebTotalTarget = FebTotalTarget;
    }

    /**
     * @return the MarTotalTarget
     */
    public double getMarTotalTarget() {
        return MarTotalTarget;
    }

    /**
     * @param MarTotalTarget the MarTotalTarget to set
     */
    public void setMarTotalTarget(double MarTotalTarget) {
        this.MarTotalTarget = MarTotalTarget;
    }

    /**
     * @return the AprTotalTarget
     */
    public double getAprTotalTarget() {
        return AprTotalTarget;
    }

    /**
     * @param AprTotalTarget the AprTotalTarget to set
     */
    public void setAprTotalTarget(double AprTotalTarget) {
        this.AprTotalTarget = AprTotalTarget;
    }

    /**
     * @return the MayTotalTarget
     */
    public double getMayTotalTarget() {
        return MayTotalTarget;
    }

    /**
     * @param MayTotalTarget the MayTotalTarget to set
     */
    public void setMayTotalTarget(double MayTotalTarget) {
        this.MayTotalTarget = MayTotalTarget;
    }

    /**
     * @return the JunTotalTarget
     */
    public double getJunTotalTarget() {
        return JunTotalTarget;
    }

    /**
     * @param JunTotalTarget the JunTotalTarget to set
     */
    public void setJunTotalTarget(double JunTotalTarget) {
        this.JunTotalTarget = JunTotalTarget;
    }

    /**
     * @return the JulTotalTarget
     */
    public double getJulTotalTarget() {
        return JulTotalTarget;
    }

    /**
     * @param JulTotalTarget the JulTotalTarget to set
     */
    public void setJulTotalTarget(double JulTotalTarget) {
        this.JulTotalTarget = JulTotalTarget;
    }

    /**
     * @return the AugTotalTarget
     */
    public double getAugTotalTarget() {
        return AugTotalTarget;
    }

    /**
     * @param AugTotalTarget the AugTotalTarget to set
     */
    public void setAugTotalTarget(double AugTotalTarget) {
        this.AugTotalTarget = AugTotalTarget;
    }

    /**
     * @return the SepTotalTarget
     */
    public double getSepTotalTarget() {
        return SepTotalTarget;
    }

    /**
     * @param SepTotalTarget the SepTotalTarget to set
     */
    public void setSepTotalTarget(double SepTotalTarget) {
        this.SepTotalTarget = SepTotalTarget;
    }

    /**
     * @return the OctTotalTarget
     */
    public double getOctTotalTarget() {
        return OctTotalTarget;
    }

    /**
     * @param OctTotalTarget the OctTotalTarget to set
     */
    public void setOctTotalTarget(double OctTotalTarget) {
        this.OctTotalTarget = OctTotalTarget;
    }

    /**
     * @return the NovTotalTarget
     */
    public double getNovTotalTarget() {
        return NovTotalTarget;
    }

    /**
     * @param NovTotalTarget the NovTotalTarget to set
     */
    public void setNovTotalTarget(double NovTotalTarget) {
        this.NovTotalTarget = NovTotalTarget;
    }

    /**
     * @return the DecTotalTarget
     */
    public double getDecTotalTarget() {
        return DecTotalTarget;
    }

    /**
     * @param DecTotalTarget the DecTotalTarget to set
     */
    public void setDecTotalTarget(double DecTotalTarget) {
        this.DecTotalTarget = DecTotalTarget;
    }

    /**
     * @return the YearTotalAmount
     */
    public double getYearTotalAmount() {
        return YearTotalAmount;
    }

    /**
     * @param YearTotalAmount the YearTotalAmount to set
     */
    public void setYearTotalAmount(double YearTotalAmount) {
        this.YearTotalAmount = YearTotalAmount;
    }

    /**
     * @return the YearTotalTarget
     */
    public double getYearTotalTarget() {
        return YearTotalTarget;
    }

    /**
     * @param YearTotalTarget the YearTotalTarget to set
     */
    public void setYearTotalTarget(double YearTotalTarget) {
        this.YearTotalTarget = YearTotalTarget;
    }

    /**
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    /**
     * @return the ItemName
     */
    public String getItemName() {
        return ItemName;
    }

    /**
     * @param ItemName the ItemName to set
     */
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    /**
     * @return the AccountName
     */
    public String getAccountName() {
        return AccountName;
    }

    /**
     * @param AccountName the AccountName to set
     */
    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
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
