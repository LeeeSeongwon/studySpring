package jpabook.jpashop;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // Thread 공유 절대 X

        EntityTransaction tx = em.getTransaction(); // JPA 모든 data 변경은 transaction 안에서 실행
        tx.begin();

        try {
            Order order = new Order();
            // order.addOrderItem(new OrderItem());
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            em.persist(orderItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
