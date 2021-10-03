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
            // Member member = new Member();
            // member.setId(1L);
            // member.setName("HelloA");
            // em.persist(member);
            // tx.commit();
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
