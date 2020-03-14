/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.basic;


//import java.util.HashMap;
import java.util.LinkedHashMap;
import items.Item;



/**
 *
 * @author marce
 */
public class Inventory {

    private final int size;
    
    private LinkedHashMap<String, Item> items;  
    //Linked HashMap si pamata poradie v akom boli popridavane itemy - vhodne pre indexovanie
    //HashMap<Integer, Item> ???

    public Inventory(int size) {
        this.size = size;
        this.items = new LinkedHashMap<String, Item>();
        
    }
    /**
     * Prida predmet do inventara. Ak je inventar plny, neprida ho
     * @param item 
     * POZN. AK SA PRIDA ITEM S ROVNAKYM NAZVOM, PREPISE SA..
     *      NEMOZU BYT 2 ROVNAKO - MENNE ITEMY V INVENTORY
     *      -- mozno prerobit hashmap na Integer, Item
     */
    public void addItem(Item item) {
        if (this.items.size() >= this.size) {
            return;
        }
        
        this.items.put(item.getName(), item);
    }
    
    /**
     * Vymaze predmet z inventara.Ak sa taky predmet nenachadza v inventari tak nespravi nic
     * @param itemName nazov predmetu ktory chceme vymazat
     * @return 
     */
    public boolean removeItem(String itemName) {
        if (!this.items.containsKey(itemName)) {
            return false;
        }
        this.items.remove(itemName);
        return true;
    }
    
    /**
     * Vymaze item na danej pozicii
     * @param index 
     * @return  
     */
    public boolean removeItem(int index) {
        Item itemNaVymazanie = this.getItem(index);
        if (itemNaVymazanie != null) {
            this.items.remove(itemNaVymazanie.getName());
            return true;
        }
        return false;
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
