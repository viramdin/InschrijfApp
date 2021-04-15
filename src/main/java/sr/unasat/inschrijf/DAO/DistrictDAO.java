package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.District;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class DistrictDAO {
    private EntityManager entityManager;

    public DistrictDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<District> retrieveDistrictList() {
        List<District> districtList = new ArrayList<>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            String jpql = "select d from district d";
            TypedQuery<District> query = entityManager.createQuery(jpql, District.class);
            districtList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return districtList;
    }
}
