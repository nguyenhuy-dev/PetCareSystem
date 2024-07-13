/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.*;

/**
 *
 * @author NGUYEN HUY
 */
public class Cat extends Pet {
    private static final double MAX_SPEED = 30.0;

    public Cat(String id, String name, int yob, double weight) {
        super(id, name, yob, weight);
    }

    @Override
    public double run() {
        return new Random().nextDouble() * MAX_SPEED;
    }

    @Override
    public void showProfile() {
        System.out.printf("|%6s|%-15s|%4d|%4.1f|%4.1f|\n", id, name, yob, weight, run());
    }
    
}
