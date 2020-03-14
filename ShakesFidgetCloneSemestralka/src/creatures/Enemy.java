/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatures;

import basic.Chance;
import items.Item;


public class Enemy extends Creature {

    private int xpReward;

    public Enemy(String name, int maxHealth, int damage, int xpReward) {
        super(name, maxHealth, damage);
        this.xpReward = xpReward;
    }
    
    /**
     * Ma sancu na dropnutie itemu
     * @return bud Item alebo null
     */
    public Item dropItem(int chance) {
        if (Chance.generate(chance)) {
            return new Item();
        }
        return null;
    }

    @Override
    public void die() {
        super.die(); 
    }
    
    

    public int getXpReward() {
        return this.xpReward;
    }
}
