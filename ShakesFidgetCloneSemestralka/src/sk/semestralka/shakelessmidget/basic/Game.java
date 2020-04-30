/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.basic;

import sk.semestralka.shakelessmidget.generators.Generator;
import gui.MainFrame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import sk.semestralka.shakelessmidget.exceptions.WrongTypeException;
import sk.semestralka.shakelessmidget.generators.ItemGenerator;
import sk.semestralka.shakelessmidget.player.basic.Player;
import sk.semestralka.shakelessmidget.items.equippable.Armor;
import sk.semestralka.shakelessmidget.items.equippable.Helmet;
import sk.semestralka.shakelessmidget.items.equippable.Weapon;
import sk.semestralka.shakelessmidget.items.items.Goods;

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
        //this.test();
        this.load();
        MainFrame mf = new MainFrame(this);
        
    }
    
    /**
     * Ulozi zakladne veci do suboru
     */
    public void save() {
        String path = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\saves\\currentSave.slm";
        File file = new File(path);
        try (DataOutputStream data = new DataOutputStream(new FileOutputStream(file, false));) {    //overwrite-ne subor ak je false
            this.player.save(data);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Subor sa nenasiel");
        } catch (IOException ex) {
            System.out.println("Nieco sa pokazilo v save");
        }
        
        System.out.println("uklada sa..");
        
    }
    
    
    
    /**
     * Nacita zo suboru
     */
    public void load() {
        String path = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\saves\\currentSave.slm";
        File file = new File(path);
        try (DataInputStream data = new DataInputStream(new FileInputStream(file))) {
            this.player.load(data);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Subor sa nenasiel");
        } catch (IOException ex) {
            System.out.println("Nieco sa pokazilo v loade");
        } catch (WrongTypeException ex) {
            System.out.println("Zly typ");    //toto asi nie tu treba
        }
        
        System.out.println("Nacita sa..");
        
    
    }
    
    /**
     * Vymaze subor so savemi
     */
    public void deleteFile() {
        String path = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\saves\\currentSave.slm";
        File file = new File(path);
        file.delete();
    }
    
    public void newGame() {
        this.player = new Player();
        
        this.deleteFile();
        this.save();
        this.load();
        
        System.exit(0);
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
    
    
    public void test() {
        Weapon zbran = new Weapon();
        Helmet helma = new Helmet();
        Armor armor = new Armor();
        Goods goodies = new Goods();
        
        Armor armor2 = new ItemGenerator().generateArmor(1);
        
        this.player.getInventory().addItem(helma);
        this.player.getInventory().addItem(zbran);
        this.player.getInventory().addItem(armor);

        
        this.player.getInventory().addItem(goodies);
        

    }
    
   
    
    
}
