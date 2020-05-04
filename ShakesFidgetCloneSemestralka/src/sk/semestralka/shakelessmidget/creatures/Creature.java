
package sk.semestralka.shakelessmidget.creatures;

/**
 * Trieda Creature sluzi ako nadtyp 
 */
public abstract class Creature {

    private int health;
    private int currentHealth;
    
    private int damage;
    
    private final String name;
    
    private boolean dead;
    
    
    /**
     * Vytvori instanciu
     * @param name meno
     * @param maxHealth zivoty
     * @param damage sila utoku
     */
    public Creature(String name, int maxHealth, int damage) {
        this.name = name;
        this.health = maxHealth;
        this.currentHealth = this.health;
        this.damage = damage;
        this.dead = false;
    }
    
    /**
     * Prijme utok
     * @param amount sila utoku
     */
    public void takeDamage(int amount) {
        if (this.dead) {
            return;
        }
        
        if (amount <= 0) {
            return;
        }
        
        this.currentHealth -= amount;
        if (this.currentHealth <= 0) {
            this.die();
            
        }
    }
    
    /**
     * Zautoci na protivnika
     * @param opponent protivnik
     */
    public void attack(Creature opponent) {
        if (this.dead) {
            return; 
        }
        opponent.takeDamage(this.damage);
    }
    
    /**
     * Zomrie
     */
    public void die() {
        this.dead = true;
    }

    /**
     * Vrati meno
     * @return 
     */
    public String getName() {
        return this.name;
    }

    /**
     * Vrati boolean ci je mrtvy
     * @return 
     */
    public boolean isDead() {
        return this.dead;
    }
    
    /**
     * Vylieci o dane mnozstvo
     * @param amount mnozstvo
     */
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

    /**
     * Vrati zivoty
     * @return 
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Vrati aktualne mnozstvo zivotov
     * @return 
     */
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    /**
     * Vrati silu utoku
     * @return 
     */
    public int getDamage() {
        return this.damage;
    }
    
    /**
     * ozivi bytost
     */
    protected void revive() {
        this.currentHealth = this.health;
        this.dead = false;
    }
    
    /**
     * Zvysi zivot o dane mnozstvo a instantne healne
     * @param amount 
     */
    protected void increaseHealth(int amount) {
        if (amount <= 0) {
            return;
        }
        this.health += amount;
        this.currentHealth = this.health;
    }
    
    /**
     * Zvysi damage o dane mnozstvo
     * @param amount 
     */
    protected void increaseDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        this.damage += amount;
    }
 
    
}
