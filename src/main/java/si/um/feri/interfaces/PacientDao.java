package si.um.feri.interfaces;

import jakarta.ejb.Local;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import java.util.List;

@Local
public interface PacientDao {

    Pacient addPacient(Pacient p, Doctor d);
    Pacient findPacient(int id);
    List<Pacient> pacientsWithoutDoctor();
    List<Pacient> getPacients();
    void setPacients(List<Pacient> pacients);
    void deletePacient(Pacient p);

    void deletePacient(int entityId);

    Pacient updatePacient(Pacient p);

}
