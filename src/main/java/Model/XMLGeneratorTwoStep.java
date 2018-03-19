package Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLGeneratorTwoStep {

    private final HashMap<String,String> cuota;
    public Document xml;
    public XMLGeneratorTwoStep(HashMap<String,String> cuota){
        this.cuota = cuota;
    }
    
    public void createXML(String activity){
        String nombre_archivo = "screen";
        ArrayList price = new ArrayList();
        
        for(int i = 0; i < cuota.size(); i++){
            String hh = cuota.get(activity);
            String [] parts = hh.split(";");
            price.addAll(Arrays.asList(parts));
        }

        try { 
            generate(nombre_archivo, price, activity);
        } catch (Exception e) {}
    }

    public void generate(String name, ArrayList<String> price, String activity) throws Exception{

        if(price.isEmpty()){
            System.out.println("ERROR eeempty ArrayList");
            return;
        }else{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");

            Element raiz = document.getDocumentElement();
            Element itemNode = document.createElement("table"); 
            
            for(int i=0; i<price.size();i++){
                
                Element dayNode = document.createElement("row"); 
                Element cellNode = document.createElement("cell"); 
                dayNode.appendChild(cellNode);
                
                Text nodeCellValue = document.createTextNode((i+2)+"");
                cellNode.appendChild(nodeCellValue); 
                
                Element priceNode = document.createElement("cell"); 
                Text nodePriceValue = document.createTextNode(price.get(i));
                priceNode.appendChild(nodePriceValue);      

                dayNode.appendChild(priceNode);
                itemNode.appendChild(dayNode);
                
                raiz.appendChild(itemNode); 
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