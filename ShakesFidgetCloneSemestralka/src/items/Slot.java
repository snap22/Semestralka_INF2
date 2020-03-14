/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;



/**
 * Trieda Slot sluzi pre hraca, umoznuje mu equipnut rozne itemy, ktore su equipnutelne.
 */
public class Slot {

    private EquippableItem item;
    private ItemType type;
    
    
    public Slot(ItemType type) {
        this.item = null;
        this.type = type;
    }
    
    /**
     * Skusi vlozit do slotu item. Vrati boolean ci sa mu to podarilo
     * Typ itema sa musi zhodovat s typom slotu
     * Ak je equipnuty uz inym predmet, tak ho da dole
     * @param item
     * @return 
     */
    public void insertItem(EquippableItem item) {
        if (item == null) {
            return;
        }
        
        if (this.item != null) {
            this.removeItem();
        } 
        
        item.makeEquipped();
        this.item = item;
    }
    
    public boolean canInsert(EquippableItem item) {
        return this.item.getType() == item.getType();
    }
    
    //ak by som chcel nove inventory cez sloty
    /*public boolean canInsert(Item item) {
        if (item instanceof EquippableItem) {
            return this.canInsert((EquippableItem)item);
        }
        
        return true;
    }*/
    
    
    /**
     * Pokusi sa vymazat zo slotu item
     */
    public void removeItem() {
        if (this.item == null) {
            return;
        }
        
        this.item = null;
    }
    
    public ItemType getType() {
        return this.type;
    }
    
    public boolean isEmpty() {
        return this.item == null;
    }
}
