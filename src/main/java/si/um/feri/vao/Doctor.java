package si.um.feri.vao;

public class Doctor {

    private String name;
    private String surname;
    private String email;
    private int numberOfPatients;
    private int maxNumberOfPatients;
    private boolean editable;

    public Doctor(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.numberOfPatients = 0;
        this.editable = false;
        this.maxNumberOfPatients = 1;
    }

    public Doctor() {
    }

    public Doctor(String test) {
        this.name = test;
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

    public boolean isEditable() {
        return editable;
    }
    public void setEditable(boolean editable) {
        this.editable = editable;
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
