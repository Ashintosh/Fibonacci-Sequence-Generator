package com.ANMProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class Calculation {

    public void Calculation() {
        Thread CalculationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                BigInteger num1 = BigInteger.valueOf(1), num2 = BigInteger.valueOf(1), num3;
                int printCount = 1;
                File saveFile = new File(Globals.filePath);
                try {
                    saveFile.mkdirs();
                    saveFile.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                try {
                    MainGUI GUI = new MainGUI();
                    PrintWriter writer = new PrintWriter(saveFile);
                    DecimalFormat df = new DecimalFormat("0.00");

                    writer.println(":START:");
                    while (!Globals.calcStop) {
                        num1 = num1.add(num2);

                        writer.println();
                        writer.println(num1);
                        writer.println();

                        num3 = num1;
                        num1 = num2;
                        num2 = num3;

                        printCount++;
                    }

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        CalculationThread.start();
    }
}
