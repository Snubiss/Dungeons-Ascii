/********************************************************************
//  Controls.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 7, 2018
//
//  The purpose of this class is to allow a static button mapping for 
//  our game. It defines the maximum allowed buttons in the game and
//  provides potential custom hot key setups for players.
//
//  Modifications since Phase II: Reduced maximum buttons to 4.
//                                Extensive code cleanup.
//                                
//********************************************************************/


package Rastellini2;


public abstract class Controls {
    
    // Check which hotkey matches the button pressed. Return us the button number it's associated with.
    public static final int GETBUTTONPRESSED(Player player, char buttonData){
        // Maximum allowed buttons in the game.
        final int MAXBUTTONS = 4;
        int digTemp = 0;

        for(int i = 0;i < MAXBUTTONS; i++){
            if (player.getHotkey(i) == buttonData){
                digTemp = i+1; 
            }
        }
    return digTemp;
    }

                    /***********************************
                    *           BUTTON LAYOUT          *
    ********************************************************************
    * FIRE EACH BUTTON ACCORDING TO THE SPELL ID IT'S ASSOCIATED WITH  *
    *                                                                  *
    *******************************************************************/

    public static final int FIREBUTTON1 (Player playerData){
    int spellID = playerData.castAbility(playerData, 1);
    return spellID;
    }

    public static final int FIREBUTTON2 (Player playerData){
    int spellID = playerData.castAbility(playerData, 2);
    return spellID;
    }

    public static final int FIREBUTTON3 (Player playerData){
    int spellID = playerData.castAbility(playerData, 3);
    return spellID;
    }

    public static final int FIREBUTTON4 (Player playerData){
    int spellID = playerData.castAbility(playerData, 4);
    return spellID;
    }
}


