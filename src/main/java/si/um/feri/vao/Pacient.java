package si.um.feri.vao;

import jakarta.mail.MessagingException;
import si.um.feri.observers.IObservable;
import si.um.feri.observers.IObserver;
import si.um.feri.observers.pacientObservables.concreteObservers.DoctorAssigmentObserver;
import si.um.feri.observers.pacientObservables.concreteObservers.DoctorChangeObserver;

import javax.naming.NamingException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Pacient implements Serializable, IObservable {

    private List<IObserver> observers = new ArrayList<>();
    private String name;
    private String surname;
    private String email;
    private Date dateOfBirth;
    private String characteristics;
    private Doctor doctor;
    private boolean editable;
    private Doctor pickedDoctor;


    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws MessagingException, NamingException {
        for(IObserver observer : this.observers) {
            observer.update();
        }
    }


    public Pacient(String name, String surname, String email, Date dateOfBirth, String characteristics, Doctor doctor) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.characteristics = characteristics;
        this.doctor = doctor;
        this.editable = false;
        new DoctorAssigmentObserver(this);
        new DoctorChangeObserver(this);
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
//        System.out.println(doctor);
//        if (doctor == null) {
//            this.doctor = doctor;
//            observable.notifyObservers(this,"removal");
//
//        }
//        else if (doctor != null) {
//            this.doctor = doctor;
//            observable.notifyObservers(this,"assignment");
//        }

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
