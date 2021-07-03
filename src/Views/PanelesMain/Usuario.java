package Views.PanelesMain;

import Views.Elementos.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import restaurant_manager.Cesar_Funciones;
import restaurant_manager.Restaurant_Manager;

public class Usuario implements MouseListener{
    public static JTable tbl;
    public static DefaultTableModel dtm;
    
    public void IniciarComponentes_PanelUsers() {
        Label titulo = new Label("Seccion de Usuarios", 0, 5, 430, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_User.add(titulo);
        
        //Inicianilizando Tabla
        dtm = new DefaultTableModel();
        dtm.addColumn("Usuario");
        dtm.addColumn("Password");
        for (POO.Usuario usuario : Restaurant_Manager.usuarios) {
            Object datos[] = new Object[7];
            String pass = "";
            for (int i = 0; i < usuario.getPassword().length(); i++) {
                pass+= "*";
            }
            datos[0] = usuario.getUsername();
            datos[1] = pass;
            dtm.addRow(datos);
        }
        
        tbl = new JTable(dtm);
        tbl.setEnabled(false);
        tbl.addMouseListener(this);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(10, 30, 610, 150);
        Views.Main.jpViews_User.add(scroll);
        
        Boton btnAgregarCliente = new Boton("Agregar Usuario", 10, 200, 200, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), Color.white, new Color(52, 229, 0));
        Views.Main.jpViews_User.add(btnAgregarCliente);
        btnAgregarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IniciarVentana();
            }
        });

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int fila = tbl.rowAtPoint(me.getPoint());
        FrameViews v = new FrameViews(fila, tbl.getValueAt(fila, 0).toString(), tbl.getValueAt(fila, 1).toString());
        v.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void IniciarVentana() {
        Font titleFont = new Font(Font.DIALOG_INPUT, Font.BOLD, 12);
        FrameAdd v = new FrameAdd("Nuevo Usuario", new Panel(Color.white));
        Label luser = new Label("Usuario:", 10, 10, 80, 20, titleFont, false);
        v.getPanelGeneral().add(luser);
        
        TextBox txtuser = new TextBox(97, 10, 120, 20, titleFont);
        v.getPanelGeneral().add(txtuser);
        
        Label lpass1 = new Label("Contraseña:", 10, 40, 100, 20, titleFont, false);
        Label lpass2 = new Label("Confirme Contraseña:", 10, 65, 150, 20, titleFont, false);
        v.getPanelGeneral().add(lpass1);
        v.getPanelGeneral().add(lpass2);
        TextBoxPass txtpass1 = new TextBoxPass(105,40,100,20,new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        TextBoxPass txtpass2 = new TextBoxPass(165,65,100,20,new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        v.getPanelGeneral().add(txtpass1);
        v.getPanelGeneral().add(txtpass2);
        
        Boton btnSave = new Boton("Guardar", 10, 90, 100, 20, titleFont);
        v.getPanelGeneral().add(btnSave);
        //Mostrar la ventana
        v.setVisible(true);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
           //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String strUser = txtuser.getText();
                String strPass1 = txtpass1.getText();
                String strPass2 = txtpass2.getText();
                if(!(strUser.equals("") && strPass1.equals("") && strPass2.equals(""))){
                    if(strPass1.equals(strPass2)){
                        strPass2 = "";
                        for (int i = 0; i < strPass1.length(); i++) {
                            strPass2+="*";
                        }
                        Object obj[] = {strUser, strPass2};
                        dtm.addRow(obj);
                        Restaurant_Manager.usuarios.add(new POO.Usuario(strUser, strPass1));
                        Cesar_Funciones.JsonDatos(2);
                        v.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error.\nLas Contraseñas no coiciden.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error.\nTodos los campos tienen que estar llenos");
            }
            }
        });
    }

    
}
