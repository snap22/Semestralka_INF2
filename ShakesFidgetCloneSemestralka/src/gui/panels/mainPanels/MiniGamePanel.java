/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import sk.semestralka.shakelessmidget.basic.Game;

/**
 * Zatial nic  nerobi
 */
public class MiniGamePanel extends MainPanel {

    private Game game;

    public MiniGamePanel() {
        super(PanelType.MINIGAME);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("THIS IS A FREAKING MINIGAAME");
        label.setForeground(Color.YELLOW);
        
        label.setFont(new Font("Verdana", Font.PLAIN, 70));
        
        
        this.setBackground(Color.blue);
        this.add(label, BorderLayout.NORTH);
        
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        this.add(saveButton, BorderLayout.WEST);
        this.add(loadButton, BorderLayout.EAST);
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.save();
            }
        });
        
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.load();
            }
        });
    }

    public MiniGamePanel(Game game) {
        this();
        this.game = game;
    }
    
}
