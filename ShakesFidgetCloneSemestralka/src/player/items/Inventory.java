/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;

import java.util.HashMap;



/**
 *
 * @author marce
 */
public class Inventory {

    private final int size;
    
    private HashMap<String, Item> items;

    public Inventory(int size) {
        this.size = size;
        
        this.items = new HashMap<String, Item>();
        
    }
    /**
     * Prida predmet do inventara. Ak je inventar plny, neprida ho
     * @param item 
     */
    public void addItem(Item item) {
        if (this.items.size() >= this.size) {
            return;
        }
        
        this.items.put(item.getName(), item);
    }
    
    /**
     * Vymaze predmet z inventara. Ak sa taky predmet nenachadza v inventari tak nespravi nic
     * @param itemName nazov predmetu ktory chceme vymazat
     */
    public void removeItem(String itemName) {
        if (!this.items.containsKey(itemName)) {
            return;
        }
        this.items.remove(itemName);
    }
    
    /**
     * Vyprazdni inventar
     */
    public void clear() {
        if (this.items.isEmpty()) {
            return;
        }
        this.items.clear();
    }
    
    /**
     * Vrati boolean ci je este prazdne miesto v inventari
     * @return 
     */
    public boolean hasAvailableSpace() {
        return this.items.size() < this.size;
    }
    
    
}
