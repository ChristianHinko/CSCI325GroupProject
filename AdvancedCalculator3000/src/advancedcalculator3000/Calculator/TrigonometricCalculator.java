/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;

import java.util.Scanner;

/**
 *
 * @author natem
 */
public class TrigonometricCalculator implements ICalculator
{
    private double userAngle;
    private double degree;
    private double radian;
    private double toRadians;
    
    //@Override
    public static String GetCalculatorName()
    {
        return "Trigonometric Calculator";
    }

    @Override
    public void InitialUserMenu(Scanner scanner) 
    {
        
    }

    @Override
    public void PrintUserMenu() 
    {
        System.out.println("'s' - Calculate the the value of Sine");
        System.out.println("'c' - Calculate the the value of Cosine");
        System.out.println("'t' - Calculate the the value of Tangent");
        System.out.println("'d' - Convert degrees to radians");
        System.out.println("'n' - Convert radians to degrees");
        System.out.println("'r' - Calculate a trigonometric ratio of a right triangle");
        System.out.println("'l' - Solve triangle using two angles and one side length");
        System.out.println("'g' - Solve triangle using three side lengths");
        System.out.println("'a' - Calculate the area of a triangle");
        System.out.println("'h' - Help");
    }

    @Override
    public void HandleUserMenu(Scanner scanner, char userSelection) 
    {
        switch (userSelection)
        {
            case 's':
                System.out.println("Enter an angle to find its sine value:");
                userAngle = scanner.nextDouble();
                System.out.printf("The sine value of " + userAngle + " is equal to " + "%.2f", FindSine(userAngle));
                System.out.println("");
                break;
            case 'c':
                System.out.println("Enter an angle to find its cosine value:");
                userAngle = scanner.nextDouble();
                System.out.printf("The cosine value of " + userAngle + " is equal to " + "%.2f", FindCosine(userAngle));
                System.out.println("");
                break;
            case 't':
                System.out.println("Enter an angle to find its tangent value:");
                userAngle = scanner.nextDouble();
                System.out.printf("The tangent value of " + userAngle + " is equal to " + "%.2f", FindTangent(userAngle));
                System.out.println("");
                break;
            case 'd':
                System.out.println("Enter a degree to convert to radians:");
                degree = scanner.nextDouble();
                System.out.printf("The degree " + degree + " is equal to " + "%.2f", ConvertDegree(degree) + " radians");
                System.out.println("");
                break;
            case 'n':
                System.out.println("Enter a radian to convert to degrees:");
                radian = scanner.nextDouble();
                System.out.printf("The radian " + radian + " is equal to " + "%.2f", ConvertRadian(radian) + " degrees");
                System.out.println("");
                break;
            case 'a':
                System.out.println("Enter a  ");
            case 'h':
                PrintHelpMenu();
                break;
                
        }
    }
    
    public double FindSine(double userAngle) 
    {
        toRadians = userAngle * Math.PI/180;
        
        return Math.sin(toRadians);
    }
    public double FindCosine(double userAngle) 
    {
        toRadians = userAngle * Math.PI/180;
        
        return Math.cos(userAngle);
    }
    public double FindTangent(double userAngle) 
    {
        toRadians = userAngle * Math.PI/180;
        
        return Math.tan(userAngle);
    }
    public double ConvertDegree(double degree)
    {
        return degree * Math.PI/180;
    }
    public double ConvertRadian(double radian)
    {
        return radian * 180/Math.PI;
    }
    
    public void PrintHelpMenu()
    {
        System.out.println("HELP!");
    }
}
