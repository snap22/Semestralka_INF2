/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import sk.semestralka.shakelessmidget.generators.Generator;
import gui.eventTry.Testicek;
import gui.hero.HeroPanel;
import gui.panels.mainPanels.MainPanel;
import gui.panels.mainPanels.MiniGamePanel;
import gui.panels.mainPanels.PanelType;
import gui.panels.mainPanels.ShopPanel;
import gui.panels.mainPanels.TavernPanel;
import gui.panels.mainPanels.WelcomePanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.basic.Game;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * Trieda TemporaryPanel sluzi na prepinanie panelov
 */
public class TemporaryPanel extends JPanel {

    private final CardLayout card;
    private JPanel panelToChange;
    
    private HashMap<String, MainPanel> panels;
    
    private Generator gen;
    private Player player;
    private final HeroPanel heroPanel;
    
    /**
     * Konstruktor pre TemporaryPanel, po vytvoreni sa zobrazi uvitaci panel
     * @param game hra
     */
    public TemporaryPanel(Game game) {
        Testicek.setPanel(this);
        
        this.gen = game.getGenerator();
        this.player = game.getPlayer();
        
        this.setLayout(new BorderLayout());
        this.panelToChange = new JPanel();
        
        this.add(this.panelToChange, BorderLayout.CENTER);  //aby to zaplnilo cely panel
 
        this.card = new CardLayout();
        this.panelToChange.setLayout(this.card);
        
        this.panels = new HashMap<String, MainPanel>();
        
        this.heroPanel = new HeroPanel(this.player);
        
        this.createPanel(new WelcomePanel());
        this.createPanel(new TavernPanel(game));
        this.createPanel(this.heroPanel);
        this.createPanel(new ShopPanel(this.player, 200, 50));
        this.createPanel(new MiniGamePanel(game));
        
        //this.createPanel(new WaitPanel(this.gen.generateObjective()));
        
        this.setupPanels();
        
        this.changePanel("WELCOME");    //na zaciatku nastavi welcome panel aby bol viditelny
    }

    
    
    /**
     * Na zaklade zadaneho parametra ukaze dany panel
     * @param type 
     */
    public void changePanel(PanelType type) {
        if (type == null) {
            return;
        }
        
        if (type == PanelType.HERO) {
            this.heroPanel.updateStats();
        }
        
        this.changePanel(type.toString());
        
    }
    
    /**
     * Na zaklade zadaneho retazca ukaze dany panel
     * @param type 
     */
    public void changePanel(String type) {
        if (type == null) {
            return;
        }
        
        if (!this.panels.containsKey(type)) {
            return;
        }
        
        
        this.card.show(this.panelToChange, type);
        this.heroPanel.updateStats();
        
        
    }
    
    /**
     * Nastavi panely, prida ich do kontajnera a každemu da identifikator podla jeho typu
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
 
    
}
