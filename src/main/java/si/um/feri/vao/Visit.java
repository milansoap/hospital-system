package si.um.feri.vao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "visits")
public class Visit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NotNull
    String pacientEmail;
    @NotNull
    String doctorEmail;
    @NotNull
    String date;
    String notes;
    String medications;

    public Visit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPacientEmail() {
        return pacientEmail;
    }

    public void setPacientEmail(String pacientEmail) {
        this.pacientEmail = pacientEmail;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", pacientEmail='" + pacientEmail + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", date='" + date + '\'' +
                ", notes='" + notes + '\'' +
                ", medications='" + medications + '\'' +
                '}';
    }
}
