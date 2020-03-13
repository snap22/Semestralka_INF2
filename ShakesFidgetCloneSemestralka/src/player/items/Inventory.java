/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;


//import java.util.HashMap;
import java.util.LinkedHashMap;



/**
 *
 * @author marce
 */
public class Inventory {

    private final int size;
    
    private LinkedHashMap<String, Item> items;  
    //Linked HashMap si pamata poradie v akom boli popridavane itemy - vhodne pre indexovanie

    public Inventory(int size) {
        this.size = size;
        this.items = new LinkedHashMap<String, Item>();
        
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
     * Vymaze item na danej pozicii
     * @param index 
     */
    public void removeItem(int index) {
        Item itemNaVymazanie = this.getItem(index);
        if (itemNaVymazanie != null) {
            this.items.remove(itemNaVymazanie);
        }
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
    
    /**
     * Vrati predmet na zaklade nazvu
     * @param itemName
     * @return 
     */
    
    public Item getItem(String itemName) {
        if (this.items.isEmpty()) {
            return null;
        }
        
        if (!this.items.containsKey(itemName)) {
            return null;
        }
        
        return this.items.get(itemName);
    }
    
    /**
     * Vrati item na zaklade indexu
     * @param index
     * @return 
     */
    public Item getItem(int index) {
        if (index >= this.items.size()) {
            return null;
        }
        
        if (index < 0) {
            return null;
        }
        int current = 0;
        for (Item item : this.items.values()) {
            if (current == index) {
                return item;
            }
            current++;
        }
        return null;
    }
   
    
}
