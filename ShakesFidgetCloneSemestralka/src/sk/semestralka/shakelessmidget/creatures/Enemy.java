/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.creatures;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.items.items.Item2;



public class Enemy extends Creature {

    private int xpReward;
    private Item2 itemReward;

    public Enemy(String name, int maxHealth, int damage, int xpReward, Item2 item) {
        super(name, maxHealth, damage);
        this.xpReward = xpReward;
        this.itemReward = item;
    }
    
    /*public Enemy(String name, int maxHealth, int damage) {
        this(name, maxHealth, damage, 10);
    }*/
    
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

    //test
    public Item2 getItemReward() {
        return this.itemReward;
    }
    
    public String toString() {
        return String.format("Enemy{name=%s, hp=%d, dmg=%d, xp=%d}%n", this.getName(), this.getHealth(), this.getDamage(), this.getXpReward());
    }
    
    
    
    
}
