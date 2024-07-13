/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.*;

/**
 *
 * @author NGUYEN HUY
 */
public class MyToys {
    private static Scanner sc = new Scanner(System.in);
    
    public static String getId(String inputMsg, String errorMsg, String format) {
        while (true) {          
            System.out.print(inputMsg);
            String input = sc.nextLine().toUpperCase().trim();
            if (input.matches(format)) 
                return input;
            System.out.println(errorMsg);
        }
    }
    
    public static String getName(String inputMsg, String errorMsg) {  // loại bỏ khoảng trắng ko cần thiết, in hoa chữ cái đầu
        String input = getString(inputMsg, errorMsg);
        String[] arr = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String x : arr) 
            if (!x.isEmpty()) {
                String firstWord = x.substring(0, 1).toUpperCase();
                String lastWord = firstWord + x.substring(1).toLowerCase();
                sb.append(lastWord).append(" ");
            }
        return sb.toString().trim();
    }
    
    public static String getString(String inputMsg, String errorMsg) {
        while (true) {            
            System.out.print(inputMsg);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) 
                return input;
            System.out.println(errorMsg);
        } 
    }
    
    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {  //lấy số double trong khoảng
        while (true) {            
            try {
                System.out.print(inputMsg);
                double input = Double.parseDouble(sc.nextLine());
                if (input < lowerBound || input > upperBound) 
                    throw new Exception();
                return input;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {  // lấy số int trong khoảng
        while (true) {            
            try {
                System.out.print(inputMsg);
                int input = Integer.parseInt(sc.nextLine());
                if (input < lowerBound || input > upperBound) 
                    throw new Exception();
                return input;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double getADouble(String inputMsg, String errorMsg) {
        while (true) {            
            try {
                System.out.print(inputMsg);
                double input = Double.parseDouble(sc.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int getAnInteger(String inputMsg, String errorMsg) {
        while (true) {            
            try {
                System.out.print(inputMsg);
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
}
