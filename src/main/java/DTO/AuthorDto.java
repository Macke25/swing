package DTO;

import model.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorDto {

    public static List<Author> getAuthors;
    private List<Author> authors=new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
