/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.a.gui.main;

import sk.semestralka.shakelessmidget.a.gui.main.PanelType;
import javax.swing.JPanel;

/**
 *  Trieda MainPanel sluzi len ako nadtyp pre hlavne panely ktore sa budu v hre menit podla interakcie hraca
 */
public abstract class MainPanel extends JPanel {
    
    private PanelType type;
    
    /**
     * Konstruktor, uklada si typ panela
     * @param type 
     */
    public MainPanel(PanelType type) {
        this.type = type;
    }

    /**
     * Vrati typ panela
     * @return 
     */
    public PanelType getType() {
        return this.type;
    }
    
    /**
     * Vrati typ panela vo forme stringu
     * @return 
     */
    public String getTypeString() {
        return this.type.toString();
    }

    
    
    
    
     
}
