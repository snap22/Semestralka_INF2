
package sk.semestralka.shakelessmidget.a.gui.hero;

import sk.semestralka.shakelessmidget.a.gui.basic.BasicGui;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import sk.semestralka.shakelessmidget.items.slots.Inventory;
import sk.semestralka.shakelessmidget.creatures.Player;

/**
 * Trieda HeroStatsPanel sluzi pre zobrazovanie zakladnych informacii o hracovi
 */
public class HeroStatsPanel {
    
    private HashMap<String, DetailLabel> labels;
    private final Player player;
    private JProgressBar bar;
    private final HeroEquippedItems equippedItems;
    private final HeroInventoryItems inventoryItems;
    private final JLabel inventoryItemsLabel;
    private final DetailLabelHolder labelsManager;
    private final JPanel panel;

    /**
     * Konstruktor pre triedu, vytvoria sa udaje ktore udavaju zakladne informacie o hracovi
     * @param player 
     */
    public HeroStatsPanel(Player player) {
        this.panel = new JPanel();
        this.player = player;
        this.labelsManager = new DetailLabelHolder();
        this.bar = new JProgressBar(0, this.player.getRequiredXp());
        this.panel.setBackground(Color.white);
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.panel.add(this.labelsManager.getPanel());
        
        this.labelsManager.addLabel("Mood", player.getMood().getName());
        this.labelsManager.addLabel("Health", player.getHealth());
        this.labelsManager.addLabel("Armor", player.getArmor());
        this.labelsManager.addLabel("Damage", player.getDamage());
        this.labelsManager.addLabel("Level", player.getLevel());
        this.labelsManager.addLabel("Gold", player.getGold());
        
        this.panel.add(Box.createRigidArea(new Dimension(5, 10)));    //medzera
        
        this.panel.add(this.bar);
        this.bar.setStringPainted(true);
        this.bar.setForeground(Color.orange);
        this.bar.setString("XP");
        
        
        
        
        this.panel.add(Box.createRigidArea(new Dimension(5, 5)));
        this.panel.add(new JSeparator());
        
        //  Equipped label
        JLabel equippedItemsLabel = new JLabel("Equipped:");
        equippedItemsLabel.setFont(BasicGui.getFont());
        this.panel.add(equippedItemsLabel);
       
        
        //  Equipped items
        this.equippedItems = new HeroEquippedItems(this.player); 
        JScrollPane equippedScrollPane = new JScrollPane(this.equippedItems.getList());
        this.panel.add(equippedScrollPane);
        
        //  medzera
        this.panel.add(Box.createRigidArea(new Dimension(5, 10)));
        
        // Inventory Label
        this.inventoryItemsLabel = new JLabel("Inventory:");
        this.inventoryItemsLabel.setFont(BasicGui.getFont());
        this.panel.add(this.inventoryItemsLabel);
        
        
        //  Inventory Items
        this.inventoryItems = new HeroInventoryItems(this.player);
        JScrollPane inventoryScrollPane = new JScrollPane(this.inventoryItems.getList());
        this.panel.add(inventoryScrollPane);

       
    }

    /**
     * Vrati zoznam predmetov ktore ma hrac equipnute
     * @return 
     */
    public HeroEquippedItems getEquippedItems() {
        return this.equippedItems;
    }

    /**
     * Vrati zoznam predmetov ktore ma hrac v inventory
     * @return 
     */
    public HeroInventoryItems getInventoryItems() {
        return this.inventoryItems;
    }

    /**
     * Vrati panel
     * @return  panel
     */
    public JPanel getPanel() {
        return this.panel;
    }
    
    
    
    
    /**
     * Aktualizuje vsetky komponenty
     */
    public void updateAll() {
        this.updateLabel("Mood", this.player.getMood().getName(), this.player.getMood().getDescription());
        this.updateLabel("Health", this.player.getHealth(), this.player.getHealthStats());
        this.updateLabel("Armor", this.player.getArmor(), null);
        this.updateLabel("Damage", this.player.getDamage(), this.player.getDamageStats());
        this.updateLabel("Level", this.player.getLevel(), null);
        this.updateLabel("Gold", this.player.getGold(), null);

        this.updateBar();
        this.equippedItems.update();
        this.inventoryItems.update();
        this.updateInventoryLabel();
        
    }
    
    /**
     * Aktualizuje labely
     * @param labelName nazov labelu
     * @param text text v labelu
     * @param tooltip  hover tip labelu
     */
    private void updateLabel(String labelName, String text, String tooltip) {
        this.labelsManager.updateText(labelName, text);
        if (tooltip != null) {
            this.labelsManager.getLabel(labelName).getLabel().setToolTipText(tooltip);
        }
        
    }
    
    /**
     * Pretazenie, aktualizuje labely
     * @param labelName nazov labelu
     * @param number cislo v labelu
     * @param tooltip  hover tip labelu
     */
    private void updateLabel(String labelName, int number, String tooltip) {
        this.updateLabel(labelName, String.valueOf(number), tooltip);
    }
    
    /**
     * aktualizuje predmety v inventory hraca
     */
    private void updateInventoryLabel() {
        Inventory inv = this.player.getInventory();
        this.inventoryItemsLabel.setText(String.format("Inventory: %d / %d", inv.getCurrentSize(), inv.getMaxSize()));
    }
    
    /**
     * Aktualizuje progressbar
     */
    private void updateBar() {
        this.bar.setMaximum(this.player.getRequiredXp());
        this.bar.setValue(this.player.getCurrentXp());
        String xpStatus = String.format("XP %d / %d", this.player.getCurrentXp(), this.player.getRequiredXp());
        this.bar.setString(xpStatus);
    }

    
}
