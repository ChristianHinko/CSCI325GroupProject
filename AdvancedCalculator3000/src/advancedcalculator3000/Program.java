/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000;


import java.util.Scanner;
import advancedcalculator3000.Calculator.AlgebraCalculator;



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
        // TODO: code application logic here
        
        
        
        
        
        
        
        
        
        
        // TESTING:
        Scanner scanner = new Scanner(System.in);
        
        AlgebraCalculator algebraCalc = new AlgebraCalculator();
        
//        algebraCalc.InitialUserMenu(scanner);
//        while (true)
//        {
//            algebraCalc.HandleUserMenu(scanner);
//        }
        
        //algebraCalc.SetQuadratic("4x^2 + 14x - 8");
        algebraCalc.SetQuadratic("x^2 + x + 1");
        //algebraCalc.PrintCoefficients();
        
        algebraCalc.PrintXVals();
        
        String factored = algebraCalc.FactorQuadratic();
        System.out.println(factored);
        algebraCalc.GraphQuadratic();
    }
}
