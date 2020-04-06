package app.repository.impl;

import app.domain.entities.Company;
import app.domain.entities.User;
import app.repository.CompanyRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CompanyRepositoryImpl implements CompanyRepository {

    private final EntityManager entityManager;

    @Inject
    public CompanyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Company company) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(company);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Company findByName(String name) {
        this.entityManager.getTransaction().begin();

        Company company = this.entityManager.createQuery("SELECT c FROM Company c WHERE c.name = :name", Company.class)
                .setParameter("name", name)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return company;

    }

    @Override
    public void update(Company company) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(company);
        this.entityManager.getTransaction().commit();
    }
}
