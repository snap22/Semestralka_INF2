/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author marce
 */
public class MenuButton extends JButton {

    

    public MenuButton(String text, Dimension dimension) {
        super(text);
        this.setMaximumSize(new Dimension(dimension.width, 60));    //50
        Color bgColor = new Color(16, 49, 94);
        Color textColor = new Color(189, 172, 81);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 35);  //30
        
        Border border = new LineBorder(textColor);
        //Font font = new Font("Century", Font.PLAIN, 20);
        this.setFont(font);
        this.setBackground(bgColor);
        this.setForeground(textColor);
        this.setBorder(border);
        
        
        
       
        
        
    }
    
    public void toggle() {
        
        this.setEnabled(!this.isEnabled());
        
        
    }
    
    
    
}

/*
Fonts
Abadi MT Condensed Extra Bold
Abadi MT Condensed Light
Academy Engraved LET
Al Bayan
American Typewriter
Andale Mono
Apple Casual
Apple Chancery
Apple LiGothic
Apple LiSung
Apple Symbols
AppleGothic
AppleMyungjo
Arial
Arial Black
Arial Hebrew
Arial Narrow
Arial Rounded MT Bold
Ayuthaya
Baghdad
Bank Gothic
Baskerville
Baskerville Old Face
Batang
Bauhaus 93
Bell MT
Bernard MT Condensed
BiauKai
Big Caslon
Bitstream Vera Sans
Bitstream Vera Sans Mono
Bitstream Vera Serif
Blackmoor LET
BlairMdITC TT
Bodoni Ornaments ITC TT
Bodoni SvtyTwo ITC TT
Bodoni SvtyTwo OS ITC TT
Bodoni SvtyTwo SC ITC TT
Book Antiqua
Bookman Old Style
Bordeaux Roman Bold LET
Bradley Hand ITC TT
Braggadocio
Britannic Bold
Brush Script MT
Calisto MT
Century
Century Gothic
Century Schoolbook
Chalkboard
Charcoal CY
Cochin
Colonna MT
Comic Sans MS
Cooper Black
Copperplate
Copperplate Gothic Bold
Copperplate Gothic Light
Corsiva Hebrew
Courier
Courier New
Cracked
Curlz MT
DecoType Naskh
Desdemona
Devanagari MT
Dialog
DialogInput
Didot
Edwardian Script ITC
Engravers MT
Euphemia UCAS
Eurostile
Footlight MT Light
Futura
Garamond
GB18030 Bitmap
Geeza Pro
Geneva
Geneva CY
Georgia
Gill Sans
Gill Sans Ultra Bold
Gloucester MT Extra Condensed
Goudy Old Style
Gujarati MT
Gulim
Gurmukhi MT
Haettenschweiler
Handwriting - Dakota
Harrington
Hei
Helvetica
Helvetica CY
Helvetica Neue
Herculanum
Hiragino Kaku Gothic Pro
Hiragino Kaku Gothic Std
Hiragino Maru Gothic Pro
Hiragino Mincho Pro
Hoefler Text
Impact
Imprint MT Shadow
InaiMathi
Jazz LET
Kai
Kino MT
Krungthep
KufiStandardGK
LiHei Pro
LiSong Pro
Lucida Blackletter
Lucida Bright
Lucida Calligraphy
Lucida Fax
Lucida Grande
Lucida Handwriting
Lucida Sans
Lucida Sans Typewriter
Marker Felt
Matura MT Script Capitals
Mistral
Modern No. 20
Mona Lisa Solid ITC TT
Monaco
Monospaced
Monotype Corsiva
Monotype Sorts
MS Gothic
MS Mincho
MS PGothic
MS PMincho
Mshtakan
MT Extra
Nadeem
New Peninim MT
News Gothic MT
Onyx
OpenSymbol
Optima
Osaka
Palatino
Papyrus
Party LET
Perpetua Titling MT
Plantagenet Cherokee
Playbill
PMingLiU
PortagoITC TT
Princetown LET
Raanana
Rockwell
Rockwell Extra Bold
SansSerif
Santa Fe LET
Sathu
Savoye LET
SchoolHouse Cursive B
SchoolHouse Printed A
Serif
Silom
SimSun
Skia
Snell Roundhand
Stencil
STFangsong
STHeiti
STKaiti
Stone Sans ITC TT
Stone Sans Sem ITC TT
STSong
Symbol
Synchro LET
Tahoma
Thonburi
Times
Times New Roman
Trebuchet MS
Type Embellishments One LET
Verdana
Webdings
Wide Latin
Wingdings
Wingdings 2
Wingdings 3
Zapf Dingbats
Zapfino
*/