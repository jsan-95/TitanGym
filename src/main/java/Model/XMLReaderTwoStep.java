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

public class XMLReaderTwoStep {

    private final String fileName;
    public XMLReaderTwoStep(String fileName) {
        this.fileName = fileName;
    }
    
    public HashMap<String, String> XMLreader(String activity) throws ParserConfigurationException, SAXException, IOException{
        Document doc = createDocument(fileName);
        NodeList nList = doc.getElementsByTagName("cuotas");
        
        Cuota x = new Cuota();
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode; 
                String q = eElement.getNodeName();
                for(int j = 0; j < 4; j++){
                    NodeList nl = eElement.getElementsByTagName(activity);
                    Node n = nl.item(j);
                    String a = n.getTextContent();
                    
                    x.setActivities(a,activity);
                }
            }
        }
        return x.getCuota();
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

}
