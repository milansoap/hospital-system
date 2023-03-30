package si.um.feri;


import jakarta.mail.MessagingException;
import jakarta.mail.Session;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Properties;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;


public class Main {
    public static void main(String[] args) throws NamingException, MessagingException {

        Properties props=new Properties();
        props.put("java.naming.factory.initial","org.jboss.naming.remote.client.InitialContextFactory");
        props.put("java.naming.provider.url","http-remoting://127.0.0.1:8080");
        props.put("jboss.naming.client.ejb.context","true");
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        props.put("java.naming.security.principal", "milan.soap123");
        props.put("java.naming.security.credentials", "Samsung123@");

        InitialContext ctx=new InitialContext(props);

        EmailSender mailer = (EmailSender) ctx.lookup("java:app/osebeMemoryDao/EmailSenderBean!si.um.feri.interfaces.EmailSender");

        Doctor doctor1 = new Doctor("John", "Doe", "johndoe@example.com");
        Pacient pacient1 =new Pacient("Milan", "Djuric", "milan.seid123@gmail.com", new Date(), "Najjaci lik ikad tebradzouns", null);

        mailer.sendEmail(doctor1,pacient1);

    }
}