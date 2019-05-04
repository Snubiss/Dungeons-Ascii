/********************************************************************
//  Greeting.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 2, 2018
//
//  Provides a static method for an initial greeting at the menu screen.
//
//  Modifications since Phase II: None.
//
//********************************************************************/

package Rastellini2;


public class Greeting {
    
    private static int rng(int minnum, int maxnum){
        int randomnumber = (int)(Math.random()*(maxnum+1-minnum))+ minnum;
    return randomnumber;   
    }
    
    static public void randomGreeting(Graphics display){
        
        String greeting = "";
        int number = rng(1,7);
        
        switch (number){
            case 1: greeting = "Home of aggressive ascii characters.";
            break;
            case 2: greeting = "Beware of the strings[] they may kill you ..";
            break;
            case 3: greeting = "Warning: You may get your ascii kicked.";
            break;
            case 4: greeting = "Emergency personnel will not be standing by.";
            break;
            case 5: greeting = "Most dont make it out alive, except that one guy...";
            break;
            case 6: greeting = "Attacking dragons may be hazardous to your health.";
            break;
            case 7: greeting = "Scientists all agree, Dragons DO breath fire!";
            break;
            default: greeting = "Scientists all agree, Dragons DO breath fire!";
            break;
        }
        display.setCombat(greeting,0);
    }
    
}
