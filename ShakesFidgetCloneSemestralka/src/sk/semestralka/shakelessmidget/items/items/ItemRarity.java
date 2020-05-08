
package sk.semestralka.shakelessmidget.items.items;

import java.util.Random;

/**
 * Vzacnost itemov. Podla vzacnosti sa meni sanca  na drop
 * 
 */
public enum ItemRarity {
    COMMON, UNCOMMON, RARE, EPIC;
    
    /**
     * Vrati hodnotu na zaklade vlozeneho indexu
     * @param index index
     * @return vzacnost
     */
    public static ItemRarity getRarity(int index) {
        if (index >= values().length || index < 0) {
            return COMMON;
        }
        return values()[index];
    }
    
    /**
     * Vrati nahodnu hodnotu
     * @return vzacnost
     */
    public static ItemRarity getRandom() {
        Random random = new Random();
        return getRarity(random.nextInt(values().length));
    }
}
