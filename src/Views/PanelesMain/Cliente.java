
package Views.PanelesMain;

import Views.Elementos.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import restaurant_manager.*;

public class Cliente implements MouseListener{
    
    public static JTable tbl;
    public static DefaultTableModel dtm;
    public void IniciarComponentes_PanelCliente(){
        //Inicianilizando Labels
        Label titulo = new Label("Seccion de Clientes", 0, 5, 630, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_Cliente.add(titulo);
        
        //Inicianilizando Tabla
        dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Nombre");
        dtm.addColumn("Dierreccion");
        dtm.addColumn("Telefono");
        dtm.addColumn("nit");
        for (POO.Cliente cliente : Restaurant_Manager.clientes) {
            Object datos[] = new Object[7];
            datos[0] = cliente.getId();
            datos[1] = cliente.getName();
            datos[2] = cliente.getAddress();
            datos[3] = cliente.getPhone();
            datos[4] = cliente.getNit();
            dtm.addRow(datos);
        }
        
        tbl = new JTable(dtm);
        tbl.setEnabled(false);
        tbl.addMouseListener(this);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(10, 30, 610, 150);
        Views.Main.jpViews_Cliente.add(scroll);
        
        Boton btnAgregarCliente = new Boton("Agregar Cliente", 10, 200, 200, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), Color.white, new Color(52, 229, 0));
        Views.Main.jpViews_Cliente.add(btnAgregarCliente);
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
        Frame fCliente = new Views.Elementos.FrameViews(fila, Integer.parseInt(tbl.getValueAt(fila, 0).toString()), tbl.getValueAt(fila, 1).toString(),tbl.getValueAt(fila, 2).toString(), Integer.parseInt(tbl.getValueAt(fila, 3).toString()), tbl.getValueAt(fila, 4).toString());
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
    
    private void IniciarVentana(){
        FrameAdd ventana = new FrameAdd("Cliente", new Panel(Color.white));
        //Creacion de Labels
        Label lname = new Label("Nombre:", 10, 10, 50, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        ventana.getPanelGeneral().add(lname);
        Label laddress = new Label("Direccion:", 10, 10, 50, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        ventana.getPanelGeneral().add(laddress);
        Label lnit = new Label("Nit:", 10, 10, 50, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        Label lphone = new Label("Phone:", 10, 10, 50, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        ventana.getPanelGeneral().add(lnit);
        ventana.getPanelGeneral().add(lphone);
        //Creacion de textbox
        
        //Mostrar la Ventana
        ventana.setVisible(true);
    }
   
}
