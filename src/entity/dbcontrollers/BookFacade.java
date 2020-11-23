package entity.dbcontrollers;

import entity.Book;
import factory.ConnectorSingleton;

import javax.persistence.EntityManager;

public class BookFacade extends AbstractFacade<Book> {

    private EntityManager em;

    public BookFacade() {
        super(Book.class);
        ConnectorSingleton connect = ConnectorSingleton.getInstance();
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
