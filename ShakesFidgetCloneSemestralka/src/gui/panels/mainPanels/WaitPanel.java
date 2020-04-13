/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import adventure.Objective;
import generators.Generator;
import gui.BasicGui;
import gui.panels.TemporaryPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import player.basic.Player;

/**
 *
 * @author marce
 */
public class WaitPanel extends MainPanel {

    private JButton skipButton;
    public WaitPanel(Objective obj) {
        super(PanelType.WAIT);
        int price = 50;
        this.skipButton = new JButton("Skip");
        this.skipButton.setToolTipText(String.format("Price for skipping: %d", price));
        this.setBackground(Color.black);
        JLabel label = new JLabel(obj.getName());
        label.setFont(BasicGui.getFont(50));
        label.setForeground(Color.WHITE);
        
        JLabel time = new JLabel(String.format("Duration: %d", obj.getDuration()));
        time.setFont(BasicGui.getFont(30));
        time.setForeground(Color.WHITE);
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        this.add(time);
        this.add(Box.createRigidArea(new Dimension(0, 300)));
        
        
        JProgressBar bar = new JProgressBar(0, obj.getDuration());
        
        
        this.add(bar);
        this.add(this.skipButton);
        
        
    }
    
}
