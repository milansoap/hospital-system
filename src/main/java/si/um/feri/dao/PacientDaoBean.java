package si.um.feri.dao;

import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.vao.Pacient;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local(PacientDao.class)
public class PacientDaoBean implements PacientDao {

    private List<Pacient> pacients = new ArrayList<>();
    private List<Pacient> withoutDoctor = new ArrayList();
    private static PacientDaoBean instance;

    @EJB
    DoctorDao doctorDao;



//    @PostConstruct
//    private void initPacients() {
//        Doctor doctor1 = doctorDao.findDoctor("johndoe@example.com");
//        Doctor doctor2 = doctorDao.findDoctor("janedoe@example.com");
//        Doctor doctor3 = doctorDao.findDoctor("bobsmith@example.com");
//        Doctor doctor4 = doctorDao.findDoctor("alicejones@example.com");
//        Doctor doctor5 = doctorDao.findDoctor("tomwilson@example.com");
//
//        addPacient(new Pacient("Alice", "Adams", "aliceadams@example.com", new Date(), "High blood pressure", doctor1));
//        // ...
//    }



//        Doctor doctor1 = new Doctor("John", "Doe", "johndoe@example.com");
//        Doctor doctor2 = new Doctor("Jane", "Doe", "janedoe@example.com");
//        Doctor doctor3 = new Doctor("Bob", "Smith", "bobsmith@example.com");
//        Doctor doctor4 = new Doctor("Alice", "Jones", "alicejones@example.com");
//        Doctor doctor5 = new Doctor("Tom", "Wilson", "tomwilson@example.com");
//
//        doctorDao.addDoctor(doctor1);
//        doctorDao.addDoctor(doctor2);
//        doctorDao.addDoctor(doctor3);
//        doctorDao.addDoctor(doctor4);
//        doctorDao.addDoctor(doctor5);
//
//        addPacient(new Pacient("Alice", "Adams", "aliceadams@example.com", new Date(), "High blood pressure", doctor1));
//        addPacient(new Pacient("Bob", "Baker", "bobbaker@example.com", new Date(), "Asthma", doctor2));
//        addPacient(new Pacient("Charlie", "Clark", "charlieclark@example.com", new Date(), "Diabetes", doctor3));
//
//        // Create 3 Pacients without Doctor
//        addPacient(new Pacient("Milan", "Djuric", "milan.seid123@gmail.com", new Date(), "Najjaci lik ikad tebradzouns", null));
//        addPacient(new Pacient("Dave", "Davis", "davedavis@example.com", new Date(), "None", null));
//        addPacient(new Pacient("Eve", "Evans", "eveevans@example.com", new Date(), "None", null));
//        addPacient(new Pacient("Frank", "Franklin", "frankfranklin@example.com", new Date(), "None", null));


//    public static synchronized PacientDao getInstance() {
//        if (instance == null) {
//            instance = new PacientDao();
//        }
//        return instance;
//    }

    public void addPacient(Pacient p) {
        pacients.add(p);
        if (p.getDoctor() != null) {
            doctorDao.incrementNumberOfPacients(p.getDoctor());
        }
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
           if (p.getDoctor() == null) {
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

    public void updatePacient(Pacient p) {
        for (int i = 0; i < pacients.size(); i++) {
            Pacient pacient = pacients.get(i);
            if (pacient.getEmail().equals(p.getEmail())) {
                pacients.set(i, p);
                break;
            }
        }
        p.setEditable(false);
    }


}
