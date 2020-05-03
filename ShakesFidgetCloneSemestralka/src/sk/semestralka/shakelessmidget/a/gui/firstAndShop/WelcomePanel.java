/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.a.gui.firstAndShop;

import sk.semestralka.shakelessmidget.a.gui.main.MainPanel;
import sk.semestralka.shakelessmidget.a.gui.main.PanelType;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JScrollPane;


/**
 * Trieda WelcomePanel sluzi ako uvitacia trieda pre hraca ked spusti hru
 * Pocas hry nie je mozne opat sa dostat do tohto panela
 */
public class WelcomePanel extends MainPanel {

    private JScrollPane panel;

    public WelcomePanel() {
        super(PanelType.WELCOME);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel();
        label.setForeground(Color.white);
        this.setBackground(Color.black);
        this.add(label, BorderLayout.NORTH);
        

        //ImageIcon icon = new ImageIcon("files/logoSM.png");
        //ImageIcon icon = new ImageIcon(new ImageIcon("files/logoSmall.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
        ImageIcon icon = new ImageIcon("files/logoSmall.png");
        
        JLabel imgLabel = new JLabel(icon);
        this.add(imgLabel, BorderLayout.CENTER);
    }

}
