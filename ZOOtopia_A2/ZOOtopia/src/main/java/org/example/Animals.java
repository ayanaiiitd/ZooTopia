package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Animals {
    private List<Animals> animalList;
    private String animalName;
    private String animalType;
    private String animalNoise;
    private String animalDescription;
    public Animals(String AnimalName,String animalType,String animalNoise,String animalDescription) {
        this.animalName = AnimalName;
        this.animalType=animalType;
        this.animalNoise=animalNoise;
        this.animalDescription=animalDescription;
        animalList = new ArrayList<>();

    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setAnimalNoise(String animalNoise) {
        this.animalNoise = animalNoise;
    }

    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalNoise() {
        return animalNoise;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    Scanner sc= new Scanner(System.in);
    boolean flag=true;



    //        Manage Animals:
//    Mammals m1=new Mammals("","");
    public void viewAnimals(){
        for (Animals ele:animalList
             ) {
            System.out.println(ele.getAnimalName()+" Descripiton : "+ele.getAnimalDescription());
        }
    }
    public void zooAnimals(String animalName,String animalType,String animalNoise,String animalDescription){
        Animals a1=new Animals(animalName, animalType,animalNoise,animalDescription);
        animalList.add(a1);
    }
    public boolean addAnimals(String animalName,String animalType,String animalNoise,String animalDescription){


            if (Objects.equals(animalType, "Mammal")) {
                Animals a1 = new Animals(animalName, animalType,animalNoise,animalDescription);
                animalList.add(a1);
                System.out.println("Animal added successfully");
                return true;
            } else if (Objects.equals(animalType, "Reptile")) {
                Animals a1 = new Animals(animalName, animalType,animalNoise,animalDescription);
                animalList.add(a1);
                System.out.println("Animal added successfully");
                return true;
            } else if (Objects.equals(animalType, "Amphibian")) {
                Animals a1 = new Animals(animalName, animalType,animalNoise,animalDescription);
                animalList.add(a1);
                System.out.println("Animal added successfully");
                return true;

            } else {
                System.out.println("Wrong animal type!!");
                return false;
            }
        }

    public boolean updateAnimalDetails(){
        boolean foundFlag=true;
        flag=true;
//        sc.nextLine();
        System.out.print("Enter animal previous name : ");
        String name=sc.nextLine();
        System.out.println("1.change animal name\n"+
                "2.change animal type\n"+
                "3.change animal noise\n"+
                "4.change animal description");
        System.out.println("Enter your choice : ");
        int choice =sc.nextInt();
        for (Animals ele:animalList
             ) {
            if (Objects.equals(ele.animalName, name)){
                foundFlag=true;
                if (choice ==1){
                    sc.nextLine();
                    System.out.print("Enter new name of the animal : ");
                    String newName=sc.nextLine();
                    ele.setAnimalName(newName);
                    System.out.println("Animal name updated");

                } else if (choice ==2) {
                    System.out.print("Enter new type of the animal : ");
                    String newType=sc.next();
                    ele.setAnimalType(newType);
                    System.out.println("Animal type updated");

                } else if (choice==3) {
                    System.out.print("Enter new noise : ");
                    String newNoise=sc.next();
                    ele.setAnimalNoise(newNoise);
                    System.out.println("Animal noise updated successfully");

                } else if (choice==4) {
                    sc.nextLine();
                    System.out.print("Enter new description : ");
                    String newDescription=sc.nextLine();
                    ele.setAnimalDescription(newDescription);
                    System.out.println("Animal description updated");

                }
                else {
                    System.out.println("Invalid choice !!");
                    flag=false;

                }
                break;
            }
            else{
                foundFlag=false;
            }
        }
        if (foundFlag==false){
            System.out.println("No animal in the zoo with name : "+name);
            sc.nextLine();
            flag=false;

        }
        return flag;

    }
    public boolean removeAnimal(String animalName){
        boolean foundFlag=false;
        int lengthList=animalList.size();
        int countMammals=0;
        int countReptiles=0;
        int countAmphibians=0;
        for (Animals ele:animalList
             ) {if (Objects.equals(ele.getAnimalName(), "Mammal")){
                 countMammals+=1;
        } else if (Objects.equals(ele.getAnimalName(), "Reptile")) {
            countReptiles+=1;
        }
        else {
            countAmphibians+=1;
        }

        }
        if(lengthList>6 && countMammals>2 && countReptiles>2 && countAmphibians>2) {

            for (Animals ele : animalList
            ) {
                if (Objects.equals(animalName, ele.getAnimalName())) {
                    foundFlag = true;
                    animalList.remove(ele);
                    break;

                }
            }
        }
        else{
            System.out.println("Cannot remove animal!!");
            foundFlag=true;
        }
        return foundFlag;
    }
   public List<Animals> animalList(){
        return animalList;
   }
}