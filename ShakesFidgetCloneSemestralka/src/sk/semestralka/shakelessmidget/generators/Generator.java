/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.generators;

import sk.semestralka.shakelessmidget.adventure.Mission;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.creatures.Enemy;
import java.util.Random;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 *  Trieda, ktorej úlohou je generovanie náhodných vecí
 */
public class Generator {

    private final Player player;
    private LoadFile enemyNames;
    private LoadFile objectiveTitles;
    private LoadFile objectiveDescriptions;
    private Random random;
 
    
    /**
     * 
     * @param player 
     */
    public Generator(Player player) {
        this.player = player;
        this.enemyNames = new LoadFile(ExampleType.ENEMYNAME);
        this.objectiveTitles = new LoadFile(ExampleType.OBJECTNAME);
        this.objectiveDescriptions = new LoadFile(ExampleType.OBJECTDESCRIPTION);
        this.random = new Random();
    }
    
    
    
    /**
     * Vytvorí a vráti inštanciu triedy Objective s náhodnými parametrami
     * @return 
     */
    public Objective generateObjective() {
        String description = this.objectiveDescriptions.getRandom();
        String title = this.objectiveTitles.getRandom();
        Objective obj = new Objective(title, description, this.generateEnemy(), this.random.nextInt(100) + 1, this.random.nextInt(100) + 1, this.random.nextInt(15) + 5);
        return obj;
    }
    
    /**
     * Vytvorí a vráti náhodného nepriateľa
     * @return 
     */
    public Enemy generateEnemy() {
        Enemy enemy = new Enemy(this.enemyNames.getRandom(), this.player.getHealth() - 3, this.player.getDamage() - 2, this.random.nextInt(100));
        
        return enemy;
    }
    
    
    
    
}
