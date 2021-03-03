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
                
                switch(userChar)
                {
                    case 'a':
                        calculator = new ArithmeticCalculator();
                        break;
                    case 'x':
                        calculator = new AlgebraCalculator();
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
                        System.out.println("'q' - Quit");
                        
                        userSelection = scanner.next().charAt(0);
                        scanner.nextLine();
                        
                        calculator.HandleUserMenu(scanner, userSelection);
                    }
                }
            }
        }
        
        
        
        
        // TESTING:
//        Scanner scanner = new Scanner(System.in);
//        
//        AlgebraCalculator algebraCalc = new AlgebraCalculator();
//        
////        algebraCalc.InitialUserMenu(scanner);
////        while (true)
////        {
////            algebraCalc.HandleUserMenu(scanner);
////        }
//        
//        algebraCalc.SetQuadratic("4x^2 + 14x - 8");
//        //algebraCalc.SetQuadratic("x^2 + x + 1");
//        //algebraCalc.PrintCoefficients();
//        
//        algebraCalc.PrintXVals();
//        
//        String factored = algebraCalc.FactorQuadratic();
//        System.out.println(factored);
//        algebraCalc.GraphQuadratic();
    }
    
    public static void PrintCalculatorsMenu()
    {
        System.out.println("'a' - " + ArithmeticCalculator.GetCalculatorName());
        System.out.println("'x' - " + AlgebraCalculator.GetCalculatorName());
        System.out.println("'q' - Quit");
    }
}
