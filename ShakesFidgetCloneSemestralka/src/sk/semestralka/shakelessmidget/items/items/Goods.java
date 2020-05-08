
package sk.semestralka.shakelessmidget.items.items;

import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.main.Chance;
import java.util.Random;

/**
 * Trieda Goods sluzi ako nepouzitelny predmet pre hraca
 */
public class Goods extends Item {

    private int dropChance;
    private int goldValue;
    private final Random random;
    
    /**
     * Konstruktor, vytvori instanciu
     * @param name meno
     * @param rarity  vzacnost
     */
    public Goods(String name, ItemRarity rarity) {
        super(name, rarity);
        this.random = new Random();
        this.setupValues();
        
    }
    
    /**
     * Vytvori konkretnu instanciu
     * @param name nazov
     * @param rarity vzacnost
     * @param goldValue penazna hodnota
     */
    public Goods(String name, ItemRarity rarity, int goldValue) {
        super(name, rarity);
        this.random = new Random();
        this.setupValues();
        this.goldValue = goldValue;
        
    }
    
    /**
     * Testovaci konstruktor
     */
    public Goods() {
        this("Trash", ItemRarity.COMMON);
    }
    
        /**
     * Vrati vlastnu hodnotu sance na drop
     * @return sanca padnutia
     */
    @Override
    public int getDropChance() {
        return this.dropChance;
    }

    /**
     * Vrati vlastnu hodnotu v goldoch
     * @return hodnota v goldoch
     */
    @Override
    public int getGoldValue() {
        return this.goldValue;
    }

    /**
     * Vrati triedu v podobe stringu
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Goods{%s ,rarity=%s value= %d }", super.getName(), super.getRarity(),  this.goldValue);
    }
    
    /**
     * Ulozi hodnoty do suboru
     * @param file subor
     * @throws IOException 
     */
    @Override
    public void save(DataOutputStream file) throws IOException {
        file.writeUTF("goods");
        file.writeUTF(super.getName());
        file.writeUTF(super.getRarity().toString());
        file.writeInt(this.goldValue);
    }
    
    
    /**
     * Meni hodnotu sance na drop a ceny v goldoch podla toho aka je vzacnost
     */
    private void setupValues() {
        switch (super.getRarity()) {
            case COMMON:
                this.dropChance = 100;
                this.goldValue = Chance.random(1, 5);
                break;
            case UNCOMMON:
                this.dropChance = 50;
                this.goldValue = Chance.random(10, 20);
                break;
            case RARE:
                this.dropChance = 25;
                this.goldValue = Chance.random(50, 100);
                break;
            case EPIC:
                this.dropChance = 10;
                this.goldValue = Chance.random(150, 500);
                break;
            default:
                this.dropChance = 0;
                this.goldValue = 0;
        }
    }


}
