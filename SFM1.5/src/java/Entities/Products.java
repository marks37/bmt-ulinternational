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
public class Products {
    
    private int ProductId;
    private String RecNo;
    private String ItemCode;
    private String ItemName;
    private String Description;
    private String ItemClass;
    private String Brand;
    private String SubBrand;
    private String UnitsOfMeasure;
    private String CasePack;
    private String Availability;
    private String Status;
    
    private int ProductPromotionsId;
    private double PromoPrice_NoVat;
    private double PromoPrice_Vat;
    private int Deal;
    private int Bonus;
    private double Net_NoVat;
    private double Net_Vat;
    private double discount;
    
    private int ProductPricingId;
    private String ProductPricingNo;
    private double PriceWithVat;
    private double PriceNoVat;
    private String EffectiveDate;
    
    

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
     * @return the UnitsOfMeasure
     */
    public String getUnitsOfMeasure() {
        return UnitsOfMeasure;
    }

    /**
     * @param UnitsOfMeasure the UnitsOfMeasure to set
     */
    public void setUnitsOfMeasure(String UnitsOfMeasure) {
        this.UnitsOfMeasure = UnitsOfMeasure;
    }

    /**
     * @return the CasePack
     */
    public String getCasePack() {
        return CasePack;
    }

    /**
     * @param CasePack the CasePack to set
     */
    public void setCasePack(String CasePack) {
        this.CasePack = CasePack;
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

    /**
     * @return the RecNo
     */
    public String getRecNo() {
        return RecNo;
    }

    /**
     * @param RecNo the RecNo to set
     */
    public void setRecNo(String RecNo) {
        this.RecNo = RecNo;
    }

    /**
     * @return the ItemClass
     */
    public String getItemClass() {
        return ItemClass;
    }

    /**
     * @param ItemClass the ItemClass to set
     */
    public void setItemClass(String ItemClass) {
        this.ItemClass = ItemClass;
    }

    /**
     * @return the Brand
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * @param Brand the Brand to set
     */
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    /**
     * @return the SubBrand
     */
    public String getSubBrand() {
        return SubBrand;
    }

    /**
     * @param SubBrand the SubBrand to set
     */
    public void setSubBrand(String SubBrand) {
        this.SubBrand = SubBrand;
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
     * @return the ProductPromotionsId
     */
    public int getProductPromotionsId() {
        return ProductPromotionsId;
    }

    /**
     * @param ProductPromotionsId the ProductPromotionsId to set
     */
    public void setProductPromotionsId(int ProductPromotionsId) {
        this.ProductPromotionsId = ProductPromotionsId;
    }

    /**
     * @return the PromoPrice_NoVat
     */
    public double getPromoPrice_NoVat() {
        return PromoPrice_NoVat;
    }

    /**
     * @param PromoPrice_NoVat the PromoPrice_NoVat to set
     */
    public void setPromoPrice_NoVat(double PromoPrice_NoVat) {
        this.PromoPrice_NoVat = PromoPrice_NoVat;
    }

    /**
     * @return the PromoPrice_Vat
     */
    public double getPromoPrice_Vat() {
        return PromoPrice_Vat;
    }

    /**
     * @param PromoPrice_Vat the PromoPrice_Vat to set
     */
    public void setPromoPrice_Vat(double PromoPrice_Vat) {
        this.PromoPrice_Vat = PromoPrice_Vat;
    }

    /**
     * @return the Deal
     */
    public int getDeal() {
        return Deal;
    }

    /**
     * @param Deal the Deal to set
     */
    public void setDeal(int Deal) {
        this.Deal = Deal;
    }

    /**
     * @return the Bonus
     */
    public int getBonus() {
        return Bonus;
    }

    /**
     * @param Bonus the Bonus to set
     */
    public void setBonus(int Bonus) {
        this.Bonus = Bonus;
    }

    /**
     * @return the Net_NoVat
     */
    public double getNet_NoVat() {
        return Net_NoVat;
    }

    /**
     * @param Net_NoVat the Net_NoVat to set
     */
    public void setNet_NoVat(double Net_NoVat) {
        this.Net_NoVat = Net_NoVat;
    }

    /**
     * @return the Net_Vat
     */
    public double getNet_Vat() {
        return Net_Vat;
    }

    /**
     * @param Net_Vat the Net_Vat to set
     */
    public void setNet_Vat(double Net_Vat) {
        this.Net_Vat = Net_Vat;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the ProductPricingId
     */
    public int getProductPricingId() {
        return ProductPricingId;
    }

    /**
     * @param ProductPricingId the ProductPricingId to set
     */
    public void setProductPricingId(int ProductPricingId) {
        this.ProductPricingId = ProductPricingId;
    }

    /**
     * @return the ProductPricingNo
     */
    public String getProductPricingNo() {
        return ProductPricingNo;
    }

    /**
     * @param ProductPricingNo the ProductPricingNo to set
     */
    public void setProductPricingNo(String ProductPricingNo) {
        this.ProductPricingNo = ProductPricingNo;
    }

    /**
     * @return the PriceWithVat
     */
    public double getPriceWithVat() {
        return PriceWithVat;
    }

    /**
     * @param PriceWithVat the PriceWithVat to set
     */
    public void setPriceWithVat(double PriceWithVat) {
        this.PriceWithVat = PriceWithVat;
    }

    /**
     * @return the PriceNoVat
     */
    public double getPriceNoVat() {
        return PriceNoVat;
    }

    /**
     * @param PriceNoVat the PriceNoVat to set
     */
    public void setPriceNoVat(double PriceNoVat) {
        this.PriceNoVat = PriceNoVat;
    }

    /**
     * @return the EffectiveDate
     */
    public String getEffectiveDate() {
        return EffectiveDate;
    }

    /**
     * @param EffectiveDate the EffectiveDate to set
     */
    public void setEffectiveDate(String EffectiveDate) {
        this.EffectiveDate = EffectiveDate;
    }
    
}
