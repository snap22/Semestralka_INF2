/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import adventure.Mission;
import adventure.Objective;
import generators.Generator;
import gui.BasicGui;
import gui.tavern.adventure.MissionPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author marce
 */
public class TavernPanel extends MainPanel {

    private MissionPanel[] adventures;
    private Generator gen;
    
    public TavernPanel(Generator gen) {
        super(PanelType.TAVERN);
        this.adventures = new MissionPanel[3];
        
        this.gen = gen;
        //this.setLayout(new BorderLayout());
        JLabel label = new JLabel("TAVERN ADVENTURES");
        label.setForeground(Color.white);
        
        label.setFont(BasicGui.getFont(30));
        JButton btn = new JButton("reset");
        this.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });
        
        
        this.setBackground(Color.black);
        this.add(label);
        
        //test
        //Mission mis1 = new Mission(new Objective("The Hunt", "Go and kill!", null, 1, 5, 0, 10 ), null);
        this.restart();
        
        this.repaint();
        
    }
    
    public void restart() {
        this.clear();
        for (int i = 0; i < this.adventures.length; i++) {
            this.createMission(i);
        }
    }
    
    private void createMission(int i) {
        if (i < 0 || i >= this.adventures.length) {
            return;
        }
        Mission mis = this.gen.generateMission();
        
        this.adventures[i] = new MissionPanel(mis);
        this.add(this.adventures[i]);
    }
    
    private void clear() {
        for (int i = 0; i < this.adventures.length; i++) {
            if (this.adventures[i] == null) {
                continue;
            }
            this.remove(this.adventures[i]);
        }
    }
    
}
