
package sk.semestralka.shakelessmidget.items.items;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Trieda Item reprezentuje predmety. Kazdy predmet ma svoje meno, penaznu hodnotu a svoju vzacnost
 */
public abstract class Item {
    
    private ItemRarity rarity;
    private String name;

    /**
     * Konstruktor, vytvori instanciu s danymi hodnotami
     * @param name meno
     * @param rarity  vzacnost
     */
    protected Item(String name, ItemRarity rarity) {
        this.name = name;
        this.rarity = rarity;  
    }


    /**
     * Vrati meno
     * @return nazov
     */
    public String getName() {
        return this.name;
    }
    
    public abstract int getGoldValue();


    /**
     * Podla rarity vrati percentualnu sancu na drop
     * @return sanca padnutia
     */
    public int getDropChance() {
        switch (this.rarity) {
            case COMMON:
                return 75;
            case UNCOMMON:
                return 40;
            case RARE:
                return 20;
            case EPIC:
                return 10;
            default:
                return 0;
            
        }
    }

    /**
     * Vrati vzacnost predmetu
     * @return vzacnost
     */
    public ItemRarity getRarity() {
        return this.rarity;
    }

    public abstract void save(DataOutputStream file) throws IOException;
    

}
