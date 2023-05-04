package si.um.feri.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.mail.MessagingException;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.mailSender.MailSender;
import si.um.feri.mysql.DoctorDAOMySQL;
import si.um.feri.mysql.PacientDAOMySQL;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named("app")
@SessionScoped
public class app implements Serializable {

    private MailSender emailSender = new MailSender();
    @EJB
    DoctorDao doctorSql;
    @EJB
    PacientDao pacientSql;
    private boolean showPatientForm = false;
    private boolean showDoctorForm = true;
    private Doctor selectedDoctor;
    private Pacient insertedPacient = new Pacient();
    private Doctor insertedDoctor = new Doctor();
    private Doctor editedDoctor = new Doctor();

    public Doctor getEditedDoctor() {
        return editedDoctor;
    }

    public void setEditedDoctor(int id) {
        System.out.println("ovde sam doktor je " + editedDoctor);
        this.editedDoctor = doctorSql.findDoctor(id);
        System.out.println("ovde sam doktor je " + editedDoctor);
    }
    List<Pacient> pacients;

    public boolean isShowPatientForm() {
        return showPatientForm;
    }

    public void setShowPatientForm(boolean showPatientForm) {
        this.showPatientForm = showPatientForm;
    }

    public boolean isShowDoctorForm() {
        return showDoctorForm;
    }

    public void setShowDoctorForm(boolean showDoctorForm) {
        this.showDoctorForm = showDoctorForm;
    }

    public void addPacient(Doctor d) {
        pacientSql.addPacient(insertedPacient, d);
        insertedPacient = new Pacient();
    }

    public List<Pacient> getWithoutDoctor() {
        return pacientSql.pacientsWithoutDoctor();
    }

    public void addDoctor() {
        doctorSql.addDoctor(insertedDoctor);
        insertedDoctor = new Doctor();
        System.out.println(doctorSql.getAllDoctors());
    }

    public List<Doctor> getAllDoctors() {
        return doctorSql.getAllDoctors();
    }

    public List<Pacient> getAllPacients() {
        return pacientSql.getPacients();
    }

    public Doctor getInsertedDoctor() {
        return insertedDoctor;
    }

    public Pacient getInsertedPacient() {
        return insertedPacient;
    }

    public void setInsertedDoctor(Doctor insertedDoctor) {
        this.insertedDoctor = insertedDoctor;
    }

    public Doctor getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(Doctor selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    public void clearForm(boolean isDoctorForm) {
        if (isDoctorForm) {
            insertedDoctor = new Doctor(); // clear the Doctor form data
        } else {
            insertedPacient = new Pacient(); // clear the Pacient form data
            selectedDoctor = null; // clear the selected doctor
        }
    }

    public void switchMode() {
        clearForm(showDoctorForm); // clear the form data for the current form
        showDoctorForm = !showDoctorForm; // toggle the form mode
        showPatientForm = !showPatientForm;
    }


    public void deleteDoctor(int id) {
        doctorSql.deleteDoctor(id);
    }

    public void deletePacient(Pacient p) {
        doctorSql.deleteDoctor(p.getId());
    }

    public void enableEditing(Doctor doctor) {
        doctor.setEditable(true);
        doctorSql.updateDoctor(doctor); // update the doctor in the database
    }

    public void saveEditing(Doctor d) {
        doctorSql.updateDoctor(d);
    }

    public void enableEditingPacient(Pacient p) {
        p.setEditable(true);
    }

    public void saveEditingPacient(Pacient p) {
        pacientSql.updatePacient(p);
    }


    public int getNum(Doctor d) {
        int count = 0;
//        for (Pacient p : pacients) {
//            if (p.getDoctor() == d) {
//                count++;
//            }
//        }
        return 2;
    }

    public void updateSelectedDoctor() throws MessagingException, NamingException {
        System.out.println("Selected doctor is now " + this.selectedDoctor);
        insertedPacient.setDoctor(this.selectedDoctor);
    }


//    public void sendEmail(Doctor pickedDoctor, Pacient p) throws MessagingException, NamingException {
//        pickDoctor.sendEmail(pickedDoctor,p);
//        // klicemo iz ejba @EJB pickDOctor EmailSender
//    }

    public void sendEmail(Pacient p, String message) throws MessagingException, NamingException {
        emailSender.sendEmail(p,message);
    }

    public void setDoctor(Pacient pacient,Doctor doctor) throws MessagingException, NamingException {
        pacient.setDoctor(doctor);
//        pacient.notifyObservers();
    }





}

