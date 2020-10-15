package tools;

import entity.Book;
import java.util.Scanner;

public class BookManager {
    public Book createBook() {
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание книги ---");
        System.out.print("Название книги: ");
        book.setName(scanner.nextLine());
        System.out.print("Автор книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Год издания книги: ");
        book.setPublishedYear(scanner.nextInt());
        return book;
    }
    public void addBookToArray(Book book, Book[] books){
        for (int i = 0; i < books.length; i++) {
            if(books[i] == null){
                books[i]=book;
                break;
            }
        }
    }

    public void printListBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if(books[i]!= null){
                System.out.printf("%3d. Название книги: %s%n     Автор: %s%n     Год издания: %s%n"
                        ,i+1
                        ,books[i].getName()
                        ,books[i].getAuthor()
                        ,books[i].getPublishedYear()
                );
                System.out.println("--------------------------------");
            }
        }
    }

}