/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.basic;

/**
 *
 * @author marce
 */
public abstract class Stat {
    private int amount;

    public Stat(int amount) {
        this.amount = amount;
    }

    public Stat() {
        this.amount = 0;
    }
    
    /**
     * Zvysi hodnotu
     */
    public void increase() {
        this.amount++;
    }
    
    public abstract void change(PlayerAttributes attributes);

    public int getAmount() {
        return this.amount;
    }
    
    
    
}
