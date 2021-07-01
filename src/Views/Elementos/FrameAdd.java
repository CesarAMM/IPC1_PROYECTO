package Views.Elementos;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class FrameAdd extends JFrame{
    private Panel PanelGeneral;
    public FrameAdd(String Title, Panel PanelGeneral){
        this.PanelGeneral = PanelGeneral;
        this.setTitle(Title);
        this.setResizable(false);
        this.setSize(320, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().add(this.PanelGeneral);
    }

    public Panel getPanelGeneral() {
        return PanelGeneral;
    }

    public void setPanelGeneral(Panel PanelGeneral) {
        this.PanelGeneral = PanelGeneral;
    }

    
}
