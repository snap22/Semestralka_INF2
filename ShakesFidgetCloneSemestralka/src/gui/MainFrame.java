/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import sk.semestralka.shakelessmidget.basic.Game;
import gui.panels.TemporaryPanel;
import gui.panels.MenuPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Hlavne okno pre graficke rozhranie
 */
public class MainFrame extends JFrame {
    
    private JPanel visiblePanel;
    private MenuPanel menuPanel;
    
    private final TemporaryPanel temp;
    private final Game game;
    
    
    /**
     * Konstruktor, spusti graficke rozhranie.
     * @param game hra
     */
    public MainFrame(Game game) {
        this.game = game;
        this.setTitle(" Shakeless Midget - The game of the year 2020");
        this.setSize(800, 600);
        
        
        
        Container content = this.getContentPane();
        
        this.menuPanel = new MenuPanel();
        
        //final WelcomePanel text = new WelcomePanel();
        
        //this.visiblePanel = text;
        this.temp = new TemporaryPanel(this.game);
        
        content.add(this.menuPanel, BorderLayout.WEST);
        content.add(this.temp, BorderLayout.CENTER);
        
        //this.pack();
        
        
        
        //this.visiblePanel = p.getPanel();
        //System.out.println(this.visiblePanel);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);       //ak uzivatel stlaci na X vypne sa program
        
        
        this.setVisible(true);
    }

    
}
