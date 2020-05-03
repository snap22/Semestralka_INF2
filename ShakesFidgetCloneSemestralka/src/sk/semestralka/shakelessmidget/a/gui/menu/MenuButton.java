/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.semestralka.shakelessmidget.a.gui.menu;

import sk.semestralka.shakelessmidget.a.gui.main.BasicGui;
import gui.eventTry.Testicek;
import sk.semestralka.shakelessmidget.a.gui.main.PanelType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import javax.swing.border.LineBorder;

/**
 * Trieda MenuButton sluzi ako predvoleny button do hlavneho menu
 */
public class MenuButton extends JButton {

    private PanelType type;

    /**
     * Konstruktor ktory vytvori MenuButton so zadanymi parametrami.
     * @param text text ktory sa zobrazi na buttone
     * @param dimension dimenzia, t.j sirka a vyska
     * @param type typ triedy MainPanel ktory sa zobrazi po kliknuti na button
     */
    public MenuButton(String text, Dimension dimension, PanelType type) {
        super(text);
        this.setMaximumSize(new Dimension(dimension.width, 60));    //50
        Color bgColor = BasicGui.getDarkBlueColor();
        Color textColor = BasicGui.getGoldenColor();
        Font font = BasicGui.getFont(35);  //30
        
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border innerBorder = new LineBorder(textColor, 2);
        this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        //Font font = new Font("Century", Font.PLAIN, 20);
        
        this.setFont(font);
        this.setBackground(bgColor);
        this.setForeground(textColor);
        
        final PanelType testType = type;
        this.setFocusable(false);
        
        // exception ak by action bolo null?
        //this.addActionListener(action);
        
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Testicek.getPanel().changePanel(testType);
                
            }
        });
        
        //exception ak by type bolo null?
        this.type = type;
        
    }
    
    /**
     * Nastavi na pasivny button, ak je aktivny a naopak
     */
    public void toggle() {
        this.setEnabled(!this.isEnabled());
    }

    /**
     * Vrati typ panela ktory meni ked sa na button klikne
     * @return 
     */
    public PanelType getPanel() {
        return this.type;
    }
    
    /**
     * Vrati typ panela vo forme stringu
     * @return 
     */
    public String getPanelString() {
        return this.type.toString();
    }
}

