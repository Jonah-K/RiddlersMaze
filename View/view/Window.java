

import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Window {

    // method that used JOptionsPane, showMessageDialog in order to create a popup message
    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }


    // method that used JOptionsPane's, showInputDialog, in order to create a popup that can be typed into
    public String in(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    // method that used JOptionsPane's, showOptionDialog, in order to create a popup that has diffrent options
    public int option(String[] options, String string) {
        return JOptionPane.showOptionDialog(
                null,
                string,
                "Click a button",
                -1,
                1,
                null,
                (Object[])options,
                options[0]);
    }
    // method that printlns a message
    public void println(String msg) {
        System.out.println(msg);
    }
    //method that used println to create a message
    public void print(String msg) {
        System.out.println(msg);
    }


}
