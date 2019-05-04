/********************************************************************
//  Spells.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 2, 2018
//
//  
//  Defines the instance data, constructors and associated
//  methods for our game spells. The purpose of this class is to catalogue 
//  our games spell data for our player's to use. If you want to
//  add another spell then you would add it here.
//
//  Modifications since Phase II: Added slap ability to cheat detection.
//                                
//********************************************************************/

/*   SPELL ID's

    1 - Slap - Cheater Move
    2 - Attack
    3 - Slash
    4 - Kick
    5 - Heal (Special)
    6 - Staff
    7 - Fireball
    8 - Curse
    9 - Claw
    10 - Wand
    11 - Slam (Special)
*/
package Rastellini2;


public class Spells {
    
    public Spells(){
        
    }
    
    private static int rng(int minnum, int maxnum){
        int randomnumber = (int)(Math.random()*(maxnum+1-minnum))+ minnum;
    return randomnumber;   
    }
    
    // Spell Name list.
    public static String getSpellName(int spellID){
        
        // Create a string placeholder
        String temp = "";
        
        switch(spellID){
            case 1: temp = "Slap";
            break;
            case 2: temp = "Attack";
            break;
            case 3: temp = "Slash";
            break;
            case 4: temp = "Kick";
            break;
            case 5: temp = "Heal";
            break;
            case 6: temp = "Staff";
            break;
            case 7: temp = "Fireball";
            break;
            case 8: temp = "Curse";
            break;
            case 9: temp = "Claw";
            break;
            case 10: temp = "Wand";
            break;
            case 11: temp = "Slam";
            break;
        }
    return temp;
    }
    public void cast(Graphics display, Player player, Player enemy, int spellID) throws InterruptedException{
        
        // Clear our combat messages before we cast spells.
        display.clearCombat();
        
        // If our player's attack was a successful or our user casted a special.
        if(player.attackCheck(player) || spellID == player.specialAbility){
            
            // Animate our player.
            display.setAnimate(display, player, player.getPlayerNumber());
            
            // Cast our spell based on our spell ID.
            switch(spellID){
                
                case 1: this.slap(display, player, enemy);
                break;
                
                case 2: this.attack(display, player, enemy);
                break;

                case 3: this.slash(display, player, enemy);
                break;

                case 4: this.kick(display, player, enemy);
                break;

                case 5: this.heal(display, player, enemy);
                break;

                case 6: this.staff(display, player, enemy);
                break;

                case 7: this.fireball(display, player, enemy);
                break;

                case 8: this.curse(display, player, enemy);
                break;
                
                case 9: this.claw(display, player, enemy);
                break;
                
                case 10: this.wand(display, player, enemy);
                break;
                
                case 11: this.slam(display, player, enemy);
                break;
            }
        }
        else{
            display.setCombat("             " + player.getName() + " MISSED!",0);
            player.setPlayerTurn(false);
            enemy.setPlayerTurn(true);
        }
    }
     
    // SPELL ID # 1
    public void slap(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,1);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + " slaps " + enemy.getName() + " like a cheater for " + player.getDamage() + " damage!");
        break;
        default: display.setDialogue(display, player.getName() + " slaps " + enemy.getName() + " like a cheater for " + player.getDamage() + " damage!");
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
        
        
    }// End Attack
    
    // SPELL ID # 2
    public void attack(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, "BAM! " + player.getName() + " gorilla gunked " + enemy.getName() + " for " + player.getDamage() + " damage!");
        break;

        case 2: display.setDialogue(display, player.getName() + " punched " + enemy.getName() + " square in the face for " + player.getDamage() + " damage. Ouch!");
        break;

        case 3: display.setDialogue(display, player.getName() + " savagely attacks " + enemy.getName() + " for " + player.getDamage() + " damage!");
        break;

        default: display.setDialogue(display, player.getName() + " unleashes some move called \"The Tennessee Twizzler\" for " + player.getDamage() + " damage.");
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
        
        
    }// End Attack
    
    // SPELL ID # 3
    public void slash(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + " slashes violently at " + enemy.getName() + " for " + player.getDamage() + " damage.");
        break;
        
        case 2: display.setDialogue(display, "With a deathly look in his eye. " + player.getName() + " slashes at " + enemy.getName() + " for " + player.getDamage() + " damage.");
        break;
        
        default: display.setDialogue(display, enemy.getName() + " cries out in pain as " + player.getName() + " slash's him for " + player.getDamage() + " damage.");
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
        
    }// End Slash
    
    // SPELL ID # 4
    public void kick(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + "'s shoe flew off while trying to kick " + enemy.getName() + " but struck him anyway for " + player.getDamage() + ". ");
        break;

        case 2: display.setDialogue(display, player.getName() +" kicked " + enemy.getName() + " in the shin for " + player.getDamage() + " damage!");
        break;

        default: display.setDialogue(display, enemy.getName() + " cries out in pain as " + player.getName() + " slash's him for " + player.getDamage() + " damage.");
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
    }// End Kick
    
    
    
    // SPELL ID # 5 -- SPECIAL ABILITY
    public void heal(Graphics display, Player player, Player enemy){
        
        //************************* Healing ****************************//

        if(player.getSpecialCount() <= 0){
            display.setDialogue(display, player.getName() + " is out of Heals. Only 3 allowed per round !!");
            
        }else{
        
        // Generate a number to give our healing potion that scales base on level.
        int heal = rng(100,150) + (player.getLevel()*20);

        // Catch any overhealing so we dont go over our max health.
        if ((player.getHitPoints()+heal) > player.getMaxHealth()){
            heal = player.getMaxHealth() - player.getHitPoints();

        }
        // Add the potion effect to the players health
        player.setHitPoints(player.getHitPoints() + heal);
        
        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){
        // Update our dialogue to let user know they used a heal potion.
            case 1: display.setDialogue(display, player.getName() + " beams with light as he heals for " + heal + " health!");
            break;
            case 2: display.setDialogue(display, "Light surrounds " + player.getName() + " as he heals for " + heal + ".");
            break;
            default: display.setDialogue(display, "Light surrounds " + player.getName() + " as he heals for " + heal + ".");
            break;
        }
        // Remove a an item from the players quantity.
        player.setSpecialCount((player.getSpecialCount()) - 1);
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
        
        }
    }
    
    // SPELL ID # 6
    public void staff(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, "BAM! " + player.getName() + " gorilla gunked " + enemy.getName() + " for " + player.getDamage() + " damage!");
        break;

        case 2: display.setDialogue(display, player.getName() + " staffs " + enemy.getName() + " square in the face for " + player.getDamage() + " damage. Ouch!");
        break;

        case 3: display.setDialogue(display, player.getName() + " swings around his staff like a madman and attacks " + enemy.getName() + " for " + player.getDamage() + " damage!");
        break;
       
        case 4: display.setDialogue(display, player.getName() + " slams his staff into " + enemy.getName() + "'s toe for " + player.getDamage() + " damage!"); 
        break;
        
        default: display.setDialogue(display, player.getName() + " slams his staff into " + enemy.getName() + "'s toe for " + player.getDamage() + " damage!"); 
        break;
        }
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        }  
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
    }// End Staff
    
    // SPELL ID # 7
    public void fireball(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + " slowly gathers energy from around him before casting a flame nova at " + enemy.getName() + " for " + player.getDamage() + " damage!"); 
        break;

        case 2: display.setDialogue(display, player.getName() + " launches an explosive fireball at " + enemy.getName() + " for " + player.getDamage() + " damage."); 
        break;

        case 3: display.setDialogue(display, player.getName() + " introduced his balls of fire to " + enemy.getName() + "'s face for " + player.getDamage() + " damage."); 
        break;
        
        default: display.setDialogue(display, player.getName() + " introduced his balls of fire to " + enemy.getName() + "'s face for " + player.getDamage() + " damage."); 
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
    }// End Fireball
    
    // SPELL ID # 8
    public void curse(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + " launches a sickening curse at " + enemy.getName() + "'s face for " + player.getDamage() + " damage."); 
        break;

        case 2: display.setDialogue(display, player.getName() + " mumbles something at " + enemy.getName() + " and hits him for " + player.getDamage() + " damage."); 
        break;

        default: display.setDialogue(display, player.getName() + " mumbles something at " + enemy.getName() + " and hits him for " + player.getDamage() + " damage."); 
        break;
        }
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        }
        
       // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
    }// End Curse
    
    // SPELL ID # 9
    public void claw(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + " claws at his opponent for " + player.getDamage() + " damage!");
        break;

        default: display.setDialogue(display, player.getName() + " claws at his opponent for " + player.getDamage() + " damage!");
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
        
        
    }// End Claw
    
    // SPELL ID # 10
    public void wand(Graphics display, Player player, Player enemy){
        
        // Generate some fresh damage for our attack.
        player.setDamage(rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)));
        
        boolean crit = player.critCheck(player);
        
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",4);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,4);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + " wands her opponent for " + player.getDamage() + " damage!");
        break;
        
        case 2: display.setDialogue(display, "Sparks erupt from " + player.getName() + "'s wand as she strikes down " + enemy.getName() + " for " + player.getDamage() + " damage!");
        break;

        case 3: display.setDialogue(display, "With a sudden flash of light, " + player.getName() + " wands " + enemy.getName() + " for " + player.getDamage() + " damage!");
        break;
        
        case 4: display.setDialogue(display, player.getName() + " raises her wand to strike but pauses, then runs up and smacks " + enemy.getName() + " in the face for " + player.getDamage() + " damage!");
        break;
        
        default: display.setDialogue(display, player.getName() + " claws at his opponent for " + player.getDamage() + " damage!");
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
        
    }// End Wand
    
    // SPELL ID # 11
    public void slam(Graphics display, Player player, Player enemy){
        
        // Slam damage increase. Percentage based.
        final double SLAM_INCREASE = 2.2;
        
        // Generate some fresh damage for our attack.
        player.setDamage((int) (rng((player.getMainStat()*9)/10, ((player.getMainStat()*11)/10)) * SLAM_INCREASE));
        
        
        boolean crit = player.critCheck(player);
        if (crit){
            // Double our players damage
            player.setDamage(player.getDamage() * 2);
            // Set our dialogue on screen to show we scored a critical strike.
            display.setCombat("CRITICAL STRIKE!!",3);
            }

        // Subtract players damage from the enemy
        enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

        // Generate a random number for our players dialogue.
        int Dialogue = rng(1,2);

        // Decide what our players dialogue response is.
        switch(Dialogue){

        case 1: display.setDialogue(display, player.getName() + " SLAMMED " + enemy.getName() + " for " + player.getDamage() + " damage.");
        break;
        
        default: display.setDialogue(display, player.getName() + " SLAMMED " + enemy.getName() + " for " + player.getDamage() + " damage.");
        break;
        }
        // Remove our crit modifier if we scored a critical strike
        if (crit){
           int digTemp = player.getDamage();
           player.setDamage(digTemp /= 2);
        } 
        // Remove a an item from the players quantity.
        player.setSpecialCount((player.getSpecialCount()) - 1);
        
        // Set player turns after successful attack.
        player.setPlayerTurn(false);
        enemy.setPlayerTurn(true); 
        
        // Refresh our players stats to the screen.
        display.refreshPlayer(player,player.getPlayerNumber());
        display.refreshPlayer(enemy,enemy.getPlayerNumber());
        
    }// End Slam
}
