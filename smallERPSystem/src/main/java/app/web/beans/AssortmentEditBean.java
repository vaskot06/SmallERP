package app.web.beans;

import app.domain.models.binding.AssortmentBindingModel;
import app.domain.models.service.AssortmentServiceModel;
import app.domain.models.service.UserServiceModel;
import app.domain.models.view.AssortmentViewModel;
import app.service.AssortmentService;
import app.service.CompanyService;
import app.service.UserService;
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
public class AssortmentEditBean extends BaseBean {

    private ModelMapper modelMapper;
    private AssortmentService assortmentService;
    private UserService userService;
    private CompanyService companyService;
    private List<AssortmentViewModel> assortmentViewModel;
    private AssortmentBindingModel assortmentBindingModel;


    public AssortmentEditBean() {
    }

    @Inject
    public AssortmentEditBean(ModelMapper modelMapper, AssortmentService assortmentService, UserService userService, CompanyService companyService) {
        this.modelMapper = modelMapper;
        this.assortmentService = assortmentService;
        this.userService = userService;
        this.companyService = companyService;

    }

    @PostConstruct
    public void init() {
        this.assortmentBindingModel = new AssortmentBindingModel();

        String firstName = String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("firstName"));
        UserServiceModel userServiceModel = userService.findByFirstName(firstName);

        String companyName = userServiceModel.getCompany().getName();

        this.setAssortmentViewModel(companyService.findByName(companyName).getAssortments()
                .stream()
                .map(a -> this.modelMapper.map(a, AssortmentViewModel.class))
                .collect(Collectors.toList()));

    }

    public void editAssortment(String name) {

        AssortmentServiceModel model = assortmentService.findByName(name);

        if (!model.getName().equals(assortmentBindingModel.getName())) {
            model.setName(assortmentBindingModel.getName());
        }

        if (!model.getPrice().equals(assortmentBindingModel.getPrice())){
            model.setPrice(assortmentBindingModel.getPrice());
        }

        if (!model.getState().equals(assortmentBindingModel.getState())) {
            model.setState(assortmentBindingModel.getState());
        }
        this.assortmentService.update(model);

        this.redirect("/home");
    }

    public AssortmentBindingModel getAssortmentBindingModel() {
        return assortmentBindingModel;
    }

    public void setAssortmentBindingModel(AssortmentBindingModel assortmentBindingModel) {
        this.assortmentBindingModel = assortmentBindingModel;
    }

    public List<AssortmentViewModel> getAssortmentViewModel() {
        return assortmentViewModel;
    }

    public void setAssortmentViewModel(List<AssortmentViewModel> assortmentViewModel) {
        this.assortmentViewModel = assortmentViewModel;
    }
}


