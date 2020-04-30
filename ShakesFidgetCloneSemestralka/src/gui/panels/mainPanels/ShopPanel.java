/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import gui.BasicGui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sk.semestralka.shakelessmidget.exceptions.InventoryFullException;
import sk.semestralka.shakelessmidget.exceptions.NoMoneyException;
import sk.semestralka.shakelessmidget.player.basic.Player;
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
        //this.setLayout(new BorderLayout());
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
                    ShopPanel.this.shop.switchMood(ShopPanel.this.priceForMood);
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
                    ShopPanel.this.shop.buyItem(ShopPanel.this.priceForItem);
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
    
    
}
