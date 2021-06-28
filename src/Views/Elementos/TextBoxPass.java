package Views.Elementos;

import java.awt.Font;
import javax.swing.JPasswordField;

public class TextBoxPass extends JPasswordField{
    int xpos, ypos, xpix, ypix, limite;
     Font font;

    public TextBoxPass(int xpos, int ypos, int xpix, int ypix, int limite, Font font) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.limite = limite;
        this.font = font;
        this.setFont(font);
        this.setBounds(xpos, ypos, xpix, ypix);
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
