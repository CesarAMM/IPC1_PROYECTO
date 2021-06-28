package restaurant_manager;

import POO.Usuario;

public class Logger {
    private Usuario user;
    
    private Usuario Logger(Usuario user){
        if(this.user == null){
            this.user = user;
            return user;
        }else{
            return this.user;
        }
    }
    public Usuario getUser(){
        return Logger(this.user);
    }
}
