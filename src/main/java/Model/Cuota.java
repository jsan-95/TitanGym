package Model;

import java.util.HashMap;

public class Cuota {

    public HashMap<String,String> cuota;
    
    public Cuota() {
        this.cuota = new HashMap<>();
        
    }

    public HashMap<String, String> getCuota() {
        return this.cuota;
    }

    void setActivities(String precio, String excercise) {
        if(!cuota.containsKey(excercise)){
            cuota.put(excercise,precio);
        }else{
            String price = cuota.get(excercise);
            price += ";" + precio;
            cuota.replace(excercise, price);
        }
    }
}
