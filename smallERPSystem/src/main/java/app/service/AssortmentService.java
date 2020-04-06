package app.service;

import app.domain.models.service.AssortmentServiceModel;

public interface AssortmentService {
    AssortmentServiceModel findByName(String name);

    void update(AssortmentServiceModel model);

    void delete(AssortmentServiceModel model);
}
