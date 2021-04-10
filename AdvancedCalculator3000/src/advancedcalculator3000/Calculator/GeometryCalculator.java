/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;

import java.util.Scanner;



/**
 * 
 * @author Christian Hinkle
 */
public class GeometryCalculator implements ICalculator
{
    private EShape shape;
    
    private double shapeLength;
    private double shapeWidth;
    private double shapeHeight;
    
    private double shapeRadius;
    
    
    
    public GeometryCalculator()
    {
        shape = EShape.SHAPE_None;
    }
    
    
    //@Override
    public static String GetCalculatorName()
    {
        return "Geometry Calculator";
    }
    
    @Override
    public void InitialUserMenu(Scanner scanner)
    {
        System.out.println("Choose a shape to perform geometry on:");
        PrintShapesMenu();
        
        final char userShapeSelection = scanner.next().charAt(0);
        shape = EShape.GetShapeByCharacter(userShapeSelection);
        
        switch (shape)
        {
            case SHAPE_Box:
                System.out.print("Enter the length of your box: ");
                final double userLength = scanner.nextDouble();
                
                System.out.print("Enter the width of your box: ");
                final double userWidth = scanner.nextDouble();
                
                System.out.print("Enter the height of your box: ");
                final double userHeight = scanner.nextDouble();
                
                shapeLength = userLength;
                shapeWidth = userWidth;
                shapeHeight = userHeight;
                
                break;
                
            case SHAPE_Sphere:
                System.out.print("Enter the radius of your sphere: ");
                final double userRadius = scanner.nextDouble();
                
                shapeRadius = userRadius;
                
                break;
                
            case SHAPE_Cone:
                
                break;
                
                
            default:
                break;
        }
    }
    
    @Override
    public void PrintUserMenu()
    {
        switch (shape)
        {
            case SHAPE_Box:
                
                break;
            case SHAPE_Sphere:
                
                break;
            case SHAPE_Cone:
                
                break;
                
                
            default:
                break;
        }
    }
    @Override
    public void HandleUserMenu(Scanner scanner, char userSelection)
    {
        switch (shape)
        {
            case SHAPE_Box:
                
                break;
            case SHAPE_Sphere:
                
                break;
            case SHAPE_Cone:
                
                break;
                
                
            default:
                break;
        }
    }
    
    private void PrintShapesMenu()
    {
        for (EShape shape : EShape.values())
        {
            if (shape == EShape.SHAPE_None)
            {
                continue;
            }
            
            System.out.println("'" + EShape.GetShapeCharacter(shape) + "' - " + shape.toString());
        }
    }
    
    
    private double VolumeOfBox()
    {
        return (shapeLength * shapeWidth * shapeHeight);
    }
    private double SurfaceAreaOfBox()
    {
        final double areaLW = shapeLength * shapeWidth;
        final double areaWH = shapeWidth * shapeHeight;
        final double areaHL = shapeHeight * shapeLength;
        
        return 2 * (areaLW + areaWH + areaHL);
    }
    
    private double VolumeOfSphere()
    {
        return (4/3) * (Math.PI * Math.pow(shapeRadius, 3));
    }
    private double SurfaceAreaOfSphere()
    {
        return 4 * (Math.PI * Math.pow(shapeRadius, 2));
    }
}
