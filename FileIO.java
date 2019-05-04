/********************************************************************
//  FileIO.java       Author: Snubiss
//
//  Date: December 7, 2018
//  Modified: December 8, 2018
//
//  Defines static methods for creating, deleting and reading file objects.
//  The readObject method is called every time a player chooses their class
//  role.
//
//  Modifications since Phase II: File was created.
//                                Added cheat prevention and detection.
//                                
//********************************************************************/

package Rastellini2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Schoolbox
 */
public class FileIO {
    
    // CALLED AFTER PLAYER CHOOSES NAME AND CLASS.
    public static Player readObject(Player player) throws FileNotFoundException {
        
        // Create the save data files based on the users name and class role.
        File file = new File(player.name + player.className +".txt");
        
        // If the file doesnt exist then create it and dump our stats to it.
        if (!file.exists()) {
            
            try ( 
            PrintWriter output = new PrintWriter(file);
            ) 
            {
                // Save all of our player's data.
                output.print(player.name+" ");
                output.print(player.ABILITIESID[0]+" ");
                output.print(player.ABILITIESID[1]+" ");
                output.print(player.ABILITIESID[2]+" ");
                output.print(player.ABILITIESID[3]+" ");
                output.print(player.HOTKEY[0]+" ");
                output.print(player.HOTKEY[1]+" ");
                output.print(player.HOTKEY[2]+" ");
                output.print(player.HOTKEY[3]+" ");
                output.print(player.HOTKEY[4]+" ");
                output.print(player.HOTKEY[5]+" ");
                output.print(((player.getLevel() * 300) + 80 ) +" ");
                
            }       
        }
        // If the file exists or we just created it then upload the stats from the file
        // to our player's character.
        else if (file.exists()) {
            
            try (
                Scanner input = new Scanner(file);
            ){
                // Read all of our player's data.
                player.setName(input.next());
                player.ABILITIESID[0] = input.nextInt();
                player.ABILITIESID[1] = input.nextInt();
                player.ABILITIESID[2] = input.nextInt();
                player.ABILITIESID[3] = input.nextInt();
                player.HOTKEY[0] = input.next().charAt(0);
                player.HOTKEY[1] = input.next().charAt(0);
                player.HOTKEY[2] = input.next().charAt(0);
                player.HOTKEY[3] = input.next().charAt(0);
                player.HOTKEY[4] = input.next().charAt(0);
                player.HOTKEY[5] = input.next().charAt(0);
                // CHEAT DETECTION CODE.
                int testInput = input.nextInt();
                if(testInput > 9080){
                    testInput = 380;
                    player.setName("The Cheater");
                    player.ABILITIESID[0] = 1;
                    player.ABILITIESID[1] = 1;
                    player.ABILITIESID[2] = 1;
                    player.ABILITIES[0] = Spells.getSpellName(player.ABILITIESID[0]);
                    player.ABILITIES[1] = Spells.getSpellName(player.ABILITIESID[1]);
                    player.ABILITIES[2] = Spells.getSpellName(player.ABILITIESID[2]);
        
                }
                // When a new player is made it automatically levels once. 
                // Need to account for that by subtracting one.
                player.levelUp(((testInput - 80) / 300)-1);
                
            }
        
        }
    return player;
    }
    
    // CALLED ONLY IN SINGLE PLAYER MODE AFTER PLAYER BEATS CPU.
    public static void saveObject(Player player) throws FileNotFoundException{
        
        // Create the save data files based on the users name and class role.
        File file = new File(player.name + player.className +".txt");
        
        // If the file exists then delete it to prevent errors.
        if (file.exists()) {
            file.delete();
        }
        
        // Create a new file and dump the players stats to it.
        try ( 
        PrintWriter output = new PrintWriter(file);
        ) 
        {
            // Save all of our player's data.
            output.print(player.getName()+" ");
            output.print(player.ABILITIESID[0]+" ");
            output.print(player.ABILITIESID[1]+" ");
            output.print(player.ABILITIESID[2]+" ");
            output.print(player.ABILITIESID[3]+" ");
            output.print(player.HOTKEY[0]+" ");
            output.print(player.HOTKEY[1]+" ");
            output.print(player.HOTKEY[2]+" ");
            output.print(player.HOTKEY[3]+" ");
            output.print(player.HOTKEY[4]+" ");
            output.print(player.HOTKEY[5]+" ");
            output.print(((player.getLevel() * 300) + 80 ) +" ");
        }
    }
}
