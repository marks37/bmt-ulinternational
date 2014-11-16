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
public class Purchases {
    
    private int PurchaseHistoryItemsId;
    private double ThisYearUnits;
    private double ThisYearAmount;
    private double PastYearUnits;
    private double PastYearAmount;
    private String Month;
    private String Year;
    private int PurchaseHistoryId;
    private String AccountCode;
    private String DateCreated;
    
    private Double JanThisYearUnits;
    private Double FebThisYearUnits;
    private Double MarThisYearUnits;
    private Double AprThisYearUnits;
    private Double MayThisYearUnits;
    private Double JunThisYearUnits;
    private Double JulThisYearUnits;
    private Double AugThisYearUnits;
    private Double SepThisYearUnits;
    private Double OctThisYearUnits;
    private Double NovThisYearUnits;
    private Double DecThisYearUnits;
    private Double TotalThisYearUnits;
    
    private Double JanThisYearAmount;
    private Double FebThisYearAmount;
    private Double MarThisYearAmount;
    private Double AprThisYearAmount;
    private Double MayThisYearAmount;
    private Double JunThisYearAmount;
    private Double JulThisYearAmount;
    private Double AugThisYearAmount;
    private Double SepThisYearAmount;
    private Double OctThisYearAmount;
    private Double NovThisYearAmount;
    private Double DecThisYearAmount;
    private Double TotalThisYearAmount;
    
    private Double JanPastYearUnits;
    private Double FebPastYearUnits;
    private Double MarPastYearUnits;
    private Double AprPastYearUnits;
    private Double MayPastYearUnits;
    private Double JunPastYearUnits;
    private Double JulPastYearUnits;
    private Double AugPastYearUnits;
    private Double SepPastYearUnits;
    private Double OctPastYearUnits;
    private Double NovPastYearUnits;
    private Double DecPastYearUnits;
    private Double TotalPastYearUnits;
    
    private Double JanPastYearAmount;
    private Double FebPastYearAmount;
    private Double MarPastYearAmount;
    private Double AprPastYearAmount;
    private Double MayPastYearAmount;
    private Double JunPastYearAmount;
    private Double JulPastYearAmount;
    private Double AugPastYearAmount;
    private Double SepPastYearAmount;
    private Double OctPastYearAmount;
    private Double NovPastYearAmount;
    private Double DecPastYearAmount;
    private Double TotalPastYearAmount;
    
    
    
    private int ProductId;
    private String ItemCode;
    private String Description;
    
    
    private double MTDSales;
    private double MTDQuantity;
    private double P3Sales;
    private double P3Quantity;
    private double P6Sales;
    private double P6Quantity;
    private double P9Sales;
    private double P9Quantity;
    private double P12Sales;
    private double P12Quantity;
    private double YTDSales;
    private double YTDQuantity;
    private double PYSales;
    private double PYQuantity;
    
    private double MTDSalesTotal;
    private double MTDQuantityTotal;
    private double P3SalesTotal;
    private double P3QuantityTotal;
    private double P6SalesTotal;
    private double P6QuantityTotal;
    private double P9SalesTotal;
    private double P9QuantityTotal;
    private double P12SalesTotal;
    private double P12QuantityTotal;
    private double YTDSalesTotal;
    private double YTDQuantityTotal;
    private double PYSalesTotal;
    private double PYQuantityTOtal;
    

    /**
     * @return the PurchaseHistoryItemsId
     */
    public int getPurchaseHistoryItemsId() {
        return PurchaseHistoryItemsId;
    }

    /**
     * @param PurchaseHistoryItemsId the PurchaseHistoryItemsId to set
     */
    public void setPurchaseHistoryItemsId(int PurchaseHistoryItemsId) {
        this.PurchaseHistoryItemsId = PurchaseHistoryItemsId;
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
     * @return the PurchaseHistoryId
     */
    public int getPurchaseHistoryId() {
        return PurchaseHistoryId;
    }

    /**
     * @param PurchaseHistoryId the PurchaseHistoryId to set
     */
    public void setPurchaseHistoryId(int PurchaseHistoryId) {
        this.PurchaseHistoryId = PurchaseHistoryId;
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
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
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
     * @return the MTDSales
     */
    public double getMTDSales() {
        return MTDSales;
    }

    /**
     * @param MTDSales the MTDSales to set
     */
    public void setMTDSales(double MTDSales) {
        this.MTDSales = MTDSales;
    }

    /**
     * @return the MTDQuantity
     */
    public double getMTDQuantity() {
        return MTDQuantity;
    }

    /**
     * @param MTDQuantity the MTDQuantity to set
     */
    public void setMTDQuantity(double MTDQuantity) {
        this.MTDQuantity = MTDQuantity;
    }

    /**
     * @return the P3Sales
     */
    public double getP3Sales() {
        return P3Sales;
    }

    /**
     * @param P3Sales the P3Sales to set
     */
    public void setP3Sales(double P3Sales) {
        this.P3Sales = P3Sales;
    }

    /**
     * @return the P3Quantity
     */
    public double getP3Quantity() {
        return P3Quantity;
    }

    /**
     * @param P3Quantity the P3Quantity to set
     */
    public void setP3Quantity(double P3Quantity) {
        this.P3Quantity = P3Quantity;
    }

    /**
     * @return the P6Sales
     */
    public double getP6Sales() {
        return P6Sales;
    }

    /**
     * @param P6Sales the P6Sales to set
     */
    public void setP6Sales(double P6Sales) {
        this.P6Sales = P6Sales;
    }

    /**
     * @return the P6Quantity
     */
    public double getP6Quantity() {
        return P6Quantity;
    }

    /**
     * @param P6Quantity the P6Quantity to set
     */
    public void setP6Quantity(double P6Quantity) {
        this.P6Quantity = P6Quantity;
    }

    /**
     * @return the P9Sales
     */
    public double getP9Sales() {
        return P9Sales;
    }

    /**
     * @param P9Sales the P9Sales to set
     */
    public void setP9Sales(double P9Sales) {
        this.P9Sales = P9Sales;
    }

    /**
     * @return the P9Quantity
     */
    public double getP9Quantity() {
        return P9Quantity;
    }

    /**
     * @param P9Quantity the P9Quantity to set
     */
    public void setP9Quantity(double P9Quantity) {
        this.P9Quantity = P9Quantity;
    }

    /**
     * @return the P12Sales
     */
    public double getP12Sales() {
        return P12Sales;
    }

    /**
     * @param P12Sales the P12Sales to set
     */
    public void setP12Sales(double P12Sales) {
        this.P12Sales = P12Sales;
    }

    /**
     * @return the P12Quantity
     */
    public double getP12Quantity() {
        return P12Quantity;
    }

    /**
     * @param P12Quantity the P12Quantity to set
     */
    public void setP12Quantity(double P12Quantity) {
        this.P12Quantity = P12Quantity;
    }

    /**
     * @return the YTDSales
     */
    public double getYTDSales() {
        return YTDSales;
    }

    /**
     * @param YTDSales the YTDSales to set
     */
    public void setYTDSales(double YTDSales) {
        this.YTDSales = YTDSales;
    }

    /**
     * @return the YTDQuantity
     */
    public double getYTDQuantity() {
        return YTDQuantity;
    }

    /**
     * @param YTDQuantity the YTDQuantity to set
     */
    public void setYTDQuantity(double YTDQuantity) {
        this.YTDQuantity = YTDQuantity;
    }

    /**
     * @return the PYSales
     */
    public double getPYSales() {
        return PYSales;
    }

    /**
     * @param PYSales the PYSales to set
     */
    public void setPYSales(double PYSales) {
        this.PYSales = PYSales;
    }

    /**
     * @return the PYQuantity
     */
    public double getPYQuantity() {
        return PYQuantity;
    }

    /**
     * @param PYQuantity the PYQuantity to set
     */
    public void setPYQuantity(double PYQuantity) {
        this.PYQuantity = PYQuantity;
    }

    /**
     * @return the MTDSalesTotal
     */
    public double getMTDSalesTotal() {
        return MTDSalesTotal;
    }

    /**
     * @param MTDSalesTotal the MTDSalesTotal to set
     */
    public void setMTDSalesTotal(double MTDSalesTotal) {
        this.MTDSalesTotal = MTDSalesTotal;
    }

    /**
     * @return the MTDQuantityTotal
     */
    public double getMTDQuantityTotal() {
        return MTDQuantityTotal;
    }

    /**
     * @param MTDQuantityTotal the MTDQuantityTotal to set
     */
    public void setMTDQuantityTotal(double MTDQuantityTotal) {
        this.MTDQuantityTotal = MTDQuantityTotal;
    }

    /**
     * @return the P3SalesTotal
     */
    public double getP3SalesTotal() {
        return P3SalesTotal;
    }

    /**
     * @param P3SalesTotal the P3SalesTotal to set
     */
    public void setP3SalesTotal(double P3SalesTotal) {
        this.P3SalesTotal = P3SalesTotal;
    }

    /**
     * @return the P3QuantityTotal
     */
    public double getP3QuantityTotal() {
        return P3QuantityTotal;
    }

    /**
     * @param P3QuantityTotal the P3QuantityTotal to set
     */
    public void setP3QuantityTotal(double P3QuantityTotal) {
        this.P3QuantityTotal = P3QuantityTotal;
    }

    /**
     * @return the P6SalesTotal
     */
    public double getP6SalesTotal() {
        return P6SalesTotal;
    }

    /**
     * @param P6SalesTotal the P6SalesTotal to set
     */
    public void setP6SalesTotal(double P6SalesTotal) {
        this.P6SalesTotal = P6SalesTotal;
    }

    /**
     * @return the P6QuantityTotal
     */
    public double getP6QuantityTotal() {
        return P6QuantityTotal;
    }

    /**
     * @param P6QuantityTotal the P6QuantityTotal to set
     */
    public void setP6QuantityTotal(double P6QuantityTotal) {
        this.P6QuantityTotal = P6QuantityTotal;
    }

    /**
     * @return the P9SalesTotal
     */
    public double getP9SalesTotal() {
        return P9SalesTotal;
    }

    /**
     * @param P9SalesTotal the P9SalesTotal to set
     */
    public void setP9SalesTotal(double P9SalesTotal) {
        this.P9SalesTotal = P9SalesTotal;
    }

    /**
     * @return the P9QuantityTotal
     */
    public double getP9QuantityTotal() {
        return P9QuantityTotal;
    }

    /**
     * @param P9QuantityTotal the P9QuantityTotal to set
     */
    public void setP9QuantityTotal(double P9QuantityTotal) {
        this.P9QuantityTotal = P9QuantityTotal;
    }

    /**
     * @return the P12SalesTotal
     */
    public double getP12SalesTotal() {
        return P12SalesTotal;
    }

    /**
     * @param P12SalesTotal the P12SalesTotal to set
     */
    public void setP12SalesTotal(double P12SalesTotal) {
        this.P12SalesTotal = P12SalesTotal;
    }

    /**
     * @return the P12QuantityTotal
     */
    public double getP12QuantityTotal() {
        return P12QuantityTotal;
    }

    /**
     * @param P12QuantityTotal the P12QuantityTotal to set
     */
    public void setP12QuantityTotal(double P12QuantityTotal) {
        this.P12QuantityTotal = P12QuantityTotal;
    }

    /**
     * @return the YTDSalesTotal
     */
    public double getYTDSalesTotal() {
        return YTDSalesTotal;
    }

    /**
     * @param YTDSalesTotal the YTDSalesTotal to set
     */
    public void setYTDSalesTotal(double YTDSalesTotal) {
        this.YTDSalesTotal = YTDSalesTotal;
    }

    /**
     * @return the YTDQuantityTotal
     */
    public double getYTDQuantityTotal() {
        return YTDQuantityTotal;
    }

    /**
     * @param YTDQuantityTotal the YTDQuantityTotal to set
     */
    public void setYTDQuantityTotal(double YTDQuantityTotal) {
        this.YTDQuantityTotal = YTDQuantityTotal;
    }

    /**
     * @return the PYSalesTotal
     */
    public double getPYSalesTotal() {
        return PYSalesTotal;
    }

    /**
     * @param PYSalesTotal the PYSalesTotal to set
     */
    public void setPYSalesTotal(double PYSalesTotal) {
        this.PYSalesTotal = PYSalesTotal;
    }

    /**
     * @return the PYQuantityTOtal
     */
    public double getPYQuantityTOtal() {
        return PYQuantityTOtal;
    }

    /**
     * @param PYQuantityTOtal the PYQuantityTOtal to set
     */
    public void setPYQuantityTOtal(double PYQuantityTOtal) {
        this.PYQuantityTOtal = PYQuantityTOtal;
    }

    /**
     * @return the ProductId
     */
    public int getProductId() {
        return ProductId;
    }

    /**
     * @param ProductId the ProductId to set
     */
    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    /**
     * @return the ThisYearUnits
     */
    public double getThisYearUnits() {
        return ThisYearUnits;
    }

    /**
     * @param ThisYearUnits the ThisYearUnits to set
     */
    public void setThisYearUnits(double ThisYearUnits) {
        this.ThisYearUnits = ThisYearUnits;
    }

    /**
     * @return the ThisYearAmount
     */
    public double getThisYearAmount() {
        return ThisYearAmount;
    }

    /**
     * @param ThisYearAmount the ThisYearAmount to set
     */
    public void setThisYearAmount(double ThisYearAmount) {
        this.ThisYearAmount = ThisYearAmount;
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

    /**
     * @return the DateCreated
     */
    public String getDateCreated() {
        return DateCreated;
    }

    /**
     * @param DateCreated the DateCreated to set
     */
    public void setDateCreated(String DateCreated) {
        this.DateCreated = DateCreated;
    }

    /**
     * @return the PastYearUnits
     */
    public double getPastYearUnits() {
        return PastYearUnits;
    }

    /**
     * @param PastYearUnits the PastYearUnits to set
     */
    public void setPastYearUnits(double PastYearUnits) {
        this.PastYearUnits = PastYearUnits;
    }

    /**
     * @return the PastYearAmount
     */
    public double getPastYearAmount() {
        return PastYearAmount;
    }

    /**
     * @param PastYearAmount the PastYearAmount to set
     */
    public void setPastYearAmount(double PastYearAmount) {
        this.PastYearAmount = PastYearAmount;
    }

    /**
     * @return the JanThisYearUnits
     */
    public Double getJanThisYearUnits() {
        return JanThisYearUnits;
    }

    /**
     * @param JanThisYearUnits the JanThisYearUnits to set
     */
    public void setJanThisYearUnits(Double JanThisYearUnits) {
        this.JanThisYearUnits = JanThisYearUnits;
    }

    /**
     * @return the FebThisYearUnits
     */
    public Double getFebThisYearUnits() {
        return FebThisYearUnits;
    }

    /**
     * @param FebThisYearUnits the FebThisYearUnits to set
     */
    public void setFebThisYearUnits(Double FebThisYearUnits) {
        this.FebThisYearUnits = FebThisYearUnits;
    }

    /**
     * @return the MarThisYearUnits
     */
    public Double getMarThisYearUnits() {
        return MarThisYearUnits;
    }

    /**
     * @param MarThisYearUnits the MarThisYearUnits to set
     */
    public void setMarThisYearUnits(Double MarThisYearUnits) {
        this.MarThisYearUnits = MarThisYearUnits;
    }

    /**
     * @return the AprThisYearUnits
     */
    public Double getAprThisYearUnits() {
        return AprThisYearUnits;
    }

    /**
     * @param AprThisYearUnits the AprThisYearUnits to set
     */
    public void setAprThisYearUnits(Double AprThisYearUnits) {
        this.AprThisYearUnits = AprThisYearUnits;
    }

    /**
     * @return the MayThisYearUnits
     */
    public Double getMayThisYearUnits() {
        return MayThisYearUnits;
    }

    /**
     * @param MayThisYearUnits the MayThisYearUnits to set
     */
    public void setMayThisYearUnits(Double MayThisYearUnits) {
        this.MayThisYearUnits = MayThisYearUnits;
    }

    /**
     * @return the JunThisYearUnits
     */
    public Double getJunThisYearUnits() {
        return JunThisYearUnits;
    }

    /**
     * @param JunThisYearUnits the JunThisYearUnits to set
     */
    public void setJunThisYearUnits(Double JunThisYearUnits) {
        this.JunThisYearUnits = JunThisYearUnits;
    }

    /**
     * @return the JulThisYearUnits
     */
    public Double getJulThisYearUnits() {
        return JulThisYearUnits;
    }

    /**
     * @param JulThisYearUnits the JulThisYearUnits to set
     */
    public void setJulThisYearUnits(Double JulThisYearUnits) {
        this.JulThisYearUnits = JulThisYearUnits;
    }

    /**
     * @return the AugThisYearUnits
     */
    public Double getAugThisYearUnits() {
        return AugThisYearUnits;
    }

    /**
     * @param AugThisYearUnits the AugThisYearUnits to set
     */
    public void setAugThisYearUnits(Double AugThisYearUnits) {
        this.AugThisYearUnits = AugThisYearUnits;
    }

    /**
     * @return the SepThisYearUnits
     */
    public Double getSepThisYearUnits() {
        return SepThisYearUnits;
    }

    /**
     * @param SepThisYearUnits the SepThisYearUnits to set
     */
    public void setSepThisYearUnits(Double SepThisYearUnits) {
        this.SepThisYearUnits = SepThisYearUnits;
    }

    /**
     * @return the OctThisYearUnits
     */
    public Double getOctThisYearUnits() {
        return OctThisYearUnits;
    }

    /**
     * @param OctThisYearUnits the OctThisYearUnits to set
     */
    public void setOctThisYearUnits(Double OctThisYearUnits) {
        this.OctThisYearUnits = OctThisYearUnits;
    }

    /**
     * @return the NovThisYearUnits
     */
    public Double getNovThisYearUnits() {
        return NovThisYearUnits;
    }

    /**
     * @param NovThisYearUnits the NovThisYearUnits to set
     */
    public void setNovThisYearUnits(Double NovThisYearUnits) {
        this.NovThisYearUnits = NovThisYearUnits;
    }

    /**
     * @return the DecThisYearUnits
     */
    public Double getDecThisYearUnits() {
        return DecThisYearUnits;
    }

    /**
     * @param DecThisYearUnits the DecThisYearUnits to set
     */
    public void setDecThisYearUnits(Double DecThisYearUnits) {
        this.DecThisYearUnits = DecThisYearUnits;
    }

    /**
     * @return the JanThisYearAmount
     */
    public Double getJanThisYearAmount() {
        return JanThisYearAmount;
    }

    /**
     * @param JanThisYearAmount the JanThisYearAmount to set
     */
    public void setJanThisYearAmount(Double JanThisYearAmount) {
        this.JanThisYearAmount = JanThisYearAmount;
    }

    /**
     * @return the FebThisYearAmount
     */
    public Double getFebThisYearAmount() {
        return FebThisYearAmount;
    }

    /**
     * @param FebThisYearAmount the FebThisYearAmount to set
     */
    public void setFebThisYearAmount(Double FebThisYearAmount) {
        this.FebThisYearAmount = FebThisYearAmount;
    }

    /**
     * @return the MarThisYearAmount
     */
    public Double getMarThisYearAmount() {
        return MarThisYearAmount;
    }

    /**
     * @param MarThisYearAmount the MarThisYearAmount to set
     */
    public void setMarThisYearAmount(Double MarThisYearAmount) {
        this.MarThisYearAmount = MarThisYearAmount;
    }

    /**
     * @return the AprThisYearAmount
     */
    public Double getAprThisYearAmount() {
        return AprThisYearAmount;
    }

    /**
     * @param AprThisYearAmount the AprThisYearAmount to set
     */
    public void setAprThisYearAmount(Double AprThisYearAmount) {
        this.AprThisYearAmount = AprThisYearAmount;
    }

    /**
     * @return the MayThisYearAmount
     */
    public Double getMayThisYearAmount() {
        return MayThisYearAmount;
    }

    /**
     * @param MayThisYearAmount the MayThisYearAmount to set
     */
    public void setMayThisYearAmount(Double MayThisYearAmount) {
        this.MayThisYearAmount = MayThisYearAmount;
    }

    /**
     * @return the JunThisYearAmount
     */
    public Double getJunThisYearAmount() {
        return JunThisYearAmount;
    }

    /**
     * @param JunThisYearAmount the JunThisYearAmount to set
     */
    public void setJunThisYearAmount(Double JunThisYearAmount) {
        this.JunThisYearAmount = JunThisYearAmount;
    }

    /**
     * @return the JulThisYearAmount
     */
    public Double getJulThisYearAmount() {
        return JulThisYearAmount;
    }

    /**
     * @param JulThisYearAmount the JulThisYearAmount to set
     */
    public void setJulThisYearAmount(Double JulThisYearAmount) {
        this.JulThisYearAmount = JulThisYearAmount;
    }

    /**
     * @return the AugThisYearAmount
     */
    public Double getAugThisYearAmount() {
        return AugThisYearAmount;
    }

    /**
     * @param AugThisYearAmount the AugThisYearAmount to set
     */
    public void setAugThisYearAmount(Double AugThisYearAmount) {
        this.AugThisYearAmount = AugThisYearAmount;
    }

    /**
     * @return the SepThisYearAmount
     */
    public Double getSepThisYearAmount() {
        return SepThisYearAmount;
    }

    /**
     * @param SepThisYearAmount the SepThisYearAmount to set
     */
    public void setSepThisYearAmount(Double SepThisYearAmount) {
        this.SepThisYearAmount = SepThisYearAmount;
    }

    /**
     * @return the OctThisYearAmount
     */
    public Double getOctThisYearAmount() {
        return OctThisYearAmount;
    }

    /**
     * @param OctThisYearAmount the OctThisYearAmount to set
     */
    public void setOctThisYearAmount(Double OctThisYearAmount) {
        this.OctThisYearAmount = OctThisYearAmount;
    }

    /**
     * @return the NovThisYearAmount
     */
    public Double getNovThisYearAmount() {
        return NovThisYearAmount;
    }

    /**
     * @param NovThisYearAmount the NovThisYearAmount to set
     */
    public void setNovThisYearAmount(Double NovThisYearAmount) {
        this.NovThisYearAmount = NovThisYearAmount;
    }

    /**
     * @return the DecThisYearAmount
     */
    public Double getDecThisYearAmount() {
        return DecThisYearAmount;
    }

    /**
     * @param DecThisYearAmount the DecThisYearAmount to set
     */
    public void setDecThisYearAmount(Double DecThisYearAmount) {
        this.DecThisYearAmount = DecThisYearAmount;
    }

    /**
     * @return the JanPastYearUnits
     */
    public Double getJanPastYearUnits() {
        return JanPastYearUnits;
    }

    /**
     * @param JanPastYearUnits the JanPastYearUnits to set
     */
    public void setJanPastYearUnits(Double JanPastYearUnits) {
        this.JanPastYearUnits = JanPastYearUnits;
    }

    /**
     * @return the FebPastYearUnits
     */
    public Double getFebPastYearUnits() {
        return FebPastYearUnits;
    }

    /**
     * @param FebPastYearUnits the FebPastYearUnits to set
     */
    public void setFebPastYearUnits(Double FebPastYearUnits) {
        this.FebPastYearUnits = FebPastYearUnits;
    }

    /**
     * @return the MarPastYearUnits
     */
    public Double getMarPastYearUnits() {
        return MarPastYearUnits;
    }

    /**
     * @param MarPastYearUnits the MarPastYearUnits to set
     */
    public void setMarPastYearUnits(Double MarPastYearUnits) {
        this.MarPastYearUnits = MarPastYearUnits;
    }

    /**
     * @return the AprPastYearUnits
     */
    public Double getAprPastYearUnits() {
        return AprPastYearUnits;
    }

    /**
     * @param AprPastYearUnits the AprPastYearUnits to set
     */
    public void setAprPastYearUnits(Double AprPastYearUnits) {
        this.AprPastYearUnits = AprPastYearUnits;
    }

    /**
     * @return the MayPastYearUnits
     */
    public Double getMayPastYearUnits() {
        return MayPastYearUnits;
    }

    /**
     * @param MayPastYearUnits the MayPastYearUnits to set
     */
    public void setMayPastYearUnits(Double MayPastYearUnits) {
        this.MayPastYearUnits = MayPastYearUnits;
    }

    /**
     * @return the JunPastYearUnits
     */
    public Double getJunPastYearUnits() {
        return JunPastYearUnits;
    }

    /**
     * @param JunPastYearUnits the JunPastYearUnits to set
     */
    public void setJunPastYearUnits(Double JunPastYearUnits) {
        this.JunPastYearUnits = JunPastYearUnits;
    }

    /**
     * @return the JulPastYearUnits
     */
    public Double getJulPastYearUnits() {
        return JulPastYearUnits;
    }

    /**
     * @param JulPastYearUnits the JulPastYearUnits to set
     */
    public void setJulPastYearUnits(Double JulPastYearUnits) {
        this.JulPastYearUnits = JulPastYearUnits;
    }

    /**
     * @return the AugPastYearUnits
     */
    public Double getAugPastYearUnits() {
        return AugPastYearUnits;
    }

    /**
     * @param AugPastYearUnits the AugPastYearUnits to set
     */
    public void setAugPastYearUnits(Double AugPastYearUnits) {
        this.AugPastYearUnits = AugPastYearUnits;
    }

    /**
     * @return the SepPastYearUnits
     */
    public Double getSepPastYearUnits() {
        return SepPastYearUnits;
    }

    /**
     * @param SepPastYearUnits the SepPastYearUnits to set
     */
    public void setSepPastYearUnits(Double SepPastYearUnits) {
        this.SepPastYearUnits = SepPastYearUnits;
    }

    /**
     * @return the OctPastYearUnits
     */
    public Double getOctPastYearUnits() {
        return OctPastYearUnits;
    }

    /**
     * @param OctPastYearUnits the OctPastYearUnits to set
     */
    public void setOctPastYearUnits(Double OctPastYearUnits) {
        this.OctPastYearUnits = OctPastYearUnits;
    }

    /**
     * @return the NovPastYearUnits
     */
    public Double getNovPastYearUnits() {
        return NovPastYearUnits;
    }

    /**
     * @param NovPastYearUnits the NovPastYearUnits to set
     */
    public void setNovPastYearUnits(Double NovPastYearUnits) {
        this.NovPastYearUnits = NovPastYearUnits;
    }

    /**
     * @return the DecPastYearUnits
     */
    public Double getDecPastYearUnits() {
        return DecPastYearUnits;
    }

    /**
     * @param DecPastYearUnits the DecPastYearUnits to set
     */
    public void setDecPastYearUnits(Double DecPastYearUnits) {
        this.DecPastYearUnits = DecPastYearUnits;
    }

    /**
     * @return the JanPastYearAmount
     */
    public Double getJanPastYearAmount() {
        return JanPastYearAmount;
    }

    /**
     * @param JanPastYearAmount the JanPastYearAmount to set
     */
    public void setJanPastYearAmount(Double JanPastYearAmount) {
        this.JanPastYearAmount = JanPastYearAmount;
    }

    /**
     * @return the FebPastYearAmount
     */
    public Double getFebPastYearAmount() {
        return FebPastYearAmount;
    }

    /**
     * @param FebPastYearAmount the FebPastYearAmount to set
     */
    public void setFebPastYearAmount(Double FebPastYearAmount) {
        this.FebPastYearAmount = FebPastYearAmount;
    }

    /**
     * @return the MarPastYearAmount
     */
    public Double getMarPastYearAmount() {
        return MarPastYearAmount;
    }

    /**
     * @param MarPastYearAmount the MarPastYearAmount to set
     */
    public void setMarPastYearAmount(Double MarPastYearAmount) {
        this.MarPastYearAmount = MarPastYearAmount;
    }

    /**
     * @return the AprPastYearAmount
     */
    public Double getAprPastYearAmount() {
        return AprPastYearAmount;
    }

    /**
     * @param AprPastYearAmount the AprPastYearAmount to set
     */
    public void setAprPastYearAmount(Double AprPastYearAmount) {
        this.AprPastYearAmount = AprPastYearAmount;
    }

    /**
     * @return the MayPastYearAmount
     */
    public Double getMayPastYearAmount() {
        return MayPastYearAmount;
    }

    /**
     * @param MayPastYearAmount the MayPastYearAmount to set
     */
    public void setMayPastYearAmount(Double MayPastYearAmount) {
        this.MayPastYearAmount = MayPastYearAmount;
    }

    /**
     * @return the JunPastYearAmount
     */
    public Double getJunPastYearAmount() {
        return JunPastYearAmount;
    }

    /**
     * @param JunPastYearAmount the JunPastYearAmount to set
     */
    public void setJunPastYearAmount(Double JunPastYearAmount) {
        this.JunPastYearAmount = JunPastYearAmount;
    }

    /**
     * @return the JulPastYearAmount
     */
    public Double getJulPastYearAmount() {
        return JulPastYearAmount;
    }

    /**
     * @param JulPastYearAmount the JulPastYearAmount to set
     */
    public void setJulPastYearAmount(Double JulPastYearAmount) {
        this.JulPastYearAmount = JulPastYearAmount;
    }

    /**
     * @return the AugPastYearAmount
     */
    public Double getAugPastYearAmount() {
        return AugPastYearAmount;
    }

    /**
     * @param AugPastYearAmount the AugPastYearAmount to set
     */
    public void setAugPastYearAmount(Double AugPastYearAmount) {
        this.AugPastYearAmount = AugPastYearAmount;
    }

    /**
     * @return the SepPastYearAmount
     */
    public Double getSepPastYearAmount() {
        return SepPastYearAmount;
    }

    /**
     * @param SepPastYearAmount the SepPastYearAmount to set
     */
    public void setSepPastYearAmount(Double SepPastYearAmount) {
        this.SepPastYearAmount = SepPastYearAmount;
    }

    /**
     * @return the OctPastYearAmount
     */
    public Double getOctPastYearAmount() {
        return OctPastYearAmount;
    }

    /**
     * @param OctPastYearAmount the OctPastYearAmount to set
     */
    public void setOctPastYearAmount(Double OctPastYearAmount) {
        this.OctPastYearAmount = OctPastYearAmount;
    }

    /**
     * @return the NovPastYearAmount
     */
    public Double getNovPastYearAmount() {
        return NovPastYearAmount;
    }

    /**
     * @param NovPastYearAmount the NovPastYearAmount to set
     */
    public void setNovPastYearAmount(Double NovPastYearAmount) {
        this.NovPastYearAmount = NovPastYearAmount;
    }

    /**
     * @return the DecPastYearAmount
     */
    public Double getDecPastYearAmount() {
        return DecPastYearAmount;
    }

    /**
     * @param DecPastYearAmount the DecPastYearAmount to set
     */
    public void setDecPastYearAmount(Double DecPastYearAmount) {
        this.DecPastYearAmount = DecPastYearAmount;
    }

    /**
     * @return the TotalThisYearUnits
     */
    public Double getTotalThisYearUnits() {
        return TotalThisYearUnits;
    }

    /**
     * @param TotalThisYearUnits the TotalThisYearUnits to set
     */
    public void setTotalThisYearUnits(Double TotalThisYearUnits) {
        this.TotalThisYearUnits = TotalThisYearUnits;
    }

    /**
     * @return the TotalThisYearAmount
     */
    public Double getTotalThisYearAmount() {
        return TotalThisYearAmount;
    }

    /**
     * @param TotalThisYearAmount the TotalThisYearAmount to set
     */
    public void setTotalThisYearAmount(Double TotalThisYearAmount) {
        this.TotalThisYearAmount = TotalThisYearAmount;
    }

    /**
     * @return the TotalPastYearUnits
     */
    public Double getTotalPastYearUnits() {
        return TotalPastYearUnits;
    }

    /**
     * @param TotalPastYearUnits the TotalPastYearUnits to set
     */
    public void setTotalPastYearUnits(Double TotalPastYearUnits) {
        this.TotalPastYearUnits = TotalPastYearUnits;
    }

    /**
     * @return the TotalPastYearAmount
     */
    public Double getTotalPastYearAmount() {
        return TotalPastYearAmount;
    }

    /**
     * @param TotalPastYearAmount the TotalPastYearAmount to set
     */
    public void setTotalPastYearAmount(Double TotalPastYearAmount) {
        this.TotalPastYearAmount = TotalPastYearAmount;
    }

    
}
