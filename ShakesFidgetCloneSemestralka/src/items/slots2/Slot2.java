/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.slots2;


import items.Item2;
import wrongShit.ItemType;

/**
 *
 * @author marce
 */
public class Slot2 {

    private Item2 item;
    private ItemType type;

    
    
    public Slot2(ItemType type) {
        this.item = null;
        this.type = type;
    }
    
    public Slot2() {
        this(null);  
    }
    
    /**
     * Ak typ je null, tak hocijaky item sa do neho da vlozit
     * 
     * @param item 
     */
    public boolean insert(Item2 item) {
        if (item == null) {
            return false;
        }
        
        /*if (this.type != item.getType() && this.type != null) {
            return false;
        }*/
        
        
        if (!this.isEmpty()) {
            return false;
        }
        
        this.item = item;
        return true;
    }
    
    /**
     * Vymaze item zo slotu
     */
    public void remove() {
        this.item = null;
    }
    
    public Item2 getItem() {
        return this.item;
    }
    
    public boolean isEmpty() {
        return this.item == null;
    }
    
    public ItemType getType() {
        return this.type;
    }
}
