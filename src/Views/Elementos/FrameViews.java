package Views.Elementos;

import POO.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import restaurant_manager.Cesar_Funciones;
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
    
    private void CerrarVentana() {
        this.setVisible(false);
    }
}
