/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.hero;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import sk.semestralka.shakelessmidget.items.items.Item;

/**
 *
 * @author marce
 */
public class ItemDetailsPanel extends JPanel {

    private JButton removeButton;
    private JButton equipButton;
    private JButton sellButton;
    
    public ItemDetailsPanel() {
        this.removeButton = new JButton("Remove");
        this.equipButton = new JButton("Equip");
        this.sellButton = new JButton("Sell");
        
        
        this.setBackground(Color.red);
        this.add(this.removeButton);
        this.add(this.equipButton);
        this.add(this.sellButton);
    }
    
    public void showInfo(Item item) {
        
    }
    
}
