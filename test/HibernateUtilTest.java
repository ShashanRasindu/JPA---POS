import lk.ijse.pos.db.JPAutill;
import lk.ijse.pos.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class HibernateUtilTest {

    public static void main(String[] args) {

        EntityManager entityManager = JPAutill.getEntityManager();


        Customer c001 = entityManager.find(Customer.class, "C001");

        System.out.println(c001);

        entityManager.close();


    }

}
