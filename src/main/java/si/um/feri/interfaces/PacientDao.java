package si.um.feri.interfaces;

import jakarta.ejb.Local;
import si.um.feri.vao.Pacient;

import java.util.List;

@Local
public interface PacientDao {

    void addPacient(Pacient p);
    Pacient findPacient(String email);
    List<Pacient> pacientsWithoutDoctor();
    List<Pacient> getPacients();
    void setPacients(List<Pacient> pacients);
    void deletePacient(Pacient p);
    void updatePacient(Pacient p);

}
