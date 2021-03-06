
package sk.semestralka.shakelessmidget.generators;

import sk.semestralka.shakelessmidget.loaders.LoadFile;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.creatures.Enemy;
import java.util.Random;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.creatures.Player;

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
    private final ItemGenerator itemGen;
 
    
    /**
     * Konstruktor, vytvori instanciu
     * @param player hrac
     */
    public Generator(Player player) {
        this.player = player;
        this.enemyNames = new LoadFile(ExampleType.ENEMYNAME);
        this.objectiveTitles = new LoadFile(ExampleType.OBJECTNAME);
        this.objectiveDescriptions = new LoadFile(ExampleType.OBJECTDESCRIPTION);
        this.random = new Random();
        this.itemGen = new ItemGenerator();
    }
    
    
    
    /**
     * Vytvorí a vráti inštanciu triedy Objective s náhodnými parametrami
     * @return nahodna uloha
     */
    public Objective generateObjective() {
        String description = this.objectiveDescriptions.getRandom();
        String title = this.objectiveTitles.getRandom();
        int xpToGet = (int)((this.random.nextInt(this.player.getRequiredXp()) / 2) + 1);     
        Objective obj = new Objective(title, description, this.generateEnemy(), this.random.nextInt(30) + 1, xpToGet, this.random.nextInt(15) + 5);
        return obj;
    }
    
    /**
     * Vytvorí a vráti náhodného nepriateľa
     * @return nahodny nepriatel
     */
    public Enemy generateEnemy() {
        Item item = this.itemGen.generateRandomItem(this.player.getLevel());
        Enemy enemy = new Enemy(this.enemyNames.getRandom(), this.player.getHealth() - 3, this.player.getDamage() - 1, this.random.nextInt(30), item);
        
        return enemy;
    }
    
    
    
    
}
