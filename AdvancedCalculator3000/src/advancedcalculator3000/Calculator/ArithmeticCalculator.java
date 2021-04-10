/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;


import java.util.Scanner;



/**
 * 
 * @author Kennedy Burks
 */
public class ArithmeticCalculator implements ICalculator
{
    /*
        This Arithemetic Calculator will perform a plethora of expressions using:
            -Addition, following the format of:
            x + y = z
            -Subtraction, following the format of:
            x - y = z
            -Multiplication, following the format of:
            x * y = z
            -Division, following the format of:
            x / y = z
            -Powers, following the format of:
            x ^ y = z
            -Square Roots, following the format of:
            √x = y
        defined by the user input. The user will be given a menu to select which 
        expression will be performed.
    */
    
    //Values 
    private double xVal1;
    private double xVal2;
    
    public static String GetCalculatorName()
    {
        return "Arithmetic Calculator";
    }
    
    @Override
    public void InitialUserMenu(Scanner scanner)
    {
        System.out.println("You have chosen to perform Arithemetic expressions.");
        System.out.println("Enter two numbers to perform calculations with.");
        System.out.println("Then select the method of operation.");
        //System.out.println("If the desired calculation is to perform the square root of a number, only input one number.");
        System.out.println();
        System.out.println("Enter the first number: ");
        xVal1 = scanner.nextDouble();
        System.out.println("Enter the second number: ");
        xVal2 = scanner.nextDouble();   
    }
    
    @Override
    public void PrintUserMenu() 
    {
        System.out.println();
        System.out.println("Choose your method of operation: ");
        System.out.println();
        System.out.println("'a' - Addition");
        System.out.println("'s' - Subtraction");
        System.out.println("'m' - Multiplication");
        System.out.println("'d' - Division");
        System.out.println("'p' - Powers");
        //System.out.println("'r' - Square Root");
        System.out.println("'n' - New Arithmetic Expression");
    }
    
    @Override
    public void HandleUserMenu(Scanner scanner, char userSelection)
    {
        
        switch (userSelection)
        {
            case 'a':
                // Addition
                //x + y = z
                System.out.println();
                System.out.println(xVal1 + " + " + xVal2 + " = " + (xVal1 + xVal2));
                break;
            case 's':
                // Subtraction
                //x - y = z
                System.out.println();
                System.out.println(xVal1 + " - " + xVal2 + " = " + (xVal1 - xVal2));
                break;
            case 'm':
                // Multiplication
                //x * y = z
                System.out.println();
                System.out.println(xVal1 + " * " + xVal2 + " = " + (xVal1 * xVal2));
                break;
            case 'd':
                // Division
                //x - y = z
                System.out.println();
                System.out.println(xVal1 + " / " + xVal2 + " = " + (xVal1 / xVal2));
                break;
            case 'p':
                // Powers
                //x ^ y = z
                System.out.println();
                System.out.println(xVal1 + " ^ " + xVal2 + " = " + (Math.pow(xVal1, xVal2)));
                break;
            /*case 'r':
                // Square Roots
                //√x = y
                System.out.println("√" + xVal1 + " = " + Math.sqrt(xVal1));
                break;*/
            
            case 'n':
                //Reset Menu
                InitialUserMenu(scanner);
                break;
            case 'q':
                //Quit Arithmetic Calculator 
                System.out.println();
                break;
                
            default:
                System.out.println("You have entered an invalid method of operation.");
            
        }
    }
}
