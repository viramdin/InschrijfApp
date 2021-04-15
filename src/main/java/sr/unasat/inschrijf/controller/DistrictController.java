package sr.unasat.inschrijf.controller;

import sr.unasat.inschrijf.DAO.DistrictDAO;
import sr.unasat.inschrijf.config.JPAConfiguration;
import sr.unasat.inschrijf.entities.District;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("district")
public class DistrictController {
    private DistrictDAO distriktDAO = new DistrictDAO(JPAConfiguration.getEntityManager());

    @Path("/getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<District> retrieveDistrictList() {
        return distriktDAO.retrieveDistrictList();
    }

}
