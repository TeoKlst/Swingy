package app;

import app.Movement;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
// Swing Imports
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class Main  extends JFrame {
    private static final long serialVersionUID = -130737910397146677L;
    JPanel panOuter = new JPanel(new BorderLayout());
    JPanel panLeft = new JPanel(new BorderLayout());
    JPanel panRight = new JPanel(new BorderLayout());
    JPanel panBottom = new JPanel(new BorderLayout());

    JPanel panInput = new JPanel(new BorderLayout());
    JPanel panConsole = new JPanel(new BorderLayout());

    Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    Border insideBorder = BorderFactory.createTitledBorder("The Console");
    Border theBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
    
    JLabel lblLeft = new JLabel("Left Label", JLabel.CENTER);
    JLabel lblRight = new JLabel("Right Label", JLabel.CENTER);

    JTextField txtLeft = new JTextField(10);
    JTextField txtRight = new JTextField(10);

    JButton btnBottom = new JButton("Fun Button");

    JTextArea txtConsole = new JTextArea(5, 10);

    JScrollPane scrPane = new JScrollPane(txtConsole,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

//<------------------------------------------------>
    JTextField textF = new JTextField("", 8);
    JTextArea textA = new JTextArea("BRUH \nTHIS \n IS \n LIT ", 5, 5);
    JLabel labelL = new JLabel("SomethnLABEL");
    String choices[] = {"One","Two"};
    JComboBox comboBox = new JComboBox(choices);
//<------------------------------------------------>

    static Random rand = new Random();

    private class Actionlistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // int i = 1;
            // while(i == 1){
            Toolkit.getDefaultToolkit().beep();
            JFrame frame2 = new JFrame("Was Clicked");
            frame2.setSize(200,50);
            frame2.setVisible(true);
            frame2.setLocation( rand.nextInt(2000), rand.nextInt(1000));
            frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
            JLabel label = new JLabel("BRAAAAAAAAH!");
            JPanel panel = new JPanel();
            frame2.add(panel);
            panel.add(label);
            // }
        }
    }

    private class funcActionlistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textF.setText("WOOOOW!");
            labelL.setText("ChangeLabel!");
        }
    }
    
	public static void main(String[] args) throws Exception {
        //Maybe rename later in case of refferance
        // JFrame frame = new JFrame("Test");
        new Main();
    }

    public Main() {
        super ("Swingy App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setPreferredSize(new Dimension(1200, 800));
        // btnBottom.setPreferredSize(new Dimension(20, 20));

        setResizable(true);
        setLocationRelativeTo(null);

        panLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panRight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panInput.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panConsole.setBorder(theBorder);

        panOuter.add(panLeft, BorderLayout.WEST);
        panOuter.add(panRight, BorderLayout.EAST);
        panOuter.add(panBottom, BorderLayout.SOUTH);

        panLeft.add(lblLeft, BorderLayout.NORTH);
        panLeft.add(txtLeft, BorderLayout.CENTER);

        panRight.add(lblRight, BorderLayout.NORTH);
        panRight.add(txtRight, BorderLayout.CENTER);

        panBottom.add(btnBottom);
        btnBottom.addActionListener(new Actionlistener());

        panInput.add(panLeft, BorderLayout.WEST);
        panInput.add(panRight, BorderLayout.EAST);
        panInput.add(panBottom, BorderLayout.SOUTH);

        panOuter.add(panInput, BorderLayout.NORTH);
        panOuter.add(panConsole, BorderLayout.CENTER);

        panConsole.add(scrPane, BorderLayout.CENTER);

        // panOuter.getInputMap().put(KeyStroke.getKeyStroke("F2"),"doSomething");
        // component.getActionMap().put("doSomething",anAction);

        setContentPane(panOuter);
        pack();
        setVisible(true);
    }
}