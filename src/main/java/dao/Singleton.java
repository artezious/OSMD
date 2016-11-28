package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by WEO on 9/17/16.
 */

public enum Singleton {

    ENTITY_MANAGER;

    private final javax.persistence.EntityManager entityManager = Persistence.createEntityManagerFactory("osmdPersistenceUnit").createEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
