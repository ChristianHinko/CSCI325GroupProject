/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;

/**
 * 
 * @author Christian Hinkle
 */
public class AlgebraCalculator implements ICalculator
{
    private String quadratic;
    
    @Override
    public void PrintCalculationsMenu()
    {
        System.out.println("'d' - Quadratic formula");
        System.out.println("'f' - Factor a quadratic");
        //System.out.println("'r' - Square root");
    }
    
    public String FactorQuadratic()
    {
        int a = 0;
        int b = 0;
        int c = 0;
        
        // ex: "2x^2 + x + 1"
        // ex: " x^2 + x + 1"
        // ex: "1x^2 + x + 1"
        for (int i = 0; i < quadratic.length(); ++i)
        {
            char currentChar = quadratic.charAt(i);
            
            if (Character.isDigit(currentChar))
            {
                int coefficient = Integer.parseInt("" + currentChar);
                
                
            }
        }
        
        return "";
    }
}
