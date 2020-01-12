package com.ANMProgramming;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        new MainGUI().setVisible(true);
    }

    public static void btnStart_Clicked(ActionEvent e) {

        if (Globals.filePath == null) {
            JOptionPane.showMessageDialog(null, "You must select a save file.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (!Globals.fileExt.equals(".txt")) {
            JOptionPane.showMessageDialog(null, "Save file must be a '.txt' file", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Globals.calcStop = false;

            Calculation calculationClass = new Calculation();
            calculationClass.Calculation();
        }
    }

    public static void btnStop_Clicked(ActionEvent e) {
        Globals.calcStop = true;
    }

    public static void btnBrowse_Clicked(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(new MainGUI());

        if (result == JFileChooser.APPROVE_OPTION) {
            File filePath = fileChooser.getSelectedFile();
            Globals.filePath = filePath.getAbsolutePath();
            Globals.fileExt = filePath.getAbsolutePath().substring(filePath.getAbsolutePath().lastIndexOf("."));
        }
    }
}
