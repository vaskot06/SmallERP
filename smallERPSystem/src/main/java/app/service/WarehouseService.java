package app.service;

import app.domain.models.service.WarehouseServiceModel;

public interface WarehouseService {

    void save(WarehouseServiceModel warehouseServiceModel);

    WarehouseServiceModel findByName(String name);

    void update (WarehouseServiceModel warehouseServiceModel);

    void delete(WarehouseServiceModel model);
}
