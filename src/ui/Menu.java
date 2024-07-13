/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.*;
import util.MyToys;

/**
 *
 * @author NGUYEN HUY
 */
public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();
    private LinkedHashSet<String> checkIt = new LinkedHashSet();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String input) {
        if (checkIt.add(input)) 
            optionList.add(input);
    }
    
    public void printMenu() {
        if (optionList.isEmpty()) 
            System.out.println("There is no item in the menu");
        System.out.println("\nWelcome to " + menuTitle);
        for (String x : optionList) 
            System.out.println(x);
    }
    
    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption;
        return MyToys.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
    
}
