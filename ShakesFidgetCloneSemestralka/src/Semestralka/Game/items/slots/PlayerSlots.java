/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka.game.items.slots;


import semestralka.game.items.Item2;
import semestralka.game.items.equippable.Armor;
import semestralka.game.items.equippable.Equipment;
import semestralka.game.items.equippable.Helmet;
import semestralka.game.items.equippable.Weapon;
import semestralka.game.player.basic.Player;

/**
 * Trieda zodpoveda za to aby si hrac mohol dať na seba (equipnut) a zo seba rozne predmety a zabezpecuje aby sa vratili do inventory
 * 
 */
public class PlayerSlots {
    private Slot<Weapon> weaponSlot;
    private Slot<Armor> armorSlot;
    private Slot<Helmet> headSlot;
    private final Player player;
    private Inventory inventory;
    
    /**
     * 
     * @param player hrac ktoreho equipnute itemy bude spravovat
     */
    public PlayerSlots(Player player) {
        this.weaponSlot = new Slot<Weapon>();
        this.armorSlot = new Slot<Armor>();
        this.headSlot = new Slot<Helmet>();
        
        this.player = player;
        this.inventory = this.player.getInventory();
        
        
    }
    
    /**
     * Pozrie sa kde pasuje dany predmet a ak sa da tak ho da na seba
     * @param item 
     */
    public void equip(Item2 item) {
        if (item instanceof Helmet) {
            this.equip((Helmet)item);
            
        } else if (item instanceof Armor) {
            this.equip((Armor)item);
            
        } else if (item instanceof Weapon) {
            this.equip((Weapon)item);
            
        } else {
            System.out.println("Nevhodny item pre playera");
        }
        
    }
    
    /**
     * Dá na seba helmu
     * @param item 
     */
    public void equip(Helmet item) {
        this.equipItem(this.headSlot, item);
    }
    
    /**
     * Dá na seba armor
     * @param item 
     */
    public void equip(Armor item) {
        this.equipItem(this.armorSlot, item);
    }
    
    /**
     * Dá na seba zbraň
     * @param item 
     */
    public void equip(Weapon item) {
        this.equipItem(this.weaponSlot, item);
    }
    
   /**
    * Vyberie z inventory a da na hraca. Ak uz je na hracovi equipnuty predmet, tak ho najskor da dole a da do inventory
    * @return 
    */
    private void equipItem(Slot slot, Equipment item) {
        if (item.getLevelRequired() > this.player.getLevel()) {
            return;
        }
        if (!slot.isEmpty()) {
            Item2 removedItem = slot.remove();
            this.player.decreaseStats((Equipment)removedItem);
            this.inventory.addItem(removedItem);  
        }
        
        this.inventory.removeItem(item);
        this.player.increaseStats(item);
        slot.insert(item);
        
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
    
    /**
     * Podla danej pozicie vymaze item zo slotu, hodi ho do inventory a z hraca da dole staty
     * @param index
     * @return 
     */
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
        this.inventory.addItem(item);
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
