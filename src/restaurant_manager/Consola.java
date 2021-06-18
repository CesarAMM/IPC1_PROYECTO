package restaurant_manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Consola {
    private static Scanner s;
    private Consola(){}
    
    public static String inputString(String d){
        s=new Scanner(System.in);System.out.print(d);
        return s.nextLine();
    }
    
    public static int inputInt(String d){
        s = new Scanner(System.in);System.out.print(d); int valor =0;
        try {
            valor = s.nextInt();
        } catch (Exception e) {
            System.out.println(""
                    + "\t********************************\n"
                    + "\t**  Error. Ingrese un numero  **\n"
                    + "\t********************************\n");
        }
        return valor;
    }
    
    public static void strErrorFueraRango(){
        System.out.println("\n"
                + "\t**********************************************\n"
                + "\t**  Has ingresado un nuemro fuera de rango  **\n"
                + "\t**********************************************\n");
    }
    
    public static void serialize(String pathname, Object object) {
        // Serializar un objeto
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathname));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String pathname) {
        // Leer un objeto serializado
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname));
            Object data = objectInputStream.readObject();
            objectInputStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String readFile(String pathname) {
        File archivo;
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder content = new StringBuilder();

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Se recorre linea por linea el archivo y se almacena en 'content'
            content = new StringBuilder();
            for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
                content.append(linea).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // En el finally cerramos el fichero y el buffer ocurra o no un error.
            try {
                if (null != br)
                    br.close();
                if (null != fr)
                    fr.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return content.toString();
    }
    
    private static void addToEndFile(String data, String paht) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(paht, true); // True indica que se va a agregar datos al final
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            // Escribe los datos en el archivo
            bfwriter.write(data + "\n");
            bfwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private static String Fecha(){
        Calendar fecha = new GregorianCalendar();
        String mes = "" + fecha.get(Calendar.MONTH) +1;
        String dia = "" + fecha.get(Calendar.DATE);
        String ayo = "" + fecha.get(Calendar.YEAR);
        String hora = "" + fecha.get(Calendar.HOUR);
        String min = "" + fecha.get(Calendar.MINUTE);
        if(Integer.parseInt(mes) < 10){mes = "0"+mes;}
        if(Integer.parseInt(dia) < 10){dia = "0"+dia;}
        if(Integer.parseInt(hora) < 10){hora = "0"+hora;}
        if(Integer.parseInt(min) < 10){min = "0"+min;}
        return dia+"/"+mes+"/"+ayo +" " +hora+":"+min;
    }
    
    public static void InsertNewError(String orign, String commit){
        addToEndFile(Fecha() +"\t"+orign+":\t"+commit, "C:\\Users\\cesar.monroy\\Desktop\\ipc\\PruebasProyecto\\errors.log");
    }
    public static void InsertNewLog(String orign, String commit){
        
        addToEndFile(Fecha() +"\t"+orign+":\t"+commit, "C:\\Users\\cesar.monroy\\Desktop\\ipc\\PruebasProyecto\\log.log");
    }
}
