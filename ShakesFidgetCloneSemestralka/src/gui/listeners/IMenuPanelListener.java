/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.listeners;

import gui.panels.mainPanels.PanelType;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public interface IMenuPanelListener {
    //void changePanel(JPanel panel);
    void changePanel(PanelType type);
    
}
