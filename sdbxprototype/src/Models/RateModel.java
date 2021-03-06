/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author cmason12
 */
public class RateModel {
    
    //  Attributes
    
    //  RateDate Attribute
    /*
        CSV Column; non-volatile
        Date
        Acts as primary key for this specific base rate
    */
    private Date _RateDate;
    public Date getRateDate() {return _RateDate;}
    public void setRateDate(Date rateDate) {this._RateDate = rateDate;}
    
    //  BaseRate Attribute
    /*
        CSV Column; non-volatile
        double
        Base charge for any room on a specific day
    */
    private double _BaseRate;
    public double getBaseRate() {return _BaseRate;}
    public void setBaseRate(double baseRate) {this._BaseRate = baseRate;}
    
    
    //  Model Constructors
    public RateModel(Date rateDate, double baseRate) {
        this._RateDate = rateDate;
        this._BaseRate = baseRate;
    }
    
    public RateModel(Date rateDate) {
        this(rateDate, 0);
    }

    public RateModel() {
        this(null, 0);
    }    
    
    // Overrides
    @Override
    public int hashCode() {
        // TODO: Warning 
        // - this method can create orphans when using a HashSet, or similar
        // - highly recommend to use some immutable Attribute (strings)
        int hash = 3;
        hash += hash * 11 + _RateDate.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RateModel)) {
            return false;
        }
        RateModel other = (RateModel) obj;
        return (this._RateDate != other._RateDate);
    }

    @Override
    public String toString() {
        SimpleDateFormat fm = new SimpleDateFormat("MM-dd-yyyy");
        String info = "Rate [";
        if(_RateDate != null)
            info += " rateDate=" + fm.format(_RateDate);
        info += " | baseRate=" + Double.toString(_BaseRate);
        info += " ]";
        return  info;
    }
}