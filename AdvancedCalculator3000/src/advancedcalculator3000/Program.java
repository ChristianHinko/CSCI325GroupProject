/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000;


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
        AlgebraCalculator algebraCalc = new AlgebraCalculator();
        algebraCalc.SetQuadratic("x^2 + 6x + 5"); // TODO: we don't support negative coefficients yet
        
        algebraCalc.PrintCoefficients();
        
        algebraCalc.PrintX();
        
        String factored = algebraCalc.FactorQuadratic();
        System.out.println(factored);
    }
}
