package unknownDungeon;
/**
 * The main class for The Unknown Dungeon
 * 
 * @author Eric Krawczyk
 * @version V.1.1
 */
import java.io.*;
import java.util.*;
public class MainMenu // Recommpiling the program before every run is a bit annoying.
{
	public static void pause(int ms) { // Added in V1.1, allows us to add a delay. Used for game overs, to show the game over message before closing.
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        System.err.format("IOException: %s%n", e);
	    }
	}
	public static void main(String[] args) // Changed in 1.1 to make it runnable as a jar, used to be a method called Start()
      {
        Random roomnumber = new Random( ); // creates our rooms
        int Rooms[] = {0,0,0,0,0,0,0,0,0,0,0};
        int randomroom;
        for(int count = 0; count <= 9; count++)
        {
        randomroom = 1 + roomnumber.nextInt(17);// minimumvalue + (added) =  min to min+added - 1 
        Rooms[count] = randomroom;
        }
        Rooms[10] = 42; // FUN FACT: There are 170 possible room combinations. (10 rooms * 17 possibilities for each room)
        sort(Rooms,0,10);//0,rooms.length - 1
        System.out.println("Welcome to The Unknown Dungeon.");// Introduction
        System.out.println("Crearted by: Eric Krawczyk");
        System.out.println();
        System.out.println("The land is ruled by the evil wizard-king Krow. He had taken over the castle a month ago, after he had trapped the original king in his own crown.");
        System.out.println("Krow used his spells on the kingdom wherever he saw fit, and forced people into doing various tasks for him.");
        System.out.println("Most people were afraid to oppose him, but you felt you had nothing to lose. So, you decided to go to the king and demanded that he stop his evil ways.");
        System.out.println("Krow merely laughed, and used a sleeping spell on you.");
        System.out.println("You woke up on the bottom floor of The Unknown Dungeon, created by Krow.");
        System.out.println("It was built beneath the castle, and is rumored to be enchanted with strange spells and filled with monsters and treasure.");
        String command;
        int currentroom = 0;
        CreateRoom(0);
        System.out.println("For an alternate start, type in your class (Healer, Farmer, Knight, or Blacksmith.) Alternatively, you can move forward without choosing a class."); // CLASS SYSTEM?
        do{
			Scanner textinput = new Scanner(System.in);
            System.out.println();
            System.out.print("What would you like to do? (\"Help\" for commands) : ");
            command = textinput.nextLine();
            System.out.println();
            if(command.equalsIgnoreCase("HELP")){
            System.out.println("Help : Brings up this screen!");
            System.out.println("Inventory : Shows what items are in your inventory and equipped items."); // Not Implemented
            System.out.println("Use [something]: Takes items, uses inventory items, wields equipped weapons & items,  and other minor interactions.");
            System.out.println("Attack: Uses currently equipped weapon on something.");
            System.out.println("Forward : Goes to next room or floor.");
            System.out.println("Look : Examines your current room.");
            System.out.println("Exit : Quits the game.");
            System.out.println("Quit : Exits the game.");
            } //Classes
            else if(command.equalsIgnoreCase("HEALER") & currentroom == 0 & classavailable == true){
            System.out.println("You remembered that you are a healer.");
            bonusdefense = -1;
            dagger = false;
            excalibur = false;
            sword = false;
            health = 10;
            bonushealth = 0;
            strength = 1;
            healthpotion = true;
            ironshield = false;
            }
            else if(command.equalsIgnoreCase("FARMER") & currentroom == 0 & classavailable == true){
            System.out.println("You remembered that you are a farmer.");
            healthpotion = false;
            dagger = true;
            excalibur = false;
            sword = false;
            health = 10;
            bonushealth = 0;
            strength = 2;
            bonusdefense = -1;
            ironshield = false;
            }
            else if(command.equalsIgnoreCase("KNIGHT") & currentroom == 0 & classavailable == true){
            System.out.println("You remembered that you are a knight.");
            sword = true;
            strength = 3;
            bonushealth = -2;
            health = 8;
            healthpotion = false;
            dagger = false;
            excalibur = false;
            ironshield = false;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("BLACKSMITH") & currentroom == 0 & classavailable == true){
            System.out.println("You remembered that you are a blacksmith.");
            sword = false;
            healthpotion = false;
            dagger = false;
            excalibur = false;
            ironshield = true;
            strength = 1;
            bonushealth = -2;
            health = 8;
            defense = 2;
            bonusdefense = 0;
            }
            // SECRET CLASSES
            else if(command.equalsIgnoreCase("ENEMY: KROW") & currentroom == 0 & classavailable == true){
            System.out.println("Krow cheat activated. You are the evil wizard-king, locked in his own dungeon!");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            Random crow = new Random();
            strength = 1 + crow.nextInt(10);
            bonushealth = 10;
            health = 20;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: GOBLIN") & currentroom == 0 & classavailable == true){
            System.out.println("Goblin cheat activated. You are a low-level magically-created creature that wants to escape and destroy it's creator.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 1;
            bonushealth = 0;
            health = 3;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: ZOMBIE") & currentroom == 0 & classavailable == true){
            System.out.println("Zombie cheat activated. You are a magically-created monster that wishes to destroy any nearby life and possibly transform it.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 2;
            bonushealth = 0;
            health = 3;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: GRU") & currentroom == 0 & classavailable == true){
            System.out.println("Gru cheat activated. You are a magically-created beast that comes from another dimension. Fortunately, unlike your kin, you are not hurt by light, and wish to show this to all who stand in your way.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 2;
            bonushealth = 0;
            health = 7;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: GOBLIN") & currentroom == 0 & classavailable == true){
            System.out.println("Goblin cheat activated. You are a low-level magically-created creature that wants to escape and destroy it's creator.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 1;
            bonushealth = 0;
            health = 3;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: MIMIC") & currentroom == 0 & classavailable == true){
            System.out.println("Mimic cheat activated. You are an enchanted chest that wishes to destroy greedy adventurers, though you have grown greedy in destroying things.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 2;
            bonushealth = 0;
            health = 5;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: EVIL MOSQUITO") & currentroom == 0 & classavailable == true){
            System.out.println("Evil Mosquito cheat activated. You are an evil mosquito, created by a magic button, set off to completely destroy everything until only the void and yourself remain.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 1;
            bonushealth = 0;
            health = 1;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: KING ARTHUR'S GOLEMN") & currentroom == 0 & classavailable == true){
            System.out.println("King Arthur's Golemn cheat activated. You are the guardian of the excalibur, although recently you decided to stop waiting and went to find a hero outside of the dungeon.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = true;
            strength = 10;
            bonushealth = 0;
            health = 15;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: YOU") & currentroom == 0 & classavailable == true){
            System.out.println("You cheat activated. You are an evil version of some hero. You defeated them, but now search for new prey.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 1;
            bonushealth = 0;
            health = 10;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: WIZARD-KING KROW") & currentroom == 0 & classavailable == true){
            System.out.println("Wizard-King Krow cheat activated. You are an illusion of the wizard-king, Krow. You are only about half as powerful. You enjoy tricking and destroying the unsuspecting.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 5;
            bonushealth = 0;
            health = 10;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("ENEMY: A REALLY ANNOYING KILLER FOX") & currentroom == 0 & classavailable == true){
            System.out.println("A Really Annoying Killer Fox cheat activated. You were popular at one time, and you annoy people that enjoy keeping their hearing.");
            sword = false;
            healthpotion = false;
            dagger = false;
            ironshield = false;
            excalibur = false;
            strength = 999999999;
            bonushealth = 0;
            health = 999999999;
            defense = 0;
            bonusdefense = 0;
            }
            else if(command.equalsIgnoreCase("FORWARD") & moveon == true){
                currentroom++;
                CreateRoom(Rooms[currentroom]);
                if(currentroom > 0){
                    classavailable = false;
                }
            }
            else if(command.equalsIgnoreCase("LOOK")){
                if(Rooms[currentroom] == 1 & dagger == true){
                  System.out.println("The room is empty.");
                }
                else if(Rooms[currentroom] == 4 & treaty == true | Rooms[currentroom] == 4 & bloodscroll == true){
                  System.out.println("The room is empty.");
                }
                else if(Rooms[currentroom] == 4 & combat == true){
                  System.out.println("There is a mimic made of steel and gold, with a â˜  symbol on it, labeled \"War\". It is hostile and is about to attack you.");
                }
                else if(Rooms[currentroom] == 5 & shield == true){
                  System.out.println("The room is empty.");
                }
                else if(Rooms[currentroom] == 8 & combat == false){
                  System.out.println("The room is dark, but you see the faint outline of a one-way door.");
                }
                else if(Rooms[currentroom] == 10 & combat == true){
                  System.out.println("There is a golemn that looks like King Arthur standing in front of you, ready to strike you with it's sword.");
                }
                else if(Rooms[currentroom] == 10 & excalibur == true  & combat == false){
                  System.out.println("There is a destroyed statue on the ground.");
                }
                else if(Rooms[currentroom] == 10 & excalibur == true  & combat == false){
                  System.out.println("There is a destroyed statue on the ground.");
                }
                else if(Rooms[currentroom] == 15 & combat == false){
                  System.out.println("The room is empty.");
                }
                else if(Rooms[currentroom] == 17 & combat == false){
                  System.out.println("The room is empty.");
                }
                else{
                  System.out.println(desc);
                }
            }
            else if(command.equalsIgnoreCase("ATTACK") & combat == true){
             rival.fight();
            }
            else if(command.equalsIgnoreCase("USE DAGGER") & Rooms[currentroom] == 1 & dagger == false){
              System.out.println("You pick up and wield the dagger.");
              dagger = true;
              strength = 2;
            }
            else if(command.equalsIgnoreCase("USE PIPE") & shield == false & Rooms[currentroom] == 2){
              System.out.println("You enter the pipe. You are sucked through it to a new destination, seeing flashes of turtles, dragons, and burning flowers."); // Mario Reference
              Random warpzone = new Random();
              currentroom = 2 + warpzone.nextInt(3);
              CreateRoom(Rooms[currentroom]);
            }
            else if(command.equalsIgnoreCase("USE PEACE") & Rooms[currentroom] == 4 & combat == false & bloodscroll == false & treaty == false){
                if(dagger == true & healthpotion == false){
                    System.out.println("Your dagger dissapears, leaving a health potion in it's place.");
                    dagger = false;
                    strength = 1;
                    healthpotion = true;
                }
                System.out.println("You take a scroll from the chest labeled \"All-Purpose Peace Treaty, lasts 1 hour.\"");
                System.out.println("Both chests sink into the floor, and stone tiles seal off the floor."); 
                treaty = true;
            }
            else if(command.equalsIgnoreCase("USE WAR") & Rooms[currentroom] == 4 & treaty == false & combat == false){
                if(dagger == true){
                    System.out.println("You notice your dagger grows and becomes a sword.");
                    dagger = false;
                    sword = true;
                    strength = 3;
                }
                System.out.println("The other chest sinks into the floor, and you realise this chest is a mimic!");
                rival.name = "Mimic";
                rival.hp = 5;
                rival.attack = 2;
                combat = true;
                moveon = false;
            }
            else if(command.equalsIgnoreCase("USE HEALTH POTION") & healthpotion == true | command.equalsIgnoreCase("USE POTION") & healthpotion == true){
              System.out.println("You drink the health potion, healing you fully.");
              healthpotion = false;
              health = 10 + bonushealth;
            }
            else if(command.equalsIgnoreCase("USE TREATY") & treaty == true & combat == true | command.equalsIgnoreCase("USE PEACE TREATY") & treaty == true & combat == true){
              if(rival.name == "Krow"){
              System.out.println("You sign the paper on a line, and it flies at Krow. Krow looks at himself, and sits down on the throne.");
              System.out.println("Whenever you attempt to do anything to him, you realize the treaty works both ways and you cannot will yourself to complete your task.");
              System.out.println("When you consider exiting the castle, you realize that you would be caught by guards eventually.");
              System.out.println("You instead use this time to search the castle for supplies.");
                if(sword == false){
                    System.out.println("You find a sword.");
                    strength = 3;
                    sword = true;
                }
                if(ironshield == false){
                    System.out.println("You find an iron shield.");
                    ironshield = true;
                    defense = 2;
                }
                if(excalibur == false & oncecalibur == true){
                    System.out.println("You walk back to the excalibur you lost, and pick it back up.");
                    strength = 10;
                    excalibur = true;
                    oncecalibur = false;
                }
                if(healthpotion == false){
                    System.out.println("You find a health potion in the infirmary.");
                    healthpotion = true;
                }
              treaty = false;
              }
              else{
              System.out.println("You sign the paper on a line, and it flies at the enemy. They absorb it, and look calmer. They leave the room.");
              treaty = false;
              combat = false;
              moveon = true;
              desc = "The room is empty";
              }
            }
            else if(command.equalsIgnoreCase("USE SHIELD") & shield == false & Rooms[currentroom] == 5){
              System.out.println("You pick up and wield the shield.");
              shield = true;
              defense = 1;
            }
            else if(command.equalsIgnoreCase("USE SWORD") & Rooms[currentroom] == 10 & combat == false | command.equalsIgnoreCase("USE STATUE") & Rooms[currentroom] == 10 & combat == false| command.equalsIgnoreCase("USE PEDESTAL") & Rooms[currentroom] == 10 & combat == false){
              System.out.println("You attempt to take the magical sword, but the statue begins to move. At a closer look, the statue is of King Arthur!");
              rival.name = "King Arthur's Golemn";
              rival.hp = 15;
              rival.attack = 10;
              combat = true;
              moveon = false;
            }
            else if(command.equalsIgnoreCase("USE BUTTON") & Rooms[currentroom] == 6){
              Random ness = new Random();
              int button = 1 + roomnumber.nextInt(8);
                if(button == 1){
                    System.out.println("Nothing Happens.");
                }
                else if(button == 2){
                    System.out.println("Your health is restored back to 10!");
                    health = 10;
                }
                else if(button == 3){
                    System.out.println("You died.");
                    gameover = true;
                    pause(5000);
                }
                else if(button == 4){
                    System.out.println("An evil mosquito appears and blocks your exit.");
                    rival.name = "Mosquito";
                    rival.hp = 1;
                    rival.attack = 1;
                    moveon = false;
                    combat = true;
                }
                else if(button == 5){
                    System.out.println("Your inventory empties.");
                    dagger = false;
                    sword = false;
                    bloodscroll = false;
                    healthpotion = false;
                    treaty = false;
                    shield = false;
                    strength = 1;
                    defense = 0;
                }
                else if(button == 6){
                    System.out.println("You notice that your equipment got upgraded.");
                        if(dagger == true){
                            dagger = false;
                            sword = true;
                            strength = 3;
                        }
                        if(shield == true){
                            shield = false;
                            ironshield = true;
                            defense = 2;
                        }
                }
                else if(button == 7){
                    System.out.println("Your strength increases, but your life decreases.");
                    strength = strength + 1;
                    health = health - 1;
                }
                else if(button == 8){
                    System.out.println("Your life increases, but your strength decreases.");
                    strength = strength - 1;
                    health = health + 1;
                }
            }
            else if(command.equalsIgnoreCase("SPACE") & Rooms[currentroom] == 11 & Wisdom == false){
              System.out.println("You say \"Space\", and then are able to take the object. You do so, and learn how to avoid attacks better due to newfound wisdom.");
              bonusdefense = 1;
              Wisdom = true;
            }
            else if(command.equalsIgnoreCase("USE PERSON") & Rooms[currentroom] == 11 & Wisdom == true | command.equalsIgnoreCase("USE TRAVELER") & Rooms[currentroom] == 11 & Wisdom == true | command.equalsIgnoreCase("USE MERCHANT") & Rooms[currentroom] == 11 & Wisdom == true){
              System.out.println("You give the man your uneeded items, including your:");
              if(excalibur == true){
               if(sword == true){
                System.out.println("Sword");
                sword = false;
                coins = coins + 2;
               }
               if(dagger == true){
                System.out.println("Dagger");
                dagger = false;
                coins = coins + 1;
               }
              }
              if(sword == true & dagger == true){
               System.out.println("Dagger");
               dagger = false;
               coins = coins + 1;
              }
              System.out.println("In exchange, he gives you");
              if(coins == 1){
                  if(healthpotion == false){
                    System.out.println("A health potion");
                    healthpotion = true;
                    coins = 0;
                  }
                  else{
                   System.out.println("A coin");
                  }
              }
              if(coins == 2){
                  if(shield == false){
                    System.out.println("A shield");
                    shield = true;
                    coins = 0;
                  }
                  else if(healthpotion == true){
                    System.out.println("A health potion");
                    healthpotion = true;
                    coins = 1;
                  }
                  else{
                  System.out.println("2 coins");
                  coins = 2;
                  }
              }
              if(coins == 3){
                  if(shield == false){
                    System.out.println("A shield");
                    shield = true;
                    coins = coins - 2;
                  }
                  if(healthpotion == true){
                    System.out.println("A health potion");
                    healthpotion = true;
                    coins = coins - 1;
                  }
                  if(healthpotion == true & shield == true & coins == 3){
                    System.out.println("An iron shield.");
                    ironshield = true;
                    defense = 2;
                  }
                  if(coins != 0){
                  System.out.println(coins + " coins");
                  }
              }
            }
            else if(command.equalsIgnoreCase("USE GOLD") & Rooms[currentroom] == 13 & Courage == false | command.equalsIgnoreCase("USE TRIFORCE") & Rooms[currentroom] == 13  & Courage == false| command.equalsIgnoreCase("USE COURAGE") & Rooms[currentroom] == 13  & Courage == false| command.equalsIgnoreCase("USE TRIANGLE") & Rooms[currentroom] == 13 & Courage == false){
              System.out.println("You bravely run towards the object, but realise that you didn't get harmed somehow. You take it, and the room returns to normal. You feel tougher, and are more courageous.");
              desc = "The room is now a regular empty room";
              bonushealth = 5;
              health = 15;
              Courage = true;
              if(excalibur == true & Wisdom == true & Power == true & Courage == true & MastersBlade == false){
                  System.out.println("You notice the three shards glowing even brighter, as well as the Excalibur. When they all touch, they fuse together, forming an enchanted sword.");
                  MastersBlade = true;
                  excalibur = false;
                  strength = 13;
              }
            }
            else if(command.equalsIgnoreCase("USE CYLINDER") & Rooms[currentroom] == 13 & Courage == true | command.equalsIgnoreCase("USE LIGHT") & Rooms[currentroom] == 13 & Courage == true ){
              System.out.println("You step into the light and hear strange sounds. You step out, and realise that you are fully healed.");
              health = 10 + bonushealth;
              Courage = true;
            }
            else if(command.equalsIgnoreCase("USE SHOVEL") & mace == false & Rooms[currentroom] == 14){
              System.out.println("You pick up the shovel, but it turns into a mace.");
              strength = 5;
              desc = "The room is empty";
              mace = true;
            }
            else if(command.equalsIgnoreCase("USE REWINDSCROLL") & rewindscroll == true){
              System.out.println("You use the scroll, then it hits the wall. The room is shifting around you, until you can see nothing but the door.");
              rewindscroll = false;
              moveon = true;
              combat = false;
              currentroom = 0;
              desc = "You can think of nothing but going forward through the door";
            }
             // Equipping Items
            else if(command.equalsIgnoreCase("USE DAGGER") & dagger == true){
              System.out.println("You equip your dagger.");
              strength = 2;
            }
            else if(command.equalsIgnoreCase("USE SWORD") & sword == true){
              System.out.println("You equip your sword.");
              strength = 3;
            }
            else if(command.equalsIgnoreCase("USE EXCALIBUR") & excalibur == true){
              System.out.println("You equip the Excalibur.");
              strength = 10;
            }
            else if(command.equalsIgnoreCase("USE ENCHANTED SWORD") & MastersBlade == true | command.equalsIgnoreCase("USE MASTER SWORD") & MastersBlade == true | command.equalsIgnoreCase("USE ENCHANTED BLADE") & MastersBlade == true ){
              System.out.println("You equip the enchanted sword.");
              strength = 13;
            }
            else if(command.equalsIgnoreCase("USE MACE") & mace == true){
              System.out.println("You equip the Mace.");
              strength = 5;
            }
            else if(command.equalsIgnoreCase("INVENTORY")){
                System.out.println("USABLE:");
                if(healthpotion == true){
                    System.out.println("Health Potion");
                }
                if(treaty == true){
                    System.out.println("Treaty");
                }
                if(rewindscroll == true){
                    System.out.println("RewindScroll");
                }
                System.out.println("EQUIPPED:");
                if(dagger == true){
                    System.out.println("Dagger");
                }
                if(sword == true){
                    System.out.println("Sword");
                }
                if(shield == true){
                    System.out.println("Wooden Shield");
                }
                if(ironshield == true){
                    System.out.println("Iron Shield");
                }
                if(bloodscroll == true){
                    System.out.println("BloodScroll");
                }
                if(excalibur == true){
                    System.out.println("Excalibur");
                }
                if(Wisdom == true){
                    System.out.println("Wisdom");
                }
                if(Power == true){
                    System.out.println("Strength");
                }
                if(Courage == true){
                    System.out.println("Courage");
                }
                if(MastersBlade == true){
                    System.out.println("Enchanted Sword (Infused with the three things listed above and made with the Excalibur)");
                }
                if(mace == true){
                    System.out.println("Mace");
                }
                if(coins >= 1){
                    System.out.println(coins + " Coins");
                }
            }
            else if(command.equalsIgnoreCase("EXIT") | command.equalsIgnoreCase("QUIT")){ // Fixed in 1.1, used to both be "EXIT"
            System.out.println("Goodbye.");
            gameover = true;
            pause(5000);
            }
            //CHEAT CODES BELOW
            else if(command.equalsIgnoreCase("UP UP DOWN DOWN LEFT RIGHT LEFT RIGHT B A START")){
            System.out.println("Konami Code Cheat Activated, all items unlocked.");
            sword = true;
            dagger = true;
            excalibur = true;
            shield = true;
            ironshield = true;
            Wisdom = true;
            Power = true;
            Courage = true;
            bloodscroll = true;
            treaty = true;
            healthpotion = true;
            MastersBlade = true;
            mace = true;
            rewindscroll = true;
            bonushealth = 5;
            bonusstrength = 5;
            bonusdefense = 1;
            health = 15;
            strength = 13;
            defense = 2;
            }
            else if(command.equalsIgnoreCase("SV_CHEATS 1")){
            System.out.println("Source engine cheat activated, level skip enabled.");
            currentroom = 9;
            }
            else if(command.equalsIgnoreCase("IDQD") | command.equalsIgnoreCase("IDDQD")){
            System.out.println("Doom cheat activated, god mode enabled.");
            health = 999999999;
            bonushealth = 999999999;
            }
            else if(command.equalsIgnoreCase("ILLUMINATI")){
            System.out.println("Triangular cheat activated, you know too much.");
            Wisdom = true;
            }
            else if(command.equalsIgnoreCase("GANDHI")){
            System.out.println("Peaceful cheat activated, you no longer need to fight.");
            moveon = true;
            combat = false;
            }
            else if(command.equalsIgnoreCase("ERIC")){
            System.out.println("Game developer cheat activated, you are all-powerful.");
            health = 999999999;
            bonushealth = 999999999;
            strength = 999999999;
            bonusstrength = 999999999;
            defense = 999999999;
            bonusdefense = 999999999;
            }
            else if(command.equalsIgnoreCase("OLD SPICE")){
            System.out.println("Odor blocker bodywash cheat activated, you are too powerful for this game.");
            strength = 999999999;
            bonusstrength = 999999999;
            }
            //EASTER EGGS
            else if(command.equalsIgnoreCase("STOP")){
            System.out.println("Hammertime.");
            }
            // V1.1: Got rid of this easter egg
            //else if(command.equalsIgnoreCase("DELETE SYSTEM32") | command.equalsIgnoreCase("DELETE SYSTEM 32")){ // INFINITE LOOP WARNING, LUCKILY SAFELY CONTAINED UNTIL ACTIVATED
            //for(int a = 1; a > 0; a++){
            //    System.out.println("You just broke the game. Good job.");
            //}
            //}
            else if(command.equalsIgnoreCase("SMOKE")){
            System.out.println("You Smoked for a while, became addicted, spent most of your money to feed your habit, then died of a variety of things sometime later.");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("Not really, there are no ciggaretes in this game. But in reality, smoking can have terrible effects on your health, such as cancer, yellow & damaged skin & teeth, and other negative effects. "); 
            // I decided to keep the spelling error (and weird commands) in v1.1, as I want to change as little 
            // as I can from my original school project (Except for making the game run better/run as a jar file).
            System.out.println("In other words, don't smoke. It's terrible for you and anyone near you's health, and your wealth.");
            }
            else if(command.equalsIgnoreCase("DRINK")){
            System.out.println("You should not drink alchohol, or at least drink in moderation, as it can damage your brain and make you too dumb to play games such as this one.");
            }
            else if(command.equalsIgnoreCase("COUNT")){
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            System.out.println("4");
            System.out.println("5");
            System.out.println("6");
            System.out.println("7");
            System.out.println("8");
            System.out.println("9");
            System.out.println("10");
            }
            else if(command.equalsIgnoreCase("TWERK") | command.equalsIgnoreCase("SWAG") | command.equalsIgnoreCase("SELFIE")){
            System.out.println("You died of stupidity");
            gameover = true;
            pause(5000);
            }
            else if(command.equalsIgnoreCase("WHAT DOES THE FOX SAY?")){
            System.out.println("I don't know, ask the killer fox that just appeared (And that may have glitched your game a little).");
            rival.name = "A really annoying killer fox";
            rival.hp = 999999999;
            rival.attack = 999999999;
            combat = true;
            moveon = false;
            }
            else{
            System.out.println("You cannot do that.");
            }
        }while(!command.equalsIgnoreCase("EXIT") && gameover == false);
 }
public static boolean moveon = true; // Can you continue to the next room?
public static String desc; // Room Descriptions
public static Enemy rival = new Enemy("MissingNo",0,0); // Our enemy
public static int health = 10; // Player's HP
public static int bonushealth = 0; // Better mechanics implemented lightly
public static int strength = 1; // Player's attack power
public static int bonusstrength = 0; // Somewhat better mechanics implemented lightly
public static int defense = 0; // Player's defense
public static int bonusdefense = 0; // Somewhat better mechanics implemented lightly
public static boolean gameover = false; // The game ends.
public static boolean combat = false; // Can you fight anything?
public static boolean oncecalibur = false; // Did you ever lose the excalibur?
public static boolean classavailable = true; // Can you choose a class?
// Items
public static boolean dagger = false;
public static boolean sword = false;
public static boolean healthpotion = false;
public static boolean treaty = false;
public static boolean bloodscroll = false;
public static boolean shield = false;
public static boolean excalibur = false;
public static boolean ironshield = false;
public static boolean Power = false; // Legend Of Zelda Reference
public static boolean Courage = false; // Legend Of Zelda Reference
public static boolean Wisdom = false; // Legend Of Zelda Reference
public static boolean MastersBlade = false; // Legend Of Zelda Reference
public static boolean mace = false;
public static boolean rewindscroll = false;
public static int coins = 0;
public static void CreateRoom(int progress) // Our Rooms
{
if(progress == 0){
    desc = "You are at the bottom floor of The Unknown Dungeon. There is a one-way door up ahead. The room is lit by immovable torches. A peek past the door shows all rooms have these features.";
    System.out.println(desc);
}
else if(progress == 1){
    if(dagger == false){
    desc = "There is a small dagger on the ground.";
    }
    else{
    desc = "The room is empty, save for a paper reading \"The rooms in the bottom of the dungeon are tame, but things get more serious later on.\"";
    }
    System.out.println(desc);
}
else if(progress == 2){
    desc = "There is nothing in this room, save for a large green pipe in the wall.";
    System.out.println(desc);
}
else if(progress == 3){
    desc = "There is a goblin in this room.";
    rival.name = "Goblin";
    rival.hp = 3;
    rival.attack = 1;
    System.out.println(desc);
    combat = true;
    moveon = false;
}
else if(progress == 4){
    if(treaty == false & bloodscroll == false){
    desc = "There are 2 treasure chests here, one with a ☮ symbol made of glass and wood labeled \"Peace\", the other with a ☠  symbol made of steel and gold labeled \"War\".";
    }
    else{
    desc = "You notice something shuffling towards you. It's a Zombie!";
    rival.name = "Zombie";
    rival.hp = 3;
    rival.attack = 2;
    moveon = false;
    combat = true;
    }
    System.out.println(desc);
}
else if(progress == 5){
    if(shield == false){
    desc = "There is a wooden shield on the ground.";
    System.out.println(desc);
    }
    else{
    desc = "There is a note in the room. It reads \"Some items reduce the damage dealt to the user.\"";
    System.out.println(desc);
    }
}
else if(progress == 6){
    desc = "A button is on the wall to your right. It says \"Button Of Randomness\"";
    System.out.println(desc);
}
else if(progress == 7){
    desc = "˙uʍop ǝp!sdn s! ʇ! ʇɐɥʇ ʇdǝɔxǝ 'lɐɯɹou s! ɯooɹ s!ɥ┴";
    System.out.println(desc);
}
else if(progress == 8){
    desc = "The torches in this room are extinguished, and you hear a monster in front of you.";
    rival.name = "Gru";
    rival.hp = 7;
    rival.attack = 2;
    moveon = false;
    combat = true;
    System.out.println(desc);
}
else if(progress == 9){
    System.out.println("You are hit by a magical orb as you enter the room. You have a vision of another dimension, in which a person in white \"armor\" is breaking into an ice fortress.");
    System.out.println("Alot of strange technology is present.");
    desc = "The magical orb has dissapeared, and the vision fades. You can still faintly hear the words \"Stop That Nuke!\"" ;
    System.out.println(desc);
}
else if(progress == 10){
    desc = "There is a statue of a warrior in the room, holding a real sword stuck in a small pedestal. It says \"To use this sword, you will need to prove your strength in combat.\"";
    System.out.println(desc);
}
else if(progress == 11){ // Legend of Zelda reference, triforce of wisdom
    if(Wisdom == false){
    System.out.println("There is a triangular piece of gold here, glowing green. It is on a podium, which has a message inscribed into it.");
    System.out.println("It reads: \"To get the triumph forks, answer this riddle.\"");
    desc = "\"What exists beyond the sky, is a very useful key to others in the future (though they will claim it is a bar), had a race during a frozen battle in another dimension, and contains almost everything?.\" [Type your answer]"; // The answer Is space
    System.out.println(desc);
    }
    else{
    desc = "You see a traveler that says \"I am a merchant. Use me if you want to trade unneeded items for more useful ones.\"";
    System.out.println(desc);
    }
}
else if(progress == 12){ // Legend of Zelda reference, triforce of power
    if(Power == false){
    desc = "There is a triangular piece of gold here, glowing red. It is embedded in the chest of an ogre. The ogre says \"if you want this, then let us fight. Otherwise, be on your way.\"";
    rival.name = "Ogre";
    rival.hp = 010; //0n10n
    rival.attack = 53; //5hr3k
    combat = true;
    System.out.println(desc);
   }
   else{
   desc = "A thief appears, and steals your weapons! He then shouts \"Just go to the next room, you can't fight me unarmed!\"";
   System.out.println(desc);
   rival.name = "Thief";
   rival.attack = 5;
   rival.hp = 13;
   combat = true;
   sword = false;
   if(excalibur = true){
       oncecalibur = true;
   }
   excalibur = false;
   dagger = false;
   strength = 1;
   }
}
else if(progress == 13){ // Legend of Zelda reference, triforce of courage
    if(Courage == false){
    desc = "There is a triangular piece of gold here, glowing yellow. It is to the right side of the path leading to the door. To get to the triangle, you would have to go through snakes & spiders, avoid arrow traps, crawl through a small head-level tunnel, and avoid explosions along the way.";
    combat = false;
    System.out.println(desc);
   }
   else{
    desc = "You see a cylinder of light that is slightly larger than you are. There is metal on the ceiling and ground it touches.";
    System.out.println(desc);
   }
}
else if(progress == 14){
    if(mace == false){
    desc = "You see a shovel hanging on a hook.";
    System.out.println(desc);
   }
   else{
    desc = "There is a note here saying \"MIIIIIIIIIISTER KROW!.\"";
    System.out.println(desc);
   }
}
else if(progress == 15){
    desc = "You see Krow. He is laughing at you, and begins to attack you.";
    System.out.println(desc);
    combat = true;
    moveon = false;
    rival.name = "Wizard-King Krow";
    rival.hp = 10;
    rival.attack = 5;
}
else if(progress == 16){
    if(rewindscroll == false){
    desc = "You take a scroll off the wall that states \"RewindScroll - This scroll will allow you to go back to the start of your journey.\"";
    System.out.println(desc);
    desc = "The room is empty";
    rewindscroll = true;
    }
    else{
    desc = "As you enter the room, you feel some of your life and your clothes/armor fusing and then unfusing.";
    System.out.println(desc);
    int melding = health + defense / 2;
    health = melding;
    defense = melding;
    }
}
else if(progress == 17){
    desc = "The room looks empty, but when you look at your feet, you see a glowing rune that is reflective. Suddenly, you see yourself in front of you. They are going to attack!";
    System.out.println(desc);
    combat = true;
    moveon = false;
    rival.name = "You";
    rival.hp = health;
    if(healthpotion == true){
      rival.hp = rival.hp + 10;
    }
    if(ironshield == true){
      rival.hp = rival.hp + 2;
    }
    else if(shield == true){
      rival.hp = rival.hp + 1;
    }
    rival.attack = strength;
}
else if(progress == 42){ // FINAL BOSS
    System.out.println("You see natural sunlight, and you realize you are now back in the castle. You rush to the throne room, and see Krow launching a fireball at a fleeing person.");
    System.out.println("They escape, and the fireball burns the door.");
    System.out.println("Krow laughs wickedly, then notices you. He says \"I thought I had you thrown in the dungeon? No matter, I needed something to test my spells on anyway.\"");
    desc = "Krow is aiming his staff at you, ready to hit you with a spell.";
    System.out.println(desc);
    moveon = false;
    combat = true;
    rival.name = "Krow";
    rival.hp = 20;
}
}



public static void sort(int a[ ], int left, int right) // Quicksort. For our sorting requirement. Creates the room numbers.
{
if (left >= right) return;
int k = left;
int j = right;
int pivotValue = a[ (left + right) / 2 ]; // salient feature
while ( k < j )
{
while (a[k] < pivotValue) //salient feature (pivot point)
{
k++;
}
while (pivotValue < a[j])
{
j--;
}
if ( k <= j)
{
int temp = a[k]; //swap a[k] and a[j]
a[k] = a[j];
a[j] = temp;
k++;
j--;
}
} 
sort(a, left, j); //salient feature (recursion)
sort(a, k, right);
}
}