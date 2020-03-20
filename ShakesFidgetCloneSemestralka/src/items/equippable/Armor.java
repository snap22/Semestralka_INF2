/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.equippable;

import items.ItemRarity;


public class Armor extends Equipment {

    public Armor(String name, ItemRarity rarity, int goldValue, int levelRequired) {
        super(name, rarity, goldValue, 0, 1, 1, levelRequired);
    }
    
}
