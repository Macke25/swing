package bookController;

import model.Book;
import service.BookFileService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdddBookActionListener implements ActionListener{

   private DefaultListModel<Book> listModel= new DefaultListModel<>();
   private AddBookWindow addBookWindow=new AddBookWindow();
    private BookFileService bookFileService = new BookFileService();

    public AdddBookActionListener(DefaultListModel<Book> listModel, AddBookWindow addBookWindow) {
        this.listModel = listModel;
        this.addBookWindow = addBookWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Book bookCheck = addBookWindow.createBook();
        if(bookCheck.getAuthor() == null){
            addBookWindow.showAlert("brak autora!");
        } else {
            listModel.addElement(addBookWindow.createBook());
            ArrayList<Book> list = new ArrayList<>();
            for(int i = 0; i <listModel.getSize(); i++){
                list.add(listModel.get(i));
            }
            bookFileService.saveBooks(list);

        }
    }

//
//    private void saveBooks(){
//        BookDto bookDto = new BookDto();
//        for (int i =0; i<listModel.getSize(); i++){
//            bookDto.getBooks().add(listModel.getElementAt(i));
//        }
//        BookFileService bookFileService = new BookFileService();
//        bookFileService.saveBooks(bookDto.getBooks());
//        List <Book> bookList = bookDto.getBooks();

    }



