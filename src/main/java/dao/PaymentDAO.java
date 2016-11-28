package dao;

import model.PaymentEntity;

import javax.persistence.EntityManager;
import java.util.List;

import static dao.Singleton.ENTITY_MANAGER;

/**
 * Created by WEO on 9/12/16.
 */

public class PaymentDAO {

    EntityManager entityManager = ENTITY_MANAGER.getEntityManager();

    public List<PaymentEntity> getPayment() {
        return entityManager.createQuery("Select Payment from PaymentEntity payment").getResultList();
    }

    public void savePayment(PaymentEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
}
