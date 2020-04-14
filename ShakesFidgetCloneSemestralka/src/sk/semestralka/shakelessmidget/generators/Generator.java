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
 *  Trieda ktora generuje nahodne veci
 */
public class Generator {

    private final Player player;
    private LoadFile enemyNames;
    private LoadFile objectiveTitles;
    private LoadFile objectiveDescriptions;
    private Random random;
 
    
    
    public Generator(Player player) {
        this.player = player;
        this.enemyNames = new LoadFile(ExampleType.ENEMYNAME);
        this.objectiveTitles = new LoadFile(ExampleType.OBJECTNAME);
        this.objectiveDescriptions = new LoadFile(ExampleType.OBJECTDESCRIPTION);
        this.random = new Random();
    }
    
    
    

    public Objective generateObjective() {
        String description = this.objectiveDescriptions.getRandom();
        String title = this.objectiveTitles.getRandom();
        Objective obj = new Objective(title, description, this.generateEnemy(), this.random.nextInt(100), this.random.nextInt(100), this.random.nextInt(10) + 1);
        return obj;
    }
    
    public Enemy generateEnemy() {
        Enemy enemy = new Enemy(this.enemyNames.getRandom(), this.player.getHealth() - 3, this.player.getDamage() - 2, this.random.nextInt(100));
        
        return enemy;
    }
    
    
    
    
}
