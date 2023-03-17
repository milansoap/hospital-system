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


@FacesConverter(value = "doctorConverter")
@ApplicationScoped
public class DoctorConverter extends SelectItemsConverter {

    @EJB
    DoctorDao doctorDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }

        try {
            return doctorDao.findDoctor(email);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Doctor", email)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || !(value instanceof Doctor)) {
            return null;
        }
        Doctor doctor = (Doctor) value;
        return doctor.getEmail();
    }


}
