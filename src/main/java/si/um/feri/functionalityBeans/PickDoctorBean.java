package si.um.feri.functionalityBeans;

import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.mail.*;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.interfaces.PickDoctor;
import si.um.feri.vao.Doctor;
import java.io.Serializable;
import java.util.Scanner;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import si.um.feri.vao.Pacient;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@Stateless
@Local(PickDoctor.class)
public class PickDoctorBean implements Serializable, PickDoctor {

    @EJB
    DoctorDao doctorDao;
    @EJB
    PacientDao pacientDao;

    @Override
    public void sendEmail(Doctor d, Pacient p) throws NamingException, MessagingException {

        InitialContext ctx = new InitialContext();
        Session session = (Session) ctx.lookup("java:jboss/mail/UMMail");
        Message message = new MimeMessage(session);
        InternetAddress toAdress = new InternetAddress(p.getEmail());
        message.addRecipient(Message.RecipientType.TO, toAdress);
        message.setSubject("Doctor Pick Info");

        if (d.getNumberOfPatients() >= d.getMaxNumberOfPatients()) {
            message.setContent("Dear " + p.getName() + " " + "\n We are sorry to inform you that you were unable to pick Doctor "
                    + d.getName() + d.getSurname()
                    + "because he already has an maximum number of patientes. \n Best Regards from Sveti Vracevi", "text/plain");
            Transport.send(message);

        } else if (d.getNumberOfPatients() < d.getMaxNumberOfPatients()) {
            System.out.print(" ovde sam " + d.getNumberOfPatients() + "<=" + d.getMaxNumberOfPatients());
            message.setContent("Dear " + p.getName() + "\n We are glad to inform you that you sucessfully picked Doctor "
                    + d.getName() + d.getSurname()
                    + "For more info please contact us. \n \n Best Regards from Sveti Vracevi", "text/plain");
            Transport.send(message);
        }


    }

//    public void consoleApp() {
//
//        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        System.out.println("Enter patient email:");
//        String patientEmail = scanner.nextLine();
//
//        System.out.println("Enter doctor email:");
//        String doctorEmail = scanner.nextLine();
//
//        Pacient p = pacientDao.findPacient(patientEmail);
//        Doctor d = doctorDao.findDoctor(doctorEmail);
//
//        if (d == null) {
//            System.out.println("We cannot find a doctor with that email");
//        }
//        else {
//            System.out.println("We found your doctor" + d);
//        }
//
//    }
        // Method to read input from the console and call the sendEmail method
        public void consoleApp() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter patient name: ");
            String patientName = scanner.nextLine();
            System.out.println(patientName);
            scanner.close();

//
//            System.out.print("Enter patient email: ");
//            while (!scanner.hasNextLine()) { // wait for input
//            }
//            String patientEmail = scanner.nextLine();
//
//            System.out.print("Enter doctor name: ");
//            while (!scanner.hasNextLine()) { // wait for input
//            }
//            String doctorName = scanner.nextLine();
//
//            System.out.print("Enter doctor surname: ");
//            while (!scanner.hasNextLine()) { // wait for input
//            }
//            String doctorSurname = scanner.nextLine();
//
//            Doctor doctor = new Doctor();
//            doctor.setName(doctorName);
//            doctor.setSurname(doctorSurname);
//
//            Pacient pacient = new Pacient();
//            pacient.setName(patientName);
//            pacient.setEmail(patientEmail);
//
//            try {
//                sendEmail(doctor, pacient);
//                System.out.println("Email sent successfully!");
//            } catch (NamingException | MessagingException e) {
//                System.err.println("Error sending email: " + e.getMessage());
//            } finally {
//                scanner.close();
//            }
         }
    }



