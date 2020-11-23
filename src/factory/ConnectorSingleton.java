package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectorSingleton {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static ConnectorSingleton instance;
    private ConnectorSingleton(){
        emf = Persistence.createEntityManagerFactory("JPTVR19LibraryPU");
        em = emf.createEntityManager();
    }
    public static ConnectorSingleton getInstance(){
        if (instance == null){
            instance = new ConnectorSingleton();
        }
        return instance;
    }
    public EntityManager getEntityManager(){
        return em;
    }
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
