package si.um.feri.mysql;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.vao.Doctor;
import java.util.List;
@Stateless
public class DoctorDAOMySQL implements DoctorDao {
    @PersistenceContext(unitName = "hospital")
    EntityManager entityManager;

    @Override
    public Doctor addDoctor(Doctor d) {
        entityManager.merge(d);
        return d;
    }

    @Override
    public Doctor findDoctor(int id) {
        return entityManager.find(Doctor.class, id);
    }

    @Override
    public int deleteDoctor(int entityId) {
        Doctor found = entityManager.find(Doctor.class, entityId);
        if (found != null) {
            // Update the doctor_id of all patients associated with the doctor being deleted
            Query query = entityManager.createQuery("UPDATE Pacient p SET p.doctor = null WHERE p.doctor = :doctor");
            query.setParameter("doctor", found);
            query.executeUpdate();
            entityManager.remove(found);
            return found.getId();
        }
        return -1;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        TypedQuery<Doctor> query = entityManager.createQuery("SELECT d FROM Doctor d", Doctor.class);
        List<Doctor> doctors = query.getResultList();
        return doctors;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Doctor foundDoctor = entityManager.find(Doctor.class, doctor.getId());
        foundDoctor.setName(doctor.getName());
        foundDoctor.setSurname(doctor.getSurname());
        foundDoctor.setMaxNumberOfPatients(doctor.getMaxNumberOfPatients());
        foundDoctor.setNumberOfPatients(doctor.getNumberOfPatients());

        entityManager.merge(foundDoctor);
        return doctor;

    }

    @Override
    public Doctor findDoctorByEmail(String email) {
        TypedQuery<Doctor> query = entityManager.createQuery("SELECT d FROM Doctor d WHERE d.email = :email", Doctor.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }


}
