/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sk.semestralka.shakelessmidget.player.basic.Player;
import sk.semestralka.shakelessmidget.player.moods.Mood;
import sk.semestralka.shakelessmidget.shop.Shop;

/**
 * Trieda ShopPanel sluzi ako obchod v ktorom si hrac moze kupit nahodnu vec 
 */
public class ShopPanel extends MainPanel {

    private final Player player;
    private final Shop shop;
    private final JButton buyBtn;
    private final JButton moodBtn;
    private final int priceForMood;
    private final int priceForItem;

    public ShopPanel(Player player, int priceForMood, int priceForItem) {
        super(PanelType.SHOP);
        this.shop = new Shop(player);
        this.player = player;
        JLabel label = new JLabel("THIS IS THE BEST SHOP");
        label.setFont(BasicGui.getFont(40));
        label.setForeground(Color.white);
        
        this.priceForMood = priceForMood;
        this.priceForItem = priceForItem;
        
        
        this.setBackground(Color.black);
        this.add(label, BorderLayout.NORTH);
        
        this.moodBtn = new JButton("Buy a mood");
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
        
        this.buyBtn = new JButton("Buy an item");
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
        
        this.add(this.moodBtn);
        this.add(this.buyBtn);
        
        this.setupButton(this.moodBtn, String.format("Price for a mood: %d", this.priceForMood));
        this.setupButton(this.buyBtn, String.format("Price for an item: %d", this.priceForItem));
        
        
        
    }
    
    /**
     * Nastavi vizualne tlacitka
     * @param button ktoreho tlacitka sa to tyka
     * @param toolTip aky text sa objavi ak sa s myskou pozriem na tlacitko
     */
    private void setupButton(JButton button, String toolTip) {
        button.setFont(BasicGui.getFont());
        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setToolTipText(toolTip);
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
    
    private void showBoughtMessage(Mood mood) {
        JOptionPane.showMessageDialog(null , String.format("You acquired %s mood!", mood.getName()));
    }
    
    private void showBoughtMessage(Item item) {
        JOptionPane.showMessageDialog(null , String.format("You acquired %s !", item.getName()));
    }
    
    
}
