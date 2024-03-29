package gui;

import javax.swing.*;

import model.Villains;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArtifactMenu extends JFrame {
    private JPanel MainWindow;
    private JButton equipButton;
    private JButton dropButton;
    public static JLabel IntroText;
    public static JLabel ArtifactLabel;
    public static JLabel ArtifactStats;
    public static String choice;
    
    public ArtifactMenu() {
        add(MainWindow);
        setTitle("Swingy-App ArtifactMenu");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GameMenu.downButton.setEnabled(false);
        GameMenu.leftButton.setEnabled(false);
        GameMenu.rightButton.setEnabled(false);
        GameMenu.upButton.setEnabled(false);
        GameMenu.saveButton.setEnabled(false);
        GameMenu.loadButton.setEnabled(false);
        GameMenu.closeButton.setEnabled(false);
        GameMenu.statsButton.setEnabled(false);

        equipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choice = "equip";
                Villains.equipDropGUI();
                GameMenu.downButton.setEnabled(true);
                GameMenu.leftButton.setEnabled(true);
                GameMenu.rightButton.setEnabled(true);
                GameMenu.upButton.setEnabled(true);
                GameMenu.saveButton.setEnabled(true);
                GameMenu.loadButton.setEnabled(true);
                GameMenu.closeButton.setEnabled(true);
                GameMenu.statsButton.setEnabled(true);
                dispose();
            }
        });

        dropButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choice = "drop";
                Villains.equipDropGUI();
                GameMenu.downButton.setEnabled(true);
                GameMenu.leftButton.setEnabled(true);
                GameMenu.rightButton.setEnabled(true);
                GameMenu.upButton.setEnabled(true);
                GameMenu.saveButton.setEnabled(true);
                GameMenu.loadButton.setEnabled(true);
                GameMenu.closeButton.setEnabled(true);
                GameMenu.statsButton.setEnabled(true);
                dispose();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MainWindow = new JPanel();
        MainWindow.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 4, new Insets(0, 0, 0, 0), -1, -1));
        equipButton = new JButton();
        equipButton.setText("Equip");
        MainWindow.add(equipButton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dropButton = new JButton();
        dropButton.setText("Drop");
        MainWindow.add(dropButton, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        IntroText = new JLabel();
        IntroText.setText("Equip or Drop the artifact!");
        MainWindow.add(IntroText, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ArtifactLabel = new JLabel();
        ArtifactLabel.setText("Artifact Stats:");
        MainWindow.add(ArtifactLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ArtifactStats = new JLabel();
        ArtifactStats.setText("*STATS*");
        MainWindow.add(ArtifactStats, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        MainWindow.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        MainWindow.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainWindow;
    }
}
