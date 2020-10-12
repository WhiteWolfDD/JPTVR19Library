/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author pupil
 */
public class Book implements Serializable{
    private String firstname;
    private String author;
    private Integer publishedYear;
    private String isbn;
    
    public Book(){
    }
    public Book(String firstname, String author, Integer publishedYear, String isbn) {
        this.firstname = firstname;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
    }

    public String getName() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" 
                + "name=" + firstname 
                + ", author=" + author 
                + ", publishedYear=" + publishedYear 
                + ", isbn=" + isbn 
                + '}';
    }
    
}
