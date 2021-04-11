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
    
    private double boxLength;
    private double boxWidth;
    private double boxHeight;
    
    private double sphereRadius;
    
    private double coneAngle;
    private double coneRadius;
    private double coneHeight;
    private double coneSideLength;
    
    
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
                System.out.print("Enter the length of your " + shape.toString().toLowerCase() + ": ");
                final double userBoxLength = scanner.nextDouble();
                
                System.out.print("Enter the width of your " + shape.toString().toLowerCase() + ": ");
                final double userBoxWidth = scanner.nextDouble();
                
                System.out.print("Enter the height of your " + shape.toString().toLowerCase() + ": ");
                final double userBoxHeight = scanner.nextDouble();
                
                
                boxLength = userBoxLength;
                boxWidth = userBoxWidth;
                boxHeight = userBoxHeight;
                
                break;
                
            case SHAPE_Sphere:
                System.out.print("Enter the radius of your " + shape.toString().toLowerCase() + ": ");
                final double userSphereRadius = scanner.nextDouble();
                
                sphereRadius = userSphereRadius;
                
                break;
                
            case SHAPE_Cone:
                System.out.print("Enter the angle of your " + shape.toString().toLowerCase() + " (in degrees): ");
                final double userConeAngle = scanner.nextDouble();
                
                System.out.print("Enter the height of your " + shape.toString().toLowerCase() + ": ");
                final double userConeHeight = scanner.nextDouble();
                
                
                coneAngle = (Math.PI/180) * userConeAngle;
                coneHeight = userConeHeight;
                
                coneSideLength = 1.0 / (Math.cos(coneAngle) * coneHeight);
                coneRadius = coneSideLength * Math.sin(coneAngle);
                
                break;
                
                
            default:
                break;
        }
    }
    
    @Override
    public void PrintUserMenu()
    {
        System.out.println("'v' - Volume of " + shape.toString().toLowerCase());
        System.out.println("'s' - Surface area of " + shape.toString().toLowerCase());
        System.out.println("'n' - New shape");
        System.out.println("'h' - Help");
    }
    @Override
    public void HandleUserMenu(Scanner scanner, char userSelection)
    {
        switch (shape)
        {
            case SHAPE_Box:
                
                switch (userSelection)
                {
                    case 'v':
                        System.out.println("The volume of your " + shape.toString().toLowerCase() + " is: " + VolumeOfBox());
                        break;
                    case 's':
                        System.out.println("The surface area of your " + shape.toString().toLowerCase() + " is: " + SurfaceAreaOfBox());
                        break;
                        
                    default:
                        break;
                }
                
                break;
            case SHAPE_Sphere:
                
                switch (userSelection)
                {
                    case 'v':
                        System.out.println("The volume of your " + shape.toString().toLowerCase() + " is: " + VolumeOfSphere());
                        break;
                    case 's':
                        System.out.println("The surface area of your " + shape.toString().toLowerCase() + " is: " + SurfaceAreaOfSphere());
                        break;
                        
                    default:
                        break;
                }
                
                break;
            case SHAPE_Cone:
                
                switch (userSelection)
                {
                    case 'v':
                        System.out.println("The volume of your " + shape.toString().toLowerCase() + " is: " + VolumeOfCone());
                        break;
                    case 's':
                        System.out.println("The surface area of your " + shape.toString().toLowerCase() + " is: " + SurfaceAreaOfCone());
                        break;
                        
                    default:
                        break;
                }
                
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
        return (boxLength * boxWidth * boxHeight);
    }
    private double SurfaceAreaOfBox()
    {
        final double areaLW = boxLength * boxWidth;
        final double areaWH = boxWidth * boxHeight;
        final double areaHL = boxHeight * boxLength;
        
        return 2 * (areaLW + areaWH + areaHL);
    }
    
    private double VolumeOfSphere()
    {
        return (4.0/3.0) * (Math.PI * Math.pow(sphereRadius, 3));
    }
    private double SurfaceAreaOfSphere()
    {
        return 4 * AreaOfCircle(sphereRadius);
    }
    
    private double VolumeOfCone()
    {
        return AreaOfCircle(coneRadius) * (coneHeight / 3);
    }
    private double SurfaceAreaOfCone()
    {
        return (Math.PI * coneRadius) * (coneRadius + Math.sqrt(Math.pow(coneHeight, 2) + Math.pow(coneRadius, 2)));
    }
    
    
    private static double AreaOfCircle(double radius)
    {
        return (Math.PI * Math.pow(radius, 2));
    }
}
