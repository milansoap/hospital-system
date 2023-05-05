package si.um.feri.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.vao.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoBean {


    private List<Doctor> doctors = new ArrayList<>();

    public Doctor addDoctor(Doctor d) {
        doctors.add(d);
        return d;
    }

    public Doctor findDoctor(String email) {
        for (Doctor d : doctors) {
            if (d.getEmail().equals(email)) {
                return d;
            }
        }
        return null;
    }

    public int deleteDoctor(int entityId) {
        return 0;
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor updateDoctor(Doctor d) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getEmail().equals(d.getEmail())) {
                doctors.set(i, d);
                break;
            }
        }
        return d;
    }

    public void incrementNumberOfPacients(Doctor doctor) {
        doctor.setNumberOfPatients(doctor.getNumberOfPatients()+1);
    }

}
