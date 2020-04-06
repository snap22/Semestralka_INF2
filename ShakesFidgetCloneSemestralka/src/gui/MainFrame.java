/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.panels.MenuPanel;
import gui.panels.WelcomePanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class MainFrame extends JFrame {
    
    private JPanel visiblePanel;
    private JPanel menuPanel;
    
    public MainFrame() {
        this.setTitle(" Shakeless Midget - The game of the year 2020");
        this.setSize(800, 600);
        
        
        this.menuPanel = new MenuPanel();
        this.visiblePanel = new WelcomePanel();
        this.add(this.visiblePanel, BorderLayout.CENTER);
        this.add(this.menuPanel, BorderLayout.WEST);
        
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);       //ak uzivatel stlaci na X vypne sa program
        
        
        this.setVisible(true);
    }
    
    
    /**
     * Zmeni aktualny panel, nie som si isty ci to funguje
     * @param newPanel 
     */
    public void changePanel(JPanel newPanel) {
        if (newPanel == null || newPanel == this.visiblePanel) {
            return;
        } 
        this.visiblePanel = newPanel;
    }
}
