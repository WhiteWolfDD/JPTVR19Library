package entity.dbcontrollers;

import entity.History;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();


    public void create(T entity){
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    public List<T> findAll() {
        try {
            return getEntityManager().createQuery("SELECT en FROM "+entityClass.getName()+" en")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    public T find(long id) {
        try {
            return (T) getEntityManager().createQuery("SELECT en FROM "+entityClass.getName()+" en WHERE en.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    public void edit(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }
}
