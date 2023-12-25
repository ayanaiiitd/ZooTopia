package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Visitor {
    private String visitorName;
    private int visitorAge;
    private String visitorPhoneNumber;
    private int visitorBalance;
    private String visitorEmail;
    private String visitorPassword;
    private String memberShipType="None";

    private String feedback;
    private List<Ticket> visitorTicketList;


    //    private List<Visitor> visitorRegister;
    public Visitor(String visitorName, int visitorAge, String visitorPhoneNumber, int visitorBalance, String visitorEmail, String visitorPassword) {
        this.visitorName = visitorName;
        this.visitorAge = visitorAge;
        this.visitorBalance = visitorBalance;
        this.visitorPhoneNumber = visitorPhoneNumber;
        this.visitorEmail = visitorPhoneNumber;
        this.visitorPassword = visitorPassword;
        visitorTicketList=new ArrayList<>();
//        visitorRegister=new ArrayList<>();


    }
    public class Ticket{
        public String ticketName;
        public int ticketCount;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorAge(int visitorAge) {
        this.visitorAge = visitorAge;
    }

    public int getVisitorAge() {
        return visitorAge;
    }

    public void setVisitorPhoneNumber(String phoneNumber) {
        this.visitorPhoneNumber = phoneNumber;
    }

    public String getVisitorPhoneNumber() {
        return visitorPhoneNumber;
    }

    public void setVisitorBalance(int balance) {
        this.visitorBalance = balance;
    }

    public int getVisitorBalance() {
        return visitorBalance;
    }

    public void setVisitorEmail(String email) {
        this.visitorEmail = email;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorPassword(String password) {
        this.visitorPassword = password;
    }

    public String getVisitorPassword() {
        return visitorPassword;
    }

    public void setMemberShipType(String memberShipType) {
        this.memberShipType = memberShipType;
    }

    public String getMemberShipType() {
        return memberShipType;
    }



    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }
    public void setVisitorTicketList(String ticketName,int ticketCount){
        Ticket t1=new Ticket();
        t1.ticketName=ticketName;
        t1.ticketCount=ticketCount;
        visitorTicketList.add(t1);
    }

    public List<Ticket> getVisitorTicketList() {
        return visitorTicketList;
    }
}