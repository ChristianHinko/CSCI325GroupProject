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
public enum EShape
{
    SHAPE_Square
    {
        @Override
        public String toString()
        {
            return "Square";
        }
    },
    SHAPE_Rectangle
    {
        @Override
        public String toString()
        {
            return "Rectangle";
        }
    },
    SHAPE_Sphere
    {
        @Override
        public String toString()
        {
            return "Sphere";
        }
    },
    SHAPE_Triangle
    {
        @Override
        public String toString()
        {
            return "Triangle";
        }
    }
}
