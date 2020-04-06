package app.web.beans;

import app.domain.models.service.UserServiceModel;
import app.domain.models.service.WarehouseServiceModel;
import app.domain.models.view.WarehouseViewModel;
import app.service.CompanyService;
import app.service.UserService;
import app.service.WarehouseService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class WarehouseDeleteBean extends BaseBean {

    private ModelMapper modelMapper;
    private WarehouseService warehouseService;
    private UserService userService;
    private CompanyService companyService;
    private List<WarehouseViewModel> warehouseViewModel;


    public WarehouseDeleteBean() {
    }

    @Inject
    public WarehouseDeleteBean(ModelMapper modelMapper, WarehouseService warehouseService, UserService userService, CompanyService companyService) {
        this.modelMapper = modelMapper;
        this.warehouseService = warehouseService;
        this.userService = userService;
        this.companyService = companyService;

    }

    @PostConstruct
    public void init() {

        String firstName = String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("firstName"));
        UserServiceModel userServiceModel = userService.findByFirstName(firstName);

        String companyName = userServiceModel.getCompany().getName();

        this.setWarehouseViewModel(companyService.findByName(companyName).getWarehouses()
                .stream()
                .map(w -> this.modelMapper.map(w, WarehouseViewModel.class))
                .collect(Collectors.toList()));

    }

    public void deleteWarehouse(String name) {


        WarehouseServiceModel model = warehouseService.findByName(name);

        this.warehouseService.delete(model);

        this.redirect("/home");
    }

    public List<WarehouseViewModel> getWarehouseViewModel() {
        return warehouseViewModel;
    }

    public void setWarehouseViewModel(List<WarehouseViewModel> warehouseViewModel) {
        this.warehouseViewModel = warehouseViewModel;
    }
}


