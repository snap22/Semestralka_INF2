/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatures;

import basic.Chance;
import items.Item2;
import items.ItemGenerator;


public class Enemy extends Creature {

    private int xpReward;
    private Item2 itemReward;

    public Enemy(String name, int maxHealth, int damage, int xpReward) {
        super(name, maxHealth, damage);
        this.xpReward = xpReward;
        this.itemReward = ItemGenerator.generateRandomItem(damage);
    }
    
    /**
     * Ma sancu na dropnutie itemu
     * @return bud Item alebo null
     */
    public Item2 dropItem() {
        if (Chance.generate(this.itemReward.getDropChance())) {
            return this.itemReward;
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
