package Views.Elementos;

import javax.swing.JFrame;

public class Frame extends JFrame{
    
    public Frame(String str){
        if(str.equals("CLIENTE")){
            FrameCliente();
        }else if(str.equals("USUARIO")){
            FrameUsuario();
        }
    }
    
    public void FrameCliente(){
        this.setTitle("Cliente");
        this.setResizable(false);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void FrameUsuario(){
        this.setTitle("Usuario");
        this.setResizable(false);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
}
