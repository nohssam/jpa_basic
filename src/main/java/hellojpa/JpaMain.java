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
            //  Members members = new Members();
            //  members.setId(1L);
            //  members.setName("A_Hello");
            //  entityManager.persist((members));

            // 검색하기
            // Members findMembers =  entityManager.find(Members.class, 1L);
            // System.out.println("findMembers.id = " + findMembers.getId());
            // System.out.println("findMembers.name = " + findMembers.getName());

            // 삭제
            // Members findMembers =  entityManager.find(Members.class, 1L);
            // entityManager.remove(findMembers);

             // 수정하기
            Members findMembers =  entityManager.find(Members.class, 2L);
            findMembers.setName("B_Hello");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
