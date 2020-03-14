/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatures;

/**
 *
 * @author marce
 */
public class Creature {

    private int health;
    private int currentHealth;
    
    private int damage;
    
    private final String name;
    
    private boolean dead;
    
    

    public Creature(String name, int maxHealth, int damage) {
        this.name = name;
        this.health = maxHealth;
        this.currentHealth = this.health;
        this.damage = damage;
        this.dead = false;
    }
    
    public void takeDamage(int amount) {
        if (this.dead) {
            System.out.println("Already dead.");
            return;
        }
        
        if (amount <= 0) {
            return;
        }
        
        System.out.format("%s takes %d damage.%n", this.name, amount);
        this.currentHealth -= amount;
        if (this.currentHealth <= 0) {
            this.die();
            
        }
    }
    
    public void attack(Creature opponent) {
        if (this.dead) {
            return; 
        }
        opponent.takeDamage(this.damage);
    }
    
    public void die() {
        this.dead = true;
        System.out.format("%s died.%n", this.name);
    }

    public String getName() {
        return this.name;
    }

    public boolean isDead() {
        return this.dead;
    }
    
    public void heal(int amount) {
        if (this.dead) {
            return;
        }
        
        if (amount <= 0) {
            return;
        }
        this.currentHealth += amount;
        if (this.currentHealth > this.health) {
            this.currentHealth = this.health;
        }
    }

    public int getHealth() {
        return this.health;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getDamage() {
        return this.damage;
    }
    
    protected void fullyHealUp() {
        this.currentHealth = this.health;
    }
    
    
    
    
    
    
    
}
