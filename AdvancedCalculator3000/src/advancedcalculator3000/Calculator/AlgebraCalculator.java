/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;


import java.util.Scanner;



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
    private double x1Val;
    /** Secondary value of x of the quadratic to fulfill quadratic formula (not always necessary because it's sometimes the same as x1). */
    private double x2Val;
    
    
    
    public AlgebraCalculator()
    {
        SetQuadratic("x^2 + x + 1");
    }
    public AlgebraCalculator(int a, int b, int c)
    {
        SetQuadratic("" + a + "x^2 + " + b + "x + " + c);
    }
    
    //@Override
    public static String GetCalculatorName()
    {
        return "Algebra Calculator";
    }
    
    @Override
    public void InitialUserMenu(Scanner scanner)
    {
        EnterQuadraticMenu(scanner);
    }
    
    @Override
    public void PrintUserMenu()
    {
        System.out.println("'y' - Evaluate Y at a given value of X");
        System.out.println("'x' - Quadratic formula");
        System.out.println("'f' - Factor quadratic");
        System.out.println("'g' - Graph quadratic");
        System.out.println("'n' - New quadratic");
        System.out.println("'h' - Help");
    }
    @Override
    public void HandleUserMenu(Scanner scanner, char userSelection)
    {
        switch (userSelection)
        {
            case 'y':
                System.out.println("Enter an X value to plug in to your quadratic: ");
                final int userX = scanner.nextInt();
                System.out.println("f(" + userX + ") = " + AdvancedCalculatorGlobals.DoubleToString(PlugInX(userX)));
                break;
            case 'x':
                // Quad form
                System.out.println("The values of X where y = 0:");
                PrintXVals();
                break;
            case 'f':
                // Factor
                String factoredQuadratic = FactorQuadratic();
                if (factoredQuadratic.equals(quadratic))
                {
                    System.out.println("Your quadratic cannot be factored: " + "\"" + factoredQuadratic + "\"");
                    break;
                }
                
                System.out.println("The factored form of your quadratic is: " + "\"" + factoredQuadratic + "\"");
                break;
                
            case 'g':
                // Graph
                GraphQuadratic();
                break;
            
            case 'n':
                InitialUserMenu(scanner); // this is temporary
                break;
            
            case 'h':
                PrintHelpMenu();
                break;
        }
    }
    
    public void EnterQuadraticMenu(Scanner scanner)
    {
        System.out.println("Enter a quadratic to perform algebra on:");
        System.out.print("f(x) = ");
        final String userQuadratic = scanner.nextLine();
        SetQuadratic(userQuadratic);
    }
    
    public void PrintHelpMenu()
    {
        System.out.println("Examples of viable formats for quadratics:");
        System.out.println("f(x) = x^2 + x + 1");
        System.out.println("f(x) = 1x^2 + 1x + 1");
        System.out.println("f(x) = -2x^2 + 4x + 2");
        System.out.println("f(x) = x^2+x+1");
        System.out.println("f(x) = -x^2 - x - 1");
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
     * Finds the value of x and stores it into x1 and x2.
     */
    public void QuadraticFormula()
    {
        double discriminant = Math.pow(bCoefficient, 2) - (4 * (aCoefficient * cCoefficient));
        
        if (discriminant > 0)
        {
            x1Val = (-bCoefficient + Math.sqrt(discriminant)) / (2 * aCoefficient);
            x2Val = (-bCoefficient - Math.sqrt(discriminant)) / (2 * aCoefficient);
        }
        else if (discriminant == 0)
        {
            x1Val = (-bCoefficient) / (2 * aCoefficient);
            x2Val = (-bCoefficient) / (2 * aCoefficient);
        }
        else
        {
            // TODO: complex solution (how should we handle this? add imaginary components for x1 and x2?)
            
            x1Val = -Double.MAX_VALUE;
            x1Val = -Double.MAX_VALUE;
        }
    }
    
    /**
     * Returns a string of the quadratic in its factored form.
     * If unable to factor any further, returns the quadratic itself.
     */
    public String FactorQuadratic()
    {
        String retVal = "";
        
        
        // These are what we are trying to calculate. To return them as: GCD(coeffOne*x + constOne)(coeffTwo*x + constTwo)
        int GCD = 0;
        int coeffOne = 0;
        int constOne = 0;
        int coeffTwo = 0;
        int constTwo = 0;
        
        
        // Find the GCD of all coefficients
        GCD = AdvancedCalculatorGlobals.GreatestCommonDivisor(Math.abs(aCoefficient), AdvancedCalculatorGlobals.GreatestCommonDivisor(Math.abs(bCoefficient), Math.abs(cCoefficient)));
        
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
                
                // If there are not more attempts that have a possiblity to work. We have exhausted all retries. 
                if (constTwo > Math.abs(desiredProduct))
                {
                    if (GCD != 1)
                    {
                        // At least return a GCD factored quadratic
                        AlgebraCalculator factoredByGcdOnly = new AlgebraCalculator(factoredA, factoredB, factoredC);
                        return "" + GCD + "(" + factoredByGcdOnly.GetQuadratic() + ")";
                    }
                    
                    // We don't have anything useful to factor, just return the quadratic
                    return quadratic;
                }
            }
        }
        
        // Calculate our first factor
        {
            coeffOne = factoredA;
            int divisorOne = AdvancedCalculatorGlobals.GreatestCommonDivisor(Math.abs(constOne), Math.abs(coeffOne)); 
            
            constOne /= divisorOne;
            coeffOne /= divisorOne;
        }
        
        // Calculate our second factor
        {
            coeffTwo = factoredA;
            int divisorTwo = AdvancedCalculatorGlobals.GreatestCommonDivisor(Math.abs(constTwo), Math.abs(coeffTwo));
            
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
    
    
    public void GraphQuadratic()
    {
        final int xMin = -10;
        final int xMax = 10;
        final int yMin = -10;
        final int yMax = 10;
        
        double resX = 1;
        resX /= 2;
        double resY = 1;
        
        final int xMinNumDigs = AdvancedCalculatorGlobals.NumDigits(xMin, true);
        final int xMaxNumDigs = AdvancedCalculatorGlobals.NumDigits(xMax, true);
        final int yMinNumDigs = AdvancedCalculatorGlobals.NumDigits(yMin, true);
        final int yMaxNumDigs = AdvancedCalculatorGlobals.NumDigits(yMax, true);
        
        for (double y = yMax; y >= yMin; y -= resY)
        {
            for (double x = xMin; x <= xMax; x += resX)
            {
                if (y == 0)
                {
                    if (x == (xMax - xMaxNumDigs))
                    {
                        System.out.print("|");
                        continue;
                    }
                    if (x == (xMin + xMinNumDigs))
                    {
                        System.out.print("|");
                        continue;
                    }
                }
                if (y == -resY)
                {
                    if (x == (xMax - xMaxNumDigs))
                    {
                        System.out.print("" + xMax);
                        for (int i = 0; i < xMaxNumDigs - 1; ++i)
                        {
                            x += resX;
                        }
                        continue;
                    }
                    if (x == (xMin + xMinNumDigs))
                    {
                        System.out.print("" + xMin);
                        for (int i = 0; i < xMinNumDigs - 1; ++i)
                        {
                            x += resX;
                        }
                        continue;
                    }
                }
                
                if (x == 0)
                {
                    if (y == (yMax - yMaxNumDigs))
                    {
                        System.out.print("-");
                        continue;
                    }
                    if (y == (yMin + yMinNumDigs))
                    {
                        System.out.print("-");
                        continue;
                    }
                }
                if (y == (yMax - yMaxNumDigs))
                {
                    if (x == -(resX + yMaxNumDigs - 1))
                    {
                        System.out.print("" + yMax);
                        for (int i = 0; i < yMaxNumDigs - 1; ++i)
                        {
                            x += resX;
                        }
                        continue;
                    }
                }
                if (y == (yMin + yMinNumDigs))
                {
                    if (x == -(resX + yMinNumDigs - 1))
                    {
                        System.out.print("" + yMin);
                        for (int i = 0; i < yMinNumDigs - 1; ++i)
                        {
                            x += resX;
                        }
                        continue;
                    }
                }
                
                
                
                
                
               
                double yVal = PlugInX(x);
                
                double slope = Math.abs((yVal - PlugInX(x - resX)) / resX);
                
                if (AdvancedCalculatorGlobals.IsNearlyEqual(y, yVal, slope / (4 / resY)))
                {
                    if (yVal >= PlugInX(x - resX)) // if we are increasing
                    {
                        System.out.print("/");
                        continue;
                    }
                    
                    if (yVal < PlugInX(x - resX)) // if we are decreasing
                    {
                        System.out.print("\\");
                        continue;
                    }
                    
                    System.out.print("-");
                    continue;
                }
                
                if (AdvancedCalculatorGlobals.IsNearlyEqual(y, 0, resY / 2))
                {
                    if (AdvancedCalculatorGlobals.IsNearlyEqual(x, 0, resX / 2))
                    {
                        System.out.print("+");
                        continue;
                    }
                    
                    if (AdvancedCalculatorGlobals.IsNearlyEqual(x, xMax))
                    {
                        System.out.print(">");
                        continue;
                    }
                    if (AdvancedCalculatorGlobals.IsNearlyEqual(x, xMin))
                    {
                        System.out.print("<");
                        continue;
                    }
                    System.out.print("-");
                    continue;
                }
                if (AdvancedCalculatorGlobals.IsNearlyEqual(x, 0, resX / 2))
                {
                    if (AdvancedCalculatorGlobals.IsNearlyEqual(y, yMax))
                    {
                        System.out.print("^");
                        continue;
                    }
                    if (AdvancedCalculatorGlobals.IsNearlyEqual(y, yMin))
                    {
                        System.out.print("v");
                        continue;
                    }
                    
                    System.out.print("|");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    public double PlugInX(double x)
    {
        return (aCoefficient * Math.pow(x, 2)) + (bCoefficient * x) + cCoefficient;
    }
    
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
    
    
    public double GetX1Val() { return x1Val; }
    public double GetX2Val() { return x2Val; }
    
    public void PrintXVals()
    {
        if (x1Val == -Double.MAX_VALUE || x2Val == -Double.MAX_VALUE)
        {
            System.out.println("X has imaginary solutions");
            return;
        }
        
        System.out.print("X = " + AdvancedCalculatorGlobals.DoubleToString(x1Val));
        
        // If we have a second solution
        if (x1Val != x2Val)
        {
            System.out.print(", and X = " + AdvancedCalculatorGlobals.DoubleToString(x2Val));
        }
        
        System.out.println("");
    }
    
    public void PrintCoefficients() // helpful for debugging
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
                        if (coeStr.charAt(0) == '-' && Character.isDigit(coeStr.charAt(coeStr.length() - 1)) == false)
                        {
                            coeStr = coeStr + "1";
                        }
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
