package Views.Elementos;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label extends JLabel{
    String text, strRuta;
    int xpos, ypos, xpix, ypix;
    Font font;

    public Label(String text, int xpos, int ypos, int xpix, int ypix, Font font, boolean center) {
        this.text = text;
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.font = font;
        if(center){
            this.setVerticalAlignment(SwingConstants.CENTER);
            this.setHorizontalAlignment(SwingConstants.CENTER);
        }
        this.setBounds(xpos, ypos, xpix, ypix);
        this.setText(text);
        this.setFont(font);
    }
    
    public Label(String strRuta, int xpos, int ypos, int xpix, int ypix) {
        this.strRuta = strRuta;
        this.xpos = xpos;
        this.ypos = ypos;
        this.xpix = xpix;
        this.ypix = ypix;
        this.setIcon(new ImageIcon(strRuta));
        this.setBounds(xpos, ypos, xpix, ypix);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStrRuta() {
        return strRuta;
    }

    public void setStrRuta(String strRuta) {
        this.strRuta = strRuta;
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
    
     
}
