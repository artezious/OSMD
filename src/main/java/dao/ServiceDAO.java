package dao;

import model.ServiceEntity;

import javax.persistence.EntityManager;
import java.util.List;

import static dao.Singleton.ENTITY_MANAGER;

/**
 * Created by WEO on 9/12/16.
 */

public class ServiceDAO {

    EntityManager entityManager = ENTITY_MANAGER.getEntityManager();

    public List<ServiceEntity> getService() {
        return entityManager.createQuery("Select Service from ServiceEntity service").getResultList();
    }

    public void saveService(ServiceEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
}
