/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;

import creatures.Player;
import player.characteristics.Characteristic;

/**
 * Trieda ma za ulohu starat sa o equipovanie itemov, unequipovanie itemov, zabezpecit pridanie statov hracovi.
 * 
 */
public class PlayerSlots {
    private Slot headSlot;
    private Slot armorSlot;
    private Slot weaponSlot;
    private Slot[] slots;
    
    private final Player player;

    public PlayerSlots(Player player) {
        this.player = player;
        this.headSlot = new Slot(ItemType.HELMET);
        this.armorSlot = new Slot(ItemType.ARMOR);
        this.weaponSlot = new Slot(ItemType.WEAPON);
        this.slots = new Slot[]{this.headSlot, this.armorSlot, this.weaponSlot};
    }
    
    /**
     * Najde prvy slot do ktoreho moze vlozit dany item a equipnut ho
     * @param item 
     */
    public void equip(EquippableItem item) {
        for (Slot slot : this.slots) {
            //pokusi sa dat do slotu dany item, vrati boolean ci sa mu to podarilo + nastavi item na equipped
            if (slot.canInsert(item)) { 
                slot.insertItem(item);
                this.player.increaseStats(item);
                System.out.println("Uspesne equipnuty predmet");
                return;
            }
        }
    }
    
    /**
     * Pretazenie metody equip, vlozi charakteristiku do hraca
     * @param characteristic charakteristika ktoru chceme equipnut
     */
    public void equip(Characteristic characteristic) {
        this.player.changeCharacteristic(characteristic);
    }
    
    /**
     * Vymaze item na danej pozicii 
     * @param index index slotu z ktoreho ma vymazat item
     */
    public void remove(int index) {
        if (index >= this.slots.length) {
            return;
        }
        
        this.slots[index].removeItem();
    }
    
}
