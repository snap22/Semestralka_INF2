/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatures;

import creatures.specialCharacters.ICharacter;


public class Player extends Creature {

    private final ICharacter character;
    
    private int requiredXp;
    private int currentXp;
    private int level;
    
    private int damage;
    private int gold;
    

    public Player(int maxHealth, int damage, ICharacter specialCharacter) {
        super("The hero", maxHealth, damage);
        
        this.character = specialCharacter;
        this.requiredXp = 10;
        this.currentXp = 0;
        this.level = 1;
        this.damage = damage;
        this.gold = 0;
        
        
    }
    
    

    /**
     * Zautoci na inu bytost, pri tom este spravi specialnu cinnost, ktoru ma kazdy character inu
     * Ak je character null - nespravi tie specialne cinnosti ani neprida bonus damage
     * @param opponent nepriatel na ktoreho zautoci
     */
    @Override
    public void attack(Creature opponent) {
        int dmg = this.damage;
        
        if (this.character != null) {
            this.character.doSpecialStuff(this);
            dmg += this.character.gainBonusDamage();
        }

        opponent.takeDamage(dmg);
    }
    /**
     * prida hracovi xp, ak bude viac ako pozadovane xp tak mu zvysi uroven
     * @param amount mnozstvo xp
     */
    public void addXp(int amount) {
        if (amount <= 0) {
            return;
        }
        
        System.out.format("Gained %d xp%n", amount);
        this.currentXp += amount;
        if (this.currentXp >= this.requiredXp) {
            int numOfLevels = this.currentXp / this.requiredXp;
            this.currentXp %= this.requiredXp;
            
            for (int i = 0; i < numOfLevels; i++) {
                this.levelUp();
            }

        }
        
    }
    
    private void levelUp() {
        this.level++;
        this.requiredXp += 5;
        if (this.character != null) {
            this.character.upgrade();
        }
       
        System.out.format("Reached level %d %n", this.level);
        
    }

    /**
     * Prida goldy hracovi
     * @param amount pocet goldov
     */
    public void addGold(int amount) {
        if (amount <= 0) {
            return;
        }
        System.out.format("Gained %d gold%n", amount);
        this.gold += amount;
        
    }

    
    
    

    
    
}
