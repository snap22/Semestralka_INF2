/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author marce
 */
public abstract class BasicGui {
    public static Color getGoldenColor() {
        return new Color(189, 172, 81);
    }
    
    public static Color getDarkBlueColor() {
        return new Color(16, 49, 94);
    }
    
    public static Color getDarkGrayColor() {
        return new Color(29, 28, 43);
    }
    
    public static String getFontName() {
        return "Comic Sans MS";
    }
    
    public static Font getFont(int size) {
        if (size <= 0) {
            return getFont();
        }
        return new Font("Comic Sans MS", Font.PLAIN, size);
    }
    
    public static Font getFont() {
        return getFont(12);
    }
}
