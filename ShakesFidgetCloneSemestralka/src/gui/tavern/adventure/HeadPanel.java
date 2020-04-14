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

    private final JLabel label;

    public HeadPanel(String name) {
        this.label = new JLabel(name);
        this.setBackground(Color.black);
        this.label.setFont(BasicGui.getFont(40));
        this.label.setForeground(Color.white);
        this.add(this.label);
    }
    
    public void changeTitle(String text) {
        this.label.setText(text);
    }
}
