package FrontController;

import Model.XMLGenerator;
import Model.XMLGeneratorTwoStep;
import Model.XMLReader;
import Model.XMLReaderTwoStep;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class CyclingCommand extends FrontCommand {
    
    @Override
    public void process() {
        try {
            String pathHorario = request.getServletContext().getRealPath("/WEB-INF/Horario.xml");
            XMLReader xmlreader = new XMLReader(pathHorario);
            HashMap<String,String> horario = xmlreader.XMLreader("local","Cycling");
            XMLGenerator myxml = new XMLGenerator(horario);
            myxml.createXML();
            Document xml = myxml.xml;
            request.setAttribute("xml", xml);
            
            String pathCuota = request.getServletContext().getRealPath("/WEB-INF/Cuotas.xml");
            XMLReaderTwoStep xmlreaderTwoStep = new XMLReaderTwoStep(pathCuota);
            HashMap<String,String> cuota = xmlreaderTwoStep.XMLreader("cycling");
            XMLGeneratorTwoStep myXML = new XMLGeneratorTwoStep(cuota);
            myXML.createXML("cycling");
            Document xmlTwoStep = myXML.xml;
            request.setAttribute("xmlTwoStep", xmlTwoStep);
            forward("/ControllerPages/Cycling.jsp");
        } catch (ServletException | IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(CyclingCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
