package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.NawGegevens;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class NawGegevensDAO {
    private EntityManager entityManager;

    public NawGegevensDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public NawGegevens insertGegevens(NawGegevens gegevens) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(gegevens);
        transaction.commit();
        return gegevens;
    }
}
