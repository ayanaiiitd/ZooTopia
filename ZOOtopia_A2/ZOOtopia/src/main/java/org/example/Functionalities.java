package org.example;

import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Functionalities{

//    List<Visitor> visitorRegister=new ArrayList<>();
    private List<Visitor> visitorRegister;
//    private List<Attraction> attractionList;
    private List<String> feedbackList;
    private List<Integer> amountDeposited;
    private Admin admin1;
    private Animals animal1 ;
    private List<Visitor.Ticket> ticketList;
    Animals a11;
    SpecialDeals sd1=new SpecialDeals(0,"",0);
    public Functionalities(Animals animal1,Admin admin1) {
        visitorRegister=new ArrayList<>();
        feedbackList=new ArrayList<>();
        amountDeposited=new ArrayList<>();
        ticketList=new ArrayList<>();
//        attractionList=new ArrayList<>();
        this.animal1=animal1;
        this.admin1=admin1;
    }
    Scanner sc = new Scanner(System.in);
    public List<Visitor> registerVisitor(Visitor visitor1) {
//        this.visitorRegister=visitorRegister;
        boolean flag = true;
        if (visitorRegister!=null){
            for (Visitor ele : visitorRegister
            ) {
                if (Objects.equals(ele.getVisitorEmail(), visitor1.getVisitorEmail())) {
                    if (Objects.equals(ele.getVisitorPassword(), visitor1.getVisitorPassword())) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag) {
            assert visitorRegister != null;
            visitorRegister.add(visitor1);
            System.out.println("Visitor registered successfully :)");
            return visitorRegister;
        }
        else{
            System.out.println("Visitor already registered!!");
        }
        return visitorRegister;
    }

    public boolean login(String email,String password) {
        boolean flag = false;
        for (Visitor ele : visitorRegister
        ) {
            if (Objects.equals(ele.getVisitorEmail(), email)) {
                if (Objects.equals(ele.getVisitorPassword(), password)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public void exploreTheZoo(){
//        1. View Attractions
//        2. View Animals
//        3. Exit
        boolean flag=true;
        while(flag) {
            System.out.println(" 1. View Attractions\n" +
                    "2. View Animals\n" +
                    "3. Exit");
            System.out.print("Enter your choice : ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    admin1.viewAttractions();
                    break;
                case 2:
                    animal1.viewAnimals();
                    break;
                case 3:
                    flag=false;
                    break;
            }

        }

    }
    public void buyMembership(String visitorEmail){
//        1. Basic Membership (₹20)
//                2. Premium Membership (₹50)
//                Enter your choice: 2
//
//        Apply Discount Code: None
//
//        Basic Membership purchased successfully. Your balance is now ₹80.
        System.out.println("1. Basic Membership (₹20)\n" +
                "2. Premium Membership (₹50)");
        System.out.print("Enter your choice : ");
        int choice =sc.nextInt();
        for (Visitor ele:visitorRegister
             ) {
            if (Objects.equals(ele.getVisitorEmail(), visitorEmail)){
                System.out.println(ele.getVisitorEmail());
                if (choice==1) {
                    System.out.print("Apply Discount Code: ");
                    String discountCode = sc.next();
                    if (Objects.equals(sd1.discountValidation(ele.getVisitorAge()), "None")) {
                        ele.setMemberShipType("Basic Membership (₹20)");
                        ele.setVisitorBalance(ele.getVisitorBalance() - 20);
                        amountDeposited.add(20);
                        System.out.println("Basic Membership purchased successfully. Your balance is now ₹" + ele.getVisitorBalance());
                    }
                    else{
                        if (Objects.equals(sd1.discountValidation(ele.getVisitorAge()), "MINOR10")){
                            ele.setMemberShipType("Basic Membership (₹20) + discount: "+discountCode);
                            ele.setVisitorBalance(ele.getVisitorBalance() - 18);
                            amountDeposited.add(18);
                            System.out.println("Basic Membership purchased successfully. Your balance is now ₹" + ele.getVisitorBalance());
                        }
                        else{
                            ele.setMemberShipType("Basic Membership (₹20) + discount: "+discountCode);
                            ele.setVisitorBalance(ele.getVisitorBalance() - 16);
                            amountDeposited.add(16);
                            System.out.println("Basic Membership purchased successfully. Your balance is now ₹" + ele.getVisitorBalance());
                        }
                    }
                }
                else{
                    System.out.print("Apply Discount Code: ");
                    String discountCode=sc.next();

                    if (Objects.equals(sd1.discountValidation(ele.getVisitorAge()), "None")) {
                        ele.setMemberShipType("Premium Membership (₹50)");
                        ele.setVisitorBalance(ele.getVisitorBalance()-50);
                        amountDeposited.add(50);
                        System.out.println("Premium Membership purchased successfully. Your balance is now ₹"+ele.getVisitorBalance());
                    }
                    else{
                        if (Objects.equals(sd1.discountValidation(ele.getVisitorAge()), "MINOR10")){
                            ele.setMemberShipType("Premium Membership (₹50)+discount: "+discountCode);
                            ele.setVisitorBalance(ele.getVisitorBalance()-45);
                            amountDeposited.add(45);
                            System.out.println("Premium Membership purchased successfully. Your balance is now ₹"+ele.getVisitorBalance());
                        }
                        else{
                            ele.setMemberShipType("Premium Membership (₹50)+discount: "+discountCode);
                            ele.setVisitorBalance(ele.getVisitorBalance()-40);
                            amountDeposited.add(40);
                            System.out.println("Premium Membership purchased successfully. Your balance is now ₹"+ele.getVisitorBalance());
                        }
                    }
                }
            }
            break;
        }

    }
    public void buyTickets(String email){
        int ticketPrice;

//        if (ticketPrice==0){
//            System.out.println("Invalid input");
//        }
//        else{
            for (Visitor ele:visitorRegister
                 ) {
                if (Objects.equals(email, ele.getVisitorEmail())){
                    if (ele.getMemberShipType().contains("Basic Membership")) {
                        System.out.print("Enter attractionId: ");
                        int choice=sc.nextInt();
                        int discount=0;
                        System.out.print("Enter number of tickets to be purchased: ");
                        int numberTickets=sc.nextInt();
                        for (SpecialDeals.Specialdealset item:admin1.getDealsList()
                             ) {if (item.numberTickets==numberTickets){
                                 discount=item.discountPercentage;
                        }

                        }
                        ticketPrice = admin1.tickets(choice);
                        ele.setVisitorTicketList(admin1.attractionName(choice),numberTickets);
                        ele.setVisitorBalance(ele.getVisitorBalance() -((numberTickets* ticketPrice)-(numberTickets* ticketPrice*discount/100)));

                        System.out.println("Your balance is now ₹" + ele.getVisitorBalance());
                    } else if (Objects.equals(ele.getMemberShipType(), "None")) {
                        System.out.println("Cannot buy tickets before getting a membership!!");
                    }
                    else{
                        System.out.println("Premium members not need to buy tickets");
                    }
                }
                break;
//            }
        }

    }
    public void viewDiscounts() {
//        View Discounts:
//        1. Minor (10% discount) - MINOR10
//        2. Senior Citizen (20% discount) - SENIOR20
        System.out.println("Discounts are as follows-->");
        System.out.println("1. Minor (10% discount) - MINOR10\n" +
                "2. Senior Citizen (20% discount) - SENIOR20");
        admin1.viewDiscount();
    }
    public void viewSpecialDeals(){
//        Special Deals:
//        1. Buy 2 tickets and get 15% off
//        2. Buy 3 tickets and get 30% off
        if (admin1.getDealsList().size()!=0) {
            for (SpecialDeals.Specialdealset ele : admin1.getDealsList()
            ) {
                System.out.println("Buy " + ele.numberTickets + " tickets and get " + ele.discountPercentage + "% off");
            }
        }
        else{
            System.out.println("No special deals available");
        }
    }
    public void visitAnimals(String visitorEmail){
        System.out.println("Enter the animal name:");
        String animalName=sc.nextLine();
        boolean foundFlag=false;
        for (Animals ele:animal1.animalList()
             ) {
            if (Objects.equals(ele.getAnimalName(), animalName)){
                foundFlag=true;
                System.out.println("1.feed animal\n"+
                        "2.Read about the animal\n");
                System.out.print("Enter your choice: ");
                int choice =sc.nextInt();
                if (choice==1){
                    System.out.println(ele.getAnimalNoise());

                }
                else{
                    System.out.println("Animal description is as follows-->");
                    System.out.println(ele.getAnimalDescription());

                }
                break;

            }
            else{
                foundFlag=false;
            }
        }
        if (foundFlag==false){
            System.out.println("Wrong Aniamal name inputted!!");
        }

    }
    public void visitAttractions(String visitorEmail){
        boolean foundFlag=false;
        int count=0;
        System.out.println("Select an Attraction to Visit:");
        count = admin1.viewAttractions();
        System.out.println(count+1+". Exit");
        System.out.print("Enter your choice: ");
        int choice =sc.nextInt();
        if (choice!=count+1){
            for (Visitor ele:visitorRegister
                 ) {
                if(Objects.equals(ele.getVisitorEmail(), visitorEmail)){
                    if (ele.getMemberShipType().contains("Premium Membership")){
                        System.out.println("Thank you for visiting "+admin1.attractionName(choice)+". Hope you enjoyed the attraction.\n");
                    }
                    else{
                        if (ele.getMemberShipType().contains("Basic Membership")){
//                            if (!Objects.equals(ele.getTicketType(), admin1.attractionName(choice))) {
//                                System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
//
//                            }
//                            else{
//                                System.out.println("Thank you for visiting "+admin1.attractionName(choice)+". Hope you enjoyed the attraction.\n");
//                            }
                            for (Visitor.Ticket item:ele.getVisitorTicketList()
                                 ) {
                                if (Objects.equals(item.ticketName, admin1.attractionName(choice))) {
                                    foundFlag = true;
                                    item.ticketCount= item.ticketCount-1;
                                    System.out.println("1 Ticket Used.");
                                    System.out.println("Thank you for visiting " + admin1.attractionName(choice) + ". Hope you enjoyed the attraction.\n");
                                    admin1.popularAttraction(admin1.attractionName(choice));
                                    break;
                                }
                            }

                            if (foundFlag==false){
                                System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                            }


                        }
                    }
                }

            }

        }

    }
    public void leaveFeedback(String visitorEmail){
        sc.nextLine();
        System.out.println("Enter your feedback (max 200 characters): ");
        String feebackStr=sc.nextLine();
        for (Visitor ele:visitorRegister
             ) {
            if (Objects.equals(visitorEmail, ele.getVisitorEmail())){
                ele.setFeedback(feebackStr);
                feedbackList.add(feebackStr);
                System.out.println("Thank you for your feedback.");

            }
            break;
        }
    }
    public List<String> viewFeedbackList(){
        return feedbackList;
    }
    public List<Visitor> visitorsList(){
        return visitorRegister;
    }
    public List<Integer> totalRevenue(){
        return amountDeposited;
    }

}
