package Views.Elementos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class TextBox extends JTextField{
     int xpos, ypos, xpix, ypix, limite;
     Font font;
     String text;
     boolean disabled;

    public TextBox(int xpos, int ypos, int xpix, int ypix, int limite, Font font) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.limite = limite;
        this.font = font;
        this.setFont(font);
        this.setBounds(xpos, ypos, xpix, ypix);
    }
    public TextBox(int xpos, int ypos, int xpix, int ypix, Font font) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.limite = limite;
        this.font = font;
        this.setFont(font);
        this.setBounds(xpos, ypos, xpix, ypix);
    }

    public TextBox(String text, int xpos, int ypos, int xpix, int ypix, Font font, boolean disabled) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.font = font;
        this.text = text;
        this.disabled = disabled;
        this.setFont(font);
        this.setText(text);
        this.setEnabled(disabled);
        this.setBounds(xpos, ypos, xpix, ypix);
        this.setDisabledTextColor(Color.BLACK);
        this.setForeground(Color.BLACK);
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

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
     
    
}
