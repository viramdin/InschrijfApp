package sr.unasat.inschrijf.controller;

import sr.unasat.inschrijf.DAO.SchoolDAO;
import sr.unasat.inschrijf.config.JPAConfiguration;
import sr.unasat.inschrijf.entities.School;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("school")
public class SchoolController {
    private SchoolDAO schoolDAO = new SchoolDAO(JPAConfiguration.getEntityManager());

    @Path("/getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<School> retrieveSchoolList() {
        return schoolDAO.retrieveSchoolList();
    }

    @Path("/insert")
    @POST
    public String insertSchool(School school) {
        schoolDAO.insertSchool(school);
        return "School toegevoegd";
    }

    @Path("/update")
    @POST
    public String updateSchool(School schoolNieuw) {
        School school = schoolDAO.findSchoolById(schoolNieuw.getSchoolId());
        school.setNaam(schoolNieuw.getNaam());
        school.setAdres(schoolNieuw.getAdres());
        school.setDistrict(schoolNieuw.getDistrict());
        school.setOmschrijving(schoolNieuw.getOmschrijving());
        school.setSchoolNiveau(schoolNieuw.getSchoolNiveau());
        schoolDAO.updateSchool(school);
        return "School bewerkt";
    }
}
