/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.slots2;

import wrongShit.ItemType;
import semestralka.game.player.basic.Player;

/**
 *
 * @author marce
 */
public class PlayerSlots2 {
    private Slot2 headSlot;
    private Slot2 armorSlot;
    private Slot2 weaponSlot;
    private final Player player;
    
    private Slot2[] slots;

    public PlayerSlots2(Player player) {
        this.player = player;
        this.headSlot = new Slot2(ItemType.HELMET);
        this.armorSlot = new Slot2(ItemType.ARMOR);
        this.weaponSlot = new Slot2(ItemType.WEAPON);
        
        this.slots = new Slot2[]{this.headSlot, this.armorSlot, this.weaponSlot};
    }
    
    /**
     * Prejde vsetky sloty, ak sa typ slotu zhoduje s typom itemu, vlozi ho tam. 
     * Nasledne zvysi playerovi staty o dane hodnoty
     * Ak uz je nahodou ten slot obsadeny, tak vymaze dany item zo slot
     * @param item Predmet ktory chceme vlozit
     */
    /*public void equip(Item2 item) {
        for (Slot2 slot : this.slots) {
            if (slot.getType() == item.getType()) {
                if (!slot.isEmpty()) {
                    slot.remove();
                }
                
                if (slot.insert(item)) {
                    item.equip();
                    //this.player.increaseStats(item);
                    return;
                }
                
                
                
            }
        }
    }
    
    public void unequip(int index) {
        if (index >= this.slots.length || index < 0) {
            return;
        }
        
        if (this.slots[index].isEmpty()) {
            return;
        }
        //this.player.decreaseStats(item);
        
        this.slots[index].getItem().unequip();
        this.slots[index].remove();
    }*/
    
    
    
    
    
    
    
}
