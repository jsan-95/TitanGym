package FrontController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

class UnknownCommand extends FrontCommand{

    @Override
    public void process() {
        try {
            forward("/ControllerPages/Unknown.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UnknownCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
