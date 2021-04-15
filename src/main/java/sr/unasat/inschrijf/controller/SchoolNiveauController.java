package sr.unasat.inschrijf.controller;

import sr.unasat.inschrijf.DAO.SchoolNiveauDAO;
import sr.unasat.inschrijf.config.JPAConfiguration;
import sr.unasat.inschrijf.entities.SchoolNiveau;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("niveau")
public class SchoolNiveauController {
    private SchoolNiveauDAO niveauDAO = new SchoolNiveauDAO(JPAConfiguration.getEntityManager());

    @Path("/getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SchoolNiveau> retrieveNiveauList() {
        return niveauDAO.retrieveNiveauList();
    }

}
