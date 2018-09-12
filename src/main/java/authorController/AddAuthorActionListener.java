package authorController;

import DTO.AuthorDto;
import model.Author;
import service.AuthorFileService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAuthorActionListener implements ActionListener {

    private AddAuthorWindow addAuthorWindow;
    private DefaultListModel<Author> authorListModel;


    public AddAuthorActionListener(DefaultListModel<Author> authorListModel, AddAuthorWindow addAuthorWindow) {
        this.authorListModel = authorListModel;
        this.addAuthorWindow = addAuthorWindow;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        authorListModel.addElement(addAuthorWindow.createAuthor());
        System.out.println(authorListModel.toString());
        saveAuthors();

    }
    private void saveAuthors(){
        AuthorDto authorDto = new AuthorDto();
        for (int i =0; i<authorListModel.getSize(); i++){
            authorDto.getAuthors().add(authorListModel.getElementAt(i));
        }
        AuthorFileService authorFileService = new AuthorFileService();
        authorFileService.saveAuthor(authorDto.getAuthors());

    }
}
