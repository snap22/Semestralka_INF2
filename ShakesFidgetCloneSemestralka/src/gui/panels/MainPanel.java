/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class MainPanel extends JPanel {

    private final CardLayout card;
    private JPanel tempPanel;
    
    
    public MainPanel() {
        this.card = new CardLayout();
        this.setLayout(this.card);
        this.tempPanel = new WelcomePanel();
        
        this.add(this.tempPanel);
        
    }
    
    public void change(JPanel newPanel) {
        this.tempPanel = newPanel;
        this.card.next(this.tempPanel);
    }
    
}
