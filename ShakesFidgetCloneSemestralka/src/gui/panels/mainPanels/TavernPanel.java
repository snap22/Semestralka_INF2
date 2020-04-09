/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import adventure.Mission;
import adventure.Objective;
import gui.tavern.adventure.MissionPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author marce
 */
public class TavernPanel extends MainPanel {

    public TavernPanel() {
        super(PanelType.TAVERN);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("TAVERN");
        label.setForeground(Color.blue);
        
        label.setFont(new Font("Verdana", Font.PLAIN, 70));
        
        
        this.setBackground(Color.RED);
        this.add(label, BorderLayout.NORTH);
        
        //test
        Mission mis = new Mission(new Objective("The Hunt", "Go and kill!", null, 1, 5, 0, 10 ), null);
        this.add(new MissionPanel(mis), BorderLayout.CENTER);
    }
    
}
