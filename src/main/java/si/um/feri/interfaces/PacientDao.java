package si.um.feri.interfaces;

import jakarta.ejb.Local;
import si.um.feri.vao.Pacient;

import java.util.List;

@Local
public interface PacientDao {

    Pacient addPacient(Pacient p);
    Pacient findPacient(int id);
    List<Pacient> pacientsWithoutDoctor();
    List<Pacient> getPacients();
    int deletePacient(int entityId);
    Pacient updatePacient(Pacient p);

}
