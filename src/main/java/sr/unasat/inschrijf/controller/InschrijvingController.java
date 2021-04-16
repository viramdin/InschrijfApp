package sr.unasat.inschrijf.controller;

import sr.unasat.inschrijf.DAO.InschrijvingDAO;
import sr.unasat.inschrijf.DAO.NawGegevensDAO;
import sr.unasat.inschrijf.DAO.SchoolDAO;
import sr.unasat.inschrijf.DTO.InschrijvingDTO;
import sr.unasat.inschrijf.betalingMethodes.Betaling;
import sr.unasat.inschrijf.betalingMethodes.Crypto;
import sr.unasat.inschrijf.betalingMethodes.HOP;
import sr.unasat.inschrijf.betalingMethodes.Uni5Pay;
import sr.unasat.inschrijf.builder.InschrijvingBuilder;
import sr.unasat.inschrijf.config.JPAConfiguration;
import sr.unasat.inschrijf.entities.Inschrijving;
import sr.unasat.inschrijf.entities.Kosten;
import sr.unasat.inschrijf.entities.NawGegevens;
import sr.unasat.inschrijf.entities.School;
import sr.unasat.inschrijf.kosten.BoekKosten;
import sr.unasat.inschrijf.kosten.BusKosten;
import sr.unasat.inschrijf.kosten.StandaardKosten;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("inschrijving")
public class InschrijvingController {
    private InschrijvingDAO inschrijvingDAO = new InschrijvingDAO(JPAConfiguration.getEntityManager());
    private NawGegevensDAO nawGegevensDAO = new NawGegevensDAO(JPAConfiguration.getEntityManager());
    private SchoolDAO schoolDAO = new SchoolDAO(JPAConfiguration.getEntityManager());

    @Path("/getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inschrijving> retrieveInschrijvingList() {
        return inschrijvingDAO.retrieveInschrijvingList();
    }

    @Path("/insert")
    @POST
    public String insertInschrijving(InschrijvingDTO inschrijvingDTO) {
        inschrijvingDTO.setCreatedDate(LocalDate.now());

        NawGegevens gegevensNew = nawGegevensDAO.insertGegevens(inschrijvingDTO.getGegevens());
        School schoolNew = schoolDAO.findSchoolById(inschrijvingDTO.getSchoolId());

        Inschrijving inschrijvingNew = new InschrijvingBuilder(gegevensNew, schoolNew, LocalDate.now()).build();

        List<Kosten> kostenList = new ArrayList<>();

//  Decorator
        sr.unasat.inschrijf.kosten.Kosten standaardKosten = new StandaardKosten();
        switch (inschrijvingDTO.getKosten()) {
            case 1:
                standaardKosten = new BoekKosten(standaardKosten);
                break;
            case 2:
                standaardKosten = new BusKosten(standaardKosten);
                break;
            case 3:
                standaardKosten = new BoekKosten(new BusKosten(standaardKosten));
                break;
            default:
        }
        String kostenMelding = "Totale Kosten: " + standaardKosten.getPrijs();

//  Template
        Betaling betaling = null;
        if (inschrijvingDTO.getBetalingMethode() == 1) {
            betaling = new Crypto();
        } else if (inschrijvingDTO.getBetalingMethode() == 2) {
            betaling = new HOP();
        } else if (inschrijvingDTO.getBetalingMethode() == 2) {
            betaling = new Uni5Pay();
        }
        inschrijvingDAO.insertInschrijving(inschrijvingNew);

        return kostenMelding + "\n" + "Inschrijving toegevoegd";
    }

    @Path("/delete")
    @DELETE
    public String deleteInschrijving(long id) {
        Inschrijving inschrijving = inschrijvingDAO.findInschrijvingById(id);
        inschrijvingDAO.deleteInschrijving(inschrijving);
        return "Succesvol verwijderd!";
    }
}
