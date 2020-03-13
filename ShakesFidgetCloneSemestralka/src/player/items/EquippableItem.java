/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;


public class EquippableItem extends Item {

    private final ItemType type;
    private boolean isEquipped;

    public EquippableItem(String name, int value, ItemType type) {
        super(name, value);
        this.type = type;
        this.isEquipped = false;
    }

    public ItemType getType() {
        return this.type;
    }
    
    public boolean equip() {

        if (this.isEquipped) {
            return false;
        }
        
        this.isEquipped = true;
        System.out.println("Uspesne equipnuty predmet");
        return true;
    }

    
    /**
     * Equippable item stale bude equippable
     * @return 
     */
    @Override
    public boolean isEquippable() {
        return true;
    }
    
    
    
    
}
