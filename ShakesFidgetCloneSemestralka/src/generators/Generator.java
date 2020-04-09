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

/**
 *
 *  ZATIAL LEN TEST CLASS , ASI SPRAVIT NA KONKRETNU...
 */
public abstract class Generator {
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
    
    private static Random random = new Random();
    public static Mission generateMission() {
        return new Mission(generateObjective(), null);
    }
    
    private static Objective generateObjective() {
        //public Objective(String name, String description, Enemy enemy, int goldReward, int xpReward, int duration)
        Objective obj = new Objective(chooseWord(Type.TITLE), chooseWord(Type.DESCRIPTION), generateEnemy(), random.nextInt(100), random.nextInt(100), random.nextInt(10) + 1);
        return obj;
    }
    
    private static Enemy generateEnemy() {
        //public Enemy(String name, int maxHealth, int damage, int xpReward)
        Enemy enemy = new Enemy(chooseWord(Type.ENEMY), random.nextInt(5) + 1, random.nextInt(1) + 1, random.nextInt(100));
        
        return enemy;
    }
    
    private static String chooseWord(Type type) {
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
