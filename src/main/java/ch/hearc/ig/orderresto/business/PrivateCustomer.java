package ch.hearc.ig.orderresto.business;

import javax.persistence.*;

//@Entity
//@Table(name="CLIENT")
public class PrivateCustomer extends Customer {

    //On pourrait utiliser @Enumerated(EnumType.STRING) mais la DB ne traite pas la donnée de cette manière ?
    //@Column(name="EST_UNE_FEMME", columnDefinition = "CHAR(1)")
    private String gender;
    //@Column(name="PRENOM")
    private String firstName;
    //@Column(name="NOM")
    private String lastName;

    public PrivateCustomer() {
    }

    public PrivateCustomer(Long id, String phone, String email, Address address, String gender, String firstName, String lastName) {
        super(id, phone, email, address);
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}