package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.SchoolNiveau;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class SchoolNiveauDAO {
    private EntityManager entityManager;

    public SchoolNiveauDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<SchoolNiveau> retrieveNiveauList() {
        List<SchoolNiveau> niveauList = new ArrayList<>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            String jpql = "select s from school_niveau s";
            TypedQuery<SchoolNiveau> query = entityManager.createQuery(jpql, SchoolNiveau.class);
            niveauList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return niveauList;
    }
}
