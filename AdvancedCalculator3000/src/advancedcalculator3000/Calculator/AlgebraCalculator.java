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
        if ((x1 % 1) != 0 || (x2 % 1) != 0) // if x1 or x2 have decimals or not         TODO: actually some are ok to have decimals sometimes figure this out
        {
            // This is its most simplified form
            return quadratic;
        }
        
        
        
        // These are what we are trying to calculate. To return them as: GCD(coeffOne*x + constOne)(coeffTwo*x + constTwo)
        int GCD = 0;
        int coeffOne = 0;
        int constOne = 0;
        int coeffTwo = 0;
        int constTwo = 0;
        
        
        // Find the GCD of all coefficients
        GCD = GreatestCommonDivisor(Math.abs(aCoefficient), GreatestCommonDivisor(Math.abs(bCoefficient), Math.abs(cCoefficient)));
        
        // Get the most factored forms of our coefficients
        int factoredA = aCoefficient;
        int factoredB = bCoefficient;
        int factoredC = cCoefficient;
        
        // Reduce our coefficients by their factor if we can
        if (GCD != 0)
        {
            factoredA /= GCD;
            factoredB /= GCD;
            factoredC /= GCD;
        }
        
        // Find the correct values for our constants (we want constOne and constTwo to multiply to A*C but add to B).
        // We are about to brute force this using a while-loop and check every possible product of the 2 until both of them add to B.
        {
            // We want (constOne * constTwo) to equal this
            int desiredProduct = factoredA * factoredC;
            
            // Loop until constTwo and constOne not only multiply to our desired product, but add to the factored form of B
            int currentSum = 0;
            while (currentSum != factoredB)
            {
                // Increment constTwo in attempt to find a value that works
                ++constTwo;
                
                // Make constOne times constTwo become our desired result
                constOne = desiredProduct / constTwo;
                
                // If constOne is a whole number (if it evenly divided into our desiredProduct)
                // then this constant might work! Get the sum of the two so we can check if they
                // will add to factoredB
                if ((constOne % 1) == 0)
                {
                    currentSum = constOne + constTwo;
                }
            }
        }
        
        // Calculate our first factor
        {
            coeffOne = factoredA;
            int divisorOne = GreatestCommonDivisor(Math.abs(constOne), Math.abs(coeffOne)); 
            
            constOne /= divisorOne;
            coeffOne /= divisorOne;
        }
        
        // Calculate our second factor
        {
            coeffTwo = factoredA;
            int divisorTwo = GreatestCommonDivisor(Math.abs(constTwo), Math.abs(coeffTwo));
            
            constTwo /= divisorTwo;
            coeffTwo /= divisorTwo;
        }
        
        
        // Build our factors:
        
        
        
        // Build factor one (coeffOne + constOne)
        String factorOne = "(";
        if (coeffOne != 1)
        {
            factorOne += coeffOne;
        }
        factorOne += "x ";
        if (constOne >= 0)
        {
            factorOne += "+ ";
        }
        else
        {
            factorOne += "- ";
        }
        factorOne += Math.abs(constOne) + ")";
        
        // Build factor two (coeffTwo + constTwo)
        String factorTwo = "(";
        if (coeffTwo != 1)
        {
            factorTwo += coeffTwo;
        }
        factorTwo += "x ";
        if (constTwo >= 0)
        {
            factorTwo += "+ ";
        }
        else
        {
            factorTwo += "- ";
        }
        factorTwo += Math.abs(constTwo) + ")";
        
        
        // Put our greatest common devisor in front of everything
        if (GCD != 1)
        {
            retVal += "" + GCD;
        }
        retVal += factorOne;
        retVal += factorTwo;
        
        
        // Return our factored expression
        return retVal;
    }
    
    public static int GreatestCommonDivisor(int numA, int numB)
    {
        if (numB == 0)
        {
            return numA;
        }
        
        return GreatestCommonDivisor(numB, (numA % numB));
    }
    
    /**
     * Follows the format: "ax^2 + bx + c".
     * Examples of viable formats:
     *  - "x^2 + x + 1"
     *  - "1x^2 + 1x + 1"
     *  - "2x^2 + 4x + 2"
     *  - "x^2 + 2x + 1"
     *  - "x^2+x+1"
     *  - "-x^2 - x - 1"
     * Examples of formats that won't work:
     *  - "x + x^2 + 1"         // terms are not in order from highest degree to lowest
     * 
     * 
     * // TODO: how would these work?:
     *  - "0x^2 + 0x + 0"
     *  - "0x^2 + 1x + 1"
     *  - "x^2 + 0x + 1"
     */
    public void SetQuadratic(String newQuadratic)
    {
        quadratic = newQuadratic;
        UpdateCoefficients();
        CleanUpQuadratic();
        QuadraticFormula();
    }
    public String GetQuadratic() { return quadratic; }
    
    /**
     * Rebuilds the quadratic string into the most minimal, user-friendly form.
     */
    public void CleanUpQuadratic()
    {
        quadratic = "";
        
        // BUILD ax^2
        if (aCoefficient < 0)
        {
            quadratic += "-";
        }
        if (Math.abs(aCoefficient) != 1)
        {
            quadratic += Math.abs(aCoefficient);
        }
        quadratic += "x^2 ";
        // END ax^2
        
        // BUILD bx
        if (bCoefficient >= 0)
        {
            quadratic += "+ ";
        }
        else
        {
            quadratic += "- ";
        }
        if (Math.abs(bCoefficient) != 1)
        {
            quadratic += Math.abs(bCoefficient);
        }
        quadratic += "x ";
        // END bx
        
        // BUILD c
        if (cCoefficient >= 0)
        {
            quadratic += "+ ";
        }
        else
        {
            quadratic += "- ";
        }
        quadratic += Math.abs(cCoefficient);
        // END c
    }
    
    
    public void PrintX()
    {
        System.out.print("x = " + (int)x1);
        if (x1 != x2)
        {
            System.out.print(", or x = " + (int)x2);
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
        int cCoeff = 0;
        
        // Find coeffs
        {
            int itteration = 0; // to keep track of which itteration we are on
            
            // For each x in the quadratic (plus the hanging coeficient C), find its coefficient
            for (int xIndex = quadratic.indexOf('x'); xIndex < quadratic.length() && itteration <= 2; xIndex = quadratic.indexOf('x', xIndex + 1))
            {
                if (xIndex == -1) // this mean that we are the C coefficient
                {
                    // Treat this as the others by setting xIndex to the index after the coefficient
                    xIndex = quadratic.length();
                }

                int currentCoefficient = 1;
                if (itteration >= 2)
                {
                    currentCoefficient = 0;
                }

                // Build coefficient
                {
                    String coeStr = "";

                    for (int i = xIndex - 1; i >= 0; --i)
                    {
                        if (Character.isDigit(quadratic.charAt(i)))
                        {
                            coeStr = quadratic.charAt(i) + coeStr;
                        }
                        else
                        {
                            if (quadratic.charAt(i) == ' ')
                            {
                                continue;
                            }
                            
                            if (quadratic.charAt(i) == '-')
                            {
                                coeStr = "-" + coeStr;
                            }
                            break;
                        }
                    }

                    if (coeStr.length() > 0)
                    {
                        currentCoefficient = Integer.parseInt(coeStr);
                    }
                }

                switch (itteration)
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

                ++itteration;
            }
        }
        
        aCoefficient = aCoeff;
        bCoefficient = bCoeff;
        cCoefficient = cCoeff;
    }
}
