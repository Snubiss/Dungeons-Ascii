/********************************************************************
//  Dialogue.java       Author: Snubiss
//
//  Date: December 7, 2018
//  Modified: December 7, 2018
//
//  Defines static methods for dialogue within our game.
//
//  Modifications since Phase II: File was created.
//                                Added level cap of 30 to the game.
//                                Added game complete screen to the game.
//                                
//********************************************************************/

package Rastellini2;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Schoolbox
 */
public class Dialogue {
    
    // This is the enter players screen. Attempt at more modulized code.....maybe too modulized.
    public static int enterPlayers(Graphics display){

        boolean playerInputCheck = true;
        Scanner in = new Scanner(System.in);
        String temp = "";
        int digiTemp = 0;
        char tempChar;
        
        display.clearCombat();
    do{
        
        display.setCombat("\n\n\n\n\n\n\n\n\n\n",0);
        // Setup our dialogue for our Main Screen
        display.setSysMessage("Welcome to Dungeons and Ascii. Please type in your name and choose a class to play.", 0);
        display.setSysMessage("Please enter the information needed below or input Q to (Q)uit", 1);
        display.setCombat("Please Enter the number of players. (1-2): ", 2);
        Greeting.randomGreeting(display);
        
        // Display Screen
        display.screen(1);
        // Request user name with a string format so it puts the cursor at the center of screen.
        System.out.print (String.format("%62s", ""));
        // Temporarily store the user's input.
        temp = in.nextLine();
        // Check if the user data matches user's hotkeys.
        playerInputCheck = ErrorCheck.numberOfPlayers(temp);

        if (playerInputCheck){
            // Display the invalid input error message and ask the user to enter a valid input.
            display.setCombat ("         Invalid input. Try again",1);
        }
    //If errors found than ask again.
    }while(playerInputCheck);
    
    tempChar = temp.charAt(0);
    digiTemp = Character.getNumericValue(tempChar);
    return digiTemp;
    }
    
    
    // End of the fight dialogue
    public static void endFight(Graphics display, Player player1, Player player2, int playerCount) throws FileNotFoundException, InterruptedException{
        
        if (player1.getHitPoints() <= 0){
                display.setDialogue(display, "Looks like " + player1.getName() + " is out of health!!!! " + player2.getName() + " is VICTORIUS!"); 
                display.setSysMessage("              Game Over",0);
        }
        else if (player2.getHitPoints() <= 0 && playerCount > 1){
            display.setDialogue(display, "Looks like " + player2.getName() + " is out of health!!!!"); 
            display.setCombat(player1.getName() + " is VICTORIUS!",1);
            display.setSysMessage("                 Game Over",0);
        }
        // Check if our enemy died so we can post a victory response
        else if(player2.getHitPoints() <= 0 && playerCount < 2){
            display.setDialogue(display, "Congratulations! You have slain " + player2.getName() + "!");
            display.setSysMessage("                Victory!!!",0);
            display.setSysMessage("             You Leveled Up!!",1);
            player1.levelUp();
            if (player1.getLevel() >= 30 && playerCount == 1){
                player1.setLevel(30);
                winScreen(display, player1);
            }
            FileIO.saveObject(player1);
        }
        // If both player and enemy are still alive than we assume the user quit so
        // we will display a user quitting message.
        else{
            display.setDialogue(display, "You flee from the battle area!");
        }
    }
    
    public static void winScreen(Graphics display, Player player) throws InterruptedException{
        display.clearCombat();
        display.setSysMessage("  You Beat the Game!!",1);
        for(int i = 0; i < 6; i++){
        display.setCombat(player.getName() + " has become legendary!!",0);
        display.screen(3);
        TimeUnit.SECONDS.sleep(1);
        display.setCombat(player.getName() + " has become legendary!!",1);
        display.screen(3);
        TimeUnit.SECONDS.sleep(1);
        display.setCombat(player.getName() + " has become legendary!!",2);
        display.screen(3);
        TimeUnit.SECONDS.sleep(1);
        display.setCombat(player.getName() + " has become legendary!!",3);
        display.screen(3);
        TimeUnit.SECONDS.sleep(1);
        display.setCombat(player.getName() + " has become legendary!!",4);
        display.screen(3);
        TimeUnit.SECONDS.sleep(1);
        display.screen(5);
        TimeUnit.SECONDS.sleep(1);
        display.screen(3);
        TimeUnit.SECONDS.sleep(1);
        display.screen(5);
        TimeUnit.SECONDS.sleep(1);
        display.screen(3);
        TimeUnit.SECONDS.sleep(1);
        display.clearCombat();
        }
    }
    
    public static void helpScreen(Graphics display, Player player, Player player2) throws InterruptedException{
        
        String[] helpScreenData = new String[20];
          
            helpScreenData[0] = spellInfo(0);
            helpScreenData[1] = player.ABILITIES[0];
            helpScreenData[2] = spellInfo(player.ABILITIESID[0]);
            helpScreenData[3] = player.ABILITIES[1];
            helpScreenData[4] = spellInfo(player.ABILITIESID[1]);
            helpScreenData[5] = player.ABILITIES[2];
            helpScreenData[6] = spellInfo(player.ABILITIESID[2]);
            helpScreenData[7] = player.ABILITIES[3];
            helpScreenData[8] = spellInfo(player.ABILITIESID[3]);
            
            helpScreenData[9] = spellInfo(0);
            helpScreenData[10] = player2.ABILITIES[0];
            helpScreenData[11] = spellInfo(player2.ABILITIESID[0]);
            helpScreenData[12] = player2.ABILITIES[1];
            helpScreenData[13] = spellInfo(player2.ABILITIESID[1]);
            helpScreenData[14] = player2.ABILITIES[2];
            helpScreenData[15] = spellInfo(player2.ABILITIESID[2]);
            helpScreenData[16] = player2.ABILITIES[3];
            helpScreenData[17] = spellInfo(player2.ABILITIESID[3]);
            
           
            display.loadHelpScreen(helpScreenData);
            display.screen(4);
            TimeUnit.SECONDS.sleep(15);
    }
    
    private static String spellInfo(int spellID){
        
        String temp = "";
        
        switch(spellID){
            case 0: temp = "Choose between your four abilities to defeat your opponent and Win!";
            break;
            case 1: temp = "Error invalid spell";
            break;
            case 2: temp = "A Light \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 3: temp = "A Medium \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 4: temp = "A Heavy \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 5: temp = "Heal the player for 100-150 hitpoints. Increase by 20 per level.";
            break;
            case 6: temp = "A Light \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 7: temp = "A Medium \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 8: temp = "A Heavy \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 9: temp = "A Light \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 10: temp = "A Medium \"Attack\" that does 90%-110% of main stat as damage.";
            break;
            case 11: temp = "Slam your opponent increasing weapon damage by 50% for the attack.";
            break;
            default : temp = "Error invalid spell";
            break;
        }
    return temp;
    }
}
