/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.listeners.IMenuPanelListener;
import gui.panels.MainPanel;
import gui.panels.MenuPanel;
import gui.panels.WelcomePanel;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class MainFrame extends JFrame {
    
    private JPanel visiblePanel;
    private MenuPanel menuPanel;
    
    private final MainPanel omfg;
    
    
    
    public MainFrame() {
        this.setTitle(" Shakeless Midget - The game of the year 2020");
        this.setSize(800, 600);
        
        
        
        Container content = this.getContentPane();
        
        this.menuPanel = new MenuPanel();
        
        //final WelcomePanel text = new WelcomePanel();
        
        //this.visiblePanel = text;
        this.omfg = new MainPanel();
        final MainPanel omfg2 = new MainPanel();
        
        //content.add(this.visiblePanel, BorderLayout.CENTER);
        content.add(this.menuPanel, BorderLayout.WEST);
        content.add(this.omfg);
        content.add(omfg2, BorderLayout.CENTER);
        
        this.menuPanel.getAction().setPanelListener(new IMenuPanelListener() {
            @Override
            public void changePanel(JPanel newPanel) {
                omfg2.change(newPanel);
            }
            
        });
        
        
        //this.visiblePanel = p.getPanel();
        System.out.println(this.visiblePanel);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);       //ak uzivatel stlaci na X vypne sa program
        
        
        this.setVisible(true);
    }

    
}
