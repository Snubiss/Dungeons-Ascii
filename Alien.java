/********************************************************************
//  Alien.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 1, 2018
//
//  Defines the instance data, constructors and associated
//  methods of an alien class object. Alien objects are a subclass
//  of the Player class object.
//
//  Modifications since Phase II: Cleaned up excess code.
//********************************************************************/
package Rastellini2;


public final class Alien extends Player {
    
    
    public Alien(){
        
        name = "Herbert";
        className = "Alien";
        mainStatName = "Intellect";
        mainStat = intellect;
        playerTurn = true;
        playerNumber = 1;
        
        ABILITIESID[0] = 2;
        ABILITIESID[1] = 9;
        ABILITIESID[2] = 3;
        ABILITIESID[3] = 5;
        
        specialAbility = 5;
        ABILITIES[0] = Spells.getSpellName(ABILITIESID[0]);
        ABILITIES[1] = Spells.getSpellName(ABILITIESID[1]);
        ABILITIES[2] = Spells.getSpellName(ABILITIESID[2]);
        ABILITIES[3] = Spells.getSpellName(ABILITIESID[3]);
        
        
        HOTKEY[0] = 'A';
        HOTKEY[1] = 'C';
        HOTKEY[2] = 'S';
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
    System.arraycopy(Images.GETALIEN(), 0, CHARIDLE, 0, Images.GETALIEN().length);
    switch(playerNumber){
        case 1:
            for(int i= 0; i < CHARIDLE.length; i++){
            CHARIDLE[i] = CHARIDLE[i].substring(0,68);
            }
        break;
        case 2:
        for(int i= 0; i < CHARIDLE.length; i++){
            CHARIDLE[i] = CHARIDLE[i].substring(0,73);
            StringBuilder sbTemp = new StringBuilder(CHARIDLE[i]);
            sbTemp.reverse();
            CHARIDLE[i] = sbTemp.toString();
        }
        break;    
    }
    return CHARIDLE;
}
@Override
public String[] getAnimation(){
    System.arraycopy(Images.GETALIENATTACK(), 0, CHARATTACK, 0, Images.GETALIENATTACK().length);
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
