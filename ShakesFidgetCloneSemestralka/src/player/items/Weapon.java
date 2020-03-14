/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.items;


public class Weapon extends EquippableItem {

    public Weapon(String name, int damageIncrease,  int goldValue) {
        super(name, 0, 0, damageIncrease, goldValue, ItemType.WEAPON);   
    }
    
    
    
}
