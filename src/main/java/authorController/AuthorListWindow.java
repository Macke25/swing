package authorController;

//import listModel.AuthorListModel;
import model.Author;
import service.AuthorFileService;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
public class AuthorListWindow extends GridBagWindow {
    public static final String AUTHOR_LIST_WINDOW_TITLE = "Author List";
    private JList<Author> authorList = new JList<>();
//    private DefaultListModel<Author> authorListModel = new DefaultListModel<>();
    private JButton addAuthorButton = new JButton("Add autor");
//    private AuthorListModel authorListModel = new AuthorListModel();
    private AddAuthorWindow addAuthrWindow = new AddAuthorWindow("");
    public Author getSelectedAuthor() {
        return authorList.getSelectedValue();
    }
    public void addSectionActionListener(ListSelectionListener listener) {
        authorList.addListSelectionListener(listener);
    }
    public AuthorListWindow(ActionListener actionListener) throws HeadlessException {
        super(AUTHOR_LIST_WINDOW_TITLE);
        setLayout(new GridBagLayout());
        add(new JMenuItem("Lista autorów"), createGbc(0, 2));
        add(authorList, createGbc(0, 1));
        setSize(300, 300);
        add(addAuthorButton, createGbc(0, 0));
        addAuthorButton.addActionListener(e -> addAuthrWindow.setVisible(true));
//        addAuthrWindow.addButtonActionListener(new AddAuthorActionListener(authorListModel, addAuthrWindow), actionListener);
//        authorList.setModel(authorListModel);
        loadData();
    }
    public void loadData(){
        Author author = new Author();
        AuthorFileService authorFileService = new AuthorFileService();
        List<Author> authors = authorFileService.loadAuthors();

        DefaultComboBoxModel<Author> authorListModel = null;
        authorListModel.addElement(author);
        }
    }
