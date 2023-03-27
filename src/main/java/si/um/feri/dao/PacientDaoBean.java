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
