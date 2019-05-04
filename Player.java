/********************************************************************
//  Player.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 1, 2018
//
//  Defines the abstract data associated methods of the player object. 
//  A player object is a superclass and cannot be created unless a subclass
//  is assigned. Anything changed here will change all players.
//  
//  Modifications since Phase II: Small code cleanup.
//                                Fixed Crit chance bug.
//                                Fixed Hit chance bug.
//                                
//********************************************************************/
package Rastellini2;


public abstract class Player{

private static int rng(int minnum, int maxnum){
int randomnumber = (int)(Math.random()*((maxnum+1)-minnum))+ minnum;
return randomnumber;   
}

    protected String name = "Unknown";
    protected String className = "Unknown";
    protected String mainStatName;
    
    protected String[] ABILITIES = new String[4];
    protected int[] ABILITIESID = new int[5];
    protected final char[] HOTKEY = new char[6];
    protected final String[] CHARIDLE = new String[26];
    protected final String[] CHARATTACK = new String[26];
    
    protected final int BASE_HEALTH = 500;
    protected final int BASE_STRENGTH = 50;
    protected final int BASE_INTELLECT = 50;
    protected final int BASE_DAMAGE = 50;
    protected final int BASE_CRIT_CHANCE = 30;
    protected final int BASE_HIT_CHANCE = 70;
    
    protected int maxHealth = BASE_HEALTH;
    protected int damage = BASE_DAMAGE;
    protected int strength = BASE_STRENGTH;
    protected int intellect = BASE_INTELLECT;
    protected int hitChance = BASE_HIT_CHANCE;
    protected int hitPoints = maxHealth;
    protected int critChance = BASE_CRIT_CHANCE;
    protected int playerNumber = 0;
    protected int mainStat;
    protected int level = 0;
    protected int specialCount = 3;
    protected int specialAbility;
    protected boolean playerTurn = true;
    
public void Player(){
}

public void setName(String nameData){
    name = nameData;
}
public String getName(){
    return name;
}
public String getClassRole(){
    return className;
}
public void setPlayerNumber(int Number){
    playerNumber = Number;
}
public int getPlayerNumber(){
    return playerNumber;
}
public String getMainStatName(){
    return mainStatName;
}
public int getMainStat(){
    return mainStat;
}
public int getLevel(){
    return level;
}
public void setLevel(int data){
    level = data;
}
public void setHitPoints(int data){
    if(data <= 0){
       hitPoints = 0;
    }
    else{
    hitPoints = data;
    }
}
public int getHitPoints(){
return hitPoints;    
}
public void setMaxHealth(int data){
    maxHealth = data;
}
public int getMaxHealth(){
    return maxHealth;    
}
public void setHitChance(int hit){
    hitChance = hit;
}
public int getHitChance(){
    return hitChance;
}
public void setCritChance(int hit){
    hitChance = hit;
}
public int getCritChance(){
    return hitChance;
}
public void setPlayerTurn(boolean data){
    playerTurn = data;
}
public boolean getPlayerTurn(){
    return playerTurn;
}
public int getSpecialCount(){
    return this.specialCount;
}
public void setSpecialCount(int healData){
    specialCount = healData;
}
public char getHotkey(int number){
    return HOTKEY[number];
}
public boolean checkSpecialCount(Graphics display, Player player, Player enemy, int spellID){
    
    boolean itemCount = false;
    if (spellID == player.specialAbility && player.getSpecialCount() == 0){
        
        display.clearCombat();
        display.setDialogue(display, "Your out of special abilities for this round " + player.getName() + ".");
        itemCount = true;
    }
    player.setPlayerTurn(true);
    enemy.setPlayerTurn(false);
    
    return itemCount;
}
public boolean attackCheck(Player player){

    int attackRNG = rng(1,100);
    return attackRNG <= player.getHitChance();
}
public boolean critCheck(Player player){

    int critRNG = rng(1,100);
    return critRNG <= player.getCritChance();
}
public void setDamage(int newDamage){
    damage = newDamage;
}
public int getDamage(){
    return damage;
}
public int castAbility(Player playerData, int buttonPushed){
    
    int spellID = ABILITIESID[(buttonPushed-1)];
    return spellID;
}
public char castRandomAbility(){
    return HOTKEY[rng(0,(HOTKEY.length-2))];
}

// Level up multiple times if needed
public abstract void levelUp(int temp);

public abstract void levelUp();

public abstract String[] getIdle();

public abstract String[] getAnimation();

}
