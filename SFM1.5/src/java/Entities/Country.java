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

public class Country {
 
    private String name;
    private String shortCode;
     
    public Country(String n, String c){
        this.name=n;
        this.shortCode=c;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
     
    @Override
    public String toString(){
        return name + "::" + shortCode;
    }
     
}

