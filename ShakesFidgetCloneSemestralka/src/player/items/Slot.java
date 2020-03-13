/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;

/**
 *
 * @author marce
 */
public class Slot {

    private EquippableItem item;
    private ItemType type;
    public Slot(ItemType type) {
        this.item = null;
        this.type = type;
    }
    /**
     * Skusi si dat na seba item. Vrati boolean ci sa mu to podarilo
     * Typ itema sa musi zhodovat s typom slotu
     * @param item
     * @return 
     */
    public boolean equip(EquippableItem item) {
        if (this.item != null) {
            return false;
        } 
        
        if (item.getType() != this.type) {
            return false;
        }
        
        if (item == null) {
            return false;
        }
        
        
        
        //ToDo prida efekty z itemu na hraca
        item.equip();
        this.item = item;
        
        return true;
    }
    
    /**
     * Pokusi sa dat zo seba dole item
     * Pozn. mozno dobuducna zmenit na return ITEM
     * @return 
     */
    public boolean unequip() {
        if (this.item == null) {
            return false;
        }
        
        this.item = null;
        return true;
        
    }
    
    public ItemType getType() {
        return this.type;
    }
    
    public boolean isEmpty() {
        return this.item == null;
    }
}
