package app.repository;

import app.domain.entities.Warehouse;

public interface WarehouseRepository {

    void save(Warehouse warehouse);

    Warehouse findByName(String name);

    void update(Warehouse warehouse);

    void delete(Warehouse warehouse);
}
