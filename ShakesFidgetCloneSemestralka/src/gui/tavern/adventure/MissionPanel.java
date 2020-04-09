/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tavern.adventure;

import adventure.Mission;
import adventure.Objective;
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

    private String name;
    private String description;
    private String duration;
    private String goldReward;
    private String xpReward;
    private String imgSource;
    
    
    
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel durationLabel;
    private JLabel goldRewardLabel;
    private JLabel xpRewardLabel;

    private JLabel mainLabel;
    
    
    public MissionPanel(Mission mission) {
        Objective obj = mission.getObjective();
        this.name = String.format("Name: %s%n", obj.getName());
        this.description = obj.getDescription();
        this.duration = String.valueOf(obj.getDuration());
        this.goldReward = String.valueOf(obj.getGoldReward());
        this.xpReward = String.valueOf(obj.getXpReward());
        
        this.imgSource = "a_other.pictures/mission_image.png";
        
        this.mainLabel = new JLabel(this.name);
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
    }
    
    
}
