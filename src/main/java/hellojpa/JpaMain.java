package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 하나만 만들어야 한다.
        EntityManagerFactory entityManagerFactory
                =  Persistence.createEntityManagerFactory("hello");

        // 트랜잭션 단위
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 트랜잭션을 하지 않으면 오류 발생 (반드시 트랜잭션 단위 처리 )
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            // 멤버스 저장하기
            Members members = new Members();
            members.setId(2L);
            members.setName("HelloB");
            entityManager.persist((members));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
