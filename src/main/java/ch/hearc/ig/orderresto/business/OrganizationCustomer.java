package ch.hearc.ig.orderresto.business;

import javax.persistence.*;

//@Entity
//@Table(name="CLIENT")
public class OrganizationCustomer extends Customer {

    //@Column(name="NOM")
    private String name;
    //@Column(name="FORME_SOCIALE")
    private String legalForm;

    public OrganizationCustomer() {
    }

    public OrganizationCustomer(Long id, String phone, String email, Address address, String name, String legalForm) {
        super(id, phone, email, address);
        this.name = name;
        this.legalForm = legalForm;
    }

    public String getName() {
        return name;
    }

    public String getLegalForm() {
        return legalForm;
    }
}