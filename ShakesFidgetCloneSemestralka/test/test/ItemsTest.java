/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import player.basic.Inventory;
import wrongShit.Item;

/**
 *
 * @author marce
 */
public class ItemsTest {

    private Inventory inventory;
    
    
    
    @Before
    public void setUp() {
        this.inventory = new Inventory(2);
    }
    
    
    /**
     * Vlozi sa do inventara predmet a nasledne sa vypyta
     */
    @Test
    public void ziskanieDobrehoItemu() {
        Item item = new Item("hlupost", 1);
        this.inventory.addItem(item);
        Item ziskanyItem = this.inventory.getItem(0);
        Assert.assertEquals(item, ziskanyItem);
    }
    
    /**
     * Vypyta si z inventara predmet ktory v nom nie je 
     */
    @Test
    public void ziskanieZlehoItemu() {
        Item item = this.inventory.getItem("");
        Assert.assertNull(item);
    }
    
    /**
     * Nema mat volne miesto
     */
    @Test
    public void skontrolovanieMiestaPlne() {
        this.inventory.addItem(new Item());
        this.inventory.addItem(new Item("Bum", 1));
        boolean maMiesto = this.inventory.hasAvailableSpace();
        Assert.assertFalse(maMiesto);
    }
    
    /**
     * Ma mat volne miesto
     */
    @Test
    public void skontrolovanieMiestaVolne() {
        this.inventory.addItem(new Item());
        boolean maMiesto = this.inventory.hasAvailableSpace();
        Assert.assertTrue(maMiesto);
    }
    
    /**
     * Spravne parametre pre vymazanie
     */
    @Test
    public void vymazanieItemuSpravne() {
        this.inventory.addItem(new Item("Bum", 1));
        boolean vymazalo = this.inventory.removeItem("Bum");
        Assert.assertTrue(vymazalo);
        
        this.inventory.addItem(new Item("Bum", 1));
        vymazalo = this.inventory.removeItem(0);
        Assert.assertTrue(vymazalo);
    }
    
    /**
     * Zle parametre pre vymazanie
     */
    @Test
    public void vymazanieItemuNespravne() {      
        boolean vymazalo = this.inventory.removeItem("Bum");
        boolean vymazalo2 = this.inventory.removeItem(100);
        boolean vymazalo3 = this.inventory.removeItem(null);
        Assert.assertFalse(vymazalo);
        Assert.assertFalse(vymazalo2);
        Assert.assertFalse(vymazalo3);
    }
}
