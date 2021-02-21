/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedcalculator3000.Calculator;


import java.util.Scanner;



/**
 * Base calculator interface
 * 
 * @author Christian Hinkle
 */
public interface ICalculator
{
    /**
     * Used to get this calculator set up for the user (for constant user
     * configurations regardless of the user's selection)
     */
    public void InitialUserMenu(Scanner scanner);
    
    /** Print our calculator's options and run calculations for the user */
    public void HandleUserMenu(Scanner scanner);
}
