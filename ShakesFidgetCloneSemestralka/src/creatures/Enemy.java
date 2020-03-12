/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatures;


public class Enemy extends Creature {

    private int xpReward;

    public Enemy(String name, int maxHealth, int damage, int xpReward) {
        super(name, maxHealth, damage);
        this.xpReward = xpReward;
    }
    
    public void dropItem() {
        
    }

    public int getXpReward() {
        return this.xpReward;
    }
}
