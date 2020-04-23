/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 * Trieda ShopPanel sluzi ako obchod v ktorom si hrac moze kupit nahodnu vec 
 */
public class ShopPanel extends MainPanel {

    private final Player player;

    public ShopPanel(Player player) {
        super(PanelType.SHOP);
        this.player = player;
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("THIS IS SHOP");
        label.setForeground(Color.white);
        
        label.setFont(new Font("Verdana", Font.PLAIN, 70));
        
        
        this.setBackground(Color.black);
        this.add(label, BorderLayout.NORTH);
    }
    
    // button - po kliknuti prida hracovi item, zoberie goldy. Pozn. ak je inventory full --> error- dialog box, popup window
    
}
