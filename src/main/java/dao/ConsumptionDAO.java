package dao;

import model.ConsumptionEntity;

import javax.persistence.EntityManager;
import java.util.List;

import static dao.Singleton.ENTITY_MANAGER;

/**
 * Created by WEO on 9/12/16.
 */

public class ConsumptionDAO {

    EntityManager entityManager = ENTITY_MANAGER.getEntityManager();

    public List<ConsumptionEntity> getConsumptions() {
        return entityManager.createQuery("Select Consumption from ConsumptionEntity consumption").getResultList();
    }

    public void saveConsumption(ConsumptionEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
}
