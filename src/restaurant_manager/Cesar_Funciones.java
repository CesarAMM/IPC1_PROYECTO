package restaurant_manager;

import POO.Restaurante;
import com.google.gson.Gson;

public class Cesar_Funciones {
    public static void InitDownloadData(){
        String paht_json = "C:\\Users\\cesar.monroy\\Desktop\\ipc\\PruebasProyecto\\Json\\";//Para ir a buscar los datos del Json
        String paht_bin = "C:\\Users\\cesar.monroy\\Desktop\\ipc\\PruebasProyecto\\Bin\\";//Para ir a buscar datos Binarios
        //Iniciamos con el config.json
        String config = Consola.readFile(paht_json + "config.json");
        Gson gson = new Gson();
        Restaurante restaurante = gson.fromJson(config, Restaurante.class);
        if(restaurante.getLoad().equals("json")){
            CargaDatos_Json(paht_json);
        }else if(restaurante.getLoad().equals("bin")){
            CargaDatos_Bin(paht_bin);
        }
    }
    
    private static void CargaDatos_Json(String paht){
        
    }
    
    private static void CargaDatos_Bin(String paht){
        
    }
}
