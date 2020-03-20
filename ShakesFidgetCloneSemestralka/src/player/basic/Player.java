/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.basic;

import items.slots.PlayerSlots;
import items.slots.Inventory;
import creatures.Creature;
import items.Item2;
import items.equippable.Equipment;

import player.moods.Beginner;
import player.moods.Mood;


public class Player extends Creature {

    private Mood mood;
    
    private int requiredXp;
    private int currentXp;
    private int level;
    
    private int damage;
    private int gold;
    
    private int health;
    private int currentHealth;
    
    private int armor;
    private int bonusHealth;
    private int bonusDamage;
    
    private Inventory inventory;
    private PlayerSlots slots;
    
    /**
     * Konstruktor - hlavne pre testovanie
     * @param maxHealth maximalny zivot pre hraca
     * @param damage zakladny damage
     * @param specialCharacter specialna charakteristika
     */
    public Player(int maxHealth, int damage, Mood specialCharacter) {
        super("The hero", maxHealth, damage);
        
        this.health = maxHealth;
        this.currentHealth = maxHealth;
        this.mood = specialCharacter;
        this.requiredXp = 10;
        this.currentXp = 0;
        this.level = 1;
        this.damage = damage;
        this.gold = 0;
        
        //bonusove veci, moznost zvysit cez itemy, alebo niektore charakteristiky
        this.bonusHealth = 0;   //increased by item
        this.bonusDamage = 0;   //increased by weapon or characteristic
        this.armor = 0;         //increased by item
        
        //item manazment
        this.inventory = new Inventory(6);
        this.slots = new PlayerSlots(this); 
    }
    
    /**
     * Normalny konstruktor pocas hry!
     */
    public Player() {
        this(20, 2, new Beginner());
    }
    
    /**
     * Zautoci na inu bytost, pri tom este spravi specialnu cinnost, ktoru ma kazdy character inu
     * Ak je character null - nespravi tie specialne cinnosti ani neprida bonus damage
     * @param opponent nepriatel na ktoreho zautoci
     */
    @Override
    public void attack(Creature opponent) {
        if (super.isDead()) {
            return;
        }
        int dmg = this.damage + this.bonusDamage; 
        if (this.mood != null) {
            this.mood.doSpecialStuff(this);
            dmg += this.mood.gainBonusDamage();
        }

        
        opponent.takeDamage(dmg);
    }
    
    
    /**
     * zmenit
     * @param amount 
     */
    @Override
    public void takeDamage(int amount) {
        int remainingAmount = Math.abs((this.bonusHealth + this.armor) - amount);
        super.takeDamage(remainingAmount); 
        
       /* if (super.isDead()) {
            System.out.println("Already dead.");
            return;
        }
        
        if (amount <= 0) {
            return;
        }
        
        int remainingAmount = this.bonusHealth - amount;
        //daco s armorom este
        this.currentHealth -= remainingAmount;
        
        System.out.format("Player takes %d damage.%n", amount);
        
        if (this.currentHealth <= 0) {
            this.die();
        }*/
       
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
    
    /**
     * Zvysi level, potrebne xp, damage, hp, a automaticky healne na max
     */
    private void levelUp() {
        this.level++;
        this.requiredXp += 5;
        
        this.damage += 2;
        this.health += 5;
        this.currentHealth = this.health;
        
        if (this.mood != null) {
            this.mood.upgrade();
        }
        
        System.out.format("Reached level %d %n", this.level);
    }
    
    public void addReward(int xp, int gold, Item2 item) {
        this.addXp(xp);
        this.addGold(gold);
        this.inventory.addItem(item);
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
    
    /**
     * Zmeni naladu hraca. Ak je nova nalada null, alebo je to ta ista, tak to nezmeni.
     * @param newMood 
     */
    public void changeMood(Mood newMood) {
        if (newMood == null) {
            return;
        }
        
        if (this.mood.equals(newMood)) {
            return;
        }
        
        this.mood = newMood;
    }

    public void increaseStats(Equipment item) {
        this.bonusHealth += item.getBonusHealth();
        this.bonusDamage += item.getBonusDamage();
        this.armor += item.getBonusArmor();
    }

    public void decreaseStats(Equipment item) {
        this.bonusHealth -= item.getBonusHealth();
        this.bonusDamage -= item.getBonusDamage();
        this.armor -= item.getBonusArmor();
    }
    
    public Inventory getInventory() {
        return this.inventory;
    }

    public int getLevel() {
        return this.level;
    }
    
    
    
    
    

    
    
} //koniec Player
