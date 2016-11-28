package dao;

import model.StatementEntity;

import javax.persistence.EntityManager;
import java.util.List;

import static dao.Singleton.ENTITY_MANAGER;

/**
 * Created by WEO on 9/12/16.
 */

public class StatementDAO {

    EntityManager entityManager = ENTITY_MANAGER.getEntityManager();

    public List<StatementEntity> getStatement() {
        return entityManager.createQuery("Select Statement from StatementEntity statement").getResultList();
    }

    public void saveStatement(StatementEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

}
