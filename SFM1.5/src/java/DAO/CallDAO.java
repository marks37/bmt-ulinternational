/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnectionFactory;
import Entities.CallForecast;
import Entities.CallProgress;
import Entities.Calls;
import Entities.DailyObjectives;
import Entities.SalesProgress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class CallDAO {

    public ArrayList<DailyObjectives> getDailyObjectives(String SalesRepCode) {
        ArrayList<DailyObjectives> objectives = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select CallId, CallNo ,calls.AccountCode as AccountCode, accounts.EnglishName, \n"
                    + "concat(Address1,\", \", Address2,\", \",Address3,\", \",Address4) as Address, CallStatus,\n"
                    + "Contact, calls.ActivityType, calls.SalesTarget, calls.AvailabilityTarget \n"
                    + "from calls\n"
                    + "join accounts on calls.AccountCode = accounts.AccountCode\n"
                    + "join acc_address on acc_address.AccountCode = accounts.AccountCode\n"
                    + "where Calldate = curdate() and AssignedTo = ?\n"
                    + "order by CallId");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DailyObjectives objective = new DailyObjectives();
                objective.setCallId(rs.getInt("CallId"));
                objective.setCallNo(rs.getString("CallNo"));
                objective.setAccountCode(rs.getString("AccountCode"));
                objective.setEnglishName(rs.getString("accounts.EnglishName"));
                objective.setAddress(rs.getString("Address"));
                objective.setCallStatus(rs.getString("CallStatus"));
                objective.setContact(rs.getString("Contact"));
                objective.setActivityType(rs.getString("calls.ActivityType"));
                objective.setSalesTarget(rs.getString("calls.SalesTarget"));
                objective.setAvailabilityTarget(rs.getString("calls.AvailabilityTarget"));
                objectives.add(objective);
            }
            conn.close();
            return objectives;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objectives;
    }

    public Calls getCallDetails(String CallNo) {
        Calls Call = new Calls();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from calls where CallNo=?");
            pstmt.setString(1, CallNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Call.setCallId(rs.getInt("CallId"));
                Call.setAssignedTo(rs.getString("AssignedTo"));
                Call.setWorkplanNo(rs.getString("WorkPlanNo"));
                Call.setCallNo(rs.getString("CallNo"));
                Call.setCallDate(rs.getString("CallDate"));
                Call.setActivityType(rs.getString("calls.ActivityType"));
                Call.setSalesTarget(rs.getString("calls.SalesTarget"));
                Call.setAvailabilityTarget(rs.getString("calls.AvailabilityTarget"));
                Call.setCallStatus(rs.getString("CallStatus"));
                Call.setAccountCode(rs.getString("AccountCode"));
                Call.setCallYear(rs.getString("CallYear"));
                Call.setCallMonth(rs.getString("CallMonth"));
                Call.setCallDay(rs.getString("CallDay"));
            }
            conn.close();
            return Call;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Call;
    }

    public int getObjectivesCount(String SalesRepCode) {
        int count = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select count(*) as 'count' from calls\n"
                    + "where CallDate = curdate() and AssignedTo = ?");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getCoveredCallsCount(String SalesRepCode) {
        int count = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, count(*) as 'count' from calls\n"
                    + "where month(CallDate) = month(curdate()) and AssignedTo = ? and CallStatus = 'Completed'");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getCoveredCallsCount_Account(String SalesRepCode, String AccountCode) {
        int count = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, count(*) as 'count' from calls\n"
                    + "where month(CallDate) = month(curdate()) and AssignedTo = ? and CallStatus = 'Completed' and AccountCode = ?");
            pstmt.setString(1, SalesRepCode);
            pstmt.setString(2, AccountCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getMissedCallsCount(String SalesRepCode) {
        int count = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, count(*) as 'count' from calls\n"
                    + "where month(CallDate) = month(curdate()) and AssignedTo = ? and CallStatus = 'Missed'");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getNewCallsCount(String SalesRepCode) {
        int count = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, count(*) as 'count' from calls\n"
                    + "where month(CallDate) = month(curdate()) and AssignedTo = ? and CallStatus = 'New'");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getTotalCallsCount(String SalesRepCode) {
        int count = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, count(*) as 'count' from calls\n"
                    + "where month(CallDate) = month(curdate()) and AssignedTo = ?");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int getTotalCallsCount_Account(String SalesRepCode, String AccountCode) {
        int count = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select *, count(*) as 'count' from calls\n"
                    + "where month(CallDate) = month(curdate()) and AssignedTo = ? and AccountCode = ?");
            pstmt.setString(1, SalesRepCode);
            pstmt.setString(2, AccountCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            conn.close();
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public double getMonthSalesTarget(String SalesRepCode) {
        double MonthTarget = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT sum(SalesTarget) as MonthTarget FROM calls\n"
                    + "where Month(CallDate) = Month(curdate()) and AssignedTo=?");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MonthTarget = rs.getDouble("MonthTarget");
            }
            conn.close();
            return MonthTarget;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MonthTarget;

    }

    public double getCallTarget(int CallId) {
        double MonthTarget = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT SalesTarget FROM calls\n"
                    + "where CallId = ?");
            pstmt.setInt(1, CallId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MonthTarget = rs.getDouble("SalesTarget");
            }
            conn.close();
            return MonthTarget;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MonthTarget;

    }

    public double getMonthSalesTarget_Account(String AccountCode, String SalesRepCode) {
        double MonthTarget = 0;

        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT sum(SalesTarget) as MonthTarget FROM calls\n"
                    + "where Month(CallDate) = Month(curdate()) and AssignedTo=? and AccountCode = ?");
            pstmt.setString(1, SalesRepCode);
            pstmt.setString(2, AccountCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MonthTarget = rs.getDouble("MonthTarget");
            }
            conn.close();
            return MonthTarget;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MonthTarget;

    }

    public ArrayList<SalesProgress> getSalesProgress(String SalesRepCode) {
        ArrayList<SalesProgress> SalesProgress = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select calls.AccountCode, EnglishName, sum(Sales_act) as 'Sales', sum(salestarget) as 'SalesTarget' from calls\n"
                    + "join call_performance on calls.CallNo = call_performance.CallNo\n"
                    + "join accounts on calls.AccountCode = accounts.AccountCode\n"
                    + "where calls.AssignedTo=?\n"
                    + "group by calls.accountCode\n"
                    + "order by CallId");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SalesProgress salesprogress = new SalesProgress();
                salesprogress.setAccountCode(rs.getString("calls.AccountCode"));
                salesprogress.setEnglishName(rs.getString("EnglishName"));
                salesprogress.setActualSales(rs.getDouble("Sales"));
                salesprogress.setSalesTarget(rs.getDouble("SalesTarget"));
                SalesProgress.add(salesprogress);
            }
            conn.close();
            return SalesProgress;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SalesProgress;
    }

    public ArrayList<CallProgress> getCallProgress(String SalesRepCode) {
        ArrayList<CallProgress> CallProgresses = new ArrayList<>();
        try {
            DBConnectionFactory myConnection = DBConnectionFactory.getInstance();
            Connection conn = myConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select T1.AccountCode, EnglishName,IFNULL(CompletedCalls,0) as Completed, IFNULL(MissedCalls,0) as Missed, \n"
                    + "IFNULL(NewCalls,0) as New, IFNULL(TotalCalls,0) as Total, T1.AssignedTo as SalesRepCode \n"
                    + "from calls as T1\n"
                    + "join accounts\n"
                    + "on T1.AccountCode = accounts.AccountCode\n"
                    + "left join \n"
                    + "(select *, count(*) as CompletedCalls from calls \n"
                    + "where Month(CallDate) = Month(curdate()) and CallStatus = 'Completed'\n"
                    + "group by AccountCode,AssignedTo) \n"
                    + "as T2 on T1.AccountCode = T2.AccountCode\n"
                    + "left join (select *, count(*) as MissedCalls from calls \n"
                    + "where Month(CallDate) = Month(curdate()) and CallStatus = 'Missed'\n"
                    + "group by AccountCode,AssignedTo) \n"
                    + "as T3 on T1.AccountCode = T3.AccountCode\n"
                    + "left join\n"
                    + "(select *, count(*) as NewCalls from calls \n"
                    + "where Month(CallDate) = Month(curdate()) and CallStatus = 'New'\n"
                    + "group by AccountCode,AssignedTo)\n"
                    + " as T4 on T1.AccountCode = T4.AccountCode\n"
                    + "left join\n"
                    + "(select *, count(*) as TotalCalls from calls \n"
                    + "where Month(CallDate) = Month(curdate())\n"
                    + "group by AccountCode,AssignedTo)\n"
                    + " as T5 on T1.AccountCode = T5.AccountCode\n"
                    + "where T1.AssignedTo = ?\n"
                    + "group by T1.AccountCode,T1.AssignedTo\n"
                    + " ");
            pstmt.setString(1, SalesRepCode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CallProgress callprogress = new CallProgress();
                callprogress.setAccountCode(rs.getString("T1.AccountCode"));
                callprogress.setEnglishName(rs.getString("EnglishName"));
                callprogress.setCompleted(rs.getInt("Completed"));
                callprogress.setMissed(rs.getInt("Missed"));
                callprogress.setNew(rs.getInt("New"));
                callprogress.setTotal(rs.getInt("Total"));
                CallProgresses.add(callprogress);
            }
            conn.close();
            return CallProgresses;
        } catch (SQLException ex) {
            Logger.getLogger(CallDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CallProgresses;
    }

}
