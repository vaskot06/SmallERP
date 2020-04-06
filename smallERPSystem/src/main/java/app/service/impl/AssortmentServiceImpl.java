package app.service.impl;

import app.domain.entities.Assortment;
import app.domain.entities.Warehouse;
import app.domain.models.service.AssortmentServiceModel;
import app.repository.AssortmentRepository;
import app.service.AssortmentService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class AssortmentServiceImpl implements AssortmentService {

    private final ModelMapper modelMapper;
    private final AssortmentRepository assortmentRepository;

    @Inject
    public AssortmentServiceImpl(ModelMapper modelMapper, AssortmentRepository assortmentRepository) {
        this.modelMapper = modelMapper;
        this.assortmentRepository = assortmentRepository;
    }

    @Override
    public AssortmentServiceModel findByName(String name) {
        return this.modelMapper.map(this.assortmentRepository.findByName(name), AssortmentServiceModel.class);
    }

    @Override
    public void update(AssortmentServiceModel model) {
        this.assortmentRepository.update(this.modelMapper.map(model, Assortment.class));
    }

    @Override
    public void delete(AssortmentServiceModel model) {
        this.assortmentRepository.delete(this.modelMapper.map(model, Assortment.class));
    }
}
