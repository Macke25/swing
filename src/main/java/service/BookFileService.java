package service;

import DTO.BookDto;
import com.google.gson.Gson;
import model.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class BookFileService extends AbstractFileService<BookDto> {

    private List<Book> books;
    private String json;

    public BookFileService() {
        super(logger);
    }

    public void saveBooks(List<Book> books){
        BookDto bookDto = new BookDto();
        bookDto.setBooks(books);
        PrintWriter printWriter = null;
     try {

         printWriter=new PrintWriter("books.json");
         printWriter.println(new Gson().toJson(bookDto));
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } finally {
         if (printWriter != null){
             printWriter.close();
         }
     }
 }


    public List<Book> loadBooks() {
        BookDto bookDto = new BookDto();
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("books.json")));
            bookDto = new Gson().fromJson(jsonString, BookDto.class);
            return bookDto.getBooks();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }
}

