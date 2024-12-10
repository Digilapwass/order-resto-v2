package ch.hearc.ig.orderresto.business;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

//@Entity
public class Product {

    //@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //Voir s'il faut également ajouter la SequenceGenerator (page 20 chap. 6)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PRODUIT")
    //@Column(name="NUMERO")
    private Long id;
    //@Column(name="NOM")
    private String name;
    //@Column(name="PRIX_UNITAIRE")
    private BigDecimal unitPrice;
    //@Column(name="DESCRIPTION")
    //Faut-il ajouter @Lob ? Si c'est le cas, ajouter également @Basic(fetch=FetchType.LAZY) pour charger uniquement lorsqu'on appelle le getter
    private String description;
    private Set<Order> orders;
    private Restaurant restaurant;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal unitPrice, String description, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
        this.orders = new HashSet<>();
        this.restaurant = restaurant;
        restaurant.registerProduct(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %.2f de chez %s: %s",
                this.getName(),
                this.getUnitPrice(),
                this.getRestaurant().getName(),
                this.getDescription()
        );
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}