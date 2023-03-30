package si.um.feri.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.vao.Doctor;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local(DoctorDao.class)
public class DoctorDaoBean implements DoctorDao {

    private List<Doctor> doctors = new ArrayList<>();

    @Override
    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    @Override
    public Doctor findDoctor(String email) {
        for (Doctor d : doctors) {
            if (d.getEmail().equals(email)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public void deleteDoctor (Doctor d) {
        doctors.remove(d);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @Override
    public void updateDoctor(Doctor d) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getEmail().equals(d.getEmail())) {
                doctors.set(i, d);
                break;
            }
        }
        d.setEditable(false);
    }

    @Override
    public void incrementNumberOfPacients(Doctor doctor) {
        doctor.setNumberOfPatients(doctor.getNumberOfPatients()+1);
    }

}
