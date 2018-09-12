package FactoryMethod;

import model.Author;

public class Authors {

    public static Author createAuthor(String firstName, String lastName){

        Author author=new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return author;
    }
}
