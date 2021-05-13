package sr.unasat.inschrijf.DAO;

import sr.unasat.inschrijf.entities.School;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {
    private EntityManager entityManager;
    private SchoolNiveauDAO niveauDAO;

    public SchoolDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        niveauDAO = new SchoolNiveauDAO(entityManager);
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
        EntityTransaction transaction = entityManager.getTransaction();
        School school = new School();
        try {
            transaction.begin();
            String jpql = "select s from school s where s.schoolId = :schoolId";
            TypedQuery<School> query = entityManager.createQuery(jpql, School.class);
            query.setParameter("schoolId", schoolId);
            school = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return school;
    }

    public void insertSchool(School school) {
        school.setSchoolNiveau(niveauDAO.findSchoolNiveauById(school.getSchoolNiveau().getNiveauId()));
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(school);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void updateSchool(School school) {
        school.setSchoolNiveau(niveauDAO.findSchoolNiveauById(school.getSchoolNiveau().getNiveauId()));
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(school);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
