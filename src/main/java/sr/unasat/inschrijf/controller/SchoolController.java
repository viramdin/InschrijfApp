package sr.unasat.inschrijf.controller;

import sr.unasat.inschrijf.config.JPAConfiguration;
import sr.unasat.inschrijf.DAO.SchoolDAO;
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

}
