package org.example;
//Special Deals:
//        1. Buy 2 tickets and get 15% off
//        2. Buy 3 tickets and get 30% off

import java.util.ArrayList;
import java.util.List;

public class SpecialDeals {
    private String discountCategory;
    private int discountPercentage;

    private String discountCode;

    private int discountId;
    private List<SpecialDeals> discountList;
    private List<Specialdealset> specialdealsetList;


    public SpecialDeals(int discountId, String discountCategory,int discountPercentage){
        this.discountCategory=discountCategory;
        this.discountPercentage=discountPercentage;
        this.discountId=discountId;
        discountList=new ArrayList<>();
        specialdealsetList=new ArrayList<>();
    }
    public class Specialdealset{
        public int numberTickets;
        public int discountPercentage;
    }

    public void setDiscountCategory(String discountCategory) {
        this.discountCategory = discountCategory;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }



    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountCategory() {
        return discountCategory;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }



    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public String discountValidation(int age){
        if (age<18){
            return "MINOR10";
        } else if (age>60) {
            return "SENIOR20";
        }
        else{
            return "None";
        }
    }

    public void addDiscount(int discountId,String discountCategory,int discountPercentage){
        SpecialDeals s1=new SpecialDeals(discountId,discountCategory,discountPercentage);
        discountList.add(s1);
        System.out.println("Discount added successfully");
    }
    public List<SpecialDeals> viewDiscountList(){
        return discountList;
    }
    public boolean removeDiscountListElement(int discountId){
        boolean flag=false;
        for (SpecialDeals ele:discountList
             ) {if (ele.getDiscountId()==discountId){
                 discountList.remove(ele);
                 flag=true;
                 break;
        }
        }
        return flag;
    }

    public void setSpecialDeal(int numberTickets,int discountPercentage){
        Specialdealset s1=new Specialdealset();
        s1.numberTickets=numberTickets;
        s1.discountPercentage=discountPercentage;
        specialdealsetList.add(s1);
    }

    public List<Specialdealset> getSpecialdealsetList() {
        return specialdealsetList;
    }
}
