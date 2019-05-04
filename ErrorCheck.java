/********************************************************************
//  ErrorCheck.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 7, 2018
//
//  This class is purely for error checking and input
//  testing for our game.
//  
//  Modifications since Phase II: Moved 2 methods to their own class as they
//                                were not associated with error checking.
//                                
//********************************************************************/

package Rastellini2;


public abstract class ErrorCheck {
    
    // CHECK THE LENGTH OF THE USER'S NAME. Max of 25 characters.
    public static boolean inputCheck(String userData){
        boolean test = (userData.length() > 25 || userData.length() <= 0);
    return test;
    }
    
    
    // Check if our input is empty
    public static boolean boolCheck(String data){
        
        boolean temp = false;
        if (data.length() <=0){
            temp = true;
            return temp;
        }
    return temp;
    }
    
    // Show positive only if our user chose an allowed class key.
    public static boolean classCheck(String playerClass){
        // Change the user's input to uppercase to make decisions a bit easier.
            playerClass = playerClass.toUpperCase();
            // Grab the first character in the player's string.
            char classInput = playerClass.charAt(0);
            //Check if player pick a value class or to quit.
            boolean playerClassCheck = (playerClass.charAt(0) != 'K' && playerClass.charAt(0) != 'W' && playerClass.charAt(0) != 'Q' && playerClass.charAt(0) != 'D' && playerClass.charAt(0) != 'A' && playerClass.charAt(0) != 'F');
        return playerClassCheck;
    }
    
    // Check if the key entered by our user matches a hotkey ability.
    public static boolean hotkeyCheck(String input, Player player){
            
            // Change the user's input to uppercase to make decisions a bit easier.
            input = input.toUpperCase();
            
            //Check if player picked a valid hotkey.
            boolean playerClassCheck = (input.charAt(0) != player.getHotkey(0) && input.charAt(0) != player.getHotkey(1) && input.charAt(0) != player.getHotkey(2) && input.charAt(0) != player.getHotkey(3) && input.charAt(0) != player.getHotkey(4) && input.charAt(0) != player.getHotkey(5));
        return playerClassCheck;
    }
    
    // Input for choosing 1 or 2 player.
    public static boolean numberOfPlayers(String dataEntered){
         
        char dataGiven = dataEntered.charAt(0);
        boolean digiCheck = false;
        
        // If the character is not a number than we dont want it.
        if (!Character.isDigit(dataGiven)){
            digiCheck = true;
            return digiCheck;
        // If the user's input was not a 1 or 2 than we dont want it.
        }else if(dataGiven != '1' && dataGiven != '2'){
            digiCheck = true;
            return digiCheck;
        }
    return digiCheck;   
    }
}
