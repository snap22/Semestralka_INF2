/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tavern.adventure;

import gui.BasicGui;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class HeadPanel extends JPanel {

    public HeadPanel(String name) {
        JLabel label = new JLabel(name);
        this.setBackground(Color.black);
        label.setFont(BasicGui.getFont(50));
        label.setForeground(Color.white);
        this.add(label);
    }
    
}
