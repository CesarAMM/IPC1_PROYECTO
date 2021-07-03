package Views.PanelesMain;

import POO.Ingrediente;
import Views.Elementos.*;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import restaurant_manager.Consola;
import restaurant_manager.Restaurant_Manager;

public class Producto implements MouseListener{
    public static JTable tbl;
    public static DefaultTableModel dtm;
    public void IniciarComponentes_PanelProducto() {
        Label titulo = new Label("Seccion de Producto", 0, 5, 430, 15, Views.Main.Font_title , true);
        Views.Main.jpViews_Producto.add(titulo);
        
        //Inicianilizando Tabla
        dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Producto");
        dtm.addColumn("Costo");
        dtm.addColumn("Precio");
        for (POO.Producto producto : Restaurant_Manager.productos) {
            Object[] vector = {producto.getId(), producto.getName(), producto.getCost(), producto.getPrice()};
            dtm.addRow(vector);
        }
        
        tbl = new JTable(dtm);
        tbl.setEnabled(false);
        tbl.addMouseListener(this);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(10, 30, 610, 150);
        Views.Main.jpViews_Producto.add(scroll);
        
        Boton btnAgregar = new Boton("Nuevo Producto", 20, 190, 200, 25, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), Color.white, new Color(52, 229, 0));
        Views.Main.jpViews_Producto.add(btnAgregar);
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
        POO.Producto p = null;
        for (POO.Producto producto : Restaurant_Manager.productos) {
            if(Integer.parseInt(tbl.getValueAt(fila, 0).toString()) == producto.getId()){
                p = producto;
                break;
            }
        }
        FrameViews fProducto = new FrameViews(fila, p.getId(), p.getName(), p.getCost(), p.getPrice(), p.getDescription(), p.getIngredientes());
        fProducto.setSize(450, 450);
        fProducto.setVisible(true);
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void IniciarVentana(){
        FrameAdd v = new FrameAdd("Nuevo Producto", new Panel(Color.white));
        v.setSize(450, 400);
        //Iniciar los elementos Labels
        Label l_name = new Label("Producto:", 10, 10, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        Label l_cost = new Label("Costo:", 10, 35, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15),false);
        Label l_price = new Label("Precio:", 10, 60, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        Label l_descripcion = new Label("Descripcion:", 10, 85, 150, 15, new Font(Font.DIALOG_INPUT, Font.BOLD, 15), false);
        v.getPanelGeneral().add(l_name);
        v.getPanelGeneral().add(l_cost);
        v.getPanelGeneral().add(l_price);
        v.getPanelGeneral().add(l_descripcion);
        Label l_addIngrediente = new Label("Ingrediente:", 10, 105, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 12), false);
        Label l_addCount = new Label("Cantidad:", 115, 105, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 12),false);
        Label l_addUnity = new Label("Unidad:", 220, 105, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 12), false);
        v.getPanelGeneral().add(l_addIngrediente);
        v.getPanelGeneral().add(l_addCount);
        v.getPanelGeneral().add(l_addUnity);
        //Crear textbox
        TextBox t_name = new TextBox(165, 10, 130, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        TextBox t_cost = new TextBox(165, 35, 130, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        TextBox t_price = new TextBox(165, 60, 130, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        TextBox t_descripcion = new TextBox(165, 85, 130, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        v.getPanelGeneral().add(t_name);
        v.getPanelGeneral().add(t_cost);
        v.getPanelGeneral().add(t_price);
        v.getPanelGeneral().add(t_descripcion);
        TextBox t_addingrediente = new TextBox(10, 127, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        TextBox t_addCantidad = new TextBox(115, 127, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        TextBox t_addUnity = new TextBox(220, 127, 100, 20, new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        v.getPanelGeneral().add(t_addingrediente);
        v.getPanelGeneral().add(t_addCantidad);
        v.getPanelGeneral().add(t_addUnity);
        Boton btnAgregarIngrediente = new Boton("Agregar", 325, 120, 100, 20, new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
        v.getPanelGeneral().add(btnAgregarIngrediente);
        //Crear Tabla para ver los Ingredintes
        DefaultTableModel dmt1 = new DefaultTableModel();
        dmt1.addColumn("Id");
        dmt1.addColumn("Ingrediente");
        dmt1.addColumn("Cantidad");
        dmt1.addColumn("Unidad");
        JTable tbl1 = new JTable(dmt1);
        tbl1.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tbl1);
        scroll.setBounds(10, 150, 430, 150);
        v.getPanelGeneral().add(scroll);
        //Agregar Boton save
        Boton btnSaveProducto = new Boton("Guardar", 10, 320, 100, 20, new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
        v.getPanelGeneral().add(btnSaveProducto);
        //Mostrar Ventana
        v.setVisible(true);
        
        //Seccion para las acciones de los elementos
        btnAgregarIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!t_addCantidad.getText().equals("") && !t_addingrediente.getText().equals("") && !t_addUnity.getText().equals("")){
                    if(Consola.ValidarInt(t_addCantidad.getText())){
                        Object[] ojc = {tbl1.getRowCount()+1, t_addingrediente.getText(), t_addCantidad.getText(), t_addUnity.getText()};
                        dmt1.addRow(ojc);
                        t_addCantidad.setText("");
                        t_addUnity.setText("");
                        t_addingrediente.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error. \nTiene que llenar la cantidad con un numero.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error.\nTiene que llenar todos los campos para agregar un producto.");
                }
            }
        });
        tbl1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int filaseleccionada = tbl1.rowAtPoint(me.getPoint());
                int opc = JOptionPane.showConfirmDialog(null, "¿Eliminaras este ingrediente: "+tbl1.getValueAt(filaseleccionada, 2)+"?");
                if(opc == 0){
                    tbl1.remove(filaseleccionada);
                }
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
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
           //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btnSaveProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              if(tbl1.getRowCount() !=0 &&!t_name.getText().equals("") && !t_descripcion.getText().equals("") && !t_cost.getText().equals("") && !t_price.getText().equals("")){
                  if(Consola.ValidarFloat(t_cost.getText()) && Consola.ValidarFloat(t_price.getText())){
                      int idProducto = Restaurant_Manager.productos.get(Restaurant_Manager.productos.size()-1).getId()+1;
                      ArrayList<POO.Ingrediente> arraylistining = new ArrayList<>();
                      for (int i = 0; i < tbl1.getRowCount(); i++) {
                          POO.Ingrediente Inge = new Ingrediente(tbl1.getValueAt(i, 1).toString(),Integer.parseInt(tbl1.getValueAt(i, 2).toString()), tbl1.getValueAt(i, 3).toString());
                          arraylistining.add(Inge);
                      }
                      Restaurant_Manager.productos.add(new POO.Producto(idProducto,t_name.getText(), t_descripcion.getText(), Float.parseFloat(t_cost.getText()) , Float.parseFloat(t_price.getText()), arraylistining));
                      Object[] obje = {idProducto, t_name.getText(), t_cost.getText(), t_price.getText()};
                      dtm.addRow(obje);
                      v.setVisible(false);
                  }else{
                      if(!Consola.ValidarFloat(t_cost.getText())){
                          JOptionPane.showMessageDialog(null, "Error en el Costo, verifique que sea un numero");
                      }else if (!Consola.ValidarFloat(t_price.getText())){
                          JOptionPane.showMessageDialog(null, "Error en el precio, verifique que sea un numero");
                      }
                  }
              }else{
                  JOptionPane.showMessageDialog(null, "Error.\nVerifique que todos los campos esten llenos o que la tabla no este vacia");
              }
            }
        });
    }
    
}
