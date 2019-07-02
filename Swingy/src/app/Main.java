package app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main  extends JFrame {
    private static final long serialVersionUID = -130737910397146677L;
    JPanel p = new JPanel();
    JButton b = new JButton("Bruh");
    JTextField t = new JTextField("Brah");
    JTextArea ta = new JTextArea("BRUH \nTHIS \n IS \n LIT ");

	public static void main(String[] args) throws Exception {
        //Maybe rename later in case of reference
        new Main();
        System.out.println("Hello Java");
    }

    public Main() {
        super ("Swingy App");
        setSize(400,300);
        setResizable(true);

        p.add(b);
        p.add(t);
        p.add(ta);
        add(p);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}