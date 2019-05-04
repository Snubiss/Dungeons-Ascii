/********************************************************************
//  Fairy.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 1, 2018
//
//  Defines the instance data, constructors and associated
//  methods of an fairy class object. Fairy objects are a subclass
//  of the Player class object.
//
//  Modifications since Phase II: Cleaned up excess code.
//********************************************************************/
package Rastellini2;


public final class Fairy extends Player {
    
    
    public Fairy(){
        
        name = "Lilith";
        className = "Fairy";
        mainStatName = "Intellect";
        mainStat = intellect;
        playerTurn = true;
        playerNumber = 1;
        
        ABILITIESID[0] = 2;
        ABILITIESID[1] = 10;
        ABILITIESID[2] = 4;
        ABILITIESID[3] = 5;
        
        specialAbility = 5;
        
        ABILITIES[0] = Spells.getSpellName(ABILITIESID[0]);
        ABILITIES[1] = Spells.getSpellName(ABILITIESID[1]);
        ABILITIES[2] = Spells.getSpellName(ABILITIESID[2]);
        ABILITIES[3] = Spells.getSpellName(ABILITIESID[3]);
        
        HOTKEY[0] = 'A';
        HOTKEY[1] = 'W';
        HOTKEY[2] = 'K';
        HOTKEY[3] = 'H';
        HOTKEY[4] = 'Q';
        HOTKEY[5] = 'I';
        
        this.levelUp();
    }
    
@Override
public void setName(String nameData){
    name = nameData;
}
@Override
public void levelUp(){
    level++;
    strength += 5;
    intellect += 5;
    maxHealth += (40+level);
    hitPoints = maxHealth;
    hitChance += 1;
    critChance += 1;
    mainStat = intellect;
    damage = mainStat + BASE_DAMAGE;
}
@Override
// Level up multiple times if needed
public void levelUp(int times){
    
    for (int i = 0; i < times; i++){
    level++;
    strength += 5;
    intellect += 5;
    maxHealth += (40+level);
    hitPoints = maxHealth;
    hitChance += 1;
    critChance += 1;
    mainStat = intellect;
    damage = mainStat + BASE_DAMAGE;
    }
}
@Override
public String[] getIdle(){

    switch(playerNumber){
        case 1:
            System.arraycopy(Images.GETFAIRY1P(), 0, CHARIDLE, 0, Images.GETFAIRY1P().length);
            for(int i= 0; i < CHARIDLE.length; i++){
                CHARIDLE[i] = CHARIDLE[i].substring(0,68);
            }
        break;
        case 2:
            System.arraycopy(Images.GETFAIRY2P(), 0, CHARIDLE, 0, Images.GETFAIRY2P().length);
            for(int i= 0; i < CHARIDLE.length; i++){
                CHARIDLE[i] = CHARIDLE[i].substring(0,73);
            }
        break;    
    }
    return CHARIDLE;
}
@Override
public String[] getAnimation(){
    switch(playerNumber){
        case 1:
            System.arraycopy(Images.GETFAIRYATTACK1P(), 0, CHARATTACK, 0, Images.GETFAIRYATTACK1P().length);
            for(int i= 0; i < CHARATTACK.length; i++){
                CHARATTACK[i] = CHARATTACK[i].substring(0,68);
            }
        break;
        case 2:
            System.arraycopy(Images.GETFAIRYATTACK2P(), 0, CHARATTACK, 0, Images.GETFAIRYATTACK2P().length);
            for(int i= 0; i < CHARATTACK.length; i++){
                CHARATTACK[i] = CHARATTACK[i].substring(0,73);  
            }
        break;
    }
    return CHARATTACK;
}

}
