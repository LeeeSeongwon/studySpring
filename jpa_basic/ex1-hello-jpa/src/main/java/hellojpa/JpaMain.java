package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // Thread 공유 절대 X

        EntityTransaction tx = em.getTransaction(); // JPA 모든 data 변경은 transaction 안에서 실행
        tx.begin();

        try {
            // Member member = new Member(200L, "member200");
            // em.persist(member);
            // em.flush();
            // System.out.println("==============");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
