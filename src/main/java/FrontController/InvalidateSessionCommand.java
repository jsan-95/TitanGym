package FrontController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class InvalidateSessionCommand extends FrontCommand{
    
    @Override
    public void process() {
        try {
            request.getSession().invalidate();
            forward("/Main/Index.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(InvalidateSessionCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
