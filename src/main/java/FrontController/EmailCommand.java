package FrontController;

import Model.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


public class EmailCommand extends FrontCommand{
    @Override
    public void process() {
        try {
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            if(session.getAttribute("username")!=null){
                String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
                
                SendEmail sendEmail = new SendEmail(request.getParameter("email"), (String)session.getAttribute("password"),
                request.getParameter("subject"), request.getParameter("message"));
                boolean send = sendEmail.SendMail();
                if (send){
                    response.sendRedirect(request.getHeader("referer"));
                }else{
                    session.setAttribute("errorMessage", "Error al introducir el correo electrónico o contraseña");
                    response.sendRedirect(request.getHeader("referer"));
                    StringBuffer ruta =  request.getRequestURL();
                }
                
            }else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Para enviar el correo debe iniciar sesión');");
                out.println("location='/Ejemplo1/Main/Index.jsp';");
                out.println("</script>");
                
                //forward("/Main/Index.jsp");
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(EmailCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
