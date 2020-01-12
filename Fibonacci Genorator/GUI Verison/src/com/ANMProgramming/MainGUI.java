package com.ANMProgramming;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    public JButton btnBrowse = new JButton("Select Save File");
    public JButton btnStart = new JButton("Start");
    public JButton btnStop = new JButton("Stop");

    public MainGUI() {
        super("FibCal");
        setSize(600, 100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        Buttons();
    }

    public void Buttons() {
        // btnBrowse
        btnBrowse.addActionListener(Main::btnBrowse_Clicked);
        add(btnBrowse);

        // btnStart
        btnStart.addActionListener(Main::btnStart_Clicked);
        add(btnStart);

        // btnStop
        btnStop.addActionListener(Main::btnStop_Clicked);
        add(btnStop);
    }
}
