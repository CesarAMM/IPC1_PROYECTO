package Views.Elementos;

import java.awt.Color;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private int xpos, ypos, xpix, ypix;
    private Color color;

    public Panel(int xpos, int ypos, int xpix, int ypix, Color color) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.color = color;
        this.setBounds(xpos, ypos, xpix, ypix);
        this.setLayout(null);
        this.setBackground(color);
    }
    
    public Panel(Color color){
        this.setBackground(color);
        this.setLayout(null);
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
