package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    final static String userName = "a";
    final  static String password = "1234";
    private List<Attraction> attractionsList;
    private List<String> feedbackList;

    public Admin() {
        attractionsList=new ArrayList<>();

    }
    public class Attraction {
        private int attractionId;
        private String attractionName;
        private String description;
        private int price;
        private String eventTime;
        private int countVisit=0;
    }

    SpecialDeals sd1=new SpecialDeals(0,"",0);
    Scanner sc = new Scanner(System.in);
    int discountId;
    String discountCategory;
    int discountPercentage;
    boolean foundFlag;
    String discountCode;
    public boolean login(String username, String password){
        if (Objects.equals(username, Admin.userName) && Objects.equals(password, Admin.password)){
            System.out.println("logged in as Admin");
            return true;
        }
        else{
            System.out.println("login as Admin Unsuccessfull!!");
            return false;
        }
    }
    public void manageAttractions() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add Attraction\n" +
                    "2. View Attractions\n" +
                    "3. Modify Attraction\n" +
                    "4. Remove Attraction\n" +
                    "5. Exit\n");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("adding attractions");
                    System.out.print("Enter Attraction ID : ");
                    int attrcId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Attraction Name : ");
                    String attracName = sc.nextLine();
//                    sc.next();
//                    System.out.print("Enter attraction price : ");
//                    int price = sc.nextInt();

                    System.out.print("Enter Attraction Description : ");
                    String description = sc.nextLine();

                    Attraction a1 = new Attraction();
                    a1.attractionId = attrcId;
                    a1.attractionName = attracName;

//                    a1.price = price;
                    a1.description = description;
                    attractionsList.add(a1);
                    System.out.println("Attraction added successfully");
                    break;
                case 2:
                    System.out.println("View Attractions");
                    viewAttractions();
//                    for (Attraction ele : attractionsList
//                    ) {
//                        System.out.println(ele.attractionId + ". " + ele.attractionName + "   Description : " + ele.description + "  Price : " + ele.price);
//
//                    }

                    break;
                case 3:
                    foundFlag = false;
                    while (foundFlag == false) {
                        System.out.println("Modify Attraction");
                        System.out.print("Enter Attraction Id of the attraction to be modified : ");
                        int id = sc.nextInt();
                        for (Attraction ele : attractionsList
                        ) {
                            if (ele.attractionId == id) {

                                foundFlag = true;
                                System.out.println("1.Change Name\n" +
                                        "2.Change Price\n" +
                                        "3.Change Description\n");
                                System.out.print("Enter choice : ");
                                int change = sc.nextInt();
                                switch (change) {
                                    case 1:
                                        System.out.print("Enter new Name : ");
//                                String name=sc.nextLine();
                                        ele.attractionName = sc.nextLine();

                                        break;
                                    case 2:
                                        System.out.println("Enter new price : ");
                                        ele.price = sc.nextInt();
                                        break;
                                    case 3:
                                        System.out.println("Enter new description : ");
                                        ele.description = sc.nextLine();
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }

                        }
                        if (foundFlag == false) {
                            System.out.println("Invalid Id!!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("remove attraction");
                    foundFlag = false;
                    while (foundFlag == false) {

                        System.out.print("Enter Attraction Id of the attraction to be removed : ");
                        int id = sc.nextInt();
                        for (Attraction ele : attractionsList
                        ) {
                            if (ele.attractionId == id) {
                                foundFlag = true;
                                attractionsList.remove(ele);
                                System.out.println("Attraction removed successfully");
                                break;
                            }
                        }

                        if (foundFlag == false) {
                            System.out.println("Invalid Id!!");
                        }
                    }

                    break;
                case 5:
                    System.out.println("Exited from ManageAttractions");
                    flag = false;
                    break;


            }
        }
    }

    Animals a1 = new Animals("", "","","");
    public void manageAnimals() {

        boolean flag = true;
        while (flag) {
            System.out.println("1. Add Animal\n" +
                    "2. Update Animal Details\n" +
                    "3. Remove Animal\n" +
                    "4. Exit");
            int choice =sc.nextInt();
            switch (choice) {
                case 1:
                    boolean outFalg=false;
                    while (outFalg==false) {
                        sc.nextLine();
                        System.out.print("Enter animal name : ");
                        String animalName = sc.nextLine();
                        System.out.print("Enter animal type : ");
                        String animalType = sc.next();

                        System.out.print("Enter animal Noise : ");
                        String animalNoise = sc.next();
                        sc.nextLine();
                        System.out.print("Enter animal description : ");
                        String animalDescription=sc.nextLine();
                        outFalg = a1.addAnimals(animalName, animalType,animalNoise,animalDescription);
                    }
                    break;
                case 2:
                    flag=false;
                    while(flag==false) {
                        flag = a1.updateAnimalDetails();
                    }
                    break;
                case 3:
                    flag=false;
                    while(flag==false) {
                        sc.nextLine();
                        System.out.print("Enter the name of the Animal to be removed : ");
                        String name = sc.nextLine();
                        flag=a1.removeAnimal(name);
                    }
                    break;
                case 4:
                    System.out.println("Exited from manage animals!!");
                    flag =false;
                    break;
            }
        }
    }
    public void scheduleEvents(Functionalities func) {
//        1.event timings
//        2.price of entry ticket
//        3.count ticketed visitors
        foundFlag=false;
        System.out.println("Schedule Events: \n" +
                " 1.event timings\n" +
                "2.price of entry ticket\n" +
                "3.count ticketed visitors");
        System.out.print("Enter AttractionId: ");
        int attractionId = sc.nextInt();
        for (Attraction ele : attractionsList
        ) {
            if (ele.attractionId == attractionId) {
                foundFlag=true;
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter event timings: ");

                        ele.eventTime=sc.next();
                        System.out.println("Event timings set successfully");
                        break;
                    case 2:
                        System.out.print("Enter attraction price: ");
                        ele.price=sc.nextInt();
                        System.out.println("Attraction Price set successfully");
                        break;
                    case 3:
                        int count=0;
                        System.out.print("Total ticketed visitors are ");
                        for (Visitor item: func.visitorsList()
                             ) {
                            for (Visitor.Ticket t1: item.getVisitorTicketList()
                                 ) {
                                count+= t1.ticketCount;
                            }
                        }
                        System.out.println("Total ticketed visitors are "+count);
                }
            }
        }
    }
    public void setDiscounts(){
        boolean flag=true;
//        Set Discounts:
//        1. Add Discount
//        2. Modify Discount
//        3. Remove Discount
//        4. Exit
        while(flag) {
            System.out.println("1. Add Discount\n" +
                    "2. Modify Discount\n" +
                    "3. Remove Discount\n" +
                    "4. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add discount");
                    System.out.print("Enter discount Id: ");
                    discountId = sc.nextInt();
                    System.out.print("Enter Discount Category: ");
                    discountCategory = sc.next();
                    System.out.print("Enter Discount Percentage: ");
                    discountPercentage = sc.nextInt();
                    sd1.addDiscount(discountId, discountCategory, discountPercentage);
                    break;
                case 2:
                    System.out.println("Modify discount");
                    System.out.println("1.Modify discount category\n" +
                            "2.Modify Discount Percentage\n"+
                            "3.set discount code");
                    System.out.print("Enter the discountId for which changes needed: ");
                    discountId = sc.nextInt();
                    boolean foundFlag = false;
                    for (SpecialDeals ele : sd1.viewDiscountList()
                    ) {
                        if (ele.getDiscountId() == discountId) {
                            foundFlag = true;
                            System.out.print("Enter your choice: ");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                System.out.print("Enter new discount category: ");
                                discountCategory = sc.next();
                                ele.setDiscountCategory(discountCategory);
                                System.out.println("Discount category is updated successfully");
                            } else if (choice==2){
                                System.out.print("Enter new discount percentage: ");
                                discountPercentage = sc.nextInt();
                                ele.setDiscountPercentage(discountPercentage);
                                System.out.println("Discount percentage is updated successfully");
                            } else if (choice==3) {
                                System.out.print("Enter the discount code: ");
                                discountCode=sc.next();
                                ele.setDiscountCode(discountCode);
                                System.out.println("Discount code set successfully");
                            }
                            else {
                                System.out.println("Wrong choice!!");
                            }
                            break;
                        }
                    }
                    if (foundFlag == false) {
                        System.out.println("Wrong discount id !!");
                    }
                    break;
                case 3:

                    System.out.println("Remove discount");
                    System.out.print("Enter the discountId: ");
                    discountId = sc.nextInt();
                    foundFlag = sd1.removeDiscountListElement(discountId);
                    if (foundFlag == true) {
                        System.out.println("Discount removed successfully");
                    } else {
                        System.out.println("Wrong discount id!!");
                    }
                    break;

                case 4:
                    System.out.println("Exit");
                    flag=false;
                    break;

            }
        }
    }
    public void setSpecialDeals(){
        System.out.print("Enter number of tickets: ");
        int t1=sc.nextInt();
        System.out.print("Enter discount percentage: ");
        int dp1=sc.nextInt();
        sd1.setSpecialDeal(t1,dp1);

    }
    public void viewVisitorStats(Functionalities func){

//        Visitor Statistics:
//        - Total Visitors: 1200
//                - Total Revenue: $15,000
//                - Most Popular Attraction: Jungle Safari
        List<Visitor> visitorList=func.visitorsList();
        List<Integer> amountDepositedList=func.totalRevenue();
        System.out.println("Visitor Statistics:");
        System.out.println("Total Visitors: "+visitorList.size());
        int sum=0;
        for (Integer i:amountDepositedList
             ) {sum+=i;

        }
        List<Integer> popularAttracList=new ArrayList<>();
        System.out.println("Total Revenue: $"+sum);
        for (Attraction ele:attractionsList
             ) {
            popularAttracList.add(ele.countVisit);
        }
        int index=0;
        int max=popularAttracList.get(0);
        for(int i=1;i<popularAttracList.size();i=i-1){
            if (max<popularAttracList.get(i)){
                max=popularAttracList.get(i);
                index=i;
            }

        }
        System.out.println("Most Popular Attraction: "+attractionName(index));

    }
    public void viewFeedback(Functionalities func){
            List<String> feedbackList =func.viewFeedbackList();
        System.out.println("Here are feedbacks provided by Visitors-->");
        for (String ele:feedbackList
             ) {
            System.out.println(ele);
        }
    }
    public boolean exit(){
        System.out.println("-----------------Admin logged out------------------");
        return false;
    }
    public int  viewAttractions(){
        int count=0;
        for (Attraction ele : attractionsList
        ) {
            System.out.println(ele.attractionId + ". " + ele.attractionName);
            count+=1;
        }
        return count;
    }
    public int tickets(int attractionId){
        int ticketPrice=0;
        for (Attraction ele:attractionsList
             ) {
            System.out.println(ele.attractionId+". "+ele.attractionName+"(₹"+ele.price+")");
        }

        for (Attraction ele:attractionsList
        ) {
            if (ele.attractionId==attractionId){
                ticketPrice= ele.price;

                System.out.print("Ticket for "+ele.attractionName+" purchased successfully.");
            }
        }
        return ticketPrice;
    }
    public void viewDiscount(){

        for (SpecialDeals ele: sd1.viewDiscountList()
             ) {
            System.out.println("Id: "+ele.getDiscountId()+"; Category: "+ele.getDiscountCategory()+"; DiscountPercentage: "+ele.getDiscountPercentage()+"; DiscountCode: "+ele.getDiscountCode());

        }
    }
    public String attractionName(int attractionId){
        String attrname="";
        for (Attraction ele:attractionsList
             ) {if (ele.attractionId==attractionId){
                 attrname= ele.attractionName;
                 break;
            }
        }
        return attrname;
    }
    public void popularAttraction(String attractionName){
        for (Attraction ele:attractionsList
             ) {
            if(Objects.equals(ele.attractionName, attractionName)){
                ele.countVisit+=1;
            }
        }
    }
    public List<SpecialDeals.Specialdealset> getDealsList(){
        return sd1.getSpecialdealsetList();
    }

}