package Views.PanelesMain;

import Views.Elementos.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import restaurant_manager.*;

public class Factura implements MouseListener{
    public static JTable tbl;
    public static DefaultTableModel dtm;
    public void IniciarComponentes_PanelFactura() {
        Label titulo = new Label("Seccion de Facturas", 0, 5, 630, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_Factura.add(titulo);
        
        //Inicianilizando Tabla
        dtm = new DefaultTableModel();
        dtm.addColumn("Id Factura");
        dtm.addColumn("Cliente");
        dtm.addColumn("Fecha");
        for (POO.Factura factura : Restaurant_Manager.facturas) {
            POO.Cliente auxCliente = null;
            for (POO.Cliente cliente : Restaurant_Manager.clientes) {
                if(cliente.getId() == factura.getClient()){
                    auxCliente = cliente;
                    break;
                }
            }
            Object[] vector = {factura.getId(), auxCliente.getName(), factura.getDate()};
            dtm.addRow(vector);
        }
        
        tbl = new JTable(dtm);
        tbl.setEnabled(false);
        tbl.addMouseListener(this);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(10, 30, 610, 150);
        Views.Main.jpViews_Factura.add(scroll);
        
        Boton btnAgregar = new Boton("Facturar", 20, 190, 120, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), Color.white, new Color(52, 229, 0));
        Views.Main.jpViews_Factura.add(btnAgregar);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IniciarVentana();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       int fila = tbl.rowAtPoint(me.getPoint());
       FrameViews fFactura = new Views.Elementos.FrameViews(fila, Integer.parseInt(tbl.getValueAt(fila, 0).toString()), tbl.getValueAt(fila, 1).toString(), tbl.getValueAt(fila, 2).toString());
       fFactura.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ArrayList<POO.Producto> list_producto = new ArrayList<>();
        FrameAdd ventana = new FrameAdd("Cliente", new Panel(Color.white));
        ventana.setSize(400, 320);
        //Creacion de Labels
        Label lciente = new Label("Cliente:", 10, 10, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        Label ldate = new Label("Fecha:", 10, 35, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        Label lproducto = new Label("Producto:", 10, 60, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        ventana.getPanelGeneral().add(lciente);
        ventana.getPanelGeneral().add(ldate);
        ventana.getPanelGeneral().add(lproducto);
        
        //Creacion de textbox
        String StrProducto[] = new String[Restaurant_Manager.productos.size()];
        int contador = 0;
        for (POO.Producto producto : Restaurant_Manager.productos) {
            StrProducto[contador] = producto.getName();
            contador++;
        }
        
        String StrCliente[] = new String[Restaurant_Manager.clientes.size()];
        int auxContador = 0;
        for (POO.Cliente cliente : Restaurant_Manager.clientes) {
            StrCliente[auxContador] = cliente.getName();
            auxContador++;
        }
        JComboBox jcProducto = new JComboBox(StrProducto);
        jcProducto.setBounds(105, 60, 150, 20);
        jcProducto.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        jcProducto.setBackground(Color.white);
        
        JComboBox jcCliente = new JComboBox(StrCliente);
        jcCliente.setBounds(105, 10, 150, 20);
        jcCliente.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        jcCliente.setBackground(Color.white);
        TextBox txtdate = new TextBox(Consola.StrFecha(), 105, 35, 150, 20,new Font(Font.DIALOG_INPUT, Font.BOLD, 15) , false);
        ventana.getPanelGeneral().add(jcProducto);
        ventana.getPanelGeneral().add(jcCliente);
        ventana.getPanelGeneral().add(txtdate);
        //Crear Boton de guardato
        Boton btnSave = new Boton("Guardar", 10, 245, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        ventana.getPanelGeneral().add(btnSave);
        Boton btnAgregarPorducto = new Boton("Agregar", 260, 60, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 10));
        ventana.getPanelGeneral().add(btnAgregarPorducto);
        
        //Crear tabla de productos
        DefaultTableModel dftable = new DefaultTableModel();
        dftable.addColumn("Id");
        dftable.addColumn("Producto");
        dftable.addColumn("Precio");
        JTable p_table = new JTable(dftable);
        p_table.setEnabled(false);
        JScrollPane p_scroll = new JScrollPane(p_table);
        p_scroll.setBounds(10, 90, 380, 150);
        ventana.getPanelGeneral().add(p_scroll);
        //Mostrar la Ventana
        ventana.setVisible(true);
        //Funcion del metodo Guaradar a un nuevo cliente
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(p_table.getRowCount() != 0 && !(txtdate.getText().equals("")) && !(jcCliente.getSelectedItem().toString().equals(""))){
                    int idFactura = Restaurant_Manager.facturas.get(Restaurant_Manager.facturas.size()-1).getId()+1;
                    for (int i = 0; i < p_table.getRowCount(); i++) {
                        POO.Producto p = new POO.Producto(p_table.getValueAt(i, 1).toString(), Float.parseFloat(p_table.getValueAt(i, 2).toString()));
                        list_producto.add(p);
                    }
                    int idCliente =0;
                    for (POO.Cliente cliente : Restaurant_Manager.clientes) {
                        if(cliente.getName().equals(jcCliente.getSelectedItem().toString())){
                            idCliente = cliente.getId();
                            break;
                        }
                    }
                    Object kbj[] = {idFactura,jcCliente.getSelectedItem().toString(), txtdate.getText()};
                    dtm.addRow(kbj);
                    Restaurant_Manager.facturas.add(new POO.Factura(idFactura, idCliente, txtdate.getText(), list_producto));
                    Cesar_Funciones.JsonDatos(5);
                    ventana.setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error. Llena todos los campos y tiene que haber almenos un producto");
                }
            }
        });
        btnAgregarPorducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String obj_producto = jcProducto.getSelectedItem().toString();
                for (POO.Producto producto : Restaurant_Manager.productos) {
                    if(obj_producto.equals(producto.getName())){
                        Object[] vector = {producto.getId(), producto.getName(), producto.getPrice()};
                        dftable.addRow(vector);
                        break;
                    }
                }
            }
        });
        //Click en la tabla
        p_table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int fila = p_table.rowAtPoint(me.getPoint());
                int confimacion = JOptionPane.showConfirmDialog(null, "Deseas eliminar este produto: '"+ p_table.getValueAt(fila, 1)+"'");
                if(confimacion == 0){
                    dftable.removeRow(fila);
                }
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
        });
    }
    
}
