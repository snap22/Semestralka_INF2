/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import gui.buttons.MenuButton;
import gui.listeners.IMenuPanelListener;
import gui.listeners.MenuPanelAction;
import gui.panels.mainPanels.PanelType;
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
    
    private IMenuPanelListener shit;
    private MenuPanelAction action;
    
    public MenuPanel() {
        this.action = new MenuPanelAction();
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
        
        this.createGap(20);
        
        //mini game buttony --> asi zmenit type..
        this.createMenuButton("Gamble", PanelType.MINIGAME);      //random od 1 do i, vyska vkladu, vyska vyhry ( v zavislosti od i )
        this.createMenuButton("Arena", PanelType.MINIGAME);       // kto z 2 enemy vyhra?
        this.createMenuButton("Math", PanelType.MINIGAME);        // priklady, vypocitat, ak spravne -> bonus gold
        
        
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
        MenuButton newButton = new MenuButton(text, this.size, this.action, type);

        this.add(newButton);
        this.buttons.put(newButton.getText(), newButton);
        this.createGap(5);
        
                
    }
    
    public void setPanelListener(IMenuPanelListener listener) {
        if (listener == null) {
            return;
        }
        
        this.shit = listener;
    }

    public MenuPanelAction getAction() {
        return this.action;
    }
    
    
    
}
