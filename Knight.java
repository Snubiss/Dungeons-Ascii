/********************************************************************
//  Knight.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 1, 2018
//
//  Defines the instance data, constructors and associated
//  methods of an knight class object. Knight objects are a subclass
//  of the Player class object.
//
//  Modifications since Phase II: Cleaned up excess code.
//                                Fixed missing Override statements.
//********************************************************************/
package Rastellini2;


public final class Knight extends Player {
    
    
    public Knight(){
        
        name = "Arthur";
        className = "Knight";
        mainStatName = "Strength";
        mainStat = strength;
        playerTurn = true;
        playerNumber = 1;
       
        ABILITIESID[0] = 2;
        ABILITIESID[1] = 3;
        ABILITIESID[2] = 4;
        ABILITIESID[3] = 11;
        
        specialAbility = 11;
        
        ABILITIES[0] = Spells.getSpellName(ABILITIESID[0]);
        ABILITIES[1] = Spells.getSpellName(ABILITIESID[1]);
        ABILITIES[2] = Spells.getSpellName(ABILITIESID[2]);
        ABILITIES[3] = Spells.getSpellName(ABILITIESID[3]);
        
        HOTKEY[0] = 'A';
        HOTKEY[1] = 'S';
        HOTKEY[2] = 'K';
        HOTKEY[3] = 'L';
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
    mainStat = strength;
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
    mainStat = strength;
    damage = mainStat + BASE_DAMAGE;
    }
}
@Override
public String[] getIdle(){
    
    System.arraycopy(Images.GETKNIGHT(), 0, CHARIDLE, 0, Images.GETKNIGHT().length);
    switch(playerNumber){
        case 1:
            for(int i= 0; i < CHARIDLE.length; i++){
            CHARIDLE[i] = CHARIDLE[i].substring(0,68);
                }
        break;
        case 2:
        for(int i= 0; i < CHARIDLE.length; i++){
        CHARIDLE[i] = CHARIDLE[i].substring(0,73);  
        }
        break;
    }
    return CHARIDLE;
}

@Override
public String[] getAnimation(){
    System.arraycopy(Images.GETKNIGHTATTACK(), 0, CHARATTACK, 0, Images.GETKNIGHTATTACK().length);
    switch(playerNumber){
        case 1:
            for(int i= 0; i < CHARATTACK.length; i++){
            CHARATTACK[i] = CHARATTACK[i].substring(0,68);
                }
        break;
        case 2:
            for(int i= 0; i < CHARATTACK.length; i++){
            CHARATTACK[i] = CHARATTACK[i].substring(0,73); 
        }
        break;
    }
    return CHARATTACK;
}

}