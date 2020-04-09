/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import adventure.Fight;
import adventure.Mission;
import adventure.Objective;
import creatures.Creature;
import creatures.Enemy;
import creatures.Imp;
import gui.MainFrame;
import gui.panels.mainPanels.PanelType;
import items.Item2;
import items.ItemGenerator;
import items.equippable.Armor;
import items.equippable.Helmet;
import items.equippable.Weapon;
import items.slots.Inventory;
import items.slots.PlayerSlots;
import items.valuables.Goods;
import player.basic.Player;



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


