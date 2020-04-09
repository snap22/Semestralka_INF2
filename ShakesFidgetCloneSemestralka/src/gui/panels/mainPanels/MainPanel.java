/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.mainPanels;

import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public abstract class MainPanel extends JPanel {
    
    private PanelType type;
    
    public MainPanel(PanelType type) {
        this.type = type;
    }

    public PanelType getType() {
        return this.type;
    }
    
    public String getTypeString() {
        return this.type.toString();
    }
    
    
    
    
    
    
}
