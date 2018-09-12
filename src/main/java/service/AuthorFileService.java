package service;

import DTO.AuthorDto;
import com.google.gson.Gson;
import model.Author;
import model.Book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AuthorFileService extends AbstractFileService<AuthorDto> {

    private List<Book> authors;

    public void saveAuthor (List<Author> authors){
//        unJson()

            AuthorDto authorDto = new AuthorDto();
            authorDto.setAuthors(authors);
            PrintWriter printWriter = null;
            try {
            printWriter= new PrintWriter  ("authors.json");
            printWriter.println(new Gson().toJson(authorDto));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
                if (printWriter != null ){
                    printWriter.close();
                }
            }
    }

    public List<Author> loadAuthors(){
        AuthorDto authorDto = new AuthorDto();
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("authors.json")));
            authorDto = new Gson().fromJson(jsonString, AuthorDto.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new ArrayList<>();
    }
}
