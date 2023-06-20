package si.um.feri.dao;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.mail.MessagingException;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.interfaces.SetDoctor;
import si.um.feri.observers.IObserver;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

public class PacientDaoBean implements SetDoctor {


    private List<IObserver> observers = new ArrayList<>();
    private List<Pacient> pacients = new ArrayList<>();
    private List<Pacient> withoutDoctor = new ArrayList();
    private static PacientDaoBean instance;


//    public static synchronized PacientDao getInstance() {
//        if (instance == null) {
//            instance = new PacientDao();
//        }
//        return instance;
//    }

    public Pacient addPacient(Pacient p) {
        pacients.add(p);
        if (p.getDoctorEmail() != null) {
//            doctorDao.incrementNumberOfPacients(p.getDoctor());
        }
        return p;
    }

    public Pacient addPacient(Pacient p, Doctor d) {
        return null;
    }

    public Pacient findPacient(int id) {
        return null;
    }

    public Pacient findPacient(String email) {
        for (Pacient p: pacients) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        return null;
    }

    public List<Pacient> pacientsWithoutDoctor() {
        withoutDoctor.clear();
       for (Pacient p: pacients) {
           if (p.getDoctorEmail() == null) {
               withoutDoctor.add(p);
           }
       }
       return withoutDoctor;
    }

    public List<Pacient> getPacients() {
        return pacients;
    }

    public void setPacients(List<Pacient> pacients) {
        this.pacients = pacients;
    }

    public void deletePacient (Pacient p) {
        pacients.remove(p);
    }

    public void deletePacient(int entityId) {

    }

    public Pacient updatePacient(Pacient p) {
        return null;
    }

//    @Override
//    public void updatePacient(Pacient p) {
//        for (int i = 0; i < pacients.size(); i++) {
//            Pacient pacient = pacients.get(i);
//            if (pacient.getEmail().equals(p.getEmail())) {
//                pacients.set(i, p);
//                break;
//            }
//        }
//        p.setEditable(false);
//    }

    public void addDoctorToPatient(String emailP, String emailD) throws MessagingException, NamingException {
        if (pacients == null) {
            System.out.println("PLEASE INITIALIZE DATA LOAD THE PAGE");
        }
        else {
//            Doctor d = doctorDao.findDoctor(emailD);
            Pacient p = findPacient(emailP);

            // we can send here by sendEmail or just notify observers
//            p.notifyObservers();
        }

    }

}
