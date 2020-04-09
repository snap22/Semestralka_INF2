/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import gui.panels.mainPanels.HeroPanel;
import gui.panels.mainPanels.MainPanel;
import gui.panels.mainPanels.MiniGamePanel;
import gui.panels.mainPanels.PanelType;
import gui.panels.mainPanels.ShopPanel;
import gui.panels.mainPanels.TavernPanel;
import gui.panels.mainPanels.WelcomePanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class TemporaryPanel extends JPanel {

    private final CardLayout card;
    private JPanel panelToChange;
    
    private HashMap<String, MainPanel> panels;
    
    
    public TemporaryPanel() {
        this.setLayout(new BorderLayout());
        this.panelToChange = new JPanel();
        
        this.add(this.panelToChange, BorderLayout.CENTER);  //aby to zaplnilo cely panel
 
        this.card = new CardLayout();
        this.panelToChange.setLayout(this.card);
        
        this.panels = new HashMap<String, MainPanel>();
        
        this.createPanel(new WelcomePanel());
        this.createPanel(new TavernPanel());
        this.createPanel(new HeroPanel());
        this.createPanel(new ShopPanel());
        this.createPanel(new MiniGamePanel());
        
        this.setupPanels();
        
        this.changePanel("WELCOME");    //na zaciatku nastavi welcome panel aby bol viditelny
    }

    /**
     * Nastavi panely, prida ich do JPanel a každemu da identifikator podla jeho typu
     */
    private void setupPanels() {
        for (MainPanel panel : this.panels.values()) {
            this.panelToChange.add(panel, panel.getTypeString());
        }
    }
    /**
     * Vytvori panel a da ho do hashmapu
     * @param newPanel 
     */
    private void createPanel(MainPanel newPanel) {
        if (newPanel == null) {
            return;
        }
        
        this.panels.put(newPanel.getTypeString(), newPanel);
    }
    
    /**
     * Na zaklade zadaneho parametra ukaze dany panel, ak je v paneloch
     * @param type 
     */
    public void changePanel(PanelType type) {
        if (type == null) {
            return;
        }
        this.changePanel(type.toString());
        
    }
    
    public void changePanel(String type) {
        if (type == null) {
            return;
        }
        
        if (!this.panels.containsKey(type)) {
            return;
        }
        
        this.card.show(this.panelToChange, type);
    }
 
    /*
    //this.tempPanel = new WelcomePanel();
        this.add(this.panelToChange);
        this.firstPanel = new TavernPanel();
        this.firstPanel.add(this.but1);
        //this.tempPanel = this.firstPanel;
        
        this.secondPanel = new HeroPanel();
        this.secondPanel.add(this.but2);
        
        //this.add(this.tempPanel, "0");
        this.panelToChange.add(this.firstPanel, "1");
        this.panelToChange.add(this.secondPanel, "2");
        
        
        this.card.show(this.panelToChange, "1");
    */
}
