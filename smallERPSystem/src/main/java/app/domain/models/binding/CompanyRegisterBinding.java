package app.domain.models.binding;

public class CompanyRegisterBinding {

    private String id;
    private String name;
    private String eik;
    private Boolean registeredVAT;
    private String country;
    private UserRegisterBinding user;

    public CompanyRegisterBinding() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEik() {
        return eik;
    }

    public void setEik(String eik) {
        this.eik = eik;
    }

    public Boolean getRegisteredVAT() {
        return registeredVAT;
    }

    public void setRegisteredVAT(Boolean registeredVAT) {
        this.registeredVAT = registeredVAT;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserRegisterBinding getUser() {
        return user;
    }

    public void setUser(UserRegisterBinding user) {
        this.user = user;
    }

}
