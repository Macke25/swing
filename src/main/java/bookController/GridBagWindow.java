package bookController;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Mateusz Przybylski on 2017-09-30.
 */

public abstract class GridBagWindow extends JFrame {


    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);

    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);


    public GridBagWindow(String s) throws HeadlessException {

        super(s);

        setLayout(new GridBagLayout());

    }


    protected GridBagConstraints createGbc(int x, int y) {

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = x;

        gbc.gridy = y;

        gbc.gridwidth = 1;

        gbc.gridheight = 1;


        gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;

        gbc.fill = (x == 0) ? GridBagConstraints.BOTH

                : GridBagConstraints.HORIZONTAL;


        gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;

        gbc.weightx = (x == 0) ? 0.1 : 1.0;

        gbc.weighty = 1.0;

        return gbc;

    }


    protected GridBagConstraints centerInLine(int y, int lineLength) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridy = y;

        gridBagConstraints.gridwidth = lineLength;

        gridBagConstraints.insets = new Insets(5, 0, 15, 0);

        
        return gridBagConstraints;

    }

}


