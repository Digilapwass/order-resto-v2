package ch.hearc.ig.orderresto.business;

import javax.persistence.*;

//@Entity
//@Table(name = "CLIENT")
//@SecondaryTable(name = "RESTAURANT")
public class Address {

    //@Column(columnDefinition = "CHAR(2)")
    private String countryCode;
    //@Column(columnDefinition = "CHAR(4)")
    private String postalCode;
    private String locality;
    private String street;
    private String streetNumber;

    public Address() {
    }

    public Address(String countryCode, String postalCode, String locality, String street, String streetNumber) {
        this.countryCode = countryCode;
        this.postalCode = postalCode;
        this.locality = locality;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }
}