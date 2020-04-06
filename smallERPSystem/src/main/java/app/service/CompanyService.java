package app.service;

import app.domain.models.service.AssortmentCompanyServiceModel;
import app.domain.models.service.CompanyServiceModel;
import app.domain.models.service.WarehouseCompanyServiceModel;

public interface CompanyService {

    void save(CompanyServiceModel companyServiceModel);

    CompanyServiceModel findByName(String name);

    WarehouseCompanyServiceModel findByNameForWarehouse(String name);

    AssortmentCompanyServiceModel findByNameForAssortment(String name);

    void updateWarehouse(WarehouseCompanyServiceModel warehouseCompanyServiceModel);

    void updateAssortment(AssortmentCompanyServiceModel assortmentCompanyServiceModel);
}
