package app.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "warehouses")
public class Warehouse extends BaseEntity {

    private String name;
    private String address;


    public Warehouse() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
