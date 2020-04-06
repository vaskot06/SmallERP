package app.service.impl;

import app.domain.entities.Warehouse;
import app.domain.models.service.WarehouseServiceModel;
import app.repository.WarehouseRepository;
import app.service.WarehouseService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;

    @Inject
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(WarehouseServiceModel warehouseServiceModel) {
        this.warehouseRepository.save(this.modelMapper.map(warehouseServiceModel, Warehouse.class));
    }

    @Override
    public WarehouseServiceModel findByName(String name) {
        return this.modelMapper.map(this.warehouseRepository.findByName(name), WarehouseServiceModel.class);
    }

    @Override
    public void update(WarehouseServiceModel warehouseServiceModel) {
        this.warehouseRepository.update(this.modelMapper.map(warehouseServiceModel, Warehouse.class));
    }

    @Override
    public void delete(WarehouseServiceModel model) {
        this.warehouseRepository.delete(this.modelMapper.map(model, Warehouse.class));
    }
}
