/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patheticTryToMakeItBetter;

import items.ItemType;

/**
 *
 * @author marce
 */
public class Item2 {
    private ItemType type;
    private String name;
    private int goldValue;
    private boolean equipped;
    private int bonusDamage;
    private int bonusHealth;
    private int bonusArmor;
           
    
    public Item2(String name, ItemType type, int goldValue, int bonusDamage, int bonusHealth, int bonusArmor) {
        this.goldValue = goldValue;
        this.name = name;
        this.type = type;
        this.nastavHodnoty(bonusDamage, bonusHealth, bonusArmor);
        
        
    }
    
    /**
     * Vytvori item ktory sa neda equipnut
     * 
     * @param name nazov itemu
     * @param goldValue cenova hodnota
     */
    public Item2(String name, int goldValue) {
        this(name, ItemType.TRASH, goldValue, 0, 0, 0);
    }
    
    /**
     * nastavi bonusove hodnoty ktore dáva podla typu itemu
     * @param damage bonusovy damage
     * @param health bonusvy hp
     * @param armor  bonusovy armor
     */
    private void nastavHodnoty(int damage, int health, int armor) {
        //Preto je toto zakomentovane, lebo ak by som chcel pridat itemy ktore znizuju armor, ale zvysuju hp, aby sa to dalo
        /*if (damage + health + armor <= 0) {
            return;
        }*/
        if (damage == 0 && health == 0 && armor == 0) {
            return;
        }
        
        switch (this.type) {
            case HELMET:
            case ARMOR:
                this.bonusDamage = 0;
                this.bonusHealth = health;
                this.bonusArmor = armor;
                break;
            case WEAPON:
                this.bonusDamage = damage;
                this.bonusHealth = 0;
                this.bonusArmor = 0;
                break;
            case TRASH:
                this.bonusDamage = 0;
                this.bonusHealth = 0;
                this.bonusArmor = 0;
                break;
            default:
                //ak  by som chcel pridat ešte nejaky typ
        }
    }
    
    /**
     * 
     */
    public void equip() {
        if (this.type == ItemType.TRASH) {
            return;
        }
        this.equipped = true;
    }
    
    public void unequip() {
        this.equipped = false;
    }
    
    public boolean isEquipped() {
        return this.equipped;
    }

    public ItemType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getGoldValue() {
        return this.goldValue;
    }
    
    @Override 
    public String toString() {
        return String.format("[Item - %s, type %s, value %d, bonus damage %d, bonus health %d, bonus armor %d%n", 
                this.name, this.type, this.goldValue, this.bonusDamage, this.bonusHealth, this.bonusArmor);
    }
    
    
}
