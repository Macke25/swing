package bookController;

import DTO.BookDto;
import com.google.gson.Gson;
import model.Book;
import service.AbstractFileService;
import service.BookFileService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BookListWindow extends GridBagWindow {


    private JList<Book> bookList = new JList<Book>();
    private DefaultListModel<Book> bookListModel = new DefaultListModel<Book>();
    private JButton addBookButton = new JButton();
    private AddBookWindow addBookWindow = new AddBookWindow();
    private AbstractFileService bookFileService;


    public BookListWindow(String s) throws HeadlessException {
        super(s);
        setLayout(new GridBagLayout());
        addBookButton.addActionListener(e -> addBookWindow.setVisible(true));
        addBookButton.setText("add");
        add(addBookButton, createGbc(0, 0));

        bookList.setModel(bookListModel);
        add(bookList, createGbc(0, 1));
        addBookWindow.addButtonActionListener(new AdddBookActionListener(bookListModel, addBookWindow));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 800);
        loadData();}



    protected void saveBooks() {
        BookDto bookDTO = new BookDto();
        for (int i = 0; i < bookListModel.size(); i++) {
            bookDTO.getBooks().add(bookListModel.get(i));
        }
        BookFileService bookFileService = new BookFileService();
        bookFileService.saveBooks(bookDTO.getBooks());
    }

    public JList<Book> getBookList() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("D:java\\bookDataBase.json")));
            BookDto bookDto = new Gson().fromJson(json, BookDto.class);
            return (JList<Book>) bookDto.getBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void loadData(){
        BookFileService bookFileService = new BookFileService();
        List<Book> books = bookFileService.loadBooks(); // ctrl+alt+v -> nadanie zmiennej
        for (Book book : books) {
            bookListModel.addElement(book);
        }
    }
    private void addListeners(){
        addBookButton.addActionListener((e -> addBookWindow.setVisible(true)));
        addBookWindow.addButtonActionListener(e -> {
            if (addBookWindow.isValid()){
                bookListModel.addElement(addBookWindow.createBook());
                bookFileService(bookListModel.getElementAt(Integer.parseInt("1")));
                addBookWindow.setVisible(false);
            } else {
                addBookWindow.showAlert("Musisz podać autora i tytuł");
            }
        });
        }








    private void bookFileService(Book elementAt) {
    }
}

