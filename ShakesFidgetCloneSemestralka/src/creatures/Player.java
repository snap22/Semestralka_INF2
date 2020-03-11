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
    
    private int bonusDamage;
    

    public Player(int maxHealth, int damage, ICharacter specialCharacter) {
        super("The hero", maxHealth, damage);
        
        this.character = specialCharacter;
        this.requiredXp = 10;
        this.currentXp = 0;
        this.level = 1;
        this.bonusDamage = 0;
        
    }
    
    

    /**
     * Zautoci na inu bytost, pri tom este spravi specialnu cinnost, ktoru ma kazdy character inu
     * @param opponent nepriatel na ktoreho zautoci
     */
    @Override
    public void attack(Creature opponent) {
        //if should do special stuff --> do special stuff
        this.character.doSpecialStuff(this);
        
        opponent.takeDamage(0);
    }
    /**
     * prida hracovi xp, ak bude viac ako pozadovane xp tak mu zvysi uroven
     * @param amount mnozstvo xp
     */
    public void addXp(int amount) {
        if (amount <= 0) {
            return;
        }
        this.currentXp += amount;
        if (this.currentXp >= this.requiredXp) {
            this.currentXp -= this.requiredXp;
            this.levelUp();
            
        }
        
    }
    
    private void levelUp() {
        this.level++;
        this.requiredXp += 5;
        
    }

    
    
    

    
    
}
