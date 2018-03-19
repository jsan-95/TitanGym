package Model;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLGenerator {

    private final HashMap<String,String> horario;
    public Document xml;
    
    public XMLGenerator(HashMap<String,String> horario){
        this.horario = horario;
    }
    
    public void createXML(){
        String nombre_archivo = "horarios";
        ArrayList hora = new ArrayList();
        ArrayList lunes = new ArrayList();
        ArrayList martes = new ArrayList();
        ArrayList miercoles = new ArrayList();
        ArrayList jueves = new ArrayList();
        ArrayList viernes = new ArrayList();
        
        int h = 10;
        String keyHora = "09:00";
        
        for(int i = 0; i < horario.size(); i++){
            
            hora.add(keyHora);
            String hh = horario.get(keyHora);
            String [] parts = hh.split(";");
            lunes.add(parts[0]);
            martes.add(parts[1]);
            miercoles.add(parts[2]);
            jueves.add(parts[3]);
            viernes.add(parts[4]);
            keyHora = (h+i)+":00";
        }

        try { 
            generate(nombre_archivo, hora, lunes, martes, miercoles, jueves, viernes);
        } catch (Exception e) {}
    }

    public void generate(String name, ArrayList<String> hora, ArrayList<String> lunes, ArrayList<String> martes, ArrayList<String> miercoles, ArrayList<String> jueves, ArrayList<String> viernes) throws Exception{

        if(hora.isEmpty() || lunes.isEmpty() ){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");

            Element raiz = document.getDocumentElement();

            for(int i=0; i<hora.size();i++){
                Element itemNode = document.createElement("horario"); 

                Element horaNode = document.createElement("hora"); 
                Text nodeHoraValue = document.createTextNode(hora.get(i));
                horaNode.appendChild(nodeHoraValue);      

                Element lunesNode = document.createElement("lunes"); 
                Text nodeLunesValue = document.createTextNode(lunes.get(i));                
                lunesNode.appendChild(nodeLunesValue);
                
                Element martesNode = document.createElement("martes"); 
                Text nodeMartesValue = document.createTextNode(martes.get(i));                
                martesNode.appendChild(nodeMartesValue);
                
                Element miercolesNode = document.createElement("miercoles"); 
                Text nodeMiercolesValue = document.createTextNode(miercoles.get(i));                
                miercolesNode.appendChild(nodeMiercolesValue);
                
                Element juevesNode = document.createElement("jueves"); 
                Text nodeJuevesValue = document.createTextNode(jueves.get(i));                
                juevesNode.appendChild(nodeJuevesValue);
                
                Element viernesNode = document.createElement("viernes"); 
                Text nodeViernesValue = document.createTextNode(viernes.get(i));                
                viernesNode.appendChild(nodeViernesValue);

                itemNode.appendChild(horaNode);
                itemNode.appendChild(lunesNode);
                itemNode.appendChild(martesNode);
                itemNode.appendChild(miercolesNode);
                itemNode.appendChild(juevesNode);
                itemNode.appendChild(viernesNode);

                raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
            }                
            //Generate XML
            //Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            //Result result = new StreamResult(new java.io.File("/Users/Yisus95/NetBeansProjects/Ejemplo1/web/Principal/"+name+".xml")); //nombre del archivo
            //Transformer transformer = TransformerFactory.newInstance().newTransformer();
            xml = document;
            
            //transformer.transform(source, result);
        }
    }
}