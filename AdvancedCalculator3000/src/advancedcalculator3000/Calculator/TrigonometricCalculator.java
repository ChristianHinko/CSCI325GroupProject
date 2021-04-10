/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;

import static java.lang.Math.abs;
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
    private double sideOne;
    private double angleOne;
    private double sideTwo;
    private double angleTwo;
    private double sideThree;
    
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
        System.out.println("'a' - Calculate the area of a triangle");
        System.out.println("'l' - Solve a triangle using two angles and one side length");
        System.out.println("'g' - Solve a triangle using three side lengths");
        System.out.println("'h' - Help");
    }

    @Override
    public void HandleUserMenu(Scanner scanner, char userSelection) 
    {
        switch (userSelection)
        {
            case 's':
                System.out.println("Enter an angle(deg) to find its sine value:");
                userAngle = scanner.nextDouble();
                System.out.println("");
                FindSine(userAngle, scanner);
                break;
            case 'c':
                System.out.println("Enter an angle(deg) to find its cosine value:");
                userAngle = scanner.nextDouble();
                System.out.println("");
                FindCosine(userAngle, scanner);
                break;
            case 't':
                System.out.println("Enter an angle(deg) to find its tangent value:");
                userAngle = scanner.nextDouble();
                System.out.println("");
                FindTangent(userAngle, scanner);
                break;
            case 'd':
                System.out.println("Enter a degree to convert to radians:");
                degree = scanner.nextDouble();
                System.out.printf(degree + " degrees is equal to " + "%.2f", ConvertDegree(degree) + " radians");
                System.out.println("");
                break;
            case 'n':
                System.out.println("Enter a radian to convert to degrees:");
                radian = scanner.nextDouble();
                System.out.printf(radian + " radians is equal to " + "%.2f", ConvertRadian(radian) + " degrees");
                System.out.println("");
                break;
            case 'a':
                System.out.println("Enter the angle(deg) for your triangle:");
                angleOne = scanner.nextDouble();
                System.out.println("Now enter a side length:");
                sideOne = scanner.nextDouble();
                System.out.println("Now enter the final side length:");
                sideTwo = scanner.nextDouble();
                System.out.println("");
                FindAreaOfTriangle(angleOne, sideOne, sideTwo, scanner);
                break;
            case 'l':
                System.out.println("Enter the angle that corresponds to an opposite side:");
                angleOne = scanner.nextDouble();
                System.out.println("Enter the side length opposite of your first angle:");
                sideOne = scanner.nextDouble();
                System.out.println("Enter your second angle:");
                angleTwo = scanner.nextDouble();
                System.out.println("");
                LawOfSine(angleOne, sideOne, angleTwo, scanner);
                break;
            case 'g':
                System.out.println("Enter your first side length:");
                sideOne = scanner.nextDouble();
                System.out.println("Enter your second side length:");
                sideTwo = scanner.nextDouble();
                System.out.println("Enter your third side length:");
                sideThree = scanner.nextDouble();
                System.out.println("");
                LawOfCosine(sideOne, sideTwo, sideThree, scanner);
                break;
            case 'h':
                PrintHelpMenu();
                break;
        }
    }
    
    public void FindSine(double userAngle, Scanner scanner) 
    {
        toRadians = ConvertDegree(userAngle);
        
        if (userAngle <= 0)
        {
            System.out.println("Re-enter an angle that is not negative:");
            userAngle = scanner.nextDouble();
            FindSine(userAngle, scanner);
        }
        else
            System.out.printf("Sin(" + userAngle + ") is equal to " + "%.2f", Math.sin(toRadians));
            System.out.println("");
    }
    public void FindCosine(double userAngle, Scanner scanner) 
    {
        toRadians = ConvertDegree(userAngle);// userAngle * Math.PI/180;
        
        if (userAngle <= 0)
        {
            System.out.println("Re-enter an angle that is not negative:");
            userAngle = scanner.nextDouble();
            FindCosine(userAngle, scanner);
        }
        else
            System.out.printf("Cos(" + userAngle + ") is equal to " + "%.2f", Math.cos(toRadians));
            System.out.println("");
    }
    public void FindTangent(double userAngle, Scanner scanner) 
    {
        toRadians = ConvertDegree(userAngle);
        
        if (userAngle <= 0)
        {
            System.out.println("Re-enter an angle that is not negative:");
            userAngle = scanner.nextDouble();
            FindTangent(userAngle, scanner);
        }
        else
            System.out.printf("Tan(" + userAngle + ") is equal to " + "%.2f", Math.tan(toRadians));
            System.out.println("");
    }
    public double ConvertDegree(double degree)
    {
        return degree * Math.PI/180;
    }
    public double ConvertRadian(double radian)
    {
        return radian * 180/Math.PI;
    }
    public void FindAreaOfTriangle (double angleOne, double sideOne, double sideTwo, Scanner scanner)
    {
        double areaOfTriangle;
        
        areaOfTriangle =abs(((0.5) * (sideOne * sideTwo)) * (Math.sin(ConvertDegree(angleOne)))); 
        
        if(angleOne <= 0 || sideOne <= 0 || sideTwo <= 0)
        {
            System.out.println("Re-enter an angle that is not negative:");
            angleOne = scanner.nextDouble();
            System.out.println("Re-enter a side length that is not negative:");
            sideOne = scanner.nextDouble();
            System.out.println("Re-enter the final side length that is not negative:");
            sideTwo = scanner.nextDouble();
            
            FindAreaOfTriangle(angleOne, sideOne, sideTwo, scanner);
        }
        else
            System.out.printf("The area of the triangle is " + "%.2f", areaOfTriangle);
            System.out.println("");          
    }
    public void LawOfSine(double angleOne, double sideOne, double angleTwo, Scanner scanner)
    {
        
    }   
    public void LawOfCosine(double sideOne, double sideTwo, double sideThree, Scanner scanner)
    {
        
    }
    public void PrintHelpMenu()
    {
        System.out.println("HELP!");
    }
}
