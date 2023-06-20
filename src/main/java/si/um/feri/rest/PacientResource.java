package si.um.feri.rest;


import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import java.util.List;

@Path("/pacients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacientResource {

    @EJB
    DoctorDao doctorService;
    @EJB
    PacientDao pacientService;

    @GET
    @Path("/all")
    public List<Pacient> getAll() {
        return pacientService.getPacients();
    }
    @GET
    @Path("/{id}")
    public Pacient find(@PathParam("id") int id) {
        return pacientService.findPacient(id);
    }

}
