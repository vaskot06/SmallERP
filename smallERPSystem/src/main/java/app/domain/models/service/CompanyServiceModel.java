package app.domain.models.service;

import java.util.List;

public class CompanyServiceModel {

    private String id;
    private String name;
    private String eik;
    private Boolean registeredVAT;
    private String country;
    private UserServiceModel user;
    private List<WarehouseServiceModel> warehouses;
    private List<AssortmentServiceModel> assortments;

    public CompanyServiceModel() {
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

    public List<WarehouseServiceModel> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehouseServiceModel> warehouses) {
        this.warehouses = warehouses;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }

    public List<AssortmentServiceModel> getAssortments() {
        return assortments;
    }

    public void setAssortments(List<AssortmentServiceModel> assortments) {
        this.assortments = assortments;
    }
}


