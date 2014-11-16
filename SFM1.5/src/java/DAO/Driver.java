/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Accounts;
import Entities.Territories;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mark
 */
public class Driver {

    public static void main(String[] args) {

//        TerritoryDAO TeDAO = new TerritoryDAO();
//        ArrayList<Territories> Territories = (ArrayList<Territories>) TeDAO.ViewAllTerritories();
//        System.out.println("Index Territory Id TerritoryCode Region Area ZipCode");
//        for (int a = 0; a < Territories.size(); a++) {
//            System.out.println(a + 2 + " " + Territories.get(a).getTerritoryId() + " " + Territories.get(a).getTerritoryCode() + " " + Territories.get(a).getRegion() + " " + Territories.get(a).getArea() + " " + Territories.get(a).getZipCode());
//        }
//        Date ca1 = Calendar.getInstance().getTime();
        // int iMonth=ca1.get(Calendar.MONTH);
//        java.util.Date d = Calendar.getInstance().getTime();
//        String month = new SimpleDateFormat("MMMM").format(d);
//        String year = new SimpleDateFormat("YYYY").format(d);
//        String period = month+" "+year;
//
//        System.out.println("Period:"+period);
        //System.out.println("Month Name :" + new SimpleDateFormat("MMMM").format(d));
        //System.out.println("Year :" + new SimpleDateFormat("YYYY").format(d));
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date date = new Date();
        //System.out.println(dateFormat.format(date));
        double correct = 342.5;
        long correct2 = Math.round(correct);
        double questionNum = 500;
        //float percent = (correct * 100.0f) / questionNum;
        long percent = Math.round((correct * 100.0f) / questionNum);
//        double percent = (correct * 100.0f) / questionNum;

//        SimpleDateFormat sdfDate = new SimpleDateFormat("MMM. d, yyyy");//dd/MM/yyyy
//        Date now = new Date();
//        String strDate = sdfDate.format(now);
        System.out.println(percent+" "+correct2);

    }

}
