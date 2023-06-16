package si.um.feri.converters;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

@FacesConverter(value = "pacientConverter")

public class PacientConverter extends SelectItemsConverter {


    @EJB
    PacientDao pacientSql;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String email) {

        System.out.println("email za pacijenta" + email);

        if (email == null || email.trim().isEmpty()) {
            return null;
        }
        System.out.println("Converter getAsObject called with value: " + email);
        try {
            System.out.println(pacientSql.findPacientByEmail(email));
            return pacientSql.findPacientByEmail(email);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Pacient", email)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Converter getAsString called with value: " + value);

        if (!(value instanceof Pacient)) {
            return null;
        }
        Pacient pacient = (Pacient) value;
        System.out.println("pacijent email"+ pacient.getEmail());
        return pacient.getEmail();
    }


}
