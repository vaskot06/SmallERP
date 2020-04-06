package app.repository.impl;

import app.domain.entities.User;
import app.repository.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public User findByUsernameAndPassword(String firstName, String password) {
        this.entityManager.getTransaction().begin();
        User user = this.entityManager.createQuery(
                "SELECT u FROM User u WHERE u.firstName = :firstName AND u.password = :password", User.class)
                .setParameter("firstName", firstName)
                .setParameter("password", password)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public User findByFirstName(String firstName) {
        this.entityManager.getTransaction().begin();

        User user = this.entityManager.createQuery("SELECT u FROM User u WHERE u.firstName = :firstName", User.class)
                .setParameter("firstName" ,firstName)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public void remove(User user){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(user);
        this.entityManager.getTransaction().commit();
    }
}
