
package sk.semestralka.shakelessmidget.shop;

import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.exceptions.NoMoneyException;
import sk.semestralka.shakelessmidget.generators.ItemGenerator;
import sk.semestralka.shakelessmidget.generators.MoodGenerator;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.creatures.Player;
import sk.semestralka.shakelessmidget.player.moods.Mood;

/**
 * Trieda sluzi na nakup itemov a nalad
 */
public class Shop {

    private final Player player;
    private final ItemGenerator itemGen;
    private final MoodGenerator generator;

    /**
     * Nastavi pociatocne hodnoty
     * @param player hrac
     */
    public Shop(Player player) {
        this.player = player;
        this.itemGen = new ItemGenerator();   
        this.generator = new MoodGenerator();
    }
    
    /**
     * Metoda sluzi na to aby si hrac mohol kupit nahodny predmet s nahodnym potrebnym levelom za urcitu cenu
     * @param price cena
     * @return 
     * @throws InventoryFullException
     * @throws NoMoneyException 
     */
    public Item buyItem(int price) throws InventoryFullException, NoMoneyException {
        Item item = this.itemGen.generateRandomItem();
        this.player.addItem(item);
        this.player.removeGold(price);
        
        return item;
        
    }
    
    /**
     * Metoda ktora sluzi na to aby zmenila hracovi naladu za peniaze
     * @param price cena
     * @return 
     * @throws NoMoneyException
     */
    public Mood switchMood(int price) throws NoMoneyException {
        Mood currentMood = this.player.getMood();
        Mood newMood = this.generator.generateRandomMood(currentMood);
        this.player.removeGold(price);
        this.player.changeMood(newMood);
        return newMood;
    }
    
    
    
}
