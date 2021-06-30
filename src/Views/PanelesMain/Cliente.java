
package Views.PanelesMain;

import Views.Elementos.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import restaurant_manager.*;

public class Cliente implements MouseListener{
    
    JTable tbl;
    public void IniciarComponentes_PanelCliente(){
        //Inicianilizando Labels
        Label titulo = new Label("Seccion de Clientes", 0, 5, 630, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_Cliente.add(titulo);
        
        //Inicianilizando Tabla
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Nombre");
        dtm.addColumn("Dierreccion");
        dtm.addColumn("Telefono");
        dtm.addColumn("nit");
        dtm.addColumn(" ");
        dtm.addColumn(" ");
        for (POO.Cliente cliente : Restaurant_Manager.clientes) {
            Boton btn_edit = new Boton("Editar", cliente.getId(), 0, 0, 75, 20, new Font(Font.DIALOG_INPUT, Font.PLAIN,12), Color.yellow, Color.darkGray);
            Boton btn_Eliminar = new Boton("Eliminar", cliente.getId(), 0, 0, 75, 20, new Font(Font.DIALOG_INPUT, Font.PLAIN,12), Color.yellow, Color.darkGray);
            Object datos[] = new Object[7];
            datos[0] = cliente.getId();
            datos[1] = cliente.getName();
            datos[2] = cliente.getAddress();
            datos[3] = cliente.getPhone();
            datos[4] = cliente.getNit();
            datos[5] = "EDITAR";
            datos[6] = "ELIMINAR";
            dtm.addRow(datos);
        }
        tbl = new JTable(dtm);
        tbl.setEnabled(false);
        tbl.addMouseListener(this);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(10, 30, 610, 150);
        Views.Main.jpViews_Cliente.add(scroll);
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int fila = tbl.rowAtPoint(me.getPoint());
        Frame fCliente = new Views.Elementos.Frame("USUARIO");
        fCliente.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
