
/**
 * How the enemies work, and how combat works.
 * 
 * @author  Eric Krawczyk
 * @version 1.0
 */
import java.io.*;
import java.util.*;
public class Enemy
{
public Enemy(String nm, int h, int atk)
{
    name = nm;
    hp = h;
    attack = atk;
}
public void fight()
{
    int totalstrength = MainMenu.strength + MainMenu.bonusstrength;
    hp = hp - totalstrength;
    System.out.println("You hit " + Enemy.name + " for " + totalstrength + " damage!");
    System.out.println("");
    if(hp <= 0){
    System.out.println("You have defeated " + Enemy.name + "!");
        if(name != "Krow"){
            MainMenu.moveon = true;
            MainMenu.combat = false;
                if(MainMenu.bloodscroll == true){
                    System.out.println("You feel a little stronger");
                    MainMenu.strength = MainMenu.strength + 1;
                }
        }
        else { //THE GOOD END
            System.out.println("Krow falls to the ground, his staff snapping in half. He runs out of the opening where the door used to be. You try to stop him, but he throws the crown at you.");
            System.out.println("The crown releases the Original King in front of you. He looks suprised, but is happy to be out of the crown.");
            System.out.println("When the guards searched for him, all they found was that his spells were broken and the unknown dungeon was replaced with the regular dungeon, save for the fact that the prisoners were missing.");
            System.out.println("The king, after careful observation, cautiously puts on his crown. They have a feast in your honor, and are welcome in the castle anytime.");
            MainMenu.gameover = true;
        }
        if(name == "Mimic"){
            System.out.println("A scroll appears that reads \"BloodScroll: Every enemy you defeat will make you slightly stronger. Weapon changes and other things may cause you to lose strength gained this way.\"");
            System.out.println("It flies into your chest, and you somehow absorb it.");
            MainMenu.bloodscroll = true;
        }
        if(name == "King Arthur's Golemn"){
            System.out.println("The golemn drops it's sword, which you take. You realize that it is the Excalibur! You pick up the blade.");
            MainMenu.excalibur = true;
            MainMenu.strength = 10;
        }
        if(name == "Ogre"){
            System.out.println("The ogre dissapears, absorbed by the triangular gold piece. You take it and feel much stronger.");
            MainMenu.Power = true;
            MainMenu.bonusstrength = 5;
        }
        if(name == "Thief"){
            System.out.println("Before the final blow was struck, he tore open his pack of items, plunging them into your hands. Your goodwill is strong, so you let him return to the corner of the room, as he has undone the deeds he did to you.");// Samurai Jack Reference
            MainMenu.dagger = true;
            MainMenu.sword = true;
            MainMenu.strength = 3;
        if(MainMenu.oncecalibur = true){
            MainMenu.excalibur = true;
            MainMenu.strength = 10;
        }
        }
        if(name == "Wizard-King Krow"){
            System.out.println("When you defeat Krow, he falls to the ground and dissapears. You realize that this was an illusion!");
        }
    }
    else{
    if(Enemy.name == "Krow"){ // Final Boss Fight
    Random krow = new Random();
    attack = 1 + krow.nextInt(10);
    if(attack == 1){
    System.out.println("Krow strikes you with his staff.");
    MainMenu.health = MainMenu.health + MainMenu.defense + MainMenu.bonusdefense - attack;
    }
    else if(attack == 2){
    System.out.println("Krow launches magic missiles at you!");
    Random missile = new Random();
    int missiles = 1 + missile.nextInt(3);
    MainMenu.health = MainMenu.health + MainMenu.defense + MainMenu.bonusdefense - missiles;
    }
    else if(attack == 3){
    System.out.println("Krow launches a small fireball at you!");
    MainMenu.health = MainMenu.health + MainMenu.defense + MainMenu.bonusdefense - attack;
    }
    else if(attack == 4){
    System.out.println("Krow heals himself a little!");
    hp = hp + 1;
    }
    else if(attack == 5){
    System.out.println("Krow creates a small vortex, damaging both of you as you smash into things.");
    MainMenu.health = MainMenu.health - attack + MainMenu.defense + MainMenu.bonusdefense;
    hp = hp - attack;
    }
    else if(attack == 6){
    System.out.println("Uses a spell to make you hit yourself!");
    MainMenu.health = MainMenu.health - totalstrength + MainMenu.defense;
    }
    else if(attack == 7){
    System.out.println("Disarms you with a spell, tossing the weapons out of your reach.");
    MainMenu.dagger = false;
    MainMenu.sword = false;
    if(MainMenu.excalibur == true){
    MainMenu.excalibur = false;
    MainMenu.oncecalibur = true;
    }
    if(MainMenu.MastersBlade == true){
        System.out.println("However, his magic is ineffective on the Enchanted Sword. He stares at the sword carefully, but resumes fighting.");
    }
    else{
        MainMenu.strength = 1;
    }
    }
    else if(attack == 8){
    System.out.println("Yells for the guards to get you, but they are too frightened.");
    }
    else if(attack == 9){
    System.out.println("Laughs, and you realized he dodged your attack!");
    hp = hp + MainMenu.strength;
    }
    else if(attack == 10){
    System.out.println("Krow strikes you with lightning!");
    MainMenu.health = MainMenu.health - attack + MainMenu.defense + MainMenu.bonusdefense;
    }
    }
    else{
    System.out.println(Enemy.name + " hit you for " + (attack - MainMenu.defense - MainMenu.bonusdefense) + " damage!");
    MainMenu.health = MainMenu.health - attack + MainMenu.defense + MainMenu.bonusdefense;
    }
    if(MainMenu.health <= 0){
    System.out.println(Enemy.name + " lands a fatal blow. You die, but at least you died fighting.");
    MainMenu.gameover = true;
    }
    else{
    System.out.println("");
    System.out.println("You have " + MainMenu.health + " health left!");
    }
    }
    }
public static String name;
public int hp;
public int attack;
}
