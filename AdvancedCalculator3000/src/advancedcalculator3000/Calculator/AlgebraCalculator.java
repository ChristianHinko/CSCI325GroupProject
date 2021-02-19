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
    // ex: "2x^2 + x + 1"
    // ex: " x^2 + x + 1"
    // ex: "1x^2 + x + 1"
    private String quadratic;
    private int aCoefficient;
    private int bCoefficient;
    private int cCoefficient;
    
    private double x1;
    private double x2;
    
    public AlgebraCalculator()
    {
        quadratic = "x^2 + x + 1";
        UpdateCoefficients();
    }
    
    @Override
    public void PrintCalculationsMenu()
    {
        System.out.println("'d' - Quadratic formula");
        System.out.println("'f' - Factor a quadratic");
        //System.out.println("'r' - Square root");
    }
    
    public void QuadraticFormula()
    {
        double discriminant = Math.pow(bCoefficient, 2) - (4 * (aCoefficient * cCoefficient));
        
        if (discriminant > 0)
        {
            x1 = (-bCoefficient + Math.sqrt(discriminant)) / (2 * aCoefficient);
            x2 = (-bCoefficient - Math.sqrt(discriminant)) / (2 * aCoefficient);
        }
        else if (discriminant == 0)
        {
            x1 = (-bCoefficient) / (2 * aCoefficient);
            x2 = (-bCoefficient) / (2 * aCoefficient);
        }
        else
        {
            
        }
    }
    
    public String FactorQuadratic()
    {
        
        
        return "";
    }
    
    public String GetQuadratic() { return quadratic; }
    public void SetQuadratic(String newQuadratic)
    {
        quadratic = newQuadratic;
        UpdateCoefficients();
    }
    
    public void PrintX()
    {
        System.out.print("x = " + x1);
        if (x1 != x2)
        {
            System.out.print(", or x = " + x2);
        }
        
        System.out.println("");
    }
    
    public void PrintCoefficients()
    {
        System.out.println("a: " + aCoefficient + ", b: " + bCoefficient + ", c: " + cCoefficient);
    }
    private void UpdateCoefficients()
    {
        int aCoeff = 1;
        int bCoeff = 1;
        int cCoeff = 1;
        
        {
            int itterations = 0;
            for (int xIndex = quadratic.indexOf('x'); xIndex < quadratic.length(); xIndex = quadratic.indexOf('x', xIndex + 1))
            {
                if (xIndex == -1)
                {
                    break;
                }

                int currentCoefficient = 1;

                // Build coefficient
                {
                    String coeStr = "";

                    for (int i = xIndex - 1; i >= 0; --i)
                    {
                        if (Character.isDigit(quadratic.charAt(i)))
                        {
                            coeStr += quadratic.charAt(i);
                        }
                        else
                        {
                            break;
                        }
                    }

                    if (coeStr.length() > 0)
                    {
                        currentCoefficient = Integer.parseInt(coeStr);
                    }
                }

                switch (itterations)
                {
                    case 0:
                        aCoeff = currentCoefficient;
                        break;
                    case 1:
                        bCoeff = currentCoefficient;
                        break;
                    case 2:
                        cCoeff = currentCoefficient;
                        break;
                }

                ++itterations;
            }
        }
        
        aCoefficient = aCoeff;
        bCoefficient = bCoeff;
        cCoefficient = cCoeff;
    }
}
