package si.um.feri.mysql;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import java.util.List;


@Stateless
public class PacientDAOMySQL implements PacientDao {

    @PersistenceContext(unitName = "hospital")
    EntityManager entityManager;

    @Override
    public Pacient addPacient(Pacient p) {
        entityManager.merge(p);
        return p;
    }


    @Override
    public Pacient findPacient(int id) {
        return entityManager.find(Pacient.class,id);
    }

    @Override
    public List<Pacient> pacientsWithoutDoctor() {
        return null;
    }

    @Override
    public List<Pacient> getPacients() {
        TypedQuery<Pacient> query = entityManager.createQuery("SELECT p FROM Pacient p", Pacient.class);
        return query.getResultList();
    }

    @Override
    public int deletePacient(int entityId) {
        Pacient found = entityManager.find(Pacient.class, entityId);
        if (found != null) {
            entityManager.remove(found);
            return found.getId();
        }
        return -1;
    }

    @Override
    public Pacient updatePacient(Pacient pacient) {
        Pacient foundPacient = entityManager.find(Pacient.class, pacient.getId());
        foundPacient.setName(pacient.getName());
        foundPacient.setSurname(pacient.getSurname());
        foundPacient.setCharacteristics(pacient.getCharacteristics());
        entityManager.merge(foundPacient);
        return pacient;
    }
}
