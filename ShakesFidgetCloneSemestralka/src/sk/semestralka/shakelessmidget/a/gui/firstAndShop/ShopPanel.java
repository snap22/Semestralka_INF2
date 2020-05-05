
package sk.semestralka.shakelessmidget.a.gui.firstAndShop;

import sk.semestralka.shakelessmidget.a.gui.main.MainPanel;
import sk.semestralka.shakelessmidget.a.gui.main.PanelType;
import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.exceptions.NoMoneyException;
import sk.semestralka.shakelessmidget.items.items.Item;
import sk.semestralka.shakelessmidget.creatures.Player;
import sk.semestralka.shakelessmidget.player.moods.Mood;
import sk.semestralka.shakelessmidget.shop.Shop;

/**
 * Trieda ShopPanel sluzi na zobrazenie obchodu v ktorom hrac moze nakupovat 
 */
public class ShopPanel extends MainPanel {

    
    private final Shop shop;
    private final JButton buyBtn;
    private final JButton moodBtn;
    private final int priceForMood;
    private final int priceForItem;

    /**
     * Nastavi pociatocne hodnoty a vytvori potrebne komponenty
     * @param player
     * @param priceForMood
     * @param priceForItem 
     */
    public ShopPanel(Player player, int priceForMood, int priceForItem) {
        super(PanelType.SHOP);
        this.shop = new Shop(player);
        
        JLabel label = new JLabel("THIS IS THE BEST SHOP");
        label.setFont(BasicGui.getFont(40));
        label.setForeground(Color.white);
        
        this.priceForMood = priceForMood;
        this.priceForItem = priceForItem;
        
        
        super.getPanel().setBackground(Color.black);
        super.getPanel().add(label, BorderLayout.NORTH);
        
        this.moodBtn = this.createButton("Buy a mood", String.format("Price for a mood: %d", this.priceForMood));
        this.buyBtn = this.createButton("Buy an item", String.format("Price for an item: %d", this.priceForItem));
        this.moodBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Mood boughtMood = ShopPanel.this.shop.switchMood(ShopPanel.this.priceForMood);
                    ShopPanel.this.showBoughtMessage(boughtMood);
                } catch (NoMoneyException ex) {
                    ShopPanel.this.showNoMoneyError();
                }
            }
        });
        
        
        this.buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Item boughtItem = ShopPanel.this.shop.buyItem(ShopPanel.this.priceForItem);
                    ShopPanel.this.showBoughtMessage(boughtItem);
                } catch (NoMoneyException ex) {
                    ShopPanel.this.showNoMoneyError();
                } catch (InventoryFullException ex) {
                    ShopPanel.this.showInvFull();
                }
            }
        });
        
    }

    /**
     * Pociatocne vytvorenie tlacidla a nastavenie zakladnych hodnot
     * @param text text na tlacidle
     * @param tooltip co bude zobrazovat ak sa nan s mysou pozrie
     * @return 
     */
    private JButton createButton(String text, String tooltip) {
        JButton button = new JButton(text);
        button.setFont(BasicGui.getFont());
        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setToolTipText(tooltip);
        super.getPanel().add(button);
        return button;
    }
    
    /**
     * Vyhodi popup error okno so zadanymi parametrami
     * @param title titulok
     * @param description text
     */
    private void showError(String title, String description) {
        JOptionPane.showMessageDialog(null, description, title, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Vyhodi popup okno ktore oznamuje hracovi ze ma plny inventar
     */
    private void showInvFull() {
        this.showError("No space", "Your inventory is full!");
    }
    
    /**
     * Vyhodi popup okno kde oznamuje hracovi ze nema dostatok penazi
     */
    private void showNoMoneyError() {
        this.showError("No money", "You don't have enough money!");
    }
    
    /**
     * Vyhodi okno ze co si hrac kupil
     * @param mood 
     */
    private void showBoughtMessage(Mood mood) {
        JOptionPane.showMessageDialog(null , String.format("You acquired %s mood!", mood.getName()));
    }
    
    /**
     * Vyhodi okno ze co si hrac kupil
     * @param item 
     */
    private void showBoughtMessage(Item item) {
        JOptionPane.showMessageDialog(null , String.format("You acquired %s !", item.getName()));
    }
    
    
}
