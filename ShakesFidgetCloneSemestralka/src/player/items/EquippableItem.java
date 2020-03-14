/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;


public class EquippableItem extends Item {

    private final ItemType type;
    private boolean isEquipped;
    
    private final int bonusHp;
    private final int bonusArmor;

    public EquippableItem(String name, int increaseHp, int increaseArmor, int goldValue, ItemType type) {
        super(name, goldValue);
        this.type = type;
        this.isEquipped = false;
        
        this.bonusHp = increaseHp;
        this.bonusArmor = increaseArmor;
    }

    public ItemType getType() {
        return this.type;
    }
    
    public void equip() {
        if (this.isEquipped) {
            return;
        }
        
        this.isEquipped = true;
        System.out.println("Uspesne equipnuty predmet");
        
    }
    
    public void unequip() {
        this.isEquipped = false;
    }

    public int getBonusHp() {
        return this.bonusHp;
    }

    public int getBonusArmor() {
        return this.bonusArmor;
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
