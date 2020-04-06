package app.web.beans;

import app.domain.models.binding.AssortmentBindingModel;
import app.domain.models.service.*;
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
public class AssortmentCreateBean extends BaseBean {

    private AssortmentBindingModel assortment;
    private ModelMapper modelMapper;
    private UserService userService;
    private CompanyService companyService;


    public AssortmentCreateBean() {
    }

    @Inject
    public AssortmentCreateBean(ModelMapper modelMapper, UserService userService, CompanyService companyService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.companyService = companyService;
    }

    @PostConstruct
    public void init() {
        this.assortment = new AssortmentBindingModel();
    }

    public void createAssortmentRedirect() {
        this.redirect("/create-assortment");
    }

    public void editAssortmentRedirect() {
        this.redirect("/edit-assortment");
    }

    public void deleteAssortmentRedirect() {
        this.redirect("/delete-assortment");
    }

    public void createAssortment() {

        String firstName = String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("firstName"));
        UserServiceModel userServiceModel = userService.findByFirstName(firstName);
        String companyName = userServiceModel.getCompany().getName();
        AssortmentCompanyServiceModel company = this.companyService.findByNameForAssortment(companyName);

        company.getAssortments().add(this.modelMapper.map(assortment, AssortmentServiceModel.class));

        this.companyService.updateAssortment(company);

        this.redirect("/home");
    }

    public AssortmentBindingModel getAssortment() {
        return assortment;
    }

    public void setAssortment(AssortmentBindingModel assortment) {
        this.assortment = assortment;
    }
}
