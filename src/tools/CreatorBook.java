/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import java.util.Scanner;

public class CreatorBook {
    Scanner scanner = new Scanner(System.in);

    public Book getBook() {
        Book book = new Book();
        System.out.println("--- Создание книги ---");
        System.out.println("Введите имя книги: ");
        book.setFirstname(scanner.nextLine());
        System.out.println("Введите автора книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("Введите год издания книги: ");
        book.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Введите ISBN книги: ");
        book.setIsbn(scanner.nextLine());
        return book;
    }
    
}
