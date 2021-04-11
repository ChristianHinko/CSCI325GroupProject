/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000;


import java.util.Scanner;
import advancedcalculator3000.Calculator.ICalculator;
import advancedcalculator3000.Calculator.Calculators.AlgebraCalculator;
import advancedcalculator3000.Calculator.Calculators.ArithmeticCalculator;
import advancedcalculator3000.Calculator.Calculators.GeometryCalculator;
import advancedcalculator3000.Calculator.Calculators.TrigonometricCalculator;



/**
 * This holds information about our program and contains the entry point of
 * the application
 */
public class Program
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Our scanner for taking in user input
        Scanner scanner = new Scanner(System.in);
        
        
        // Display our welcome screen
        System.out.println("************************************************************************************************************************");
        System.out.println("    _       _                               _    ____      _            _       _               _____  ___   ___   ___  ");
        System.out.println("   / \\   __| |_   ____ _ _ __   ___ ___  __| |  / ___|__ _| | ___ _   _| | __ _| |_ ___  _ __  |___ / / _ \\ / _ \\ / _ \\ ");
        System.out.println("  / _ \\ / _` \\ \\ / / _` | '_ \\ / __/ _ \\/ _` | | |   / _` | |/ __| | | | |/ _` | __/ _ \\| '__|   |_ \\| | | | | | | | | |");
        System.out.println(" / ___ \\ (_| |\\ V / (_| | | | | (_|  __/ (_| | | |__| (_| | | (__| |_| | | (_| | || (_) | |     ___) | |_| | |_| | |_| |");
        System.out.println("/_/   \\_\\__,_| \\_/ \\__,_|_| |_|\\___\\___|\\__,_|  \\____\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_|    |____/ \\___/ \\___/ \\___/ ");
        System.out.println("************************************************************************************************************************");
        System.out.println("");
        
        
        // A reference to our current calculator that the user is using
        ICalculator calculator;
        
        // Calculator selection loop
        {
            char userChar = '\0';
            while (userChar != 'q')
            {
                System.out.println("Choose a calculator based on what kind of math you want to do: ");
                PrintCalculatorsMenu();
                
                System.out.println("");
                System.out.print("Choose a calculator: ");
                userChar = scanner.next().charAt(0);
                scanner.nextLine();
                userChar = Character.toLowerCase(userChar); // ensure lower case so that upper case inputs work as well
                
                // Set our calculator to the one chosen by the user
                switch(userChar)
                {
                    case 'a':
                        calculator = new ArithmeticCalculator();
                        break;
                    case 'x':
                        calculator = new AlgebraCalculator();
                        break;
                    case 'g':
                        calculator = new GeometryCalculator();
                        break;
                    case 't':
                        calculator = new TrigonometricCalculator();
                        break;
                        
                    default:
                        continue;
                }
                
                
                // Broadcast our initialization event before we begin the calculator loop
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
            
            // Print our farewell message
            System.out.println("Thank you for using " + GetProgramName() + " !!!");
            System.out.println("Come back again later!");
            
        }
    }
    
    /** The name of this program */
    public static String GetProgramName()
    {
        return "Advanced Calculator 3000";
    }
    
    /** Lists the different calculators in a menu with options to choose from */
    public static void PrintCalculatorsMenu()
    {
        System.out.println("'a' - " + ArithmeticCalculator.GetCalculatorName());
        System.out.println("'x' - " + AlgebraCalculator.GetCalculatorName());
        System.out.println("'g' - " + GeometryCalculator.GetCalculatorName());
        System.out.println("'t' - " + TrigonometricCalculator.GetCalculatorName());
        System.out.println("");
        System.out.println("'q' - Quit application");
    }
}
