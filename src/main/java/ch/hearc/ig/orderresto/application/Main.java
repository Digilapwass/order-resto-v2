package ch.hearc.ig.orderresto.application;

import ch.hearc.ig.orderresto.business.PrivateCustomer;
import ch.hearc.ig.orderresto.business.Restaurant;
import ch.hearc.ig.orderresto.presentation.MainCLI;
import ch.hearc.ig.orderresto.persistence.JpaUtils;

import javax.persistence.*;

public class Main {

  public static void main(String[] args) {



    EntityManager em = JpaUtils.getEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();

    Restaurant restaurant = em.find(Restaurant.class, 1L);
    //PrivateCustomer customer = em.find(PrivateCustomer.class, 284L);

    transaction.commit();
    em.close();

    if (restaurant != null) {
      System.out.println("Restaurant found: " + restaurant.getName());
    } else {
      System.out.println("Restaurant with ID 1 not found.");
    }




    /*EntityManager em = JpaUtils.getEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    //em.persist(Object A); //L'instance devient une "Managed Entity"
    em.flush(); //Synchronisation du contexte de persistence avec la DB
    transaction.commit();
    em.close(); //L'entity manager est fermé
    (new MainCLI()).run();*/
  }
}
