/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petcaresystem;

import data.Cabinet;
import ui.Menu;

/**
 *
 * @author NGUYEN HUY
 */
public class PetCareSystem {
    public static void main(String[] args) {
        Menu menu = new Menu("Happiness Pet Care System");
        menu.addNewOption("1. Add a new dog profile");
        menu.addNewOption("2. Add a new cat profile");
        menu.addNewOption("3. Search a pet profile by ID");
        menu.addNewOption("4. Update a pet profile by ID");
        menu.addNewOption("5. Remove a pet profile by ID");
        menu.addNewOption("6. Print the pet list ascending by id");
        menu.addNewOption("7. Print the pet list ascending by name");
        menu.addNewOption("8. Quit");
        Cabinet cage = new Cabinet();
        int choice;
        do {            
            menu.printMenu();
            choice = menu.getChoice();
            System.out.println("--------------------------------------------");
            switch (choice) {
                case 1:
                    cage.addNewDog();
                    break;
                case 2:
                    cage.addNewCat();
                    break;
                case 3:
                    cage.searchPetByID();
                    break;
                case 4:
                    cage.updatePetByID();
                    break;
                case 5:
                    cage.removePetByID();
                    break;
                case 6:
                    cage.printPetListAscendingByID();
                    break;
                case 7:
                    cage.printPetListAscendingByName();
                    break;
                case 8:
                    System.out.println("Pye, see you next time!");
                    break;
            }
        } while (choice != 8);
    }
}
