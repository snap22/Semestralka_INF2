
package sk.semestralka.shakelessmidget.items.items;

import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.main.Chance;
/**
 * Trieda sluzi ako nadtyp pre triedy ktore si hrac moze na seba zobrat
 */
public abstract class Equipment extends Item {

    private int bonusHealth;
    private int bonusDamage;
    private int bonusArmor;
    private int levelRequired;
    private int goldValue;

    /**
     * Vytvori instanciu
     * @param name nazov
     * @param rarity vzacnost
     * @param damage sila utoku
     * @param bonusHealth zivot
     * @param armor armor
     * @param levelRequired potrebny level
     */
    protected Equipment(String name, ItemRarity rarity, int damage, int bonusHealth, int armor, int levelRequired) {
        super(name, rarity);
        this.levelRequired = levelRequired;
        this.bonusDamage = damage;
        this.bonusArmor = armor;
        this.bonusHealth = bonusHealth;
        
        this.setupValues();
        
    }
    
    /**
     * Vytvori predmet s presne definovanymi hodnotami
     * @param name nazov
     * @param rarity vzacnost
     * @param damage sila utoku
     * @param bonusHealth bonusovy zivot
     * @param armor armor
     * @param levelRequired potrebny level
     * @param goldValue cena
     */
    protected Equipment(String name, ItemRarity rarity, int damage, int bonusHealth, int armor, int levelRequired, int goldValue) {
        super(name, rarity);
        this.levelRequired = levelRequired;
        this.bonusDamage = damage;
        this.bonusArmor = armor;
        this.bonusHealth = bonusHealth;
        this.goldValue = goldValue;
        
    }


    /**
     * Ulozi hodnoty do suboru
     * @param file subor
     * @throws IOException 
     */
    @Override
    public void save(DataOutputStream file) throws IOException {
        file.writeUTF(super.getName());
        file.writeUTF(super.getRarity().toString());
        file.writeInt(this.goldValue);
        file.writeInt(this.bonusArmor);
        file.writeInt(this.bonusDamage);
        file.writeInt(this.bonusHealth);
        file.writeInt(this.levelRequired);
        
    }
    
    /**
     * Nastavi hodnoty podla toho, aka je vzacnost a aky je potrebny level  na to aby bol item equipnuty
     */
    private void setupValues() {
        if (this.levelRequired < 0) {
            this.bonusArmor = 1;
            this.bonusDamage = 1;
            this.bonusHealth = 1;
            this.goldValue = 1;
            return;
        }
        
        int min = this.levelRequired;
        int max = min + 5;
        
        //nastavi pocitatocne hodnoty itemu podla level required
        int dmg = Chance.random(min, max);
        int armor = Chance.random(min, max);
        int hp = Chance.random(min, max);
        int gold = Chance.random(0, max);
        if (this.bonusArmor == 0 || this.bonusHealth == 0) {
            armor = 0;
            hp = 0;
        } else {
            dmg = 0;
        }
        switch (super.getRarity()) {   
            case COMMON:
                break;
            case UNCOMMON:
                dmg *= 2;
                armor *= 2;
                hp *= 2;
                gold *= 2;
                break;
            case RARE:
                dmg *= 4;
                armor *= 4;
                hp *= 4;
                gold *= 4;
                break;
            case EPIC:
                dmg *= 8;
                armor *= 8;
                hp *= 8;
                gold *= 8;
                break;
            default:
        }
        this.bonusArmor = armor;
        this.bonusDamage = dmg;
        this.bonusHealth = hp;
        this.goldValue = gold;
    }


    
    /**
     * Vrati zivoty ktore pridava
     * @return bonusove zivoty
     */
    public int getBonusHealth() {
        return this.bonusHealth;
    }

    /**
     * Vrati silu utoku ktoru pridava
     * @return bonusova sila utoku
     */
    public int getBonusDamage() {
        return this.bonusDamage;
    }

    /**
     * Vrati armor ktory pridava
     * @return bonusovy armor
     */
    public int getBonusArmor() {
        return this.bonusArmor;
    }

    /**
     * Vrati potrebny level
     * @return potrebny level
     */
    public int getLevelRequired() {
        return this.levelRequired;
    }
    
    /**
     * Vrati hodnotu v goldoch
     * @return hodnotu v goldoch
     */
    @Override
    public int getGoldValue() {
        return this.goldValue;
    }
    
    

    
    
    
}
