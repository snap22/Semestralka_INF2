/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.a.gui.menu;

import sk.semestralka.shakelessmidget.a.gui.main.MainFrame;
import sk.semestralka.shakelessmidget.a.gui.main.PanelType;
import java.awt.Color;

import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.Box;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 *  Trieda MenuPanel obsahujuca hlavne buttony sluziace pre zmenu okna
 */
public class MenuPanel extends JPanel {

    private Dimension size;
    private HashMap<String, JButton> buttons;
    private final MainFrame frame;
    private final LowerButtonsPanel lowPanel;
    
    
    /**
     * Konstruktor, zobrazi panel
     */
    public MenuPanel(MainFrame frame) {
        this.frame = frame;
        this.buttons = new HashMap<String, JButton>();

        this.size = this.getPreferredSize();
        this.size.width = 200;
        
        //this.setBackground(new Color(20, 60, 100));
        this.setBackground(new Color(26, 26, 53));
        this.setPreferredSize(this.size);
        
        
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
        
        this.createGap(10);
        
        // main game buttony
        this.createMenuButton("Tavern", PanelType.TAVERN);
        this.createMenuButton("Shop", PanelType.SHOP);
        this.createMenuButton("Hero", PanelType.HERO);
        //this.createMenuButton("Dungeons");
        
        this.createGap(270);
        this.lowPanel = new LowerButtonsPanel(this.frame.getGame()); 
        this.add(this.lowPanel);
        
    }
    
    
    
    /**
     * Vytvori priestor za poslednym buttonom
     * @param height 
     */
    private void createGap(int height) {
        if (height <= 0) {
            return;
        }
        this.add(Box.createRigidArea(new Dimension(0, height)));
    }
    
    /**
     * Vytvori button so zadanym textom
     * @param text 
     */
    private void createMenuButton(String text, PanelType type) {
        MenuButton newButton = new MenuButton(text, this.size, type);

        this.add(newButton);
        this.buttons.put(newButton.getText(), newButton);
        this.createGap(5);
        
                
    }
    
    
    
    
    
}
