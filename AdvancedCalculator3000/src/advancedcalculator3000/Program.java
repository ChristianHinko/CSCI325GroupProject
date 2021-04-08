/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000;


import java.util.Scanner;
import advancedcalculator3000.Calculator.ICalculator;
import advancedcalculator3000.Calculator.AlgebraCalculator;
import advancedcalculator3000.Calculator.ArithmeticCalculator;
import advancedcalculator3000.Calculator.TrigonometricCalculator;



/**
 * 
 */
public class Program
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ICalculator calculator;
        
        // Calculator selection loop
        {
            char userChar = '\0';
            while (userChar != 'q')
            {
                PrintCalculatorsMenu();
                
                userChar = scanner.next().charAt(0);
                scanner.nextLine();
                userChar = Character.toLowerCase(userChar); // ensure lower case so that upper case inputs work as well
                
                switch(userChar)
                {
                    case 'a':
                        calculator = new ArithmeticCalculator();
                        break;
                    case 'x':
                        calculator = new AlgebraCalculator();
                        break;
                    case 't':
                        calculator = new TrigonometricCalculator();
                        break;
                        
                    default:
                        continue;
                }
                
                
                calculator.InitialUserMenu(scanner);
                
                // Calculator user menu loop
                {
                    char userSelection = '\0';
                    while (userSelection != 'q')
                    {
                        calculator.PrintUserMenu();
                        System.out.println("");
                        System.out.println("'q' - Quit");
                        
                        userSelection = scanner.next().charAt(0);
                        scanner.nextLine();
                        userSelection = Character.toLowerCase(userSelection); // ensure lower case so that upper case inputs work as well
                        
                        calculator.HandleUserMenu(scanner, userSelection);
                        System.out.println("");
                    }
                }
            }
        }
    }
    
    public static void PrintCalculatorsMenu()
    {
        System.out.println("'a' - " + ArithmeticCalculator.GetCalculatorName());
        System.out.println("'x' - " + AlgebraCalculator.GetCalculatorName());
        System.out.println("'t' - " + TrigonometricCalculator.GetCalculatorName());
        System.out.println("");
        System.out.println("'q' - Quit");
    }
}
