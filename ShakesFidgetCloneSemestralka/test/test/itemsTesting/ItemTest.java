/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.itemsTesting;

import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.items.slots.PlayerSlots;
import sk.semestralka.shakelessmidget.items.slots.Slot;
import sk.semestralka.shakelessmidget.items.valuables.Goods;
import junit.framework.Assert;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * @author marce
 */
public class ItemTest {
    

    private Goods trash;
    private Weapon wep;
    private Armor armor;
    private Helmet helm;
    
    
    @Before
    public void setUp() {
        this.trash = new Goods();
        this.wep = new Weapon();
        this.armor = new Armor();
        this.helm = new Helmet();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void slotTest() {
        Slot<Weapon> slotWep = new Slot<Weapon>();
        slotWep.insert(this.wep);
        
        Assert.assertFalse(slotWep.isEmpty());
        slotWep.insert(null);
        Assert.assertFalse(slotWep.isEmpty());
        slotWep.remove();
        Assert.assertTrue(slotWep.isEmpty());
        Assert.assertNull(slotWep.getItem());
       
    }
    
    /**
     * Otestuje či je inventory full
     */
    @Test
    public void inventoryTest() {
        Inventory inv = new Inventory(3);
        inv.addItem(this.wep);
        inv.addItem(this.wep);
        inv.addItem(this.armor);
        Assert.assertTrue(inv.isFull());
        
        
        
    }
    
    /**
     * Otestuje či da spravny size pri nespravnom parametri
     */
    @Test
    public void inventoryTest1() {
        Inventory inv = new Inventory(0);
        Assert.assertEquals(1, inv.getMaxSize());
        inv = new Inventory(-100);
        Assert.assertEquals(1, inv.getMaxSize());
        
    }
    
    /**
     * Otestuje či je inventory full
     */
    @Test
    public void inventoryTest2() {
        Inventory inv = new Inventory(3);
        inv.addItem(this.wep);
        inv.addItem(this.wep);
        inv.addItem(this.armor);
        Assert.assertTrue(inv.isFull());
    }
    
    
    
    /**
     * Otestuje ci maze spravne itemy pri spravnych a nespravnych parametroch
     */
    @Test
    public void inventoryTest3() {
        Inventory inv = new Inventory(1);
        inv.addItem(this.trash);
        inv.removeItem(this.wep);
        Assert.assertTrue("Ci sa vymaze spravny item ak posleme spravu aby sa vymazal nespravny item", inv.isFull());
        inv.removeItem(null);
        Assert.assertTrue(inv.isFull());
        inv.removeItem(this.trash);
        Assert.assertFalse("Ci sa vymaze spravny item ak posleme spravu aby sa vymazal spravny item", inv.isFull());
    }
    
    /**
     * Otestuje ci maze spravne itemy pri roznych indexoch
     */
    @Test
    public void inventoryTest4() {
        Inventory inv = new Inventory(1);
        inv.addItem(this.trash);
        inv.removeItem(5);
        Assert.assertTrue(inv.isFull());
        inv.removeItem(0);
        Assert.assertFalse(inv.isFull());
    }
    
    /**
     * Testovanie spravnosti equipovania itemov
     */
    @Test
    public void playerSlotTesting() {
        
        Player player = new Player();
        PlayerSlots ps = new PlayerSlots(player);
        Inventory inv = player.getInventory();
        
        inv.addItem(this.wep);
        inv.addItem(this.trash);
        inv.addItem(this.helm);
        
        ps.equip(this.wep);
        
        Assert.assertEquals("Equipnuty spravny item", 2, inv.getCurrentSize());
        
        ps.equip(inv.getItem(1));
        
        Assert.assertEquals("Equipnuty spravny item", 1, inv.getCurrentSize());
        
        ps.equip(inv.getItem(1));
        Assert.assertEquals("Index out of bound", 1, inv.getCurrentSize());
        
        ps.equip(inv.getItem(0));
        Assert.assertEquals("Neumozni equipnut trash item", 1, inv.getCurrentSize());
    }
    
    
    
    
    
}
