package si.um.feri.vao;

import jakarta.mail.MessagingException;
import jakarta.persistence.*;
import si.um.feri.observers.IObservable;
import si.um.feri.observers.entities.PacientChangeObserver;
import si.um.feri.observers.pacientObservables.concreteObservers.DoctorAssigmentObserver;
import si.um.feri.observers.pacientObservables.concreteObservers.DoctorChangeObserver;

import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "pacients")
public class Pacient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")

    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")

    private Date dateOfBirth;
    @Column(name = "characteristics")
    private String characteristics;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private boolean editable;
//    private Doctor pickedDoctor;
    //    @Transient
//    transient public PacientChangeObserver observerEntity;
//    @Transient
//    transient private DoctorChangeObserver patientObserver;


    public Pacient(String name, String surname, String email, Date dateOfBirth, String characteristics, Doctor doctor) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.characteristics = characteristics;
        this.doctor = doctor;
        this.editable = false;
//        this.observerEntity = new PacientChangeObserver();
//        this.patientObserver = new DoctorChangeObserver(this.patientObserver)
        new DoctorAssigmentObserver(this);
//        new DoctorChangeObserver(this);
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

    public void setDoctor(Doctor doctor) throws MessagingException, NamingException {
        this.doctor = doctor;
//        notifyObservers();
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

//    public Doctor getPickedDoctor() {
//        return pickedDoctor;
//    }
//
//    public void setPickedDoctor(Doctor pickedDoctor) {
//        this.pickedDoctor = pickedDoctor;
//    }

    public int getId() {
        return id;
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
