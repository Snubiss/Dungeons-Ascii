//***********************************************************************
//  Filename: MainGame.java  -- Inital Start File
//  Application Name: Dungeons & Ascii
//  Version: Beta 1.00
//  Author: Snubiss
//  Modified Date: 12/7/2018
//
// The Purpose:
//   The goal of this application is pure enjoyment. Once the application
//   loads, the main menu will display on the screen and request the number
//   of user's that want to play the game. Next, the game will request all
//   of the players' names. All of the players will then choose a class to
//   play the game with. Once we have our names and classes the game will begin
//   The game is turn based and combat will not begin until the player 1 attacks  
//   player 2. Both players will have 3 abilities and 1 special move. Special moves
//   are only allowed 3 times per game. Once combat is started both players will take turns 
//   attacking until a player's health reaches zero. When the fight ends, the player(s) will be 
//   prompted to fight again or quit. The player(s) will gain levels based on 
//   opponent kills up to the max level of 30. Attaining higher levels increases the players 
//   critical strike chance, hit chance, damage, strength/intel (depending on class)
//   and maximum health.
//
//   ----   NOTES  ----
//
//   If you find yourself in need of help, feel free to pull up the help menu within
//   the game by pressing 'i'.
//
//   Custom hotkeys have been coded into the engine but the option is not currently
//   available to the user to set them yet.
//
//   AI levels are coded to be within +-2 of the player's level in order to maintain scalability.
//
//
//                      -------Version Beta_1.00 Changes------
//
//   - The game will now auto load your saved progress in single player mode 
//     according to your player name and class chosen so you can pickup right where you left off.
//   - The game will auto save your progress after each fight if single player is chosen.
//   - Fixed bug where upon player reloading saved progress, the main stat of the player was visually wrong
//     but worked correctly. The stat should display correctly now. 
//   - Finalized all methods within images class to improve security.
//   - Protected all variables within the Player class.
//   - Alot of code cleanup.
//   - Applied more descriptive headers to all class files.
//   - Added level cap of 30 to the game.
//   - Added game complete screen to the game.
//   - Fixed Crit chance bug.
//   - Fixed Hit chance bug.
//   - Multiplayer versus battle now starts both players at level 15.
//   - Players will no longer level when victorius in multiplayer battle.
//   - Added cheat prevention and detection to file I/O operations.
//   - To test the new win screen open your saved file and change the last number to 8780. Now re-login with same name and class and win 1 game.
//   - To test the cheat detection open your saved file and change the last number to 12000. Now re-login with same name and class.
//     (The save file detects level increase out of range)
//   
//
// Required Input Variables: 
//
//   Number of players
//   Player names
//   Player class choices
//   Player battle inputs
//   Good Luck
//
//*************************************************************************

package Rastellini2;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class MainGame {
    
    /******************************************
    *             !!! METHODS !!!             *
    ******************************************/

    private static int rng(int minnum, int maxnum){
    int randomnumber = (int)(Math.random()*(maxnum+1-minnum))+ minnum;
    return randomnumber;   
    }
    
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        
        
        // Create a screen display.
        Graphics display = new Graphics();
        // Create a scanner instance for input.
        Scanner in = new Scanner(System.in);
        // Create an instance of our spell data to look spells.
        Spells spellData = new Spells();
        // Creat an instance for dialogue.
        Greeting dialogue = new Greeting();
        // Number of players
        int playerCount;
        // Create temporary variables to store random data.
        Player[] player = new Player[2];
        String temp;
        int digTemp;
        char playerInput;
        boolean playerInputCheck;
        int spellID;
        boolean gameLoop = true;
        
        /****************************************************
        *                     MAIN MENU                     *
        /***************************************************/
        
        // Enter players screen.
        // Modulization test here.
        playerCount = Dialogue.enterPlayers(display);
        display.clearCombat();
        
        // Enter Name for each player.
        for (int i = 0; i < playerCount; i++){
            
            // Setup our dialogue for our enter player screen.
            display.setSysMessage("Welcome to Dungeons and Ascii. Please type in your name and choose a class to play.", 0);
            display.setSysMessage("Please enter the information needed below or input Q to (Q)uit", 1);
            display.setCombat("        -- " + playerCount + " PLAYER SELECTED --", 1);
            display.setCombat("     Please Enter Player " + (i+1) + "'s Name:", 2);
            Greeting.randomGreeting(display);
        
            
            // Display Title Screen
            display.screen(1);
            // Request user name with a string format so it puts the cursor at the center of screen.
            System.out.print (String.format("%62s", ""));
            // Temporarily store the input.
            temp = in.next();
            // Check if the user data has errors.
            playerInputCheck = ErrorCheck.inputCheck(temp);

            if  (playerInputCheck){
                // Display the invalid input error message and ask the user to enter a valid input.
                display.setSysMessage ((String.format("%47s", "The Name you entered is invalid.")),1);
                // Stay on the same player number if bad entry.
                i--;
            }
            else{
                // Save the name entered if data is good.
                display.setPlayerName(temp, (i+1));
            }
        } // END OF NAME ENTRY
        
        /****************************************************
        *                  CLASS SELECTION                  *
        /***************************************************/

        // Clear the dialogue from the screen than initiate new dialogue.
        // Do this for every player we have.
        for (int i = 0; i < playerCount; i++){
            
            display.clearCombat();
            display.setSysMessage ("",0);
            display.setSysMessage("Welcome " + display.getPlayerName((i+1)) + ", please select your class or input Q to (Q)uit",1);
            display.setCombat(" Choose your fighter: ",0);

            // Display class selection screen.
            display.screen(2);
            // Request user name with a string format so it puts the cursor at the center of screen.
            System.out.print (String.format("%62s", ""));
            // Temporarily store the player's class name.
            temp = in.next();
            // Check if the user data matches a valid class choice.
            playerInputCheck = ErrorCheck.classCheck(temp);

            if (playerInputCheck){

                // Display the invalid input error message and ask the user to enter a valid input.
                display.setSysMessage ((String.format("%44s", "That Class does not exist.")),1);
                // Stay on the same player number if bad entry.
                i--;
            }
            // Pick a class if the class choice is valid.
            else{
                // Transform the input to uppcase and grab the first character in the player's string.
                char classInput = (temp.toUpperCase()).charAt(0);

                // Create a class instance, set the player name and update our display based on our input.
                switch(classInput){

                // CREATE THE CLASS, SET PLAYER NUMBER, SET PLAYER NAME, SET CLASS IMAGE.

                case 'W': player[i] = new Wizard();
                          player[i].setPlayerNumber(i+1);
                          player[i].setName(display.getPlayerName(i+1));
                          if (playerCount > 1){
                          player[i].levelUp(14);
                          }
                          display.setIdle(player[i],player[i].getPlayerNumber());
                break;

                case 'D': player[i] = new Dragon();
                          player[i].setPlayerNumber(i+1);
                          player[i].setName(display.getPlayerName(i+1));
                          if (playerCount > 1){
                          player[i].levelUp(14);
                          }
                          display.setIdle(player[i],player[i].getPlayerNumber());
                break;

                case 'K': player[i] = new Knight();
                          player[i].setPlayerNumber(i+1);
                          player[i].setName(display.getPlayerName(i+1));
                          if (playerCount > 1){
                          player[i].levelUp(14);
                          }
                          display.setIdle(player[i],player[i].getPlayerNumber());
                break;

                case 'F': player[i] = new Fairy();
                          player[i].setPlayerNumber(i+1);
                          player[i].setName(display.getPlayerName(i+1));
                          if (playerCount > 1){
                          player[i].levelUp(14);
                          }
                          display.setIdle(player[i],player[i].getPlayerNumber());
                break;

                case 'A': player[i] = new Alien();
                          player[i].setPlayerNumber(i+1);
                          player[i].setName(display.getPlayerName(i+1));
                          if (playerCount > 1){
                          player[i].levelUp(14);
                          }
                          display.setIdle(player[i],player[i].getPlayerNumber());
                break;

                case 'Q': System.exit(0);
                break;  
                
                }// END OF CLASS CHOICE

                // If single player game.
                if(playerCount == 1){
                    // Check if the user name and class matches a saved file, if so, load it.
                    player[0] = FileIO.readObject(player[0]);
                }
            }
        }
        
        System.out.print(player[0]);
        /*************************************************************************
        *                          GAME/CONTINUE LOOP                            *
        *************************************************************************/
        
        // Start our game.
        while(gameLoop){

            // At the start of the game reset both player's health to 100%.
            player[0].setHitPoints(player[0].getMaxHealth());
            if (playerCount > 1){
            player[1].setHitPoints(player[1].getMaxHealth());
            }
            // Single player game so generate an enemy.
            if (playerCount <= 1){
                // Generate a random number between 1 and 2 to choose our enemy.
                int chosenEnemy = rng(1,5);
                // Create a enemy instance, set the enemy level and update our display based on our input. 
                switch(chosenEnemy){

                    case 1: 
                            player[1] = new Dragon();
                            player[1].setPlayerNumber(2);
                            player[1].levelUp((rng(player[0].getLevel()-2,player[0].getLevel()+1)));
                            display.setIdle(player[1],player[1].getPlayerNumber());
                    break;
                    
                    case 2: player[1] = new Wizard();
                            player[1].setPlayerNumber(2);
                            player[1].levelUp((rng(player[0].getLevel()-2,player[0].getLevel()+1)));
                            display.setIdle(player[1],player[1].getPlayerNumber());
                    break;
                            
                    case 3: player[1] = new Alien();
                            player[1].setPlayerNumber(2);
                            player[1].levelUp((rng(player[0].getLevel()-2,player[0].getLevel()+1)));
                            display.setIdle(player[1],player[1].getPlayerNumber());
                    break;
                    
                    case 4: player[1] = new Fairy();
                            player[1].setPlayerNumber(2);
                            player[1].levelUp((rng(player[0].getLevel()-2,player[0].getLevel()+1)));
                            display.setIdle(player[1],player[1].getPlayerNumber());
                    break;
                    
                    case 5: player[1] = new Knight();
                            player[1].setPlayerNumber(2);
                            player[1].levelUp((rng(player[0].getLevel()-2,player[0].getLevel()+1)));
                            display.setIdle(player[1],player[1].getPlayerNumber());
                    break;

                    default: player[1] = new Wizard();
                             player[1].setPlayerNumber(2);
                             player[1].levelUp((rng(player[0].getLevel()-2,player[0].getLevel()+1)));
                             display.setIdle(player[1],player[1].getPlayerNumber());
                    break;
                }// End enemy choice switch.
            } // End enemy creation.
            
            // Reset both players' special ability to 3.
            player[0].setSpecialCount(3);
            player[1].setSpecialCount(3);
            
            // Display who the player is fighting onto the screen. This should only run once.
            display.setCombat(player[0].getName() + " is fighting "+ player[1].getName() + ".",0);
            display.setCombat(player[0].getName() + " attack to Start the fight!",2);
            display.setSysMessage("              Good Luck!!      ",0);
            display.setSysMessage(" ",1);

            
            /*************************************************************************
            *                              BATTLE LOOP                               *
            *************************************************************************/

            // Create a true/false statement to control when we want the fight to stop.
            boolean battleLoop = true;
            // Start the fight. This will run until a player/enemies health reaches zero.
            while(battleLoop){
                
                // Refresh our screen data.
                display.refreshPlayer(player);
                
                // Check to see if a player died last turn so we can end the fight.
                if (player[0].getHitPoints() <=0 || player[1].getHitPoints() <= 0){
                        battleLoop = false;
                }
                // If no one died then let the fight continue.
                else{
                    
                    //**********************//
                    //     PLAYER ATTACK    //
                    //**********************//
                    if(player[0].getPlayerTurn()){

                        do{
                            // Display Screen
                            display.screen(3);
                            // Request user name with a string format so it puts the cursor at the center of screen.
                            System.out.print (String.format("%62s", ""));
                            // Temporarily store the user's input.
                            temp = in.next();
                            // Check if the user data matches user's hotkeys.
                            playerInputCheck = ErrorCheck.hotkeyCheck(temp,player[0]);

                            if (playerInputCheck){
                                // Display the invalid input error message and ask the user to enter a valid input.
                                display.setSysMessage ("         Invalid input. Try again",0);
                            }
                            if (!playerInputCheck){
                                // Check if the user want the Help screen
                                if((temp.toUpperCase()).charAt(0) == 'I'){
                                    Dialogue.helpScreen(display, player[0], player[1]);
                                    playerInputCheck = true;
                                }
                                // Check if the user wants to quit
                                if((temp.toUpperCase()).charAt(0) == 'Q'){
                                    player[1].setPlayerTurn(false);
                                    battleLoop = false;
                                    playerInputCheck = false;
                                break;
                                }
                            }
                        //If errors found than ask again.
                        }while(playerInputCheck);
                        
                        
                        // Change the user's input to uppercase to make decisions a bit easier.
                        // Store the first letter of the input given now that we know the entry is valid.
                        playerInput = (temp.toUpperCase()).charAt(0);
                        
                        // Go through the players hotkeys and match with the corresponding button number to fire.
                        digTemp = Controls.GETBUTTONPRESSED(player[0], playerInput);
                       
                        // Fire appopriate button corresponding to our user's hotkeys.
                        switch(digTemp){
                            // Obtain the spell ID associted with the button fired and cast that spell.    
                            case 1:    
                                spellID = Controls.FIREBUTTON1(player[0]);
                                if (player[0].checkSpecialCount(display, player[0], player[1], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[0], player[1], spellID);
                            break;
                            
                            case 2:    
                                spellID = Controls.FIREBUTTON2(player[0]);
                                if (player[0].checkSpecialCount(display, player[0], player[1], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[0], player[1], spellID);
                            break;
                            
                            case 3: 
                                spellID = Controls.FIREBUTTON3(player[0]);
                                if (player[0].checkSpecialCount(display, player[0], player[1], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[0], player[1], spellID);
                            break;
                            
                            case 4: 
                                spellID = Controls.FIREBUTTON4(player[0]);
                                if (player[0].checkSpecialCount(display, player[0], player[1], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[0], player[1], spellID);
                            break;
                            
                            default: break;
                        }
                        
                        // Once player casts an ability set to enemies turn and change dialogue to wait.
                        display.setSysMessage("              " + player[1].getName() + "'s turn.",0);
                        if (playerCount < 2){
                            display.setSysMessage("              Please Wait..",1);
                        }
                        else{
                            display.setSysMessage("            Enter your input",1);
                        }
                        
                    }
                    // Give the user time to read the screen.
                    display.screen(3);
                    TimeUnit.SECONDS.sleep(2);
                    
                    //*************************************************************************
                    //                         BOSS/ENEMY CODE HERE                           *
                    //*************************************************************************
                    
                    
                    // If it's the enemies turn and the enemy isn't dead do this. Else skip and let death check end game up top. 
                    if(player[1].getPlayerTurn() && player[1].getHitPoints() > 0){    
                        
                        if (playerCount > 1){
                            
                            do{
                                // Display Screen
                                display.screen(3);
                                // Request user name with a string format so it puts the cursor at the center of screen.
                                System.out.print (String.format("%62s", ""));
                                // Temporarily store the user's input.
                                temp = in.next();
                                // Check if the user data matches user's hotkeys.
                                playerInputCheck = ErrorCheck.hotkeyCheck(temp,player[1]);

                                if (playerInputCheck){
                                    // Display the invalid input error message and ask the user to enter a valid input.
                                    display.setSysMessage ("         Invalid input. Try again",0);
                                }
                                if (!playerInputCheck){
                                // Check if the user want the Help screen
                                if((temp.toUpperCase()).charAt(0) == 'I'){
                                Dialogue.helpScreen(display, player[0], player[1]);
                                playerInputCheck = true;
                                }
                                // Check if the user wants to quit
                                if((temp.toUpperCase()).charAt(0) == 'Q'){
                                battleLoop = false;
                                playerInputCheck = false;
                                break;
                                }
                            }
                            //If errors are found than ask again.
                            }while(playerInputCheck);
                        
                        
                        // Clear our dialogue for user response.
                        display.clearCombat();
                        // Change the user's input to uppercase to make decisions a bit easier.
                        // Store the first letter of the input given now that we know the entry is valid.
                        playerInput = (temp.toUpperCase()).charAt(0);

                        }
                        else{
                            playerInput = player[1].castRandomAbility();
                        }
                        // Go through the players hotkeys and match with the corresponding button number to fire.
                        digTemp = Controls.GETBUTTONPRESSED(player[1], playerInput);
                       
                        // Fire appopriate button corresponding to our user's hotkeys.
                        switch(digTemp){
                            // Obtain the spell ID associted with the button fired and cast that spell.    
                            case 1:    
                                spellID = Controls.FIREBUTTON1(player[1]);
                                if (player[1].checkSpecialCount(display, player[1], player[0], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[1], player[0], spellID);
                            break;
                            
                            case 2:    
                                spellID = Controls.FIREBUTTON2(player[1]);
                                if (player[1].checkSpecialCount(display, player[1], player[0], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[1], player[0], spellID);
                            break;
                            
                            case 3: 
                                spellID = Controls.FIREBUTTON3(player[1]);
                                if (player[1].checkSpecialCount(display, player[1], player[0], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[1], player[0], spellID);
                            break;
                            
                            case 4: 
                                spellID = Controls.FIREBUTTON4(player[1]);
                                if (player[1].checkSpecialCount(display, player[1], player[0], spellID)){
                                    break;
                                }
                                spellData.cast(display, player[1], player[0], spellID);
                            break;
                            
                            default: break;
                        }
                        
                        // Add some dialogue to let user know it's their turn.
                        display.setSysMessage("             " + player[0].getName() + "'s turn.",0);
                        display.setSysMessage("            Enter your input",1);
                        
                    } // END OF BOSS SECTION          
                }// END DEATH CHECK 
            }//END BATTLE
         
            /************* CONTINUE SCREEN ************/

            // Lets clear our dialogue to wipe away the games dialogue data.
            display.clearCombat();

            // Display the proper response for ending the round
            Dialogue.endFight(display, player[0], player[1], playerCount);
            
            // Refresh the player screen data;
            display.refreshPlayer(player);
            
            boolean continueScreen = true;
                
            while (continueScreen){

                do{
                    // The game has ended or the user quit. Lets ask the user if they wanna play again.
                    display.setCombat("Would you like to play again? Y or N?",2);
                    display.setCombat("",3);

                    //Now that we know if someone died or user quit. Lets update our screen data and Redraw our screen.
                    display.screen(3);

                    // Request user name with a string format so it puts the cursor at the center of screen.
                    System.out.print (String.format("%62s", ""));
                    temp = in.next();

                    // Check if the user data has errors.
                    playerInputCheck = ErrorCheck.boolCheck(temp);

                    if (playerInputCheck){
                         // Display the invalid input error message and ask the user to enter a valid input.
                        display.setSysMessage ("Invalid Entry. Please enter a valid command key",0);
                    }
                //If errors found than ask again.
                }while(playerInputCheck);


                // Change the user's input to uppercase to make decisions a bit easier.
                // Store the first letter of the input given now that we know the entry is valid.
                char choice = (temp.toUpperCase()).charAt(0);

                // Decide what action to take based on the user's entry.
                switch(choice){

                    // If user enters y or Y than restart the game.
                    case 'Y': battleLoop = true;
                              continueScreen = false;
                              player[0].setPlayerTurn(true);
                              display.clearCombat();
                    break;

                    // If user enters n or N than cancel the main program
                    case 'N': gameLoop = false;
                              continueScreen = false;
                    break;

                    // If the user does not enter Y or N than error and ask the user again.
                    default: display.clearCombat();
                             display.setSysMessage("Invalid entry. Please Enter Y or N.",0);
                             continueScreen = true;
                    break;
                }
            } // CONTINUE SCREEN
            
        } // GAME LOOP
        System.exit(0);
    }// END MAIN
}// END GAME
    

