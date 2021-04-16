package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.Inschrijving;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class InschrijvingDAO {
    private EntityManager entityManager;

    public InschrijvingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Inschrijving> retrieveInschrijvingList() {
        entityManager.getTransaction().begin();
        String jpql = "select i from inschrijving i";
        TypedQuery<Inschrijving> query = entityManager.createQuery(jpql, Inschrijving.class);
        List<Inschrijving> inschrijvingList = query.getResultList();
        entityManager.getTransaction().commit();
        return inschrijvingList;
    }

    public Inschrijving findInschrijvingById(long inschrijvingId) {
        entityManager.getTransaction().begin();
        String jpql = "select i from inschrijving i where i.inschrijvingId = :inschrijvingId";
        TypedQuery<Inschrijving> query = entityManager.createQuery(jpql, Inschrijving.class);
        query.setParameter("inschrijvingId", inschrijvingId);
        Inschrijving inschrijving = query.getSingleResult();
        entityManager.getTransaction().commit();
        return inschrijving;
    }

    public Inschrijving insertInschrijving(Inschrijving inschrijving) {
        entityManager.getTransaction().begin();
        entityManager.persist(inschrijving);
        entityManager.getTransaction().commit();
        return inschrijving;
    }

    public void deleteInschrijving(Inschrijving inschrijving) {
        entityManager.getTransaction().begin();
        entityManager.remove(inschrijving);
        entityManager.getTransaction().commit();
    }
}
