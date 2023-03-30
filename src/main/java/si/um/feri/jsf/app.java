package si.um.feri.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.mail.MessagingException;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.mailSender.MailSender;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named("app")
@SessionScoped
public class app implements Serializable {


    @EJB
    DoctorDao doctorDao;
    @EJB
    PacientDao pacientDao;
    private MailSender emailSender = new MailSender();


    private boolean showPatientForm = false;
    private boolean showDoctorForm = true;
    private Doctor selectedDoctor;
    private Pacient insertedPacient = new Pacient();
    private Doctor insertedDoctor = new Doctor();
    List<Pacient> pacients;


    @PostConstruct
    public void initializeTestData() {

        Doctor doctor1 = new Doctor("John", "Doe", "johndoe@example.com");
        Doctor doctor2 = new Doctor("Jane", "Doe", "janedoe@example.com");
        Doctor doctor3 = new Doctor("Bob", "Smith", "bobsmith@example.com");
        Doctor doctor4 = new Doctor("Alice", "Jones", "alicejones@example.com");
        Doctor doctor5 = new Doctor("Tom", "Wilson", "tomwilson@example.com");

        doctorDao.addDoctor(doctor1);
        doctorDao.addDoctor(doctor2);
        doctorDao.addDoctor(doctor3);
        doctorDao.addDoctor(doctor4);
        doctorDao.addDoctor(doctor5);

        pacientDao.addPacient(new Pacient("Alice", "Adams", "aliceadams@example.com", new Date(), "High blood pressure", doctor1));
        pacientDao.addPacient(new Pacient("Bob", "Baker", "bobbaker@example.com", new Date(), "Asthma", doctor2));
        pacientDao.addPacient(new Pacient("Charlie", "Clark", "charlieclark@example.com", new Date(), "Diabetes", doctor3));

        // Create 3 Pacients without Doctor
        pacientDao.addPacient(new Pacient("Milan", "Djuric", "milan.seid123@gmail.com", new Date(), "Najjaci lik ikad tebradzouns", null));
        pacientDao.addPacient(new Pacient("Dave", "Davis", "davedavis@example.com", new Date(), "None", null));
        pacientDao.addPacient(new Pacient("Eve", "Evans", "eveevans@example.com", new Date(), "None", null));
        pacientDao.addPacient(new Pacient("Frank", "Franklin", "frankfranklin@example.com", new Date(), "None", null));

        this.pacients = pacientDao.getPacients();


    }


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

    public void addPacient() {
        System.out.println(insertedPacient);
        pacientDao.addPacient(insertedPacient);
        insertedPacient = new Pacient();

    }

    public List<Pacient> getWithoutDoctor() {
        return pacientDao.pacientsWithoutDoctor();
    }

    public void addDoctor() {
        doctorDao.addDoctor(insertedDoctor);
        insertedDoctor = new Doctor();
        System.out.println(doctorDao.getAllDoctors());
    }

    public List<Doctor> getAllDoctors() {
        return doctorDao.getAllDoctors();
    }

    public List<Pacient> getAllPacients() {
        this.pacients = pacientDao.getPacients();
        return pacientDao.getPacients();
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

    public void deleteDoctor(Doctor d) {
        doctorDao.deleteDoctor(d);
    }

    public void deletePacient(Pacient p) {
        pacientDao.deletePacient(p);
    }

    public void enableEditing(Doctor d) {
        d.setEditable(true);
    }

    public void saveEditing(Doctor d) {
        doctorDao.updateDoctor(d);
    }

    public void enableEditingPacient(Pacient p) {
        p.setEditable(true);
    }

    public void saveEditingPacient(Pacient p) {
        pacientDao.updatePacient(p);
    }


    public int getNum(Doctor d) {
        int count = 0;
        for (Pacient p : pacients) {
            if (p.getDoctor() == d) {
                count++;
            }
        }
        return count;
    }

    public void updateSelectedDoctor() {
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
        pacient.notifyObservers();
    }





}

