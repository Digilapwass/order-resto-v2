package ch.hearc.ig.orderresto.business;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

//@Entity
//@Table(name="CLIENT")
public abstract class Customer {

    //Penser au type. Il n'y a pas d'attribut pour ça mais il doit être transmis à la colonne de la DB

    //@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //Voir s'il faut également ajouter la SequenceGenerator (page 20 chap. 6)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLIENT")
    //@Column(name="NUMERO")
    private Long id;
    //@Column(name="TELEPHONE")
    private String phone;
    //@Column(name="EMAIL")
    private String email;
    private Set<Order> orders;
    private Address address; //Voir comment implémenter l'adresse

    public Customer() {
    }

    protected Customer(Long id, String phone, String email, Address address) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.orders = new HashSet<>();
        this.address = address;
    }

    /*
    Voir la page 22 du chapitre 6. Est-ce qu'il faut également ajotuer les column sur les getters ?
     */

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Address getAddress() {
        return address;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}