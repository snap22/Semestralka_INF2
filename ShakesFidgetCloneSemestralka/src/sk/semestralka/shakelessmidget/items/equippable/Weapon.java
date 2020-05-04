
package sk.semestralka.shakelessmidget.items.equippable;

import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.items.items.Equipment;
import sk.semestralka.shakelessmidget.items.items.ItemRarity;

/**
 * Trieda sluzi ako podtyp pre Equipment
 */
public class Weapon extends Equipment {
    /**
     * /**
     * Vytvori instanciu
     * @param name nazov
     * @param rarity vzacnost
     * @param levelRequired potrebny level
     */
    public Weapon(String name, ItemRarity rarity, int levelRequired) {
        super(name, rarity, 1, 0, 0, levelRequired);
    } 
    
    /**
     * Vytvori velmi konkretnu instanciu
     * @param name nazov
     * @param rarity vzacnost
     * @param bonusDamage sila utoku
     * @param levelRequired potrebny level
     * @param goldValue penazna hodnota
     */
    public Weapon(String name, ItemRarity rarity, int bonusDamage, int levelRequired, int goldValue) {
        super(name, rarity, bonusDamage, 0, 0, levelRequired, goldValue);
    }
    
    /**
     * Testovaci konstruktor
     */
    public Weapon() {
        this("Training Sword", ItemRarity.COMMON, 0);
    }

    /**
     * Vrati triedu v podobe stringu
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Weapon{%s, damage= %d, rarity= %s, value= %d , required level= %d}", 
                super.getName(), super.getBonusDamage(), super.getRarity(), 
                super.getGoldValue(), super.getLevelRequired());
    }

    /**
     * Ulozi hodnoty do suboru
     * @param file
     * @throws IOException 
     */
    @Override
    public void save(DataOutputStream file) throws IOException {
        file.writeUTF("weapon");
        super.save(file);
    }
    
    
    
}
