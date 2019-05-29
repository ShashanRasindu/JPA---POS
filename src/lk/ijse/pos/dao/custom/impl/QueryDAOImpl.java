package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.QueryDAO;
import lk.ijse.pos.entity.CustomEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    private Session session;



    @Override
    public List<CustomEntity> getOrdersTotal() throws Exception {

        List<Object[]> list = session.createNativeQuery("SELECT id, SUM(qty * unitPrice) AS Total FROM `Order` INNER JOIN\n" +
                "  OrderDetail OD on `Order`.id = OD.orderId GROUP BY id").list();

        List<CustomEntity> al = new ArrayList<>();

        for (Object[] objects : list) {
            al.add(new CustomEntity((Integer) objects[0], (Double) objects[1]));
        }

        return al;
    }


    @Override
    public void setEntityManager(EntityManager entityManager) {

    }
}
