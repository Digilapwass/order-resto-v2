package ch.hearc.ig.orderresto.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

//@Entity
//@Table(name="COMMANDE")
public class Order {

    //@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //Voir s'il faut également ajouter la SequenceGenerator (page 20 chap. 6)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMMANDE")
    //@Column(name="NUMERO")
    private Long id;
    //@Column(name="FK_CLIENT")
    private Customer customer;
    //@Column(name="FK_RESTO")
    private Restaurant restaurant;
    private Set<Product> products;
    //@Column(name="A_EMPORTER", columnDefinition = "CHAR(1)")
    private Boolean takeAway;
    //@Column(name="QUAND")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date when;
    private BigDecimal totalAmount;

    public Order() {
    }

    public Order(Long id, Customer customer, Restaurant restaurant, Boolean takeAway, Date when) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.products = new HashSet<>();
        this.takeAway = takeAway;
        this.totalAmount = new BigDecimal(0);
        this.when = when;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Boolean getTakeAway() {
        return takeAway;
    }

    public Date getWhen() {
        return when;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.totalAmount = this.totalAmount.add(product.getUnitPrice());
    }
}