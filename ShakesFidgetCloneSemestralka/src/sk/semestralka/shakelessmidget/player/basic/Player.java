/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.basic;

import sk.semestralka.shakelessmidget.items.slots.PlayerSlots;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.creatures.Creature;
import sk.semestralka.shakelessmidget.items.items.Item2;
import sk.semestralka.shakelessmidget.items.equippable.Equipment;

import sk.semestralka.shakelessmidget.player.moods.Beginner;
import sk.semestralka.shakelessmidget.player.moods.Mood;


public class Player extends Creature {

    private Mood mood;
    
    private int requiredXp;
    private int currentXp;
    private int level;
    
    private int gold;
    
    //private int health;
    //private int currentHealth;
    
    private int armor;
    private int bonusHealth;
    private int bonusDamage;
    
    private Inventory inventory;
    private PlayerSlots slots;
    
    /**
     * Konstruktor - hlavne pre testovanie
     * @param maxHealth maximalny zivot pre hraca
     * @param damage zakladny damage
     * @param mood specialna charakteristika
     */
    public Player(int maxHealth, int damage, Mood mood) {
        super("The hero", maxHealth, damage);
        
        this.mood = mood;
        this.requiredXp = 10;
        this.currentXp = 0;
        this.level = 1;
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
        int dmg = super.getDamage() + this.bonusDamage; 
        if (this.mood != null) {
            this.mood.doSpecialStuff(this);
            dmg += this.mood.gainBonusDamage();
        }

        
        opponent.takeDamage(dmg);
    }
    
    
    /**
     * Hrac prijme utok
     * @param amount 
     */
    @Override
    public void takeDamage(int amount) {
        //ToDO  premysliet ARMOR
        //int remainingAmount = Math.abs((this.bonusHealth + this.armor) - amount);
        int remainingAmount = amount - (this.bonusHealth + this.armor);
        super.takeDamage(remainingAmount); 
        System.out.println("RA " + remainingAmount);

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
        super.increaseHealth(5);
        
        
        if (this.mood != null) {
            this.mood.upgrade();
        }
        
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

    /**
     * Zvysi zakladne atributy hraca, ak si da na seba item
     * @param item 
     */
    public void increaseStats(Equipment item) {
        this.bonusHealth += item.getBonusHealth();
        this.bonusDamage += item.getBonusDamage();
        this.armor += item.getBonusArmor();
    }

    /**
     * Znizi zakladne atributy hraca, ak si da dole zo seba item
     * @param item 
     */
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

    @Override
    public int getDamage() {
        int totalDamage = super.getDamage() + this.bonusDamage;
        return totalDamage;
    }

    @Override
    public int getHealth() {
        int totalHealth = super.getHealth() + this.bonusHealth; 
        return totalHealth;
    }

    public int getArmor() {
        return this.armor;
    }
    
    
    
    
    
    
    

    
    
} //koniec Player
