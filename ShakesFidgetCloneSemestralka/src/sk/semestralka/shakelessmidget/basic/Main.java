/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.basic;

import sk.semestralka.shakelessmidget.adventure.Fight;
import sk.semestralka.shakelessmidget.adventure.Mission;
import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.creatures.Creature;
import sk.semestralka.shakelessmidget.creatures.Enemy;
import sk.semestralka.shakelessmidget.creatures.Imp;
import sk.semestralka.shakelessmidget.generators.Generator;
import sk.semestralka.shakelessmidget.generators.LoadFile;
import sk.semestralka.shakelessmidget.generators.ExampleType;
import gui.MainFrame;
import gui.panels.mainPanels.PanelType;
import sk.semestralka.shakelessmidget.items.items.Item2;
import sk.semestralka.shakelessmidget.generators.ItemGenerator;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.items.slots.PlayerSlots;
import sk.semestralka.shakelessmidget.items.valuables.Goods;
import sk.semestralka.shakelessmidget.player.basic.Player;



/**
 *
 * @author marce
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Enemy imp = new Imp();
        
        Creature player = new Player(10, 10, null);
        Objective obj = new Objective("Imp", "Zabi", imp, 20, 5, 100, 1);
        Mission mission = new Mission(obj, (Player)player);
        mission.start();
        */
        /*
        Inventory inv = new Inventory();
        Weapon wep = new Weapon();
        Goods goodie = new Goods();
        inv.addItem(wep);
        Player player = new Player();
        
        PlayerSlots ps = new PlayerSlots(player);
        */
        /*
        Armor arm = ItemGenerator.generateArmor(5);
        //System.out.println(arm);
        Weapon wep = ItemGenerator.generateWeapon(1);
        System.out.println(wep);
        Helmet helm = ItemGenerator.generateHelmet(-2);
        //System.out.println(helm);
        Goods shit = ItemGenerator.generateGoods();
        //System.out.println(shit);
        
        Player p = new Player(10, 10, null);
        PlayerSlots ps = new PlayerSlots(p);
        ps.equip(wep);
        //System.out.println(p.getDamage());
        Enemy e = new Enemy("BillyBoy", 20, 1);
        Fight f = new Fight(p, e);
        f.begin();
        */
        
        Game game = new Game();
        
        
        
    }
    
}


