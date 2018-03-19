package Model;
import java.util.HashMap;
import java.util.Map;

public class Horario {
    
    private final String userName;
    public Map<String,HashMap<String,String>> horario;

    public Horario(String userName){
        this.horario = new HashMap<>();
        this.userName = userName;
    }

    public void setActivities(String username,String hora, String dia, String ejercicio) {
        
        if(!horario.containsKey(username)){
            HashMap<String,String> activities = new HashMap<>();
            activities.put(hora, ejercicio);
            horario.put(username,activities);
        }else{
            HashMap<String,String> hM = this.horario.get(username);
            if(!hM.containsKey(hora)){
                hM.put(hora, ejercicio);
            }else{
                String sActivities = hM.get(hora);
                sActivities += ";" + ejercicio;
                hM.replace(hora, sActivities);
            }
            horario.put(username,hM);
        }
    }
    
    public String getUsername() {
        return this.userName;
    }
    
    public HashMap<String,String> getHorario(String username){
        return horario.get(username);
    }
}
