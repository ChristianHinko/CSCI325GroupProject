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
        System.out.println("'n' - Convert degrees to radians");
        System.out.println("'d' - Convert radians to degrees");
        System.out.println("'r' - Calculate a trigonometric ratio of a right triangle");
        System.out.println("'l' - Solve triangle using two angles and one side length");
        System.out.println("'g' - Solve triangle using three side lengths");
        System.out.println("'a' - Calculate the area of a triangle");
        System.out.println("'h' - Help");
    }

    @Override
    public void HandleUserMenu(Scanner scanner, char userSelection) 
    {
        
    }
    
}
