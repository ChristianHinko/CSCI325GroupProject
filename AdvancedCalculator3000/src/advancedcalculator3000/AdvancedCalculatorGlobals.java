/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000;



/**
 * A collection of some handy static functions related to math and numbers
 * 
 * @author Christian Hinkle
 */
public class AdvancedCalculatorGlobals
{
    // MAGIC NUMBERS
    static final double SMALL_NUMBER = 0.00000001;
    static final double KINDA_SMALL_NUMBER = 0.0001;
    
    
    /**
     * Returns true if 2 doubles are nearly equal (with a 0.0001 tolerance)
     */
    public static boolean IsNearlyEqual(double a, double b)
    {
        double tolerance = KINDA_SMALL_NUMBER;
        
        return IsNearlyEqual(a, b, tolerance);
    }
    /**
     * Returns true if 2 doubles are nearly equal with a specified tolerance
     */
    public static boolean IsNearlyEqual(double a, double b, double tolerance)
    {
        if (Math.abs(a - b) <= tolerance)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns the greatest common denominator between two integers
     */
    public static int GreatestCommonDivisor(int numA, int numB)
    {
        if (numB == 0)
        {
            return numA;
        }
        
        return GreatestCommonDivisor(numB, (numA % numB));
    }
    
    /**
     * Returns a double as a string with the ".0" decimal removed if necessary
     */
    public static String DoubleToString(double number)
    {
        String retVal = "" + number;
        if (number % 1 == 0)
        {
            retVal = "" + (int)number;
        }
        
        return retVal;
    }
    
    /**
     * Does not account for negative signs by default
     */
    public static int NumDigits(int number)
    {
        boolean includeNegativeSign = false;
        return NumDigits(number, includeNegativeSign);
    }
    /**
     * Returns the number of digits of a given integer
     */
    public static int NumDigits(int number, boolean includeNegativeSign)
    {
        int retVal = 0;
        
        if (number < 0)
        {
            if (includeNegativeSign)
            {
                ++retVal;
            }
            number *= -1;
        }
        
        int counter = number;
        while (counter > 0)
        {
            counter /= 10;
            ++retVal;
        }
        
        return retVal;
    }
}
