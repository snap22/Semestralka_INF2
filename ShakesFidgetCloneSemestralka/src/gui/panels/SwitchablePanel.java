/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import gui.panels.mainPanels.HeroPanel;
import gui.panels.mainPanels.TavernPanel;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class SwitchablePanel extends JPanel {

    private final CardLayout card;
    private JPanel tempPanel = new JPanel();
    
    private JPanel firstPanel;
    private JPanel secondPanel;
    
    private JButton but1 = new JButton("hi");
    private JButton but2 = new JButton("bye");
    
    public SwitchablePanel() {
        this.card = new CardLayout();
        this.tempPanel.setLayout(this.card);
        //this.tempPanel = new WelcomePanel();
        this.add(this.tempPanel);
        this.firstPanel = new TavernPanel();
        this.firstPanel.add(this.but1);
        //this.tempPanel = this.firstPanel;
        
        this.secondPanel = new HeroPanel();
        this.secondPanel.add(this.but2);
        
        //this.add(this.tempPanel, "0");
        this.tempPanel.add(this.firstPanel, "1");
        this.tempPanel.add(this.secondPanel, "2");
        
        
        this.card.show(this.tempPanel, "1");
        
        
        this.but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(tempPanel, "2");
            }
        });
        
        this.but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(tempPanel, "1");
            }
        });
    }
    
    public void showPanel(String panelName) {
        
    }
    
    public void change(JPanel newPanel) {
        this.tempPanel = newPanel;
        this.card.next(this.tempPanel);
    }
    
}
