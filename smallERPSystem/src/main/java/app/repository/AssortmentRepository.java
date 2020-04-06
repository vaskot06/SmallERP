package app.repository;

import app.domain.entities.Assortment;

public interface AssortmentRepository {

     Assortment findByName(String name);

    void update(Assortment assortment);

    void delete(Assortment assortment);
}
