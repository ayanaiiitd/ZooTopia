package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Admin admin1=new Admin();
        Animals a1=new Animals("","","","");
        List<String> rawList;

        a1.zooAnimals("Monkey","Mammal","whoop","Monkeys are small or medium-sized primates that typically have long tails. There are more than 260 types of monkeys all over the globe, in different sizes, shapes and colours. These mammals are really intelligent and have opposable thumbs, which makes them similar to humans");
        a1.zooAnimals("Elephant","Mammal"," trumpet","Elephants - the largest land animals alive today - are the only remaining species of the family Elephantidae, which belongs to an ancient order of Proboscidea. Proboscideans were a diverse and widespread group of herbivores that first appeared in Africa about 60 million years ago");
        a1.zooAnimals("Snake","Reptile","hiss","Snakes are thought to have evolved from terrestrial lizards as early as the Middle Jurassic Epoch (174.1 million to 163.5 million years ago). The oldest known fossil snake, Eophis underwoodi, was a small snake that lived in southern England about 167 million years ago");
        a1.zooAnimals("Crocodile","Reptile","grunt","The earliest ancestors of the crocodiles evolved around 200 million years ago during the Late Triassic and Early Jurassic. These ancestors were smaller than most living crocodilians, with a shorter snout");
        a1.zooAnimals("Frog","Amphibian","croak","There is evidence that frogs have roamed the Earth for more than 200 million years, at least as long as the dinosaurs. The world's largest frog is the goliath frog of West Africa—it can grow to 15 inches and weigh up to 7 pounds. A goliath frog skeleton is featured in Frogs: A Chorus of Colors");
        a1.zooAnimals("Slam-mender","Amphibian","silent","The earliest known salamander fossils have been found in geological deposits in China and Kazakhstan, dated to the middle Jurassic period around 164 million years ago");

        Functionalities func=new Functionalities(a1,admin1);
        System.out.println("--------------------------Welcome to ZOOtopia!!------------------------");
        boolean outerFlag=true;
        while(outerFlag){
            System.out.println("=============================================");
            System.out.println("1. Enter as Admin\n" +
                    "2. Enter as a Visitor\n" +
                    "3. View Special Deals\n"+
                    "4.Exit");
            System.out.println("=============================================");
            System.out.print("Enter your choice : ");
            int choice1=sc.nextInt();
            switch (choice1) {
                case 1:
                    boolean flag = true;
                    System.out.println("admin enter");
                    System.out.print("Enter your username : ");
                    String username = sc.next();
                    System.out.print("Enter your password : ");
                    String password = sc.next();
                    flag = admin1.login(username, password);
                    if (flag == true) {
                        while (flag) {
                            System.out.println("Admin Menu:");
                            System.out.println("1. Manage Attractions\n" +
                                    "2. Manage Animals\n" +
                                    "3. Schedule Events\n" +
                                    "4. Set Discounts\n" +
                                    "5. Set Special Deal\n" +
                                    "6. View Visitor Stats\n" +
                                    "7. View Feedback\n" +
                                    "8. Exit\n");
                            System.out.println("=============================================");
                            System.out.print("Enter your choice : ");
                            int choice2 = sc.nextInt();
                            switch (choice2) {
                                case 1:
                                    System.out.println("manage attractions");
                                    admin1.manageAttractions();
                                    System.out.println("=============================================");
                                    break;
                                case 2:
                                    System.out.println("Manage Animals");
                                    admin1.manageAnimals();
                                    System.out.println("=============================================");
                                    break;
                                case 3:
                                    System.out.println("Schedule Events");
                                    admin1.scheduleEvents(func);
                                    System.out.println("=============================================");
                                    break;
                                case 4:
                                    System.out.println("Set Discounts");
                                    admin1.setDiscounts();
                                    System.out.println("=============================================");
                                    break;
                                case 5:
                                    System.out.println("Set Special Deal");
                                    admin1.setSpecialDeals();
                                    System.out.println("=============================================");
                                    break;
                                case 6:
                                    System.out.println("View Visitor Stats");
                                    admin1.viewVisitorStats(func);
                                    System.out.println("=============================================");
                                    break;
                                case 7:
                                    System.out.println("View Feedback");

                                    admin1.viewFeedback(func);
                                    System.out.println("=============================================");
                                    break;

                                case 8:
                                    System.out.println("exit");
                                    flag = admin1.exit();
                                    System.out.println("=============================================");
                                    break;
                            }

                        }
                    } else {
                        break;
                    }
                    break;
                case 2:
                    boolean loginFlag = true;
                    while (true) {
//                        System.out.println("enter as visitor");
                        System.out.println("\n" +
                                "1. Register\n" +
                                "2. Login\n" +
                                "\n");
                        System.out.println("=============================================");
                        System.out.print("Enter your choice : ");
                        int regOrLogin = sc.nextInt();
                        if (regOrLogin == 1) {
                            System.out.println("Registering a new visitor!!");
                            System.out.print("Enter visitor name : ");
                            String visitorName = sc.next();
                            System.out.print("Enter visitor age : ");
                            int visitorAge = sc.nextInt();
                            System.out.print("Enter visitor phone number : ");
                            String visitorPhoneNumber = sc.next();
                            System.out.print("Enter visitor balance : ");
                            int visitorBalance = sc.nextInt();
                            System.out.print("Enter visitor email : ");
                            String visitorEmail = sc.next();
                            System.out.print("Enter visitor password : ");
                            String visitorPassword = sc.next();
                            Visitor visitor1 = new Visitor(visitorName, visitorAge, visitorPhoneNumber, visitorBalance, visitorEmail, visitorPassword);

                            func.registerVisitor(visitor1);
                        } else {
                            System.out.println("Log in as Visitor");
                            System.out.print("Enter email : ");
                            String email = sc.next();
                            System.out.print("Enter password : ");
                            password = sc.next();
                            loginFlag = func.login(email, password);


                            if (loginFlag) {
                                System.out.println("Visitor logged in successfully");
                                boolean visitorflag = true;
                                while (visitorflag) {
                                    System.out.println("Visitor Menu:\n" +
                                            "1. Explore the Zoo\n" +
                                            "2. Buy Membership\n" +
                                            "3. Buy Tickets\n" +
                                            "4. View Discounts\n" +
                                            "5. View Special Deals\n" +
                                            "6. Visit Animals\n" +
                                            "7. Visit Attractions\n" +
                                            "8. Leave Feedback\n" +
                                            "9. Log Out\n");
                                    System.out.println("=============================================");
                                    int choice2 = sc.nextInt();
                                    switch (choice2) {
                                        case 1:
                                            System.out.println("Explore the Zoo");
                                            func.exploreTheZoo();
                                            System.out.println("=============================================");
                                            break;
                                        case 2:
                                            System.out.println("Buy Membership");
                                            func.buyMembership(email);
                                            System.out.println("=============================================");
                                            break;
                                        case 3:
                                            System.out.println("Buy Tickets");
                                            func.buyTickets(email);
                                            System.out.println("=============================================");
                                            break;
                                        case 4:
                                            System.out.println("View Discounts");
                                            func.viewDiscounts();
                                            System.out.println("=============================================");
                                            break;
                                        case 5:
                                            System.out.println("View Special Deals");
                                            func.viewSpecialDeals();
                                            System.out.println("=============================================");
                                            break;
                                        case 6:
                                            System.out.println("Visit Animals");
                                            func.visitAnimals(email);
                                            System.out.println("=============================================");
                                            break;
                                        case 7:
                                            System.out.println("Visit Attractions");
                                            func.visitAttractions(email);
                                            System.out.println("=============================================");
                                            break;
                                        case 8:
                                            System.out.println("leave feedback");
                                            func.leaveFeedback(email);
                                            System.out.println("=============================================");
                                            break;
                                        case 9:
                                            System.out.println("----------------Visitor logged out---------------");
                                            visitorflag = false;
                                            break;
                                    }
                                }
                                break;


                            } else {
                                System.out.println("Login unsuccessful!!");

                            }
                        }
                    }
                break;

                case 3:
                    System.out.println("special deals");
                    func.viewSpecialDeals();
                    break;
                default:
                    outerFlag=false;
                    break;
            }

        }
    }
}