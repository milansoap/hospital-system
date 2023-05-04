package si.um.feri.mysql;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import java.util.List;


@Stateless
public class PacientDAOMySQL implements PacientDao {

    @PersistenceContext(unitName = "hospital")
    EntityManager entityManager;

    @Override
    public Pacient addPacient(Pacient p, Doctor d) {
        entityManager.getTransaction().begin();
//        p.setDoctorId(d.getId()); //
        entityManager.persist(p); // Persist the Pacient object
        entityManager.getTransaction().commit();
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
    public void setPacients(List<Pacient> pacients) {

    }

    @Override
    public void deletePacient(Pacient p) {

    }

    @Override
    public void deletePacient(int entityId) {
        Pacient found = entityManager.find(Pacient.class, entityId);
        if (found == null) {
            return;
        }
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(found);
            entityManager.getTransaction().commit();
            return;
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public Pacient updatePacient(Pacient entity) {
        Pacient found = entityManager.find(Pacient.class, entity.getId());
        if (found == null) {
            return null;
        }
        try {
            found.setName(entity.getName());
            found.setSurname(entity.getSurname());
            found.setCharacteristics(entity.getCharacteristics());
            found.setDateOfBirth(entity.getDateOfBirth());
            found.setEmail(entity.getEmail());
            found.setDoctor(entity.getDoctor());
            entityManager.getTransaction().begin();
            entityManager.merge(found);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return null;
        }
        return entity;
    }
}
