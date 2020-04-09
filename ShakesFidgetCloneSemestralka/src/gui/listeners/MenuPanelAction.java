/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.listeners;

import gui.buttons.MenuButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.listeners.IMenuPanelListener;
import gui.panels.mainPanels.PanelType;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class MenuPanelAction implements ActionListener {

    private IMenuPanelListener listener;
    public MenuPanelAction() {
        
    }
    
    public void setPanelListener(IMenuPanelListener listener) {
        if (listener == null) {
            return;
        }
        
        this.listener = listener;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.listener == null) {
            return;
        }
        if (!(e.getSource() instanceof MenuButton)) {
            return;
        }
        PanelType type = ((MenuButton)e.getSource()).getPanel();
        this.listener.changePanel(type);
    }
    
}
