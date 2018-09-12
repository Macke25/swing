package DTO;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDto {

    private List<Book> books=new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
