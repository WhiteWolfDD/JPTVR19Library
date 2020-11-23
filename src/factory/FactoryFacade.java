package factory;

import entity.dbcontrollers.BookFacade;
import entity.dbcontrollers.HistoryFacade;
import entity.dbcontrollers.ReaderFacade;
import entity.dbcontrollers.UserFacade;

public class FactoryFacade {
    public static BookFacade getBookFacade(){
        return new BookFacade();
    }
    public static ReaderFacade getReaderFacade(){
        return new ReaderFacade();
    }
    public static UserFacade getUserFacade(){
        return new UserFacade();
    }
    public static HistoryFacade getHistoryFacade(){
        return new HistoryFacade();
    }
}
