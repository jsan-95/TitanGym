package FrontController;

import Model.XMLGenerator;
import Model.XMLReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class RegisterCommand extends FrontCommand{
    @Override
    public void process() {
        
        try {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            HttpSession session = request.getSession();
            session.setAttribute("username", userName);
            session.setAttribute("password", password);
            
            String pathHorario = request.getServletContext().getRealPath("/WEB-INF/Horario.xml");
            XMLReader xmlreader = new XMLReader(pathHorario);
            HashMap<String,String> horario = xmlreader.XMLreader(userName, " ");
            XMLGenerator myxml = new XMLGenerator(horario);
            myxml.createXML();
            Document xml = myxml.xml;

            session.setAttribute("miHorario", xml);
            forward("/ControllerPages/Perfil.jsp");
            
        } catch (ServletException | IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
