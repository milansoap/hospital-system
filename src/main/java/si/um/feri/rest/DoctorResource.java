package si.um.feri.rest;


import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import si.um.feri.interfaces.DoctorDao;
import si.um.feri.interfaces.PacientDao;
import si.um.feri.vao.Doctor;

import java.util.ArrayList;
import java.util.List;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {

    @EJB
    DoctorDao doctorService;
    @EJB
    PacientDao pacientService;

    @GET
    @Path("/all")
    public List<Doctor> getAll() {
        return doctorService.getAllDoctors();
    }

    @GET
    @Path("/{id}")
    public Doctor find(@PathParam("id") int id) {
        return doctorService.findDoctor(id);
    }



//    @POST
//    @Path("/addPatient")
//    public DoctorJSONDto addPacientToDoctor(AddPatientReqDto reqDto) {
//
//    }
//
//    @POST
//    @Path("/removePatient")
//    public DoctorJSONDto removePatient(AddPatientReqDto reqDto) {
//        Patient patient = patientService.find(reqDto.getPatientId());
//        Doctor doctor = doctorService.find(reqDto.getDoctorId());
//        if (patient == null || doctor == null) {
//            return null;
//        } else {
//            doctorService.removePatient(doctor.getId(), patient.getId());
//            return DoctorJSONDto.to(doctor);
//        }
//    }

//    @GET
//    @Path("{id}/patients")
//    public List<DoctorsPatientJSONDto> getPatients(@PathParam("id") int doctorId) {
//        Doctor doctor = doctorService.find(doctorId);
//        if (doctor == null) {
//            return null;
//        } else {
//            return DoctorJSONDto.to(doctor).getPatients();
//        }
//    }
}
