/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tavern.adventure;

import adventure.Mission;
import adventure.Objective;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class MissionPanel extends JPanel {

    
    
    
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel durationLabel;
    private JLabel goldRewardLabel;
    private JLabel xpRewardLabel;

    private JLabel mainLabel;
    
    
    public MissionPanel(Mission mission) {
        this.setup(mission);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    private void setup(Mission mission) {
        Objective obj = mission.getObjective();
        this.nameLabel = new JLabel(String.format("Name: %s", obj.getName()));
        this.descriptionLabel = new JLabel(String.format("Description: %s%n", obj.getDescription()));
        this.durationLabel = new JLabel(String.format("Duration: %s%n", obj.getDuration()));
        
        this.goldRewardLabel = new JLabel(String.format("Gold: %s%n", obj.getGoldReward()));
        this.xpRewardLabel = new JLabel(String.format("Xp: %s%n", obj.getXpReward()));
        
        this.add(this.nameLabel);
        this.add(this.descriptionLabel);
        this.add(this.durationLabel);
        this.add(this.goldRewardLabel);
        this.add(this.xpRewardLabel);
        
        //add button to label
        //add image to label
    }
    
    /*
    Objective obj = mission.getObjective();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s%n", obj.getName()));
        sb.append(String.format("Description: %s%n", obj.getDescription()));
        sb.append(String.format("Duration: %s%n", obj.getDuration()));
        sb.append("\n");
        sb.append(String.format("Gold: %s%n", obj.getGoldReward()));
        sb.append(String.format("Xp: %s%n", obj.getXpReward()));
        
        JLabel newLabel = new JLabel(sb.toString());
        newLabel.setBackground(Color.red);
        newLabel.setForeground(Color.white);
        this.add(newLabel);
    */
    
}
