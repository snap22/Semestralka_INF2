/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.creatures;

import sk.semestralka.shakelessmidget.basic.Chance;
import sk.semestralka.shakelessmidget.items.items.Item;


/**
 * Trieda Enemy sluzi ako hlavny nepriatel pre hraca
 * @author marce
 */
public class Enemy extends Creature {

    private int xpReward;
    private Item itemReward;

    /**
     * Vytvori instanciu
     * @param name nazov
     * @param maxHealth zivoty
     * @param damage sila utoku
     * @param xpReward odmena v xp
     * @param item predmet ktory moze dropnut
     */
    public Enemy(String name, int maxHealth, int damage, int xpReward, Item item) {
        super(name, maxHealth, damage);
        this.xpReward = xpReward;
        this.itemReward = item;
    }
    
    /**
     * Ma sancu na dropnutie itemu
     * @return bud Item alebo null
     */
    public Item dropItem() {
        if (Chance.generate(this.itemReward.getDropChance())) {
            return this.itemReward;
        }
        return null;
    }

    /**
     * Vrati odmenu v xp
     * @return 
     */
    public int getXpReward() {
        return this.xpReward;
    }

    /*
    public Item getItemReward() {
        return this.itemReward;
    }*/
    
    /**
     * Vypise nepriatela vo forme stringu
     * @return 
     */
    public String toString() {
        return String.format("Enemy{name=%s, hp=%d, dmg=%d, xp=%d}%n", this.getName(), this.getHealth(), this.getDamage(), this.getXpReward());
    }
    
    
    
    
}
