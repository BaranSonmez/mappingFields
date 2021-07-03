import config.JpaConfig;
import enums.AccountType;
import model.Address;
import model.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTests {
    @Test
    public void testUserAdd() {
        EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        User user = new User();
        user.setUserName("USER--NAME");
        user.setAccountType(AccountType.BRONZE);

        Address address = new Address("sokak", "333", "ANKARA");
        user.setBillingAdress(address);

        entityManager.persist(user);

        tx.commit();
        entityManager.close();
        JpaConfig.getEntityManagerFactory().close();
    }

    @Test
    public void testJpaSetup() {
        EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        tx.commit();
        entityManager.close();
        JpaConfig.getEntityManagerFactory().close();
    }
}
