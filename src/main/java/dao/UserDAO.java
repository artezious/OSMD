package dao;

import model.UserEntity;

import javax.persistence.EntityManager;
import java.util.List;

import static dao.Singleton.ENTITY_MANAGER;

/**
 * Created by WEO on 9/12/16.
 */


public class UserDAO {

    EntityManager entityManager = ENTITY_MANAGER.getEntityManager();

    public List<UserEntity> getUsers() {
        return entityManager.createQuery("Select User from UserEntity user").getResultList();
    }

    public void saveUser(UserEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
}
