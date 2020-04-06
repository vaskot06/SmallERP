package app.repository.impl;

import app.domain.entities.User;
import app.domain.entities.Warehouse;
import app.repository.WarehouseRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class WarehouseRepositoryImpl implements WarehouseRepository {

    private final EntityManager entityManager;

    @Inject
    public WarehouseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Warehouse warehouse) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(warehouse);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Warehouse findByName(String name) {
        this.entityManager.getTransaction().begin();

        Warehouse warehouse = this.entityManager.createQuery("SELECT w FROM Warehouse w WHERE w.name = :name", Warehouse.class)
                .setParameter("name" ,name)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return warehouse;
    }

    @Override
    public void update(Warehouse warehouse) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(warehouse);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Warehouse warehouse) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(entityManager.contains(warehouse) ? warehouse : entityManager.merge(warehouse));
        this.entityManager.getTransaction().commit();
    }
}
