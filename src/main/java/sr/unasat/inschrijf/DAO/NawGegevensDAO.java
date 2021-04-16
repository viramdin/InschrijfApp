package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.NawGegevens;

import javax.persistence.EntityManager;

public class NawGegevensDAO {
    private EntityManager entityManager;

    public NawGegevensDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public NawGegevens insertGegevens(NawGegevens gegevens) {
        entityManager.getTransaction().begin();
        entityManager.persist(gegevens);
        entityManager.getTransaction().commit();
        return gegevens;
    }
}
