package si.um.feri.vao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Pacient implements Serializable {

    private String name;
    private String surname;
    private String email;
    private Date dateOfBirth;
    private String characteristics;
    private Doctor doctor;
    private boolean editable;
    private Doctor pickedDoctor;


    public Pacient(String name, String surname, String email, Date dateOfBirth, String characteristics, Doctor doctor) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.characteristics = characteristics;
        this.doctor = doctor;
        this.editable = false;
    }

    public Pacient() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Doctor getPickedDoctor() {
        return pickedDoctor;
    }

    public void setPickedDoctor(Doctor pickedDoctor) {
        this.pickedDoctor = pickedDoctor;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", characteristics='" + characteristics + '\'' +
                ", doctor=" + doctor +
                ", editable=" + editable +
                '}';
    }
}
