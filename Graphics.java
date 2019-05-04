/********************************************************************
//  Graphics.java       Author: Snubiss
//
//  Date: November 12, 2018
//  Modified: December 8, 2018
//
//  Defines the instance data, constructors and associated
//  methods of a the screen display/graphics of our game. This class
//  is responsible to keeping track of the game-state of our game and
//  displaying it to the user in a friendly manner.
//
//  Modifications since Phase II: Code cleanup.
//                                Added game complete screen to the game.
//
//********************************************************************/

package Rastellini2;
import java.util.concurrent.TimeUnit;


public class Graphics {
    
    // Initiate all the variables needed for our graphical display.
    
    String[] p1Image = new String[26];
    String[] p2Image = new String[26];
    String[] p1Abilities = new String[4];
    String[] p2Abilities = new String[4];
    final String[] helpScreen = new String[20];
    final String[] combat = new String[6];
    final String[] sysMessage = new String[2];
    final String[] p1Hotkey = new String[4];
    final String[] p2Hotkey = new String[4];
    String p1MainStatName;
    String p2MainStatName;
    String p1Name;
    String p2Name;
    String p1ClassName; 
    String p2ClassName; 
    int p1Level;
    int p2Level;
    int p1HitPoints;
    int p2HitPoints;
    int p1MaxHealth;
    int p2MaxHealth;
    int p1MainStat;
    int p2MainStat;
    int p1CritChance;
    int p2CritChance;
    int p1HitChance;
    int p2HitChance;
    int p1SpecialCount;
    int p2SpecialCount;
    String screenDisplay;
    
    
    
public final void screen(int menu){
    
    // Clear some screen space
    System.out.println ("\n\n\n\n\n");
    
    // This is a menu switch. We tell it what menu board we want based on a number we give it.
    switch(menu){

        case 1: screenDisplay =
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-10s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", combat[0])) + "\n" +
                (String.format("%-10s%10s","", "                                                                                                        |\\                     /)")) + "\n" +
                (String.format("%-10s%10s","", "                                                                                                      /\\_\\\\__               (_//")) + "\n" +
                (String.format("%-10s%10s","", "                                                                                                     |   `>\\-`     _._       //`)")) + "\n" +
                (String.format("%-10s%10s","", " ___                                                          _        _____                          \\ /` \\\\  _.-`:::`-._  //")) + "\n" +
                (String.format("%-10s%10s","", "(  _`\\                                                       ( )      (  _  )              _  _        `    \\|`    :::    `|/")) + "\n" +
                (String.format("%-10s%10s","", "| | ) | _   _   ___     __     __     _     ___    ___     __| |__    | (_) |  ___    ___ (_)(_)             |     :::     |")) + "\n" +
                (String.format("%-10s%10s","", "| | | )( ) ( )/' _ `\\ /'_ `\\ /'__`\\ /'_`\\ /' _ `\\/',__)   (__   __)   |  _  |/',__) /'___)| || |             |.....:::.....|")) + "\n" +
                (String.format("%-10s%10s","", "| |_) || (_) || ( ) |( (_) |(  ___/( (_) )| ( ) |\\__, \\      | |      | | | |\\__, \\( (___ | || |             |:::::::::::::|")) + "\n" +
                (String.format("%-10s%10s","", "(____/'`\\___/'(_) (_)`\\__  |`\\____)`\\___/'(_) (_)(____/      (_)      (_) (_)(____/`\\____)(_)(_)             \\     :::     /")) + "\n" +
                (String.format("%-10s%10s","", "                     ( )_) |                                                                                  \\    :::    /")) + "\n" +
                (String.format("%-10s%10s","", "                      \\___/'                                                                                   `-. ::: .-'")) + "\n" +
                (String.format("%-10s%10s","", "                                                                                                                //`:::`\\\\")) + "\n" +
                (String.format("%-10s%10s","", "                                                                                                               //   '   \\\\")) + "\n" +
                (String.format("%-10s%10s","", "                                                                                                              |/         \\|")) + "\n" +
                (String.format("%-25s%1s","", sysMessage[0])) + "\n" +
                (String.format("%-35s%1s","", sysMessage[1])) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%1s","", combat[1])) + "\n" +
                (String.format("%-45s%1s","", combat[2])) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n";
                System.out.print(screenDisplay);
        break;

        case 2: screenDisplay =
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "      _,.", "", "              _,._      ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "    ,` -.)","","  .||,       /_ _\\\\     ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "   ( _/-\\\\-._",""," \\.`',/      |'L'| |    ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "  /,|`--._,-^|            ,",""," = ,. =      | -,| L    ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "  \\_| |`-._/||          ,'|",""," / || \\    ,-'\\\"/,'`.   ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "    |  `-, / |         /  /","","   ||     ,'   `,,. `.  ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "    |     || |        /  /","","   ,|____,' , ,;' \\| |  ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "     `r-._||/   __   /  /","","  (3|\\    _/|/'   _| |  ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", " __,-<_     )`-/  `./  /","","   ||/,-''  | >-'' _,\\\\ ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "'  \\   `---'   \\   /  /","","   ||'      ==\\ ,-'  ,' ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "    |           |./  /","","   ||       |  V \\ ,|   ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "    /           //  /","","   ||       |    |` |   ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "\\_/' \\         |/  /","","   ||       |    |   \\  ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", " |    |   _,^-'/  /","","   ||       |    \\    \\ ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", " |    , ``  (\\/  /_","(A)lien","   ||       |     |    \\")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "  \\,.->._    \\X-=/^","(D)ragon","   ||       |      \\_,-'")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "  (  /   `-._//^`","(K)night","   ||       |___,,--\")_\\")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "   `Y-.____(__]","(W)izard","   ||         |_|   ccc/")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "    |     {__)","(F)airy","   ||        ccc/       ")) + "\n" +
                (String.format("%-18s%-45s%-30s%1s","", "          ()","","   ||                ")) + "\n" +
                (String.format("%-25s%-75s%1s","", "", "")) + "\n" +
                (String.format("%-25s%1s","", "")) + "\n" +
                (String.format("%-25s%1s","", sysMessage[0])) + "\n" +
                (String.format("%-35s%1s","", sysMessage[1])) + "\n" +
                (String.format("%-45s%10s","", "")) + "\n" +
                (String.format("%-55s%1s","", combat[0])) + "\n" +
                (String.format("%-55s%1s","", combat[1])) + "\n";
                System.out.print(screenDisplay);
        break;
        
        case 3:screenDisplay =
                (String.format("%-150s", "\n***************************************************************************************************************************************************")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[0], " ", "*", p2Image[0], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[1], " ", "*", p2Image[1], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[2], " ", "*", p2Image[2], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[3], " ", "*", p2Image[3], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[4], " ", "*", p2Image[4], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[5], " ", "*", p2Image[5], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[6], " ", "*", p2Image[6], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[7], " ", "*", p2Image[7], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[8], " ", "*", p2Image[8], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[9], " ", "*", p2Image[9], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[10], " ", "*", p2Image[10], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[11], " ", "*", p2Image[11], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[12], " ", "*", p2Image[12], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[13], " ", "*", p2Image[13], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[14], " ", "*", p2Image[14], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[15], " ", "*", p2Image[15], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[16], " ", "*", p2Image[16], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[17], " ", "*", p2Image[17], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[18], " ", "*", p2Image[18], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[19], " ", "*", p2Image[19], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[20], " ", "*", p2Image[20], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[21], " ", "*", p2Image[21], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[22], " ", "*", p2Image[22], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[23], " ", "*", p2Image[23], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[24], " ", "*", p2Image[24], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[25], " ", "*", p2Image[25], "*")) + "\n" +
                (String.format("%-150s", "***************************************************************************************************************************************************")) + "\n" +
                (String.format("%-8s%-24s%-6s%-9s%-43s%-10s%-28s%-6s%-9s%-1s", "*  Name: ", p1Name,"Class: ",p1ClassName,  "* " + combat[0], "*  Name: ", p2Name, "Class: ", p2ClassName, "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "* " + combat[1],"*", "*")) + "\n" +
                (String.format("%-13s%-11s%-12s%-8s%-5s%-43s%-15s%-11s%-12s%-8s%-8s%-1s", "*  Level", "Health", p1MainStatName, "Crit", "Hit",  "* " + combat[2], "*  Level", "Health", p2MainStatName, "Crit", "Hit", "*")) + "\n" +
                (String.format("%-4s%-9s%-14s%-10s%-7s%-5s%-43s%-4s%-11s%-14s%-10s%-7s%-8s%-1s", "* ", p1Level, + p1HitPoints+"/"+p1MaxHealth, p1MainStat, p1CritChance+"%", p1HitChance+"%", "* " + combat[3], "*", p2Level, + p2HitPoints+"/"+p2MaxHealth, p2MainStat, p2CritChance+"%", p2HitChance+"%", "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "* " + combat[4],"*", "*")) + "\n" +
                (String.format("%-20s%-29s%-43s%-20s%-34s%-1s", "*", "Action Bar", "* " + combat[5], "*", "Action Bar", "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "*","*", "*")) + "\n" +
                (String.format("%-15s%-12s%-10s%-12s%-43s%-15s%-14s%-12s%-13s%-1s", "*  " + p1Hotkey[0] + ":" + p1Abilities[0], p1Hotkey[1] + ":" +p1Abilities[1], p1Hotkey[2] + ":" + p1Abilities[2], p1Hotkey[3] + ":" + p1Abilities[3], "* " + sysMessage[0], "*  " + p2Hotkey[0] + ":" + p2Abilities[0], p2Hotkey[1] + ":" + p2Abilities[1], p2Hotkey[2] + ":" + p2Abilities[2], p2Hotkey[3] + ":" + p2Abilities[3], "*")) + "\n" +
                (String.format("%-15s%-34s%-43s%-15s%-39s%-1s", "*  Q:Quit", "I:Help","* " + sysMessage[1], "*  Q:Quit", "I:Help","*")) + "\n" +
                (String.format("%-150s", "***************************************************************************************************************************************************")) + "\n"
                ;
                System.out.print(screenDisplay);
        break;
        
        case 4:screenDisplay =
                (String.format("%-150s", "\n***************************************************************************************************************************************************")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "General: ", " ", "*", "General: ", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", helpScreen[0], " ", "*", helpScreen[9], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "(" +helpScreen[1]+")", " ", "*", "(" +helpScreen[10]+")", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", helpScreen[2], " ", "*", helpScreen[11], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "(" +helpScreen[3]+")", " ", "*","(" +helpScreen[12]+")", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", helpScreen[4], " ", "*", helpScreen[13], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "(" +helpScreen[5]+")", " ", "*","(" +helpScreen[14]+")", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", helpScreen[6], " ", "*", helpScreen[15], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "(" +helpScreen[7]+")", " ", "*","(" +helpScreen[16]+")", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", helpScreen[8], " ", "*", helpScreen[17], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", "", " ", "*", "", "*")) + "\n" +
                (String.format("%-150s", "***************************************************************************************************************************************************")) + "\n" +
                (String.format("%-8s%-24s%-6s%-9s%-43s%-10s%-28s%-6s%-10s%-1s", "*  Name: ", p1Name,"Class: ",p1ClassName,  "* This screen will be displayed for the", "*  Name: ", p2Name, "Class", p2ClassName, "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "* next 15 seconds.","*", "*")) + "\n" +
                (String.format("%-13s%-11s%-12s%-8s%-5s%-43s%-15s%-11s%-12s%-8s%-8s%-1s", "*  Level", "Health", p1MainStatName, "Crit", "Hit",  "* ", "*  Level", "Health", p2MainStatName, "Crit", "Hit", "*")) + "\n" +
                (String.format("%-4s%-9s%-14s%-10s%-7s%-5s%-43s%-4s%-11s%-14s%-10s%-7s%-8s%-1s", "* ", p1Level, + p1HitPoints+"/"+p1MaxHealth, p1MainStat, p1CritChance+"%", p1HitChance+"%", "* ", "*", p2Level, + p2HitPoints+"/"+p2MaxHealth, p2MainStat, p2CritChance+"%", p2HitChance+"%", "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "* " + combat[4],"*", "*")) + "\n" +
                (String.format("%-20s%-29s%-43s%-20s%-34s%-1s", "*", "Action Bar", "* " + combat[5], "*", "Action Bar", "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "*","*", "*")) + "\n" +
                (String.format("%-13s%-14s%-10s%-12s%-43s%-15s%-14s%-12s%-13s%-1s", "*  " + p1Hotkey[0] + ":" + p1Abilities[0], p1Hotkey[1] + ":" +p1Abilities[1], p1Hotkey[2] + ":" + p1Abilities[2], p1Hotkey[3] + ":" + p1Abilities[3], "*          --- Help Screen ---", "*  " + p2Hotkey[0] + ":" + p2Abilities[0], p2Hotkey[1] + ":" + p2Abilities[1], p2Hotkey[2] + ":" + p2Abilities[2], p2Hotkey[3] + ":" + p2Abilities[3], "*")) + "\n" +
                (String.format("%-13s%-36s%-43s%-15s%-39s%-1s", "*  Q:Quit", "I:Help","*                 PAUSED", "*  Q:Quit", "I:Help","*")) + "\n" +
                (String.format("%-150s", "***************************************************************************************************************************************************")) + "\n"
                ;
                System.out.print(screenDisplay);
        break;
        
        case 5:screenDisplay =
                (String.format("%-150s", "\n***************************************************************************************************************************************************")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[0], " ", "*", p2Image[0], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[1], " ", "*", p2Image[1], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[2], " ", "*", p2Image[2], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[3], " ", "*", p2Image[3], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[4], " ", "*", p2Image[4], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[5], " ", "*", p2Image[5], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-73s%-1s","*", p1Image[6], " ", "*", p2Image[6], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[7], " ", "*", p2Image[7], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[8], " ", "*", p2Image[8], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[9], " ", "*", p2Image[9], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[10], " ", "*", p2Image[10], "*")) + "\n" +
                (String.format("%-150s", "             ______ _______ _______ _______ ______ _______ _______ _______ _____   _______ _______ _______ _______ _______ _______           ")) + "\n" +     
                (String.format("%-150s", "            |      |       |    |  |     __|   __ \\   _   |_     _|   |   |     |_|   _   |_     _|_     _|       |    |  |     __|          ")) + "\n" + 
                (String.format("%-150s", "            |   ---|   -   |       |    |  |      <       | |   | |   |   |       |       | |   |  _|   |_|   -   |       |__     |          ")) + "\n" + 
                (String.format("%-150s", "            |______|_______|__|____|_______|___|__|___|___| |___| |_______|_______|___|___| |___| |_______|_______|__|____|_______|          ")) + "\n" + 
                (String.format("%-150s", " ___ ___ _______ _______      ______ _______ _______ _______      _______ _______ _______      _______ _______ _______ _______      __ __ __ ")) + "\n" + 
                (String.format("%-150s", "|   |   |       |   |   |    |   __ \\    ___|   _   |_     _|    |_     _|   |   |    ___|    |     __|   _   |   |   |    ___|    |  |  |  |")) + "\n" + 
                (String.format("%-150s", " \\     /|   -   |   |   |    |   __ <    ___|       | |   |        |   | |       |    ___|    |    |  |       |       |    ___|    |__|__|__|")) + "\n" + 
                (String.format("%-150s", "  |___| |_______|_______|    |______/_______|___|___| |___|        |___| |___|___|_______|    |_______|___|___|__|_|__|_______|    |__|__|__|")) + "\n" + 
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[19], " ", "*", p2Image[19], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[20], " ", "*", p2Image[20], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[21], " ", "*", p2Image[21], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[22], " ", "*", p2Image[22], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[23], " ", "*", p2Image[23], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[24], " ", "*", p2Image[24], "*")) + "\n" +
                (String.format("%-2s%-68s%-1s%-2s%-72s%-1s","*", p1Image[25], " ", "*", p2Image[25], "*")) + "\n" +
                (String.format("%-150s", "***************************************************************************************************************************************************")) + "\n" +
                (String.format("%-8s%-24s%-6s%-9s%-43s%-10s%-28s%-6s%-9s%-1s", "*  Name: ", p1Name,"Class: ",p1ClassName,  "* " + combat[0], "*  Name: ", p2Name, "Class: ", p2ClassName, "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "* " + combat[1],"*", "*")) + "\n" +
                (String.format("%-13s%-11s%-12s%-8s%-5s%-43s%-15s%-11s%-12s%-8s%-8s%-1s", "*  Level", "Health", p1MainStatName, "Crit", "Hit",  "* " + combat[2], "*  Level", "Health", p2MainStatName, "Crit", "Hit", "*")) + "\n" +
                (String.format("%-4s%-9s%-14s%-10s%-7s%-5s%-43s%-4s%-11s%-14s%-10s%-7s%-8s%-1s", "* ", p1Level, + p1HitPoints+"/"+p1MaxHealth, p1MainStat, p1CritChance+"%", p1HitChance+"%", "* " + combat[3], "*", p2Level, + p2HitPoints+"/"+p2MaxHealth, p2MainStat, p2CritChance+"%", p2HitChance+"%", "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "* " + combat[4],"*", "*")) + "\n" +
                (String.format("%-20s%-29s%-43s%-20s%-34s%-1s", "*", "Action Bar", "* " + combat[5], "*", "Action Bar", "*")) + "\n" +
                (String.format("%-49s%-43s%-54s%-1s","*", "*","*", "*")) + "\n" +
                (String.format("%-15s%-12s%-10s%-12s%-43s%-15s%-14s%-12s%-13s%-1s", "*  " + p1Hotkey[0] + ":" + p1Abilities[0], p1Hotkey[1] + ":" +p1Abilities[1], p1Hotkey[2] + ":" + p1Abilities[2], p1Hotkey[3] + ":" + p1Abilities[3], "* " + sysMessage[0], "*  " + p2Hotkey[0] + ":" + p2Abilities[0], p2Hotkey[1] + ":" + p2Abilities[1], p2Hotkey[2] + ":" + p2Abilities[2], p2Hotkey[3] + ":" + p2Abilities[3], "*")) + "\n" +
                (String.format("%-15s%-34s%-43s%-15s%-39s%-1s", "*  Q:Quit", "I:Help","* " + sysMessage[1], "*  Q:Quit", "I:Help","*")) + "\n" +
                (String.format("%-150s", "***************************************************************************************************************************************************")) + "\n"
                ;
                System.out.print(screenDisplay);

        break;
    }
}

// Update the players name.
public void setPlayerName(String data, int playerNumber){
    switch(playerNumber){
        case 1: p1Name = data;
        break;
        case 2: p2Name = data;
        break;
    }
}
// Get the players name.
public String getPlayerName(int playerNumber){
    
    String temp = "";
    switch(playerNumber){
        case 1: temp = p1Name;
        break;
        case 2: temp = p2Name;
        break;
    }
return temp;
}

// ANIMATION IMAGES

// This is a general idle call for all player objects
public void setIdle(Player player, int playerNumber){
    
    switch(playerNumber){
        case 1:p1Image = player.getIdle();
        break;
        case 2:p2Image = player.getIdle();
        break;
    }
}

// This is a general animation call for all player objects
public void setAnimate(Graphics display, Player player, int playerNumber) throws InterruptedException{
    
    switch(playerNumber){
    
        case 1:
            display.p1Image = player.getAnimation();
            display.screen(3);
            TimeUnit.SECONDS.sleep(1);
            display.p1Image = player.getIdle();
            display.screen(3);
            TimeUnit.SECONDS.sleep(1);
            display.p1Image = player.getAnimation();
            display.screen(3);
            TimeUnit.SECONDS.sleep(1);
            display.p1Image = player.getIdle();
        break;

        case 2:
            display.p2Image = player.getAnimation();
            display.screen(3);
            TimeUnit.SECONDS.sleep(1);
            display.p2Image = player.getIdle();
            display.screen(3);
            TimeUnit.SECONDS.sleep(1);
            display.p2Image = player.getAnimation();
            display.screen(3);
            TimeUnit.SECONDS.sleep(1);
            display.p2Image = player.getIdle();
        break;
    }    
}
// END ANIMATION

// Update our combat action dialogue to a specific location.
public void setCombat(String Combat,int Location){
    combat[Location] = Combat;
}
// Clear our combat action dialogue.
public void clearCombat(){
    combat[0] = "";
    combat[1] = "";
    combat[2] = "";
    combat[3] = "";
    combat[4] = "";
    combat[5] = "";
}

// The Smart Chopper:
// Sets our dialogue from a single string. Chops it up based on our dialogue boxes length than 
// if our result cuts a word we will display it on the next line.
public void setDialogue(Graphics display, String dialogue){
        
        boolean notTheEnd = false;
        //Desired length you want your text to be cut off at.
        int dialogueLength = 40; 
        String String = (String)(dialogue);
        int cursor = 0;
        
        for (int i = 0; String.length() > 0; i++){
            
            // Place our cursor at the end of our string.
            cursor = String.length();
            // If the string is bigger than our dialogue box. Set the cursor to the spot in our string equal to the length we need.
            if (cursor > dialogueLength){
                // Track whether we are at the end of our string
                notTheEnd = true;
                cursor = dialogueLength-1;
            }
            else{
                notTheEnd = false;
            }
            // Check the last char in our string to see if it's a period or space.
            if(String.charAt(cursor-1) != ' ' && String.charAt(cursor-1) != '.' && notTheEnd){
                // No space or period found so let's go backwards through our string till we find a space so we don't break words.
                while (String.charAt(cursor) != ' '){
                    // Back it up boys
                    cursor--;
                }
                // Cursor location is on a space char so let's move forward one and store our data from there.
                cursor++;
                display.setCombat(String.substring(0,cursor),i);      
            }
            else{
            display.setCombat(String.substring(0,cursor),i);
            }
            if (String.length() > 0){
            String = String.substring(cursor, String.length());
            }
        }
        
    }
// Update our system messages board. Bottom 2 spots on dialogue screen (can be moved later)
public void setSysMessage(String data,int Location){
    sysMessage[Location] = data;
}


// Refresh all the players stats to the display. WITH A PLAYER OBJECT AND IT'S NUMBER.
public void refreshPlayer(Player player, int playerNumber){

    switch(playerNumber){

    case 1:
        p1Name = player.name;
        p1ClassName = player.getClassRole();
        p1Level = player.getLevel();
        p1HitPoints = player.getHitPoints();
        p1MaxHealth = player.getMaxHealth();
        p1MainStatName = player.getMainStatName();
        p1MainStat = player.getMainStat();
        p1CritChance = player.getCritChance();
        p1HitChance = player.getHitChance();
        p1SpecialCount = player.getSpecialCount();
        System.arraycopy(player.ABILITIES, 0, p1Abilities, 0, p1Hotkey.length);
        for(int i = 0; i < p1Hotkey.length; i++){
            p1Hotkey[i] = String.valueOf(player.HOTKEY[i]);
        }
        for (int i = 0; i < p1Abilities.length; i++){
            if (player.ABILITIESID[i] == player.specialAbility){
                p1Abilities[i] = player.ABILITIES[i] + " - " + player.specialCount;
            }
        }
        
    break;
    case 2:
        p2Name = player.getName();
        p2ClassName = player.getClassRole();
        p2Level = player.getLevel();
        p2HitPoints = player.getHitPoints();
        p2MaxHealth = player.getMaxHealth();
        p2MainStatName = player.getMainStatName();
        p2MainStat = player.getMainStat();
        p2CritChance = player.getCritChance();
        p2HitChance = player.getHitChance();
        p2SpecialCount = player.getSpecialCount();
        System.arraycopy(player.ABILITIES, 0, p2Abilities, 0, p2Hotkey.length);
        for(int i = 0; i < p2Hotkey.length; i++){
            p2Hotkey[i] = String.valueOf(player.HOTKEY[i]);
        }
        for (int i = 0; i < p2Abilities.length; i++){
            if (player.ABILITIESID[i] == player.specialAbility){
                p2Abilities[i] = player.ABILITIES[i] + " - " + player.specialCount;
            }
        }
    break;
    }
 }
// Refresh all the players stats to the display. WITH AN ARRAY OF PLAYERS
public void refreshPlayer(Player[] playerData){

    Player player = playerData[0];
    Player player2 = playerData[1];

    p1Name = player.getName();
    p1ClassName = player.getClassRole();
    p1Level = player.getLevel();
    p1HitPoints = player.getHitPoints();
    p1MaxHealth = player.getMaxHealth();
    p1MainStatName = player.getMainStatName();
    p1MainStat = player.getMainStat();
    p1CritChance = player.getCritChance();
    p1HitChance = player.getHitChance();
    p1SpecialCount = player.getSpecialCount();
    System.arraycopy(player.ABILITIES, 0, p1Abilities, 0, p1Hotkey.length);
    for(int i = 0; i < p1Hotkey.length; i++){
        p1Hotkey[i] = String.valueOf(player.HOTKEY[i]);
    }
    for (int i = 0; i < p1Abilities.length; i++){
        if (player.ABILITIESID[i] == player.specialAbility){
            p1Abilities[i] = player.ABILITIES[i] + " - " + player.specialCount;
        }
    }
    
    p2Name = player2.getName();
    p2ClassName = player2.getClassRole();
    p2Level = player2.getLevel();
    p2HitPoints = player2.getHitPoints();
    p2MaxHealth = player2.getMaxHealth();
    p2MainStatName = player2.getMainStatName();
    p2MainStat = player2.getMainStat();
    p2CritChance = player2.getCritChance();
    p2HitChance = player2.getHitChance();
    p2SpecialCount = player2.getSpecialCount();
    System.arraycopy(player2.ABILITIES, 0, p2Abilities, 0, p2Hotkey.length);
    for(int i = 0; i < p2Hotkey.length; i++){
        p2Hotkey[i] = String.valueOf(player2.HOTKEY[i]);
    }
    for (int i = 0; i < p2Abilities.length; i++){
        if (player2.ABILITIESID[i] == player2.specialAbility){
            p2Abilities[i] = player2.ABILITIES[i] + " - " + player2.specialCount;
        }
    }
}

public void loadHelpScreen(String[] helpData){
    
    System.arraycopy(helpData, 0, helpScreen, 0, helpScreen.length);
}
}