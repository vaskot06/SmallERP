package app.service.impl;

import app.domain.entities.Company;
import app.domain.models.service.AssortmentCompanyServiceModel;
import app.domain.models.service.CompanyServiceModel;
import app.domain.models.service.WarehouseCompanyServiceModel;
import app.repository.CompanyRepository;
import app.service.CompanyService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;


    @Inject
    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(CompanyServiceModel companyServiceModel) {
        this.companyRepository.save(this.modelMapper.map(companyServiceModel, Company.class));
    }

    @Override
    public CompanyServiceModel findByName(String name) {
        return this.modelMapper.map(this.companyRepository.findByName(name), CompanyServiceModel.class);
    }

    @Override
    public WarehouseCompanyServiceModel findByNameForWarehouse(String name) {
        return this.modelMapper.map(this.companyRepository.findByName(name), WarehouseCompanyServiceModel.class);
    }


    @Override
    public AssortmentCompanyServiceModel findByNameForAssortment(String name) {
        return this.modelMapper.map(this.companyRepository.findByName(name), AssortmentCompanyServiceModel.class);
    }

    @Override
    public void updateWarehouse(WarehouseCompanyServiceModel warehouseCompanyServiceModel) {
        companyRepository.update(this.modelMapper.map(warehouseCompanyServiceModel, Company.class));
    }

    @Override
    public void updateAssortment(AssortmentCompanyServiceModel assortmentCompanyServiceModel) {
        companyRepository.update(this.modelMapper.map(assortmentCompanyServiceModel, Company.class));
    }

}
