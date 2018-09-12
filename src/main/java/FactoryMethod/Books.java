package FactoryMethod;

import model.Book;

public class Books {


    public static Book createBook (String title, String author){

        Book book= new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return book;
    }
}
