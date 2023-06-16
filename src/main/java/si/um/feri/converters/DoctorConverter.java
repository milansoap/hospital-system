package si.um.feri.converters;


import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;


import si.um.feri.interfaces.DoctorDao;
import si.um.feri.vao.Doctor;
import si.um.feri.mysql.DoctorDAOMySQL;


@FacesConverter(value = "doctorConverter")
public class DoctorConverter extends SelectItemsConverter {


    @EJB
    DoctorDao doctorSql;

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String email) {

            System.out.println("email je tu" + email);

            if (email == null || email.trim().isEmpty()) {
                return null;
            }
            System.out.println("Converter getAsObject called with value: " + email);
            try {
                System.out.println(doctorSql.findDoctorByEmail(email));
                return doctorSql.findDoctorByEmail(email);
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Doctor", email)), e);
            }
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            System.out.println("Converter getAsString called with value: " + value);

            if (value == null || !(value instanceof Doctor)) {
                return null;
            }
            Doctor doctor = (Doctor) value;
            System.out.println("doktor email" + doctor.getEmail());
            return doctor.getEmail();
        }


    }
