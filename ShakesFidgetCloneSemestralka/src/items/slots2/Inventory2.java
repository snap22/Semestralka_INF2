/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.slots2;

import sk.semestralka.shakelessmidget.items.items.Item;

/**
 *
 * @author marce
 */
public class Inventory2 {
    private Slot2[] slots;

    public Inventory2(int size) {
        this.slots = new Slot2[size];
        for (int i = 0; i < this.slots.length; i++) {
            this.slots[i] = new Slot2();
        }
    }
    
    /**
     * Prejde vsetky sloty a ked najde prve vhodne miesto na ulozenie predmetu, tak ho tam vlozi
     * @param item 
     */
    public boolean addItem(Item item) {
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i].insert(item)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean addItem(Item item, int index) {
        if (index < 0 || index >= this.slots.length) {
            return false;
        }
        
        return this.slots[index].insert(item);
        /*if (this.slots[index].insert(item)) {
            return true;
        }
        return false;*/
    }
    
    public void removeItem(int index) {
        if (index < 0 || index >= this.slots.length) {
            return;
        }
        
        this.slots[index].remove();
        
    }
    
}
