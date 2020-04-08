/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import gui.buttons.MenuButton;
import java.awt.Color;

import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.Box;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 *  Trieda (panel) obsahujuca hlavne buttony
 */
public class MenuPanel extends JPanel {

    private Dimension size;
    private HashMap<String, JButton> buttons;
    
    public MenuPanel() {
        
        this.buttons = new HashMap<String, JButton>();

        this.size = this.getPreferredSize();
        this.size.width = 200;
        
        //this.setBackground(new Color(20, 60, 100));
        this.setBackground(new Color(26, 26, 53));
        this.setPreferredSize(this.size);
        
        
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
        
        this.createGap(10);
        
        // main game buttony
        this.createMenuButton("Tavern");
        this.createMenuButton("Shop");
        this.createMenuButton("Hero");
        //this.createMenuButton("Dungeons");
        
        this.createGap(20);
        
        //mini game buttony
        this.createMenuButton("Gamble");    //random od 1 do i, vyska vkladu, vyska vyhry ( v zavislosti od i )
        this.createMenuButton("Arena");
        this.createMenuButton("Math");
        
        
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
    private void createMenuButton(String text) {
        MenuButton newButton = new MenuButton(text, this.size);
        this.add(newButton);
        this.buttons.put(newButton.getText(), newButton);
        this.createGap(5);
                
    }
    
    
}
