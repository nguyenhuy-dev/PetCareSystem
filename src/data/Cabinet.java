/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.*;
import ui.Menu;
import util.MyToys;

/**
 *
 * @author NGUYEN HUY
 */
public class Cabinet {
    private ArrayList<Pet> petList = new ArrayList();
    private LinkedHashSet<String> checkIt = new LinkedHashSet();
    
    public void addNewDog() {
        String id, name;
        int yob;
        double weight;    
        while (true) {  // nhập id, ko cho trùng      
            id = MyToys.getId("Input dog ID(DXXXXX): ", "The format of ID is DXXXXX (X stands for a digit)", "^D\\d{5}$");
            if (checkIt.add(id)) 
                break;
        }
        name = MyToys.getName("Input dog name: ", "The dog name is required!");
        yob = MyToys.getAnInteger("Input dog yob (2000..2024): ", "Yob is from 2000..2024!", 2000, 2024);
        weight = MyToys.getADouble("Input dog weight (0.1->99.0): ", "Weight is from 0.1 to 99.0!", 0.1, 99.0);
        petList.add(new Dog(id, name, yob, weight));
        System.out.println("A dog profile is added successfully");
    }
    
    public void addNewCat() {
        String id, name;
        int yob;
        double weight;
        while (true) {            
            id = MyToys.getId("Input cat ID(CXXXXX): ", "The format of ID is CXXXXX (X stands for a digit)", "^C\\d{5}$");
            if (checkIt.add(id)) 
                break;
        }
        name = MyToys.getName("Input cat name: ", "The cat name is required!");
        yob = MyToys.getAnInteger("Input cat yob (2000..2024): ", "Yob is from 2000..2024!", 2000, 2024);
        weight = MyToys.getADouble("Input cat weight (0.1->99.0): ", "Weight is from 0.1 to 99.0!", 0.1, 99.0);
        petList.add(new Cat(id, name, yob, weight));
        System.out.println("A cat profile is added successfully");
    }
    
    public void searchPetByID() {
        String id = MyToys.getId("Input pet ID: ", "Pet ID is required!", "^[C|D]\\d{5}$");
        Pet x = checkIt(id);
        if (x == null) 
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the pet that you want to search");
            x.showProfile();
        }
    }
    
    public void updatePetByID() {
        Menu subMenu = new Menu("Updating Options");
        subMenu.addNewOption("1. Updating name");
        subMenu.addNewOption("2. Updating yob");
        subMenu.addNewOption("3. Updating weight");
        subMenu.addNewOption("4. Quit");
        String id = MyToys.getId("Input pet ID: ", "Pet ID is required!", "^(C|D)\\d{5}$");
        Pet x = checkIt(id);
        if (x == null) 
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the pet that you want to update");
            x.showProfile();
            subMenu.printMenu();
            int choice = subMenu.getChoice();
            switch (choice) {
                case 1:
                    x.setName(MyToys.getName("Input pet name: ", "The pet name is required!"));
                    break;
                case 2:
                    x.setYob(MyToys.getAnInteger("Input pet yob (2000..2024): ", "Yob is required ", 2000, 2024));
                    break;
                case 3:
                    x.setWeight(MyToys.getADouble("Input pet weight (0.1->99.0): ", "Weight is required", 0.1, 99.0));
                    break;
                case 4:
                    System.out.println("The pet info is updated unsuccessfully!");
                    return;
            }
            System.out.println("The pet profile after updating");
            x.showProfile();
            System.out.println("The pet info is updated successfully!");
        }
    }   
    
    public void removePetByID() {
        String id = MyToys.getId("Input pet ID: ", "Pet ID is required!", "^(C|D)\\d{5}$");
        Pet x = checkIt(id);
        if (x == null) 
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the pet that you want to remove");  // In ra thông tin pet bị removed
            x.showProfile();
            String choice = MyToys.getString("Are you sure? (Yes/No): ", "You are required to input your choice (Yes/No)");
            switch (choice.toLowerCase()) {
                case "yes":
                    petList.remove(x);
                    System.out.println("The selected pet is removed successfully!");
                    break;
                case "no":
                    System.out.println("The selected pet is removed unsuccessfully!");
                    break;
            }
        }
    }
    
    public void printPetListAscendingByID() {
        if (petList.isEmpty()) {
            System.out.println("The cage is empty. Nothing to print!");
            return;
        }
        System.out.println("Here is the pet list");
        String header = String.format("|%-6s|%-15s|%4s|%4s|%4s|", "ID", "NAME", "YOB", "WGHT", "SPD");
        System.out.println(header);
        Collections.sort(petList);
        for (Pet x : petList) 
            x.showProfile();
    }
    
    public void printPetListAscendingByName() {
        if (petList.isEmpty()) {
            System.out.println("The cage is empty. Nothing to print!");
            return;
        }
        Comparator<Pet> nameBalance = new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        Collections.sort(petList, nameBalance);
        System.out.println("Here is the pet list");
        String header = String.format("|%-6s|%-15s|%4s|%4s|%4s|", "ID", "NAME", "YOB", "WGHT", "SPD");
        System.out.println(header);
        for (Pet x : petList) 
            x.showProfile();
    }
    
    public Pet checkIt(String id) {
        if (petList.isEmpty()) 
            return null;
        for (int i = 0; i < petList.size(); i++) 
            if (petList.get(i).getId().equalsIgnoreCase(id)) 
                return petList.get(i);
        return null;
    }
    
}
