/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;



/**
 * Shape enum with helper methods that associate the shape names
 * with a character.
 * 
 * @author Christian Hinkle
 */
public enum EShape
{
    SHAPE_None,
    SHAPE_Box
    {
        @Override
        public String toString()
        {
            return "Box";
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
    SHAPE_Cone
    {
        @Override
        public String toString()
        {
            return "Cone";
        }
    };
    
    public static char GetShapeCharacter(EShape shape)
    {
        String shapeName = shape.toString();
        if (shapeName.isEmpty())
        {
            return '\0';
        }
        
        return Character.toLowerCase(shapeName.charAt(0));
    }
    public static EShape GetShapeByCharacter(char shapeChar)
    {
        for (EShape shape : EShape.values())
        {
            if (shape == SHAPE_None)
            {
                continue;
            }
            
            if (GetShapeCharacter(shape) == shapeChar)
            {
                return shape;
            }
        }
        
        return SHAPE_None;
    }
}
