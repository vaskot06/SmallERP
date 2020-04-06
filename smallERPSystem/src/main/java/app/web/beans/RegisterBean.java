package app.web.beans;

import app.domain.models.binding.CompanyRegisterBinding;
import app.domain.models.binding.UserRegisterBinding;
import app.domain.models.service.UserServiceModel;
import app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends BaseBean {

    private UserRegisterBinding user;
    private UserService userService;
    private CompanyRegisterBinding company;
    private ModelMapper modelMapper;


    public RegisterBean() {
    }

    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.user = new UserRegisterBinding();
        this.company = new CompanyRegisterBinding();
    }

    public void registerUser() {
        if (!this.user.getPassword().equals(this.user.getConfirmPassword())) {
            return;
        }
        this.user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        this.user.setCompany(this.company);
        this.userService.save(this.modelMapper.map(this.user, UserServiceModel.class));


        this.redirect("/login");

    }


    public UserRegisterBinding getUser() {
        return user;
    }

    public void setUser(UserRegisterBinding user) {
        this.user = user;
    }

    public CompanyRegisterBinding getCompany() {
        return company;
    }

    public void setCompany(CompanyRegisterBinding company) {
        this.company = company;
    }
}