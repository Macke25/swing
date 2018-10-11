package bookController;

import FactoryMethod.Books;
import authorController.AuthorListWindow;
import model.Author;
import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookWindow extends GridBagWindow {
    private Author selectedAuthor = new Author();
    private JButton selectAuthorButton = new JButton("Select Author");
    private ActionListener actionListener;
    private AuthorListWindow authorListWindow = new AuthorListWindow(actionListener);
    public static final String BOOK_WINDOW_TITLE = "Title";
    private JTextField bookTitleField = new JTextField();
    //private JTextField authorFirstName = new JTextField();
    //private JTextField authorLastName = new JTextField();
    private JButton addBookButton = new JButton("Add");
    private JLabel bookTitleLabel = new JLabel("Title: ");
    public AddBookWindow() throws HeadlessException {
        super(BOOK_WINDOW_TITLE);
        setLayout(new GridBagLayout());
        add(addBookButton, createGbc(1, 0));
        add(bookTitleField, createGbc(1, 1));
        //add(authorFirstName, createGbc(1, 0));
        //add(authorLastName, createGbc(1, 1));
        add(selectAuthorButton, createGbc(1,3));
        add(bookTitleLabel,createGbc(0,1));
        setSize(300, 300);
        selectAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorListWindow.setVisible(true);
            }
        });
    }
    public Book createBook(){
        Book book = Books.createBook(String.valueOf(authorListWindow.getSelectedAuthor()), bookTitleField.getText());
        return book;
    }
    public void addButtonActionListener(ActionListener actionListener) {
        addBookButton.addActionListener(actionListener);
    }
    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    protected GridBagConstraints centerInLine(int y, int lineLength) {
        return super.centerInLine(y, lineLength);
    }
}