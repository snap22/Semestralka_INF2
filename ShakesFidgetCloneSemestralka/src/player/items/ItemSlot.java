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
public class ItemSlot {
    private Item item;

    public ItemSlot() {
        this.item = null;
    }
    
    /**
     * Skusi pridat predmet do slotu. Ak v slote uz sa nachadza iny predmet, vrati false.
     * Ak sa podari vlozit predmet do slotu, vrati true.
     * @param item 
     * @return info ci sa podarilo vlozit predmet
     */
    public boolean add(Item item) {
        if (item == null) {
            return false;
        }
        
        if (this.item != null) {
            return false;
        }
        
        this.item = item;
        return true;
    }
    
    /**
     * Pokusi sa vymazat predmet zo slotu. Ak je slot prazdny, vrati false. 
     * Ak sa podari vymazat item zo slotu, vrati true.
     * @return info ci sa podarilo vymazat predmet
     */
    public boolean remove() {
        if (this.item == null) {
            return false;
        }
        
        this.item = null;
        return true;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    
}
