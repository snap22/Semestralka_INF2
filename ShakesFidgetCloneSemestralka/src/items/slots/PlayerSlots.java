/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.slots;


import items.Item2;
import items.equippable.Armor;
import items.equippable.Equipment;
import items.equippable.Helmet;
import items.equippable.Weapon;
import player.basic.Player;

/**
 * Trieda zodpoveda za to aby si hrac mohol dať na seba (equipnut) a zo seba rozne predmety
 * @author marce
 */
public class PlayerSlots {
    private Slot<Weapon> weaponSlot;
    private Slot<Armor> armorSlot;
    private Slot<Helmet> headSlot;
    private final Player player;
    
    public PlayerSlots(Player player) {
        this.weaponSlot = new Slot<Weapon>();
        this.armorSlot = new Slot<Armor>();
        this.headSlot = new Slot<Helmet>();
        
        this.player = player;
        
        
    }
    
    /**
     * Pozrie sa kde pasuje dany predmet a ak sa da tak ho da na seba
     * @param item 
     */
    public boolean equip(Item2 item) {
        if (item instanceof Helmet) {
            this.equip((Helmet)item);
            return true;
        } else if (item instanceof Armor) {
            this.equip((Armor)item);
            return true;
        } else if (item instanceof Weapon) {
            this.equip((Weapon)item);
            return true;
        } else {
            return false;
        }
        
    }
    
    /**
     * Dá na seba helmu
     * @param item 
     */
    public void equip(Helmet item) {
        this.headSlot.insert(item);
        this.player.increaseStats(item);
    }
    
    /**
     * Dá na seba armor
     * @param item 
     */
    public void equip(Armor item) {
        this.armorSlot.insert(item);
        this.player.increaseStats(item);
    }
    
    /**
     * Dá na seba zbraň
     * @param item 
     */
    public void equip(Weapon item) {
        this.weaponSlot.insert(item);
        this.player.increaseStats(item);
    }
    
    
    /**
     * Dá dole zo seba zbraň
     */
    public void unequipWeapon() {
        this.unequipAtPosition(0);
    }
    
    /**
     * Dá dole zo seba armor
     */
    public void unequipArmor() {
        this.unequipAtPosition(1);
    }
    
    /**
     * Dá dole zo seba helmu
     */
    public void unequipHelmet() {
        this.unequipAtPosition(2);
    }
    
    /**
     * Dá dole zo seba vsetky veci
     */
    public void unequipAll() {
        this.unequipWeapon();
        this.unequipArmor();
        this.unequipHelmet();
    }
    
    private void unequipAtPosition(int index) {
        Equipment item = null;
        switch (index) {
            case 0:
                item = this.weaponSlot.remove();
                break;
            case 1:
                item = this.armorSlot.remove();
                break;
            case 2:
                item = this.headSlot.remove();
                break;
            default:
                return;
        }
        this.player.decreaseStats(item);
    }

    
    //      ******    Getters   *******
    
    public Slot<Weapon> getWeaponSlot() {
        return this.weaponSlot;
    }

    public Slot<Armor> getArmorSlot() {
        return this.armorSlot;
    }

    public Slot<Helmet> getHeadSlot() {
        return this.headSlot;
    }
    
    
}
