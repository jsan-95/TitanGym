package Model;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendEmail  {  
    private final String origen;
    private final String password;
    private final String subject;
    private final String body;
    public SendEmail(String origen, String password, String subject, String body){
        this.origen = origen;
        this.password = password;
        this.subject = subject;
        this.body = body;
    }
    
    public boolean SendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(origen, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(origen));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("playfit.as2018@gmail.com"));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }
}  
