
package sk.semestralka.shakelessmidget.items.equippable;

import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.items.items.Equipment;
import sk.semestralka.shakelessmidget.items.items.ItemRarity;


/**
 * Trieda sluzi ako podtyp pre Equipment
 */
public class Helmet extends Equipment {

    /**
     * Vytvori instanciu
     * @param name nazov
     * @param rarity vzacnost
     * @param levelRequired potrebny level
     */
    public Helmet(String name, ItemRarity rarity, int levelRequired) {
        super(name, rarity, 0, 1, 1, levelRequired);
    }
    
    /**
     * Vytvori velmi konkretnu instanciu
     * @param name nazov
     * @param rarity vzacnost
     * @param bonusHealth zivot
     * @param armor armor
     * @param levelRequired potrebny level
     * @param goldValue penazna hodnota
     */
    public Helmet(String name, ItemRarity rarity, int bonusHealth, int armor, int levelRequired, int goldValue) {
        super(name, rarity, 0, bonusHealth, armor, levelRequired, goldValue);
    }
    
    /**
     * Testovaci konstruktor
     */
    public Helmet() {
        this("Training Cap", ItemRarity.COMMON, 0);
    }
    
    /**
     * Vrati triedu v podobe stringu
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Helmet{%s, health= %d, armor= %d, rarity= %s, value= %d, required level= %d}", 
                super.getName(), super.getBonusHealth(), super.getBonusArmor(), super.getRarity(), 
                super.getGoldValue(), super.getLevelRequired());
    }

    /**
     * Ulozi hodnoty do suboru
     * @param file
     * @throws IOException 
     */
    @Override
    public void save(DataOutputStream file) throws IOException {
        file.writeUTF("helmet");
        super.save(file);
    }
    
    
}
