package si.um.feri.vao;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

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

    @Column(name = "number_of_pacients")
    private int numberOfPatients;

    @Column(name = "max_number_of_pacients")
    private int maxNumberOfPatients;

    public Doctor(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.numberOfPatients = 0;
        this.maxNumberOfPatients = 1;
    }

    public Doctor() {
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

    public int getNumberOfPatients() {
        return numberOfPatients;
    }
    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public int getMaxNumberOfPatients() {
        return maxNumberOfPatients;
    }

    public void setMaxNumberOfPatients(int maxNumberOfPatients) {
        this.maxNumberOfPatients = maxNumberOfPatients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", numberOfPatients=" + numberOfPatients +
                '}';
    }
}
