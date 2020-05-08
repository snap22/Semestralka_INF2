
package sk.semestralka.shakelessmidget.a.gui.hero;

import sk.semestralka.shakelessmidget.a.gui.basic.BasicGui;
import sk.semestralka.shakelessmidget.a.gui.basic.MainPanel;
import sk.semestralka.shakelessmidget.a.gui.basic.PanelType;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.creatures.Player;
import sk.semestralka.shakelessmidget.a.gui.listeners.IShowItemListener;
import sk.semestralka.shakelessmidget.a.gui.listeners.IUpdatePlayerListener;

/**
 * Trieda HeroPanel sluzi na zobrazenie informacii o hracovi
 */
public class HeroPanel extends MainPanel {

    private final Player player;
    private final HeroStatsPanel heroStatsPanel;
    private final ItemDetailsPanel itemDetailsPanel;

    public HeroPanel(Player player) {
        super(PanelType.HERO);
        this.player = player;
        super.getPanel().setLayout(new BorderLayout());
        JLabel label = new JLabel("HERO");
        
        label.setFont(BasicGui.getFont(60));
        label.setForeground(Color.white);
        
        super.getPanel().setBackground(Color.black);
        super.getPanel().add(label, BorderLayout.NORTH);
        
        this.heroStatsPanel = new HeroStatsPanel(this.player);
        super.getPanel().add(this.heroStatsPanel.getPanel(), BorderLayout.WEST);
        
        this.itemDetailsPanel = new ItemDetailsPanel(this.player);
        super.getPanel().add(this.itemDetailsPanel.getPanel(), BorderLayout.CENTER);
        
        
        // listenery 
        this.setupListeners();
        
        
    }

    /**
     * Aktualizuje vsetky hodnoty hraca
     */
    public void updateStats() {
        
        this.heroStatsPanel.updateAll();
    }
    
    /**
     * Nastavi posluchacov
     */
    private void setupListeners() {
        this.heroStatsPanel.getInventoryItems().setListener(new IShowItemListener() {
            @Override
            public void itemSelected(Item item) {
                HeroPanel.this.itemDetailsPanel.showInfo(item, true);
                
            }
        });
        
        this.heroStatsPanel.getEquippedItems().setListener(new IShowItemListener() {
            @Override
            public void itemSelected(Item item) {
                HeroPanel.this.itemDetailsPanel.showInfo(item, false);
                
            }
        });
        
        this.itemDetailsPanel.setListener(new IUpdatePlayerListener() {
            @Override
            public void update() {
                HeroPanel.this.updateStats();
            }
        });
        
        
    }
    
    
}
