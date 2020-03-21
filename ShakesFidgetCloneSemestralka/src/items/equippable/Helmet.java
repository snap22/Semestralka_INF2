/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.equippable;

import items.ItemRarity;


public class Helmet extends Equipment {

    public Helmet(String name, ItemRarity rarity, int levelRequired) {
        super(name, rarity, 0, 1, 1, levelRequired);
    }
    
    public Helmet() {
        this("Training Cap", ItemRarity.COMMON, 0);
    }
    
    @Override
    public String toString() {
        return String.format("Helmet{%s, health= %d, armor= %d, rarity= %s, value= %d, required level= %d}", 
                super.getName(), super.getBonusHealth(), super.getBonusArmor(), super.getRarity(), 
                super.getGoldValue(), super.getLevelRequired());
    }
    
    
}
