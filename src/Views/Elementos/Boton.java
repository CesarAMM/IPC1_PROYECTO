package Views.Elementos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Boton extends JButton{
    private String text;
    private int xpos, ypos;
    private int xpix, ypix;
    private Font font;
    private Color text_Color, background;

    public Boton(String text, int xpos, int ypos, int xpix, int ypix, Font font, Color text_Color, Color background) {
        this.text = text;
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.font = font;
        this.text_Color = text_Color;
        this.background = background;
        this.setBackground(background);
        this.setForeground(text_Color);
        this.setFont(font);
        this.setBounds(xpos, ypos, xpix, ypix);
        this.setText(text);
    }

    public Boton(String text, int xpos, int ypos, int xpix, int ypix, Font font) {
        this.text = text;
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.font = font;
        this.setFont(font);
        this.setBounds(xpos, ypos, xpix, ypix);
        this.setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getXpix() {
        return xpix;
    }

    public void setXpix(int xpix) {
        this.xpix = xpix;
    }

    public int getYpix() {
        return ypix;
    }

    public void setYpix(int ypix) {
        this.ypix = ypix;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getText_Color() {
        return text_Color;
    }

    public void setText_Color(Color text_Color) {
        this.text_Color = text_Color;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }
    
    
}