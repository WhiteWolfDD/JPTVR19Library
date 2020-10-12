/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19library;

import tools.HistorySaver;
import tools.CreatorHistory;
import tools.CreatorBook;
import entity.Reader;
import entity.Book;
import entity.History;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.BookSaver;
import tools.CreatorReader;
import tools.ReaderSaver;

/**
 *
 * @author pupil
 */
 class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    private History[] histories = new History[10];
    private HistorySaver historySaver;
    public App(){
        BookSaver bookSaver = new BookSaver();
        books = bookSaver.loadBooks();
        
        ReaderSaver readerSaver = new ReaderSaver();
        readers = readerSaver.loadReaders();
    }
     
    public void run() {
        System.out.println("--- Библиотека ---");
        boolean repeat = true;
        do {
            System.out.println("Задачи: ");
            System.out.println("0. Выйти с программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Список книг");
            System.out.println("3. Зарегистрировать читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу в библиотеку");
            System.out.println("7. Список читаемых книг");
            System.out.println("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- Конец программы ---");
                    break;
                case "1":
                    System.out.println("--- Добавить новую книгу ---");
//                    Book book = new Book("Voina i mir","L.Tolstoy",2010, "123-1234");
                    CreatorBook creatorBook = new CreatorBook();
                    Book book = creatorBook.getBook();
                    for (int i = 0; i < books.length; i++){
                        if(books[i] == null){
                            books[i] = book;
                            break;
                        } 
                    }
                    BookSaver bookSaver = new BookSaver();
                    bookSaver.saveBooks(books);
                    System.out.println("Название книги: "+book.getName());
                    //System.out.println(book.toString());
                    break;
                case "2":
                    System.out.println("--- Список книг ---");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(i + 1+ ". " + books[i].toString());
                        }
                    }
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать читателя ---");
                    //Reader reader = new Reader("Ivan", "Ivanov", "57234874");
                    CreatorReader creatorReader = new CreatorReader();
                    Reader reader = creatorReader.getReader();
                    for (int i = 0; i < readers.length; i++){
                        if(readers[i] == null){
                            readers[i] = reader;
                            break;
                            }
                    }
                    ReaderSaver readerSaver = new ReaderSaver();
                    readerSaver.saveReaders(readers);
                    System.out.println("Имя читателя: "+reader.getFirstname());
                    //System.out.println(reader.toString());
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.println(i + 1+ ". " + readers[i].toString());
                        }
                    }
                    break;
                case "5":
                    System.out.println("--- Выдать книгу читателю ---");

                    System.out.print("Книги:");
                    System.out.println();
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(i+1+". " + books[i].toString());
                        }
                    }
                    System.out.println();
                    System.out.print("Выберите книгу: ");
                    int bookNumber = scanner.nextInt();
                    book = books[bookNumber - 1];
                    System.out.println("--- Список читателей ---");
                    System.out.println();
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.printf("%d. %s%n",i+1,readers[i].toString());
                        }
                    }
                    System.out.println();
                    System.out.print("Выберите читателя: ");
                    int readerNumber = scanner.nextInt();
                    reader = readers[readerNumber - 1];
                    History history = new History();
                    history.setBook(book);
                    history.setReader(reader);
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] == null){
                            histories[i]=history;
                            break;
                        }
                    }
                    CreatorHistory creatorHistory = new CreatorHistory();
                    creatorHistory.saveHistories(histories);
                    System.out.println("Читателю "
                            + reader.getFirstname()
                            + " "
                            + reader.getLastname()
                            + " выдана книга "
                            + '"'
                            + history.getBook().getName()
                            + '"'
                    );
                    break;
                case "6":
                     System.out.println("Читаемые книги:");
                    boolean notReadBooks = true;
                    for (int i = 0;i<histories.length;i++) {
                        if(histories[i] != null && histories[i].getReturnDate() == null){
                            System.out.printf("%d. Книгу \"%s\" читает %s %s%n"
                                    ,i+1
                                    ,histories[i].getBook().getName()
                                    ,histories[i].getReader().getFirstname()
                                    ,histories[i].getReader().getLastname()
                            );
//                            System.out.println(n+1+". Книгу \""
//                                    +h.getBook().getName()
//                                    +"\" читает "
//                                    +h.getReader().getFirstname() 
//                                    + " "
//                                    +h.getReader().getLastname()
//                            );
                            notReadBooks = false;
                        }
                    }
                    if(notReadBooks){
                        System.out.println("Читаемых книг нет");
                        break;
                    }
                    System.out.println("Выберите номер возвращаемой книги: ");
                    int historyNumber = scanner.nextInt();
                    histories[historyNumber - 1].setReturnDate(new GregorianCalendar().getTime());
                    historySaver = new HistorySaver();
                    historySaver.saveHistoryToFile(histories);
                    break;
                case "7":  
                    System.out.println("--- Список читаемых книг ---");
                    int n = 0;
                    for (History h : histories) {
                        if(h != null && h.getReturnDate() == null){
                            System.out.println(n+1+". "+h.toString());
                            n++;
                        }
                    }
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        } while (repeat);
    
    }
}
