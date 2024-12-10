package ch.hearc.ig.orderresto.business;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="RESTAURANT")
public class Restaurant {

    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //Voir s'il faut également ajouter la SequenceGenerator (page 20 chap. 6)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RESTAURANT")
    @Column(name="NUMERO")
    private Long id;
    @Column(name="NOM")
    private String name;
    @Transient
    private Set<Order> orders;
    @Transient
    private Address address; //Voir comment implémenter l'adresse
    @Transient
    private Set<Product> productsCatalog;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = new HashSet<>();
        this.productsCatalog = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Product> getProductsCatalog() {
        return productsCatalog;
    }

    public void registerProduct(Product p) {
        if (p.getRestaurant() != this) {
            throw new RuntimeException("Restaurant mismatch!");
        }
        this.productsCatalog.add(p);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}