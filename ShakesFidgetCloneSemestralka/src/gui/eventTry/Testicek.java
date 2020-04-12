/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.eventTry;

import gui.panels.TemporaryPanel;

/**
 *
 * @author marce
 */
public class Testicek {
    private static TemporaryPanel temp;
    public static void setPanel(TemporaryPanel panel) {
        temp = panel;
    }
    public static TemporaryPanel getPanel() {
        return temp;
    }
}
