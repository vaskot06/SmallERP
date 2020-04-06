package app.repository.impl;

import app.domain.entities.Assortment;
import app.repository.AssortmentRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AssortmentRepositoryImpl implements AssortmentRepository {

    private final EntityManager entityManager;

    @Inject
    public AssortmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Assortment findByName(String name) {

            this.entityManager.getTransaction().begin();
            Assortment assortment = this.entityManager.createQuery("SELECT a FROM Assortment a WHERE a.name = :name", Assortment.class)
                    .setParameter("name" ,name)
                    .getSingleResult();

            this.entityManager.getTransaction().commit();
            return assortment;
    }

    @Override
    public void update(Assortment assortment) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(assortment);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Assortment assortment) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(entityManager.contains(assortment) ? assortment : entityManager.merge(assortment));
        this.entityManager.getTransaction().commit();
    }
}
