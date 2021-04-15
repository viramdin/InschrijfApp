package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.School;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {
    private EntityManager entityManager;

    public SchoolDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<School> retrieveSchoolList() {
        List<School> schoolList = new ArrayList<>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            String jpql = "select s from school s";
            TypedQuery<School> query = entityManager.createQuery(jpql, School.class);
            schoolList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return schoolList;
    }

    public School findSchoolById(long schoolId) {
        entityManager.getTransaction().begin();
        String jpql = "select s from school s where s.schoolId = :schoolId";
        TypedQuery<School> query = entityManager.createQuery(jpql, School.class);
        query.setParameter("schoolId", schoolId);
        School school = query.getSingleResult();
        entityManager.getTransaction().commit();
        return school;
    }

    public School insertSchool(School school) {
        entityManager.getTransaction().begin();
        entityManager.persist(school);
        entityManager.getTransaction().commit();
        return school;
    }

    public void updateSchool(School school) {
        entityManager.getTransaction().begin();
        entityManager.persist(school);
        entityManager.getTransaction().commit();
    }

    public void deleteSchool(School school) {
        entityManager.getTransaction().begin();
        entityManager.remove(school);
        entityManager.getTransaction().commit();
    }
}
