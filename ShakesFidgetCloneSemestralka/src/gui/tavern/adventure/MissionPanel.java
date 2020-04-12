/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tavern.adventure;

import adventure.Mission;
import adventure.Objective;
import gui.BasicGui;
import gui.eventTry.Testicek;
import gui.panels.mainPanels.PanelType;
import gui.panels.mainPanels.TavernPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author marce
 */
public class MissionPanel extends JPanel {

    /*private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel durationLabel;
    private JLabel goldRewardLabel;
    private JLabel xpRewardLabel;
    */
    private JButton startbtn;
    private Font font;
    private Color gold;
    private Color blue;

    private GridBagConstraints gc;
   
    public MissionPanel(Mission mission, TavernPanel tavern) {
        this(mission.getObjective(), tavern);
        
    }
    
    public MissionPanel(Objective objective, TavernPanel tavern) {
        this.setPreferredSize(new Dimension(350, 150));
        this.font = BasicGui.getFont(13);
        
        this.gold = BasicGui.getGoldenColor();
        this.blue = BasicGui.getDarkBlueColor();
        
        this.setBackground(this.blue);
        //  border setup
        Border innerBorder = BorderFactory.createLineBorder(this.gold, 2);
        Border border = BorderFactory.createTitledBorder(innerBorder, "Objective ", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, this.font, this.gold); // TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION
        this.setBorder(border);
        
        
        //  gridbaglayout setup
        this.setLayout(new GridBagLayout());
        this.gc = new GridBagConstraints();
        this.gc.gridx = 0;
        this.gc.gridy = 0;
        this.gc.weightx = 1;
        this.gc.weighty = 1;
        this.gc.fill = GridBagConstraints.NONE;
        this.gc.anchor = GridBagConstraints.LINE_START;
        
        this.startbtn = new JButton("Begin");
        //this.startbtn.setFont(this.font);
        this.startbtn.setFont(new Font(BasicGui.getFontName(), Font.BOLD, 15));
        this.startbtn.setBackground(this.gold);
        this.startbtn.setForeground(this.blue);
        
        
        //  labels setup
        this.setup(objective);
        
        
        this.startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Testicek.getPanel().changePanel(PanelType.MINIGAME);
                tavern.restart();
            }
        });
        
        
        
        
        
        
    }
    
    private void setup(Objective objective) {
        if (objective == null) {
            return;
        }
        this.createRow("Name: ", objective.getName());
        this.createRow("Description: ", objective.getDescription());
        this.createRow("Duration: ", String.format("%d seconds" , objective.getDuration()));
        this.createRow("Gold: ", String.valueOf(objective.getGoldReward()));
        this.createRow("Xp: ", String.valueOf(objective.getXpReward()));
        
        
        this.movegc(1, 5);
        this.gc.anchor = GridBagConstraints.LINE_END;
        this.add(this.startbtn, this.gc);
        //this.gc.weightx = 5;
        //this.movegc(7, 5);
        
       
        
    }
    
    private void createRow(String title, String detail) {
        this.createLabel(title);
        this.moveRight();
        this.createLabel(detail);
        this.newLine();
        
    }
    
    private void createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(this.font);
        label.setForeground(this.gold);
        this.add(label, this.gc);
    }
    
    private void moveRight() {
        this.gc.gridx++;
    }
    
    private void moveDown() {
        this.gc.gridy++;
    }
    
    private void newLine() {
        this.gc.gridx = 0;
        this.gc.gridy++;
    }
    
    
    private void movegc(int x, int y) {
        this.gc.gridx = x;
        this.gc.gridy = y;
    }
    
    /*
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
        
        String url = "C:\\Users\\marce\\Documents\\NetBeansProjects\\Semestralka_ShakesAndFidget\\ShakesFidgetCloneSemestralka\\src\\a_other\\pictures\\mission_image.png";
        ImageIcon img = new ImageIcon(url);
        ImageIcon img2 = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));   //IMPORTANT
        JLabel asd = new JLabel(img2, JLabel.LEFT);
        
        this.add(asd);
    */
    
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
    
    //ImageIcon img2 = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)); --RESIZES THE IMAGE
    
}
