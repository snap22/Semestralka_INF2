/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;


public class Weapon extends EquippableItem {

    public Weapon(String name, int increaseHp, int increaseArmor, int goldValue, ItemType type) {
        super(name, increaseHp, increaseArmor, goldValue, type);
    }
    
    public int getBonusDamage() {
        return 0;
    }
    
}
