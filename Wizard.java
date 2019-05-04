/********************************************************************
//  Wizard.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 1, 2018
//
//  Defines the instance data, constructors and associated
//  methods of an wizard class object. Wizard objects are a subclass
//  of the Player class object.
//
//  Modifications since Phase II: Cleaned up excess code.
//                                Fixed missing Override statements.
//
//********************************************************************/
package Rastellini2;


public class Wizard extends Player {
    
    
    public Wizard(){
        
        name = "Merlin";
        className = "Wizard";
        mainStatName = "Intellect";
        mainStat = intellect;
        playerTurn = true;
        playerNumber = 1;
        
        ABILITIESID[0] = 6;
        ABILITIESID[1] = 7;
        ABILITIESID[2] = 8;
        ABILITIESID[3] = 5;
        
        specialAbility = 5;
        
        ABILITIES[0] = Spells.getSpellName(ABILITIESID[0]);
        ABILITIES[1] = Spells.getSpellName(ABILITIESID[1]);
        ABILITIES[2] = Spells.getSpellName(ABILITIESID[2]);
        ABILITIES[3] = Spells.getSpellName(ABILITIESID[3]);
        
        HOTKEY[0] = 'S';
        HOTKEY[1] = 'F';
        HOTKEY[2] = 'C';
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
    
    System.arraycopy(Images.GETWIZARD(), 0, CHARIDLE, 0, Images.GETWIZARD().length);
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
    
    System.arraycopy(Images.GETWIZARDATTACK(), 0, CHARATTACK, 0, Images.GETWIZARDATTACK().length);
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
