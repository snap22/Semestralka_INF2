/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import sk.semestralka.shakelessmidget.adventure.Objective;
import sk.semestralka.shakelessmidget.generators.Generator;
import gui.BasicGui;
import gui.panels.TemporaryPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import sk.semestralka.shakelessmidget.player.basic.Player;

/**
 *
 * @author marce
 */
public class WaitPanel extends MainPanel {

    private JButton skipButton;
    private final JProgressBar bar;
    private int timePassed;
    
    public WaitPanel(Objective obj) {
        super(PanelType.WAIT);
        int price = 50;
        this.skipButton = new JButton("Skip");
        this.skipButton.setToolTipText(String.format("Price for skipping: %d", price));
        this.setBackground(Color.black);
        this.timePassed = 0;
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
        
        
        this.bar = new JProgressBar(0, obj.getDuration());
        
        
        this.add(this.bar);
        this.add(this.skipButton);
        this.skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WaitPanel.this.beginCalc();
            }
        });
        JButton restart = new JButton("restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WaitPanel.this.timePassed = 0;
            }
        });
        
        this.add(restart);
        
        
        
        
    }
    
    private void beginCalc() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                WaitPanel.this.timePassed++;
                WaitPanel.this.bar.setValue(WaitPanel.this.timePassed);
                
                
                if (WaitPanel.this.timePassed >= WaitPanel.this.bar.getMaximum()) {
                    
                    t.cancel();
                }
            }
        }, 0, 1000);
    }
    
}
