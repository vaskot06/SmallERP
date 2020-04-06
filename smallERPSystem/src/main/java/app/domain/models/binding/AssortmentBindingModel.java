package app.domain.models.binding;

import java.math.BigDecimal;

public class AssortmentBindingModel {

    private String name;
    private BigDecimal price;
    private Boolean state;


    public AssortmentBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
