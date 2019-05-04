/********************************************************************
//  Dragon.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 1, 2018
//
//  Defines the instance data, constructors and associated
//  methods of an Dragon class object. Dragon objects are a subclass
//  of the Player class object.
//
//  Modifications since Phase II: Cleaned up excess code.
//********************************************************************/
package Rastellini2;


public final class Dragon extends Player {
    
    
    public Dragon(){
        
        name = "Spyro";
        className = "Dragon";
        mainStatName = "Strength";
        mainStat = strength;
        playerTurn = true;
        playerNumber = 1;
        
        ABILITIESID[0] = 9;
        ABILITIESID[1] = 7;
        ABILITIESID[2] = 3;
        ABILITIESID[3] = 11;
        
        specialAbility = 11;
        
        ABILITIES[0] = Spells.getSpellName(ABILITIESID[0]);
        ABILITIES[1] = Spells.getSpellName(ABILITIESID[1]);
        ABILITIES[2] = Spells.getSpellName(ABILITIESID[2]);
        ABILITIES[3] = Spells.getSpellName(ABILITIESID[3]);
        
        HOTKEY[0] = 'C';
        HOTKEY[1] = 'F';
        HOTKEY[2] = 'S';
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
    
    System.arraycopy(Images.GETDRAGON(), 0, CHARIDLE, 0, Images.GETDRAGON().length);
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
    System.arraycopy(Images.GETDRAGONATTACK(), 0, CHARATTACK, 0, Images.GETDRAGONATTACK().length);
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
