/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;


public class EquippableItem extends Item {

    private final ItemType type;
    private boolean isEquipped;
    
    private final int bonusHp;
    private final int bonusArmor;
    private final int bonusDamage;
    /**
     * Vytvori item ktory si na seba hrac vie equipnut
     * @param name nazov itemu
     * @param increaseHp o kolko zvysi hp hracovi
     * @param increaseArmor o kolko zvysi armor hracovi
     * @param increaseDamage o kolko zvysi damage hracovi
     * @param goldValue aku ma hodnotu
     * @param type typ itemu
     */
    public EquippableItem(String name, int increaseHp, int increaseArmor, int increaseDamage, int goldValue, ItemType type) {
        super(name, goldValue);
        this.type = type;
        this.isEquipped = false;
        
        this.bonusHp = increaseHp;
        this.bonusArmor = increaseArmor;
        this.bonusDamage = 0;
    }

    public ItemType getType() {
        return this.type;
    }
    
    /**
     * Zmeni hodnotu ci je equipnutyna true
     */
    public void makeEquipped() {
        if (this.isEquipped) {
            return;
        }
        
        this.isEquipped = true;
    }
    
    /**
     * Zmeni hodnotu ci je equipnuty  na false
     */
    public void makeUnequipped() {
        this.isEquipped = false;
    }

    public int getBonusHp() {
        return this.bonusHp;
    }

    public int getBonusArmor() {
        return this.bonusArmor;
    }
    
    public int getBonusDamage() {
        return this.bonusDamage;
    }

    
    
    /**
     * Equippable item stale bude equippable
     * @return 
     */
    @Override
    public boolean isEquippable() {
        return true;
    }
    
    
    
    
}
