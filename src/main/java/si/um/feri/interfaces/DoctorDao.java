package si.um.feri.interfaces;

import jakarta.ejb.Local;
import si.um.feri.vao.Doctor;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Local
public interface DoctorDao {
    Doctor addDoctor(Doctor d);
    Doctor findDoctor (int id);
    int deleteDoctor(int entityId);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Doctor d);
    void incrementNumberOfPacients(Doctor doctor);
}
