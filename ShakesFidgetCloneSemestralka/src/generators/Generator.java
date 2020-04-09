/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import adventure.Mission;
import adventure.Objective;
import creatures.Enemy;
import java.util.Random;
import player.basic.Player;

/**
 *
 *  ZATIAL LEN TEST CLASS , ASI SPRAVIT NA KONKRETNU...
 */
public class Generator {

    private final Player player;
    private enum Type { ENEMY, TITLE, DESCRIPTION };
    //nacitalo by zo suboru?
    private static String[] possibleMissionNames = {
        "The hunt", 
        "The call of the wild", 
        "The dangerous adventure", 
        "Interesting activity"
    };
    private static String[] possibleDescriptions = {
        "Just go and kill! Don't ask questions!", 
        "I need your help, my friend", 
        "Are you willing to help me?", 
        "What are you loooking at?!"
    };
    private static String[] possibleEnemyNames = {
        "Skeleton",
        "Golem",
        "Vampire",
        "Zombie",
        "Slime",
        "Goblin",
        "Bandit",
    };

    // nacitalo by zo suboru vsetky tieto veci
    private int descriptionSize;
    private int enemyNameSize;
    private int questTitleSize;
    public Generator(Player player) {
        this.player = player;
    }
    
    
    private static Random random = new Random();
    public Mission generateMission() {
        return new Mission(this.generateObjective(), this.player);
    }
    
    public Objective generateObjective() {
        //public Objective(String name, String description, Enemy enemy, int goldReward, int xpReward, int duration)
        Objective obj = new Objective(this.chooseWord(Type.TITLE), this.chooseWord(Type.DESCRIPTION), this.generateEnemy(), random.nextInt(100), random.nextInt(100), random.nextInt(10) + 1);
        return obj;
    }
    
    public Enemy generateEnemy() {
        //public Enemy(String name, int maxHealth, int damage, int xpReward)
        Enemy enemy = new Enemy(this.chooseWord(Type.ENEMY), this.player.getHealth() - 3, this.player.getDamage() - 2, random.nextInt(100));
        
        return enemy;
    }
    
    private String chooseWord(Type type) {
        int maxSize;
        switch (type) {
            case ENEMY:
                maxSize = possibleEnemyNames.length;
                return possibleEnemyNames[random.nextInt(maxSize)];
            case TITLE:
                maxSize = possibleMissionNames.length;
                return possibleMissionNames[random.nextInt(maxSize)];
            case DESCRIPTION:
                maxSize = possibleDescriptions.length;
                return possibleDescriptions[random.nextInt(maxSize)];
            default:
                return "Joker";
        }
    }
    
    
}
