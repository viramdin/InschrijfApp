package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.Inschrijving;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class InschrijvingDAO {
    private EntityManager entityManager;

    public InschrijvingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Inschrijving> retrieveInschrijvingList() {
        List<Inschrijving> inschrijvingList = new ArrayList<>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            String jpql = "select i from inschrijving i";
            TypedQuery<Inschrijving> query = entityManager.createQuery(jpql, Inschrijving.class);
            inschrijvingList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
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

    public void insertInschrijving(Inschrijving inschrijving) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(inschrijving);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void deleteInschrijving(Inschrijving inschrijving) {
        entityManager.getTransaction().begin();
        entityManager.remove(inschrijving);
        entityManager.getTransaction().commit();
    }
}
