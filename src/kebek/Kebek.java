
package kebek;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Kebek extends JFrame implements MouseListener {

    private static final long serialVersionUID = 1L;

    // creating save button and adding it into layout
    JButton saveButton = new JButton("Save");
    JButton openButton = new JButton("Open");

    // create text fields and add them to our layout
    JLabel fileNameLabel = new JLabel("Save a file           ", JLabel.RIGHT);
    JTextField fileNameText = new JTextField(20);

    //
    JLabel openFile = new JLabel("Open a file            ", JLabel.RIGHT);
    JTextField openFileText = new JTextField(20);

    // create writing area
    JTextArea editSpace = new JTextArea(40, 40);

    // error message shower
    JTextArea errorMessageText = new JTextArea(5, 40);

    public Kebek() {
        // set up the title of the frame
        super("Kebek Text Editor");
        //or setTitle("Kebek Text Editor");

        //must be added to customize apeariance
        this.setLookAndFeel();

        // set the size of the frame - in px
        this.setSize(500, 1000);
        // or pack();   - this The pack() method sets the frame big enough
        //to hold the preferred size of
        //each component inside the frame (but no bigger)

        // exits the program when x button is clicked
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Choose layout to give to our frame
        FlowLayout flo = new FlowLayout();

        // associate the manager with the container.
        this.setLayout(flo);

        // make save button listen for button clicks
        this.saveButton.addMouseListener(this);
        this.openButton.addMouseListener(this);

        // adding all the components
        this.add(this.fileNameLabel);
        this.add(this.fileNameText);
        this.add(this.saveButton);
        this.add(this.openFile);
        this.add(this.openFileText);
        this.add(this.openButton);
        this.add(this.editSpace);
        this.add(this.errorMessageText);

        // makes the frame visible
        this.setVisible(true);

    }

    //    public String getfileNameTxt() {
    //        return this.fileNameText.getText();
    //    }

    // action performed method - event handler
    @Override
    public void mouseClicked(MouseEvent event) {
        // listen to what button is pressed
        Object source = event.getSource();

        if (source == this.saveButton) {
            String essay = this.editSpace.getText();
            //
            String mainFileName = this.fileNameText.getText();

            try (BufferedWriter buffWrite = new BufferedWriter(
                    new FileWriter(mainFileName + ".txt"))) {

                // write the string on to a file
                buffWrite.write(essay);

                buffWrite.close();

            } catch (IOException ex) {
                System.out.println("There is an error with the file");
            }
        } else if (source == this.openButton) {

            // open file
            System.out.println("Yo, i am opening the file .");
            System.out.println("Yo, i am opening the file ..");
            System.out.println("Yo, i am opening the file ...");

            try (BufferedReader buffread = new BufferedReader(new FileReader(
                    new File(this.openFileText.getText() + ".txt")))) {

                // write the string on to a file
                String dataRead = buffread.readLine();
                buffread.close();
                this.editSpace.setText(dataRead);

            } catch (IOException ex) {
                System.out.println("There is an error with the file");
                this.errorMessageText
                        .setText("File not found. I am not Sorry. Haha ");
            }

        } else {

        }

    }

    // needed for to customize our frame
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            // do nothing
        }

    }

    public static void main(String[] argus) {
        Kebek kebekframe = new Kebek();

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
}
