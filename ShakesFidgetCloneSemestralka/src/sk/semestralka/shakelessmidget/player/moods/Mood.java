/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.player.moods;


import java.io.DataOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 *
 * @author marce
 */
// extends EquippableItem
public abstract class Mood {
    private int chance;
    private int bonusDamage;
    private String name;
    private Player player;
    private final int limit;
    
    private boolean shouldIncrease;

    /**
     * 
     * @param name nazov charakteristiky
     * @param chance sanca ze vykona danu vec
     * @param limit maximalne dosiahnutie sance
     * @param bonusDamage  ak zvysuje damage, tak o kolko
     */
    protected Mood(String name, int chance, int limit, int bonusDamage) {
        this.chance = chance;
        this.name = name;
        this.limit = limit;
        this.bonusDamage = bonusDamage;
        this.shouldIncrease = chance < limit;
    }
    
    /**
     * Pretazenie konstruktora, automaticky nastavi bonus damage na 0.
     * Teda dana charakteristika nezvysuje damage hracovi
     * @param name nazov charakteristiky
     * @param chance sanca ze vykona danu vec
     * @param limit ak zvysuje damage, tak o kolko
     */
    public Mood(String name, int chance, int limit) {
        this(name, chance, limit, 0);
    }

    /**
     * Specialna metoda, kazda podtrieda vykona nieco ine
     * @param player 
     */
    public abstract void doSpecialStuff(Player player); 
    /**
     * Kolko damage zvysi hracovi
     * @return 
     */
    public int gainBonusDamage() {
        return this.bonusDamage;
    }

    /**
     * Metoda ktora vylepsuje sancu na vyokanie specialnej vlastnosti
     */
    public void upgrade() {
        if (this.shouldIncrease) {
            if (this.chance >= this.limit) {
                return;
            }
            this.chance++;
        } else {
            if (this.chance <= this.limit) {
                return;
            }
            this.chance--;
        }
        
    }

    /**
     * Objekt do formy Stringu
     * @return 
     */
    @Override
    public String toString() {
        return String.format("[ %S, sanca: %d, maximalne dosiahnutelna sanca: %d ]%n", this.name, this.chance, this.limit);
    }
    
    public String getName() {
        return this.name;
    }
    
    /**
     * Porovna 2 charakteristiky na zaklade ich mena
     * @param other ina charakteristika s ktorou chceme porovnat
     * @return boolean ci su rovnake alebo nie
     */
    public boolean equals(Mood other) {
        return this.name.equals(other.getName());
    }

    /**
     * Metoda na ulozenie
     * @param file
     * @throws IOException 
     */
    public void save(DataOutputStream file) throws IOException {
        file.writeUTF(this.name);
    }
    
    public abstract String getDescription();
    
    protected int getChance() {
        return this.chance;
    }
}
