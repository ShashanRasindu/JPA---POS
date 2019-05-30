package lk.ijse.pos.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JPAutill {

    //    private static SessionFactory sessionFactory = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory(){
//
//        File propFile = new File("resources/application.properties");
//
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .loadProperties(propFile).build();
//
//        Metadata metadata = new MetadataSources(registry)
//                .addAnnotatedClass(Customer.class)
//                .addAnnotatedClass(Item.class)
//                .addAnnotatedClass(Order.class)
//                .addAnnotatedClass(OrderDetail.class)
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
//                .build();
//
//        return  metadata.buildSessionFactory();

    private static EntityManagerFactory entityManagerFactory =buildEntityManagerFactory();

    //            = buildSessionFactory();
    private static EntityManagerFactory buildEntityManagerFactory() {


        File file = new File("resources\\application.properties");

            Properties properties = new Properties();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit2", properties);


            return emf;
    }

    public static EntityManager getEntityManager(){


        return entityManagerFactory.createEntityManager();
    }
}










