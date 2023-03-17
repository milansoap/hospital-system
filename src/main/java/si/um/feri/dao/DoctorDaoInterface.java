package si.um.feri.dao;

import jakarta.ejb.Local;
import si.um.feri.vao.Doctor;

import java.util.ArrayList;
import java.util.List;


@Local
public interface DoctorDaoInterface {

    List<Doctor> doctors = new ArrayList<>();

    void addDoctor(Doctor d);
    Doctor findDoctor (String email);
    void deleteDoctor (Doctor d);
    List<Doctor> getAllDoctors();
    void updateDoctor(Doctor d);
    void incrementNumberOfPacients(Doctor doctor);
}
