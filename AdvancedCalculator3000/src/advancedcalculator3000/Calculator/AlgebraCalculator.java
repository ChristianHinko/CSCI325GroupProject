/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;

/**
 * Performs algebra-based math calculations
 * 
 * @author Christian Hinkle
 */
public class AlgebraCalculator implements ICalculator
{
    /**
     * A quadratic expression in string form.
     * The purpose of this is for easy end user interaction with this calculator and
     * really just exists to get the values of the coefficients a, b, and c from the user.
     * 
     * AVOID DIRECTLY SETTING!! (Use the setter instead so that our coefficients get updated)
     * 
     * Follows the format: "ax^2 + bx + c".
     * Examples of viable formats:
     *  - "x^2 + x + 1"
     *  - "1x^2 + 1x + 1"
     *  - "2x^2 + 4x + 2"
     *  - "x^2 + 2x + 1"
     */
    private String quadratic;
    
    // A, B, and C coefficients of our quadratic (what really drives the calculations):
    private int aCoefficient;
    private int bCoefficient;
    private int cCoefficient;
    
    /** Value of x of the quadratic to fulfill the quadratic formula. */
    private double x1;
    /** Secondary value of x of the quadratic to fulfill quadratic formula (not always necessary because it's sometimes the same as x1). */
    private double x2;
    
    
    public AlgebraCalculator()
    {
        SetQuadratic("x^2 + x + 1");
    }
    
    @Override
    public void PrintCalculationsMenu()
    {
        System.out.println("'d' - Quadratic formula");
        System.out.println("'f' - Factor a quadratic");
        //System.out.println("'r' - Square root");
    }
    
    /**
     * Finds the value of x and stores it into x1 and x2.
     */
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
            // TODO: complex solution (how should we handle this? add booleans for x1 and x2 about whether they are imaginary or not?)
        }
    }
    
    /**
     * Returns a string of the quadratic in its factored form.
     * If unable to factor any further, returns the quadratic itself.
     */
    public String FactorQuadratic()
    {
        String retVal = "";
        
        if (x1 == x2)
        {
            // This is its most simplified form
            return quadratic;
        }
        if ((x1 % 1) != 0 || (x2 % 1) != 0) // if x1 or x2 have decimals or not
        {
            // This is its most simplified form
            return quadratic;
        }
        
        // Build (x - x1)
        int x1Whole = (int)x1;
        if (x1 > 0)
        {
            retVal += "(x - " + x1Whole + ")";
        }
        else
        {
            retVal += "(x + " + Math.abs(x1Whole) + ")";
        }
        
        // Build (x - x2)
        int x2Whole = (int)x2;
        if (x2 > 0)
        {
            retVal += "(x - " + x2Whole + ")";
        }
        else
        {
            retVal += "(x + " + Math.abs(x2Whole) + ")";
        }
        
        // Return result
        return retVal;
    }
    
    /**
     * Follows the format: "ax^2 + bx + c".
     * Examples of viable formats:
     *  - "x^2 + x + 1"
     *  - "1x^2 + 1x + 1"
     *  - "2x^2 + 4x + 2"
     *  - "x^2 + 2x + 1"
     */
    public void SetQuadratic(String newQuadratic)
    {
        quadratic = newQuadratic;
        UpdateCoefficients();
        QuadraticFormula();
    }
    public String GetQuadratic() { return quadratic; }
    
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
    
    /**
     * Updates A, B, and C coefficients to match those of our quadratic.
     */
    private void UpdateCoefficients()
    {
        int aCoeff = 1;
        int bCoeff = 1;
        int cCoeff = 1;
        
        {
            int itterations = 0; // to keep track of which itteration we are on
            
            // For each x in the quadratic (plus the hanging coeficient C), find its coefficient
            for (int xIndex = quadratic.indexOf('x'); xIndex < quadratic.length() && itterations <= 2; xIndex = quadratic.indexOf('x', xIndex + 1))
            {
                if (xIndex == -1) // this mean that we are the C coefficient
                {
                    // Treat this as the others by setting xIndex to the index after the coefficient
                    xIndex = quadratic.length();
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
