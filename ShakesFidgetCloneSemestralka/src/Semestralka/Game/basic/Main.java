/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka.game.basic;

import semestralka.game.adventure.Fight;
import semestralka.game.adventure.Mission;
import semestralka.game.adventure.Objective;
import semestralka.game.creatures.Creature;
import semestralka.game.creatures.Enemy;
import semestralka.game.creatures.Imp;
import semestralka.game.generators.Generator;
import semestralka.game.generators.LoadFile;
import semestralka.game.generators.ExampleType;
import gui.MainFrame;
import gui.panels.mainPanels.PanelType;
import semestralka.game.items.Item2;
import semestralka.game.generators.ItemGenerator;
import semestralka.game.items.equippable.Armor;
import semestralka.game.items.equippable.Helmet;
import semestralka.game.items.equippable.Weapon;
import semestralka.game.items.slots.Inventory;
import semestralka.game.items.slots.PlayerSlots;
import semestralka.game.items.valuables.Goods;
import semestralka.game.player.basic.Player;



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


