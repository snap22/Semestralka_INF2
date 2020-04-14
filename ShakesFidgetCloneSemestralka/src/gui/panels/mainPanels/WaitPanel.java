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
public final class WaitPanel extends MainPanel {

    private JButton skipButton;
    private final JProgressBar bar;
    private int timePassed;
    private final JLabel label;
    private final JLabel time;
    private final TavernPanel tav;
    
    public WaitPanel(Objective obj, TavernPanel tav) {
        super(PanelType.WAIT);
        int price = 50;
        this.skipButton = new JButton("Skip");
        this.skipButton.setToolTipText(String.format("Price for skipping: %d", price));
        this.setBackground(Color.black);
        this.timePassed = 0;
        this.tav = tav;
        //name
        this.label = new JLabel();
        this.label.setFont(BasicGui.getFont(50));
        this.label.setForeground(Color.WHITE);
        
        //time
        this.time = new JLabel();
        this.time.setFont(BasicGui.getFont(30));
        this.time.setForeground(Color.WHITE);
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(this.label);
        this.add(this.time);
        this.add(Box.createRigidArea(new Dimension(0, 300)));
        
        
        this.bar = new JProgressBar(0, 100);
        
        
        this.add(this.bar);
        this.add(this.skipButton);
        this.skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WaitPanel.this.beginCalc();
                WaitPanel.this.timePassed += 1000;
            }
        });

        if (obj != null) {
            this.setup(obj); 
        }
    }

    public WaitPanel(TavernPanel tav) {
        this(null, tav);
    }
    
    
    
    
    public void setup(Objective newObj) {
        this.timePassed = 0;
        this.bar.setValue(0);
        this.bar.setMaximum(newObj.getDuration());
        this.label.setText(newObj.getName());
        this.time.setText(String.format("Duration: %d seconds", newObj.getDuration()));
        this.beginCalc();
        
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
                    
                    tav.showFight();
                }
            }
        }, 0, 1000);
    }
    
}
