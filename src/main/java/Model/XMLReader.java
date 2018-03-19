package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

    private final String fileName;
    public XMLReader(String fileName) {
        this.fileName = fileName;
    }
    
    public HashMap<String, String> XMLreader(String userName, String activitie) throws ParserConfigurationException, SAXException, IOException{
        Document doc = createDocument(fileName);
        NodeList nList = doc.getElementsByTagName("horarios");

        Horario jesus = new Horario("jesus");
        Horario thor = new Horario("thor");
        Horario x = new Horario(userName);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
                
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;    

                for(int j = 0; j < 12; j++){
                    addActivities("Crossfit",jesus,"jesus",eElement, j);
                    addActivities("Natacion",thor,"thor", eElement, j);
                    addActivities(activitie,x,userName, eElement, j);
                }
            }
        }
        HashMap<String,String> horario = null;
        switch (userName) {
            case "jesus":
                horario = jesus.getHorario("jesus");
                break;
            case "thor":
                horario = thor.getHorario("thor");
                break;
            default:
                horario = x.getHorario(userName);
                break;
        }
        return horario;
    }
    
    private Document createDocument(String fileName)
            throws FileNotFoundException, ParserConfigurationException,
            SAXException, IOException {
        InputStream inputStream = new FileInputStream(fileName);
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private void addActivities(String activitie, Horario name, String userName, Element eElement, int j) {
        if(activitie.equals(eElement.getElementsByTagName("lunes").item(j).getTextContent())){
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "lunes",eElement.getElementsByTagName("lunes").item(j).getTextContent());
        }else{
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "lunes"," ");
        }
        if(activitie.equals(eElement.getElementsByTagName("martes").item(j).getTextContent())){
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "martes",eElement.getElementsByTagName("martes").item(j).getTextContent());
        }else{
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "martes"," ");
        }
        if(activitie.equals(eElement.getElementsByTagName("miercoles").item(j).getTextContent())){
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "miercoles",eElement.getElementsByTagName("miercoles").item(j).getTextContent());
        }else{
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "miercoles"," ");
        }
        if(activitie.equals(eElement.getElementsByTagName("jueves").item(j).getTextContent())){
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "jueves",eElement.getElementsByTagName("jueves").item(j).getTextContent());
        }else{
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "jueves"," ");
        }
        if(activitie.equals(eElement.getElementsByTagName("viernes").item(j).getTextContent())){
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "viernes",eElement.getElementsByTagName("viernes").item(j).getTextContent());
        }else{
            name.setActivities(userName,eElement.getElementsByTagName("hora").item(j).getTextContent(),
                "viernes"," ");
        }
    }
}
