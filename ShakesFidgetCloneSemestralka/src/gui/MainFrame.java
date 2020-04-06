/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author marce
 */
public class MainFrame extends JFrame {
    
    JPanel visiblePanel;
    
    public MainFrame() {
        this.setTitle(" Shakeless Midget - The game of the year 2020");
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);       //ak uzivatel stlaci na X vypne sa program
        
        
        this.setVisible(true);
    }
    
}
