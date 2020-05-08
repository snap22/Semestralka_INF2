
package sk.semestralka.shakelessmidget.a.gui.basic;

import sk.semestralka.shakelessmidget.generators.Generator;
import sk.semestralka.shakelessmidget.a.gui.hero.HeroPanel;
import sk.semestralka.shakelessmidget.a.gui.firstAndShop.ShopPanel;
import sk.semestralka.shakelessmidget.a.gui.tavern.TavernPanel;
import sk.semestralka.shakelessmidget.a.gui.firstAndShop.WelcomePanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.main.Game;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 *
 * Trieda TemporaryPanel sluzi na prepinanie panelov
 */
public class TemporaryPanel {

    private final CardLayout card;
    private JPanel panelToChange;
    
    private HashMap<String, MainPanel> panels;
    
    private Generator gen;
    private Player player;
    private JPanel panel;
    
    /**
     * Konstruktor pre TemporaryPanel, po vytvoreni sa zobrazi uvitaci panel
     * @param game hra
     */
    public TemporaryPanel(Game game) {
        this.panel = new JPanel();
        this.gen = game.getGenerator();
        this.player = game.getPlayer();
        
        this.panel.setLayout(new BorderLayout());
        this.panelToChange = new JPanel();
        
        this.panel.add(this.panelToChange, BorderLayout.CENTER);  //aby to zaplnilo cely panel
 
        this.card = new CardLayout();
        this.panelToChange.setLayout(this.card);
        
        this.panels = new HashMap<String, MainPanel>();
        
        
        
        this.createPanel(new WelcomePanel());
        this.createPanel(new TavernPanel(game));
        this.createPanel(new HeroPanel(this.player));
        this.createPanel(new ShopPanel(this.player, 200, 50));
        
        
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
        ((HeroPanel)this.panels.get("HERO")).updateStats();
        
        
    }
    
    /**
     * Vrati panel
     * @return panel
     */
    public JPanel getPanel() {
        return this.panel;
    }
    
    /**
     * Nastavi panely, prida ich do kontajnera a každemu da identifikator podla jeho typu
     */
    private void setupPanels() {
        for (MainPanel mainPanel : this.panels.values()) {
            this.panelToChange.add(mainPanel.getPanel(), mainPanel.getTypeString());
            
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
