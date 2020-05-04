
package sk.semestralka.shakelessmidget.creatures;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.items.slots.PlayerSlots;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.exceptions.NoMoneyException;
import sk.semestralka.shakelessmidget.exceptions.WrongTypeException;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.items.Equipment;

import sk.semestralka.shakelessmidget.player.moods.Newbie;
import sk.semestralka.shakelessmidget.player.moods.Mood;
import sk.semestralka.shakelessmidget.loaders.MoodLoader;

/**
 * Trieda Player sluzi pre hraca
 * @author marce
 */
public class Player extends Creature {

    private Mood mood;
    
    private int requiredXp;
    private int currentXp;
    private int overallXp;
    private int level;
    
    private int gold;
    
    private int armor;
    private int bonusHealth;
    private int bonusDamage;
    
    private Inventory inventory;
    private PlayerSlots slots;
    
    
    /**
     * Testovaci konstruktor
     * @param maxHealth maximalny zivot pre hraca
     * @param damage zakladny damage
     * @param mood specialna charakteristika
     */
    public Player(int maxHealth, int damage, Mood mood) {
        super("The hero", maxHealth, damage);
        
        this.mood = mood;
        this.requiredXp = 10;
        this.currentXp = 0;
        this.overallXp = 0;
        this.level = 1;
        this.gold = 0;
        
        
        this.bonusHealth = 0;   
        this.bonusDamage = 0;   
        this.armor = 0;         
        
        
        this.inventory = new Inventory(6);
        this.slots = new PlayerSlots(this); 
        
    }
    
    /**
     * Normalny konstruktor 
     */
    public Player() {
        this(20, 2, new Newbie());
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
        int remainingAmount = amount - (this.bonusHealth + this.armor);
        super.takeDamage(remainingAmount); 

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
        this.overallXp += amount;
        
        while (this.currentXp >= this.requiredXp) {
            this.currentXp -= this.requiredXp;
            this.levelUp();
        }

    }
    
    /**
     * Zvysi level, potrebne xp, damage, hp, a automaticky healne na max
     */
    private void levelUp() {
        this.level++;
        this.requiredXp += 5;
        super.increaseHealth(5);
        super.increaseDamage(2);
        
        
        if (this.mood != null) {
            this.mood.upgrade();
        }
        
    }
    
    /**
     * Da odmenu hracovi
     * @param xp xp
     * @param gold goldy
     * @param item  predmet
     * @throws sk.semestralka.shakelessmidget.exceptions.InventoryFullException
     */
    public void addReward(int xp, int gold, Item item) throws InventoryFullException {
        this.addItem(item);
        this.addXp(xp);
        this.addGold(gold);
        
    }
    
    /**
     * Prida hracovi predmet
     * @param item predmet
     * @throws sk.semestralka.shakelessmidget.exceptions.InventoryFullException
     */
    public void addItem(Item item) throws InventoryFullException {
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
     * Zoberie hracovi peniaze
     * @param amount pocet goldov
     * @throws NoMoneyException ak hrac nema dostatok penazi
     */
    public void removeGold(int amount) throws NoMoneyException {
        if (amount <= 0) {
            return;
        }
        
        int remaining = this.gold - amount;
        if (remaining < 0) {
            throw new NoMoneyException();
        }
        
        this.gold -= amount;
    }
    
    public void resetHealth() {
        super.revive();
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
        if (item == null) {
            return;
        }
        this.bonusHealth += item.getBonusHealth();
        this.bonusDamage += item.getBonusDamage();
        this.armor += item.getBonusArmor();

    }

    /**
     * Znizi zakladne atributy hraca, ak si da dole zo seba item
     * @param item 
     */
    public void decreaseStats(Equipment item) {
        if (item == null) {
            return;
        }
        this.bonusHealth -= item.getBonusHealth();
        this.bonusDamage -= item.getBonusDamage();
        this.armor -= item.getBonusArmor();
    }
    
    /**
     * Vrati inventory
     * @return 
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Vrati level
     * @return 
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Vrati vlastnu hodnotu sily utoku
     * @return 
     */
    @Override
    public int getDamage() {
        int totalDamage = super.getDamage() + this.bonusDamage;
        return totalDamage;
    }

    /**
     * Vrati vlastnu hodnotu zivotov
     * @return 
     */
    @Override
    public int getHealth() {
        int totalHealth = super.getHealth() + this.bonusHealth; 
        return totalHealth;
    }

    /**
     * Vrati armor
     * @return 
     */
    public int getArmor() {
        return this.armor;
    }

    /**
     * Vrati naladu hraca
     * @return 
     */
    public Mood getMood() {
        return this.mood;
    }

    /**
     * Vrati aktualnu hodnotu xp
     * @return 
     */
    public int getCurrentXp() {
        return this.currentXp;
    }

    /**
     * Vrati pocet goldov kolko vlastni hrac
     * @return 
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * Vrati pocet zivotov ktore ma z itemov
     * @return 
     */
    public int getBonusHealth() {
        return this.bonusHealth;
    }

    /**
     * VRati silu utoku ktoru ma z itemov
     * @return 
     */
    public int getBonusDamage() {
        return this.bonusDamage;
    }

    /**
     * Vrati potrebny pocet XP na dalsie kolo
     * @return 
     */
    public int getRequiredXp() {
        return this.requiredXp;
    }

    /**
     * 
     * @return 
     */
    public PlayerSlots getSlots() {
        return this.slots;
    }
    
    /**
     * Vrati info ohladom toho, čo je basic hp a čo bonusove
     * @return 
     */
    public String getHealthStats() {
        return String.format("Health Basic: %d Bonus: %d", super.getHealth(), this.bonusHealth);
    }
    
    /**
     * Vrati info ohladom toho, čo je basic dmg a čo bonusove
     * @return 
     */
    public String getDamageStats() {
        return String.format("Damage Basic: %d Bonus: %d", super.getDamage(), this.bonusDamage);
    }
    
    
    
    //      SAVE & LOAD
    
    
    /**
     * Ulozi hracove atributy
     * @param file 
     */
    public void save(DataOutputStream file) throws IOException {
        file.writeInt(this.overallXp);      //xp
        file.writeInt(this.gold);           //gold

        this.slots.save(file);
        this.inventory.save(file);
        
        this.mood.save(file);
    }
    
    /**
     * Nacita hraca
     * @param file
     * @throws IOException
     * @throws WrongTypeException 
     */
    public void load(DataInputStream file) throws IOException, WrongTypeException {
        int xp = file.readInt();
        int currentGold = file.readInt();
        this.addXp(xp);
        this.addGold(currentGold);

        this.slots.load(file);
        this.inventory.load(file);

        Mood newMood = new MoodLoader().createMood(file);
        this.changeMood(newMood);
        
    }
    
    
    
    
    
} 
