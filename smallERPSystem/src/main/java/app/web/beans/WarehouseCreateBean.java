package app.web.beans;

import app.domain.models.binding.WarehouseBindingModel;
import app.domain.models.service.WarehouseCompanyServiceModel;
import app.domain.models.service.UserServiceModel;
import app.domain.models.service.WarehouseServiceModel;
import app.service.CompanyService;
import app.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class WarehouseCreateBean extends BaseBean {

    private WarehouseBindingModel warehouse;
    private ModelMapper modelMapper;
    private UserService userService;
    private CompanyService companyService;


    public WarehouseCreateBean() {
    }

    @Inject
    public WarehouseCreateBean(ModelMapper modelMapper, UserService userService, CompanyService companyService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.companyService = companyService;
    }

    @PostConstruct
    public void init() {
        this.warehouse = new WarehouseBindingModel();
    }

    public void createWarehouseRedirect() {
        this.redirect("/create-warehouse");
    }

    public void editWarehouseRedirect() {
        this.redirect("/edit-warehouse");
    }

    public void deleteWarehouseRedirect() {
        this.redirect("/delete-warehouse");
    }

    public void createWarehouse() {

        String firstName = String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("firstName"));
        UserServiceModel userServiceModel = userService.findByFirstName(firstName);
        String companyName = userServiceModel.getCompany().getName();
        WarehouseCompanyServiceModel company = this.companyService.findByNameForWarehouse(companyName);

        company.getWarehouses().add(this.modelMapper.map(warehouse, WarehouseServiceModel.class));

        this.companyService.updateWarehouse(company);

        this.redirect("/home");
    }

    public WarehouseBindingModel getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseBindingModel warehouse) {
        this.warehouse = warehouse;
    }
}
