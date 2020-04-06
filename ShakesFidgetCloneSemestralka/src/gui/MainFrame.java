/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.panels.WelcomePanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class MainFrame extends JFrame {
    
    private JPanel visiblePanel;
    private JPanel mainPanel;
    
    public MainFrame() {
        this.setTitle(" Shakeless Midget - The game of the year 2020");
        this.setSize(800, 600);
        this.mainPanel = new JPanel();
        this.mainPanel.setSize(800, 600);
        this.mainPanel.setLayout(new BorderLayout());
        
        this.visiblePanel = new WelcomePanel();
        this.mainPanel.add(this.visiblePanel, BorderLayout.EAST);
        
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
