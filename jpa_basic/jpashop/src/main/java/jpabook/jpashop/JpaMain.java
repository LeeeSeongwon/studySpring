package jpabook.jpashop;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import jpabook.jpashop.domain.Book;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // Thread 공유 절대 X

        EntityTransaction tx = em.getTransaction(); // JPA 모든 data 변경은 transaction 안에서 실행
        tx.begin();

        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("kim");

            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
