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
    private double angleOne;
    private double angleTwo;
    private double angleThree;
    private double sideOne;
    private double sideTwo;
    private double sideThree;
    
    public TrigonometricCalculator()
    {
        userAngle = 0.0;
        degree = 0.0;
        radian = 0.0;
        toRadians = 0.0;
        angleOne = 0.0;
        angleTwo = 0.0;
        angleThree = 0.0;
        sideOne = 0.0;
        sideTwo = 0.0;
        sideThree = 0.0;        
    }
    
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
        System.out.println("'h' - Help");
        System.out.println("");
        System.out.println("Choose an option:");
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
                System.out.printf(degree + " degrees is equal to %.2f radians", ConvertDegree(degree));
                System.out.println("");
                break;
            case 'n':
                System.out.println("Enter a radian to convert to degrees:");
                radian = scanner.nextDouble();
                System.out.printf(radian + " radians is equal to %.2f degrees", ConvertRadian(radian));
                
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
                System.out.println("Enter the first angle:");
                angleOne = scanner.nextDouble();
                System.out.println("Enter your second angle:");
                angleTwo = scanner.nextDouble();
                System.out.println("Enter the side length:");
                sideOne = scanner.nextDouble();
                System.out.println("");
                LawOfSine(angleOne, sideOne, angleTwo, scanner);
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
        return degree * Math.PI/180.0;
    }
    
    public double ConvertRadian(double radian)
    {
        return radian / (Math.PI / 180.0);
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
        angleThree = 180 - (angleOne + angleTwo);
        
        sideTwo = (sideOne * (Math.sin(ConvertDegree(angleTwo)))) / Math.sin(ConvertDegree(angleOne));
        
        sideThree = (sideOne * (Math.sin(ConvertDegree(angleThree)))) / Math.sin(ConvertDegree(angleOne));
        
        if (angleOne <= 0 || angleTwo <= 0 || sideOne <= 0)
        {
            System.out.println("Re-enter your first angle but without a negative:");
            angleOne = scanner.nextDouble();
            System.out.println("Re-enter your second angle but without a negative:");
            angleTwo = scanner.nextDouble();
            System.out.println("Re-enter your side length but without a negative");
            sideOne = scanner.nextDouble();
            
            LawOfSine(angleOne, sideOne, angleTwo, scanner);
        }
        else
            System.out.printf("Angle 1: " + angleOne + "       Side 1: " + "%.2f", sideOne);
            System.out.println("");
            System.out.printf("Angle 2: " + angleTwo + "       Side 2: " + "%.2f", sideTwo);
            System.out.println("");
            System.out.printf("Angle 3: " + angleThree + "       Side 3: " + "%.2f", sideThree);
            System.out.println("");
    }   
    public void PrintHelpMenu()
    {
        System.out.println("'s' - Only enter in an angle that is positive.");
        System.out.println("'c' - Only enter in an angle that is positive.");
        System.out.println("'t' - Only enter in an angle that is positive.");
        System.out.println("'d' - Only enter a value that is a degree.");
        System.out.println("'n' - Only enter a value that is a radian");
        System.out.println("'a' - Calculate the area of a triangle");
        System.out.println("'l' - Make sure all of your entries are positive because a triangle cannot have negative angles or sides.");
    }
}
