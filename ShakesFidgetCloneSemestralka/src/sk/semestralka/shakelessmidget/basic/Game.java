/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.basic;

import sk.semestralka.shakelessmidget.generators.Generator;
import gui.MainFrame;
import sk.semestralka.shakelessmidget.creatures.Player;

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
    
    
   
    
    
}
