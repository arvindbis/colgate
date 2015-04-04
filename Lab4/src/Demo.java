import view.Luncher;

import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Luncher("Lab4");
            }
        });
    }
}
