/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.basic;

import sk.semestralka.shakelessmidget.generators.Generator;
import gui.MainFrame;
import sk.semestralka.shakelessmidget.generators.ItemGenerator;
import sk.semestralka.shakelessmidget.player.basic.Player;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.items.valuables.Goods;

/**
 * Hlavna trieda ktora obsahuje zakladne logicke prvky
 */
public class Game {
    private Player player;
    private Generator generator;
    
    /**
     * Vytvori instanciu
     */
    public Game() {
        this.player = new Player();
        this.generator = new Generator(this.player);
        test();
        MainFrame mf = new MainFrame(this);
        
    }

    /**
     * Vrati hraca
     * @return 
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Vrati generator
     * @return 
     */
    public Generator getGenerator() {
        return this.generator;
    }
    
    
    private void test() {
        Weapon zbran = new Weapon();
        Helmet helma = new Helmet();
        Armor armor = new Armor();
        Goods goodies = new Goods();
        
        Armor armor2 = new ItemGenerator().generateArmor(1);
        
        this.player.getInventory().addItem(helma);
        this.player.getInventory().addItem(zbran);
        this.player.getInventory().addItem(armor);
        this.player.getInventory().addItem(armor2);

        
        this.player.getSlots().equip(armor);
        this.player.getSlots().equip(helma);
        this.player.getSlots().equip(zbran);
        
        this.player.getInventory().addItem(goodies);
        this.player.getInventory().addItem(new Weapon());
        this.player.getInventory().addItem(goodies);
        this.player.getInventory().addItem(goodies);
        this.player.getInventory().addItem(new Helmet());
        this.player.getInventory().addItem(goodies);
        this.player.getInventory().addItem(goodies);
        this.player.getInventory().addItem(new Armor());
        this.player.getInventory().addItem(goodies);
        this.player.getInventory().addItem(goodies);
        this.player.getSlots().equip(armor2);
        //po equipnuti
        System.out.println(player.getInventory().getCurrentSize());
        System.out.println(player.getInventory().getMaxSize());
        //System.out.println(this.player.getSlots().getArmorSlot().getItem());
    }
    
   
    
    
}
