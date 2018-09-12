package authorController;

import FactoryMethod.Authors;
import model.Author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddAuthorWindow extends GridBagWindow {


    private JTextField authorFirstName= new JTextField();
    private JTextField authorLastName= new JTextField();
    private JButton addAuthorButton = new JButton();

    public AddAuthorWindow(String s) throws HeadlessException {
        super(s);
        setLayout(new GridBagLayout());
        setSize(300, 600);

        add(new JLabel("imie autora"),createGbc(0,1));
        add(authorFirstName,createGbc(1,1));
        add(new JLabel("nazwisko autora"),createGbc(0,2));
        add(authorLastName,createGbc(1,2));
        addAuthorButton.setText("add Author");
        add(addAuthorButton,centerInLine(3,2));

    }



    public Author createAuthor() {
        return Authors.createAuthor(authorFirstName.getText(), authorLastName.getText());

    }

    public void addButtonActionListener(AddAuthorActionListener addAuthorActionListener, ActionListener actionListener) {
        addAuthorButton.addActionListener(addAuthorActionListener);

    }
}


