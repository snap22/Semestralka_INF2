/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author marce
 */
public class WelcomePanel extends MainPanel {

    private final JTextArea text;
    private JScrollPane panel;

    public WelcomePanel() {
        super(PanelType.WELCOME);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Hello world");
        label.setForeground(Color.white);
        
        label.setFont(new Font("Verdana", Font.PLAIN, 70));
        
        
        this.setBackground(Color.black);
        this.add(label, BorderLayout.NORTH);
        
        
        
        this.text = new JTextArea();
        this.panel = new JScrollPane(this.text);
        this.panel.setPreferredSize(new Dimension(10, 10));
        this.add(this.text, BorderLayout.CENTER);
        this.add(this.panel, BorderLayout.EAST);
        
        
    }
    
    public void appendText(String text) {
        this.text.append(text);
        this.text.append("\n");
    }
    
}
