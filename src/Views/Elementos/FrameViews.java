package Views.Elementos;

import POO.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import restaurant_manager.Cesar_Funciones;
import restaurant_manager.Consola;
import restaurant_manager.Restaurant_Manager;
public final class FrameViews extends JFrame{
    Panel PanelGeneral;
    private final Font titleFont = new Font(Font.DIALOG_INPUT, Font.BOLD, 12);
    
    //Para crear la ventana de un cliente
    public FrameViews(int fila, int id, String name, String address, int phone, String nit){
        this.setTitle("Cliente: " + name);
        this.setResizable(false);
        this.setSize(320, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        PanelGeneral = new Panel(Color.white);
        this.getContentPane().add(PanelGeneral);
        FrameCliente(fila,id, name, address, phone,  nit);
    }
    private void FrameCliente(int fila, int id, String name, String address, int phone, String nit){
        //Labels
        Label lid = new Label("Id:", 10, 10, 50, 20, titleFont, false);
        Label lname = new Label("Nombre:", 10, 35, 80, 20, titleFont, false);
        Label laddress = new Label("Direccion:", 10, 60, 80, 20, titleFont, false);
        Label lphone = new Label("Telefono:", 10, 85, 80, 20, titleFont, false);
        Label lnit = new Label("Nit:", 10, 110, 80, 20, titleFont, false);
        PanelGeneral.add(lid);
        PanelGeneral.add(lname);
        PanelGeneral.add(laddress);
        PanelGeneral.add(lphone);
        PanelGeneral.add(lnit);
        
        //Caja de textos
        TextBox txtid = new TextBox(""+id, 105, 10, 50, 20, titleFont, false);
        TextBox txtname = new TextBox(name, 105, 35, 200, 20, titleFont, false);
        TextBox txtaddress = new TextBox(address, 105, 60, 200, 20, titleFont, false);
        TextBox txtphone = new TextBox(""+phone, 105, 85, 100, 20, titleFont, false);
        TextBox txtnit = new TextBox(nit, 105, 110, 100, 20, titleFont, false);
        PanelGeneral.add(txtid);
        PanelGeneral.add(txtname);
        PanelGeneral.add(txtaddress);
        PanelGeneral.add(txtphone);
        PanelGeneral.add(txtnit);
        
        //Creacion de Botones
        Boton btnEdit = new Boton(20, 150, 35, 35, new Color(58, 255, 0), "img\\ico_edit.png");
        PanelGeneral.add(btnEdit);
        Boton btnEliminar = new Boton(60, 150, 35, 35, Color.red, "img\\ico_delete.png");
        PanelGeneral.add(btnEliminar);
        Boton btnCancel = new Boton(20, 150, 35, 35, Color.RED, "img\\ico_cancel.png");
        PanelGeneral.add(btnCancel);
        Boton btnSave = new Boton(60, 150, 35, 35, new Color(58, 255, 0), "img\\ico_save.png");
        PanelGeneral.add(btnSave);
        btnCancel.setVisible(false);
        btnSave.setVisible(false);
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtname.setEnabled(true);
                txtaddress.setEnabled(true);
                txtphone.setEnabled(true);
                txtnit.setEnabled(true);
                btnCancel.setVisible(true);
                btnSave.setVisible(true);
                btnEdit.setVisible(false);
                btnEliminar.setVisible(false);
            }
        });
        
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int contador = -1;
                for (Cliente cliente : Restaurant_Manager.clientes) {
                    contador++;
                    if(cliente.getId() == Integer.parseInt(txtid.getText())){
                        cliente.setName(txtname.getText());
                        cliente.setAddress(txtaddress.getText());
                        cliente.setNit(txtnit.getText());
                        cliente.setPhone(Integer.parseInt(txtphone.getText()));
                        Views.PanelesMain.Cliente.dtm.setValueAt(txtname.getText(), fila, 1);
                        Views.PanelesMain.Cliente.dtm.setValueAt(txtaddress.getText(), fila, 2);
                        Views.PanelesMain.Cliente.dtm.setValueAt(txtphone.getText(), fila, 3);
                        Views.PanelesMain.Cliente.dtm.setValueAt(txtnit.getText(), fila, 4);
                        Cesar_Funciones.JsonDatos(3);
                        break;
                    }
                }
                txtname.setEnabled(false);
                txtaddress.setEnabled(false);
                txtphone.setEnabled(false);
                txtnit.setEnabled(false);
                btnCancel.setVisible(false);
                btnSave.setVisible(false);
                btnEdit.setVisible(true);
                btnEliminar.setVisible(true);
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtname.setEnabled(false);
                txtaddress.setEnabled(false);
                txtphone.setEnabled(false);
                txtnit.setEnabled(false);
                btnCancel.setVisible(false);
                btnSave.setVisible(false);
                btnEdit.setVisible(true);
                btnEliminar.setVisible(true);
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int dato = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este Cliente del sistema?");
                if(dato == 0){
                    for (Cliente cliente : Restaurant_Manager.clientes) {
                        if(cliente.getId() == Integer.parseInt(txtid.getText())){
                            Restaurant_Manager.clientes.remove(cliente);
                            Cesar_Funciones.JsonDatos(3);
                            Views.PanelesMain.Cliente.dtm.removeRow(fila);
                            CerrarVentana();
                            break;
                        }
                    }
                }
            }
        });
    }
    
    //Para crear la ventana de un Factura
    public FrameViews(int fila, int id, String cliente, String date){
        this.setTitle("Factura #"+id);
        this.setResizable(false);
        this.setSize(320, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        PanelGeneral = new Panel(Color.white);
        this.getContentPane().add(PanelGeneral);
        FrameFactura( fila,  id,  cliente,  date);
    }
    private void FrameFactura(int fila, int id, String cliente, String date){
        Label lid = new Label("Id:", 10, 10, 50, 20, titleFont, false);
        Label lname = new Label("Cliente:", 10, 35, 80, 20, titleFont, false);
        Label ldate = new Label("Fecha:", 10, 60, 80, 20, titleFont, false);
        PanelGeneral.add(lid);
        PanelGeneral.add(lname);
        PanelGeneral.add(ldate);
        
        //Caja de textos
        String StrCliente[] = new String[Restaurant_Manager.clientes.size()];
        int contador = 0;
        for (Cliente cliente1 : Restaurant_Manager.clientes) {
            StrCliente[contador] = cliente1.getName();
            contador++;
        }
        JComboBox jcCliente = new JComboBox(StrCliente);
        jcCliente.setBounds(105, 35, 200, 20);
        jcCliente.setSelectedItem(cliente);
        jcCliente.setEnabled(false);
        jcCliente.setFont(titleFont);
        jcCliente.setBackground(Color.white);
        TextBox txtid = new TextBox(""+id, 105, 10, 50, 20, titleFont, false);
        TextBox txtdate = new TextBox(date, 105, 60, 200, 20, titleFont, false);
        PanelGeneral.add(txtid);
        PanelGeneral.add(txtdate);
        PanelGeneral.add(jcCliente);

        //Creacion de Botones
        Boton btnEdit = new Boton(20, 150, 35, 35, new Color(58, 255, 0), "img\\ico_edit.png");
        PanelGeneral.add(btnEdit);
        Boton btnEliminar = new Boton(60, 150, 35, 35, Color.red, "img\\ico_delete.png");
        PanelGeneral.add(btnEliminar);
        Boton btnCancel = new Boton(20, 150, 35, 35, Color.RED, "img\\ico_cancel.png");
        PanelGeneral.add(btnCancel);
        Boton btnSave = new Boton(60, 150, 35, 35, new Color(58, 255, 0), "img\\ico_save.png");
        PanelGeneral.add(btnSave);
        btnCancel.setVisible(false);
        btnSave.setVisible(false);
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jcCliente.setEnabled(true);
                txtdate.setEnabled(true);
                btnCancel.setVisible(true);
                btnSave.setVisible(true);
                btnEdit.setVisible(false);
                btnEliminar.setVisible(false);
            }
        });
        
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String StrCliente = jcCliente.getSelectedItem().toString();
                int idCliente = 0;
                for (Cliente cliente1 : Restaurant_Manager.clientes) {
                    if(StrCliente.equals(cliente1.getName())){
                        idCliente = cliente1.getId();
                        break;
                    }
                }
                for (Factura factura : Restaurant_Manager.facturas) {
                    if(Integer.parseInt(txtid.getText()) == factura.getId()){
                        factura.setClient(idCliente);
                        factura.setDate(txtdate.getText());
                        break;
                    }
                }
                Views.PanelesMain.Factura.dtm.setValueAt(StrCliente, fila, 1);
                Views.PanelesMain.Factura.dtm.setValueAt(txtdate.getText(), fila, 2);
                Cesar_Funciones.JsonDatos(5);
                jcCliente.setEnabled(false);
                txtdate.setEnabled(false);
                btnCancel.setVisible(false);
                btnSave.setVisible(false);
                btnEdit.setVisible(true);
                btnEliminar.setVisible(true);
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jcCliente.setEnabled(false);
                txtdate.setEnabled(false);
                btnCancel.setVisible(false);
                btnSave.setVisible(false);
                btnEdit.setVisible(true);
                btnEliminar.setVisible(true);
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int dato = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar esta Factura del sistema?");
                if(dato == 0){
                    for (Factura factura : Restaurant_Manager.facturas) {
                        if(Integer.parseInt(txtid.getText()) == factura.getId()){
                            Restaurant_Manager.facturas.remove(factura);
                            Views.PanelesMain.Factura.dtm.removeRow(fila);
                            CerrarVentana();
                            Cesar_Funciones.JsonDatos(5);
                            break;
                        }
                    }
                }
            }
        });
        
    }
    
    public FrameViews(int fila, int id, String name, float costo, float precio,String descripcion, ArrayList<POO.Ingrediente> ArrayIngredientes){
        this.setTitle("Factura #"+id);
        this.setResizable(false);
        this.setSize(320, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        PanelGeneral = new Panel(Color.white);
        this.getContentPane().add(PanelGeneral);
        FrameProducto( fila,  id,  name,  costo,  precio,descripcion, ArrayIngredientes);
    }
    private void FrameProducto(int fila, int id, String name, float costo, float precio,String descripcion, ArrayList<POO.Ingrediente> ArrayIngredientes){
        Label lid = new Label("Id:", 10, 10, 50, 20, titleFont, false);
        Label lname = new Label("Producto:", 10, 35, 80, 20, titleFont, false);
        Label lcosto = new Label("Costo:", 10, 60, 80, 20, titleFont, false);
        Label lprecio = new Label("Precio:", 10, 85, 80, 20, titleFont, false);
        Label lDescripcion = new Label("Descripcion:", 10, 110, 100, 20, titleFont, false);
        PanelGeneral.add(lid);
        PanelGeneral.add(lname);
        PanelGeneral.add(lcosto);
        PanelGeneral.add(lprecio);
        PanelGeneral.add(lDescripcion);
        
        //Inicianilizando Tabla
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Ingrediente");
        dtm.addColumn("Cantidad");
        dtm.addColumn("Unidad");
        int aux_i = 0;
        for (POO.Ingrediente ingrediente : ArrayIngredientes) {
            aux_i++;
            Object[] vector = {aux_i, ingrediente.getName(), ingrediente.getQuantity(), ingrediente.getUnits()};
            dtm.addRow(vector);
        }
        JTable tbl = new JTable(dtm);
        tbl.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(10, 140, 425, 120);
        PanelGeneral.add(scroll);
        
        //Iniciamos los textBox
        TextBox txtid = new TextBox(""+id, 115, 10, 50, 20, titleFont, false);
        TextBox txtname = new TextBox(name, 115, 35, 100, 20, titleFont, false);
        TextBox txtcosto = new TextBox("" + costo, 115, 60, 50, 20, titleFont, false);
        TextBox txtprecio = new TextBox("" + precio, 115, 85, 50, 20, titleFont, false);
        TextBox txtdescripcion = new TextBox(descripcion, 115, 110, 200, 20, titleFont, false);
        PanelGeneral.add(txtid);
        PanelGeneral.add(txtname);
        PanelGeneral.add(txtcosto);
        PanelGeneral.add(txtprecio);
        PanelGeneral.add(txtdescripcion);

        //Creacion de Botones
        Boton btnEdit = new Boton(20, 370, 35, 35, new Color(58, 255, 0), "img\\ico_edit.png");
        Boton btnEliminar = new Boton(60, 370, 35, 35, Color.red, "img\\ico_delete.png");
        Boton btnCancel = new Boton(20, 370, 35, 35, Color.RED, "img\\ico_cancel.png");
        Boton btnSave = new Boton(60, 370, 35, 35, new Color(58, 255, 0), "img\\ico_save.png");
        PanelGeneral.add(btnSave);
        PanelGeneral.add(btnCancel);
        PanelGeneral.add(btnEliminar);
        PanelGeneral.add(btnEdit);
        btnCancel.setVisible(false);
        btnSave.setVisible(false);
        
        //Crear Campos para agregar producto
        Label laddname = new Label("Ingredientes", 10, 270, 100, 20, titleFont, false);
        Label laddCantidad = new Label("Cantidad", 115, 270, 100, 20, titleFont, false);
        Label laddUnidad = new Label("Unidad", 220, 270, 100, 20, titleFont, false);
        PanelGeneral.add(laddname);
        PanelGeneral.add(laddCantidad);
        PanelGeneral.add(laddUnidad);
        TextBox txtaddname = new TextBox(10, 292, 100, 15, new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
        TextBox txtaddCantidad = new TextBox(115, 292, 100, 15, new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
        TextBox txtaddUnidad = new TextBox(220, 292, 100, 15, new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
        PanelGeneral.add(txtaddname);
        PanelGeneral.add(txtaddCantidad);
        PanelGeneral.add(txtaddUnidad);
        Boton btnAddIngrediente = new Boton("Agregar", 330, 282, 100, 20, titleFont);
        PanelGeneral.add(btnAddIngrediente);
        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!(txtaddname.getText().equals("")) && !(txtaddCantidad.getText().equals("")) && !(txtaddUnidad.getText().equals(""))){
                    if(Consola.ValidarInt(txtaddCantidad.getText())){
                        Object ojbIngre[] = {tbl.getRowCount() +1,txtaddname.getText(), txtaddCantidad.getText(), txtaddUnidad.getText()};
                        dtm.addRow(ojbIngre);
                        for (Producto producto : Restaurant_Manager.productos) {
                            if(producto.getId() == Integer.parseInt(txtid.getText())){
                                producto.getIngredientes().add(new POO.Ingrediente(txtaddname.getText(), Integer.parseInt(txtaddCantidad.getText()), txtaddUnidad.getText()));
                                Cesar_Funciones.JsonDatos(4);
                                break;
                            }
                        }
                        txtaddname.setText("");
                            txtaddUnidad.setText("");
                            txtaddCantidad.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "La contidad de Ingredeinte es tiene que ser un numero.");
                        txtaddCantidad.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                }
            }
        });
        //Seccion de Acciones de botones
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtname.setEnabled(true);
                txtcosto.setEnabled(true);
                txtprecio.setEnabled(true);
                txtdescripcion.setEnabled(true);
                btnCancel.setVisible(true);
                btnSave.setVisible(true);
                btnEdit.setVisible(false);
                btnEliminar.setVisible(false);
            }
        });
        
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(true){
                    for (Producto producto : Restaurant_Manager.productos) {
                        if(producto.getId() == Integer.parseInt(txtid.getText())){
                            producto.setName(txtname.getText());
                            producto.setCost(Float.parseFloat(txtcosto.getText()));
                            producto.setPrice(Float.parseFloat(txtprecio.getText()));
                            producto.setDescription(txtdescripcion.getText());
                            break;
                        }
                    }
                    Cesar_Funciones.JsonDatos(4);
                    txtname.setEnabled(false);
                    txtcosto.setEnabled(false);
                    txtprecio.setEnabled(false);
                    txtdescripcion.setEnabled(false);
                    btnCancel.setVisible(false);
                    btnSave.setVisible(false);
                    btnEdit.setVisible(true);
                    btnEliminar.setVisible(true);
                }
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                txtname.setEnabled(false);
                txtcosto.setEnabled(false);
                txtprecio.setEnabled(false);
                txtdescripcion.setEnabled(false);
                btnCancel.setVisible(false);
                btnSave.setVisible(false);
                btnEdit.setVisible(true);
                btnEliminar.setVisible(true);
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int dato = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este producto del sistema?");
                if(dato == 0){
                    for (Producto producto : Restaurant_Manager.productos) {
                        if(producto.getId() == Integer.parseInt(txtid.getText())){
                            Restaurant_Manager.productos.remove(producto);
                            Cesar_Funciones.JsonDatos(4);
                            CerrarVentana();
                            Views.PanelesMain.Producto.dtm.removeRow(fila);
                            break;
                        }
                    }
                }
            }
        });
        
        //Seccion de Acciones para la tabla
        tbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int fila = tbl.rowAtPoint(me.getPoint());
                String name_ing = tbl.getValueAt(fila, 1).toString(); 
                int opc = JOptionPane.showConfirmDialog(null, "Deseas eliminar este ingrediente: "+ name_ing);
                if(opc == 0){
                    dtm.removeRow(fila);
                    for (POO.Producto producto : Restaurant_Manager.productos) {
                        if(Integer.parseInt(txtid.getText()) == producto.getId()){
                            for (Ingrediente ingrediente : producto.getIngredientes()) {
                                System.out.println(ingrediente.getName());
                                if(ingrediente.getName().equals(name_ing)){
                                    producto.getIngredientes().remove(ingrediente);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    Cesar_Funciones.JsonDatos(4);
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
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    
    private void CerrarVentana() {
        this.setVisible(false);
    }
}
