package com.ANMProgramming;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        /* 1 + 1 = 2    num1(1) += num2(1); num1(1) = 2
        // 1 + 2 = 3    num3(0) = num1(2); num1(2) = num2(1); num2(1) = num3(2)
        // 2 + 3 = 5
        // 3 + 5 = 8
        // 5 + 8 = 13
        // 8 + 13 = 21 */
        BigInteger num1 = BigInteger.valueOf(1), num2 = BigInteger.valueOf(1), num3; // Creates int that can hold large numbers
        int printCount = 1;
        File file = new File("save.txt"); // Finds file named 'save.txt' from the .jar files directory
        try {
            file.mkdirs();
            file.createNewFile(); // Creates a file if it does not exist already
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            PrintWriter writer = new PrintWriter(file); // Method used to print numbers to the file
            writer.println(":START:");
            DecimalFormat df = new DecimalFormat("0.00"); // Changes the decimal format for the file size counter
            while (0 != 1) {
                num1 = num1.add(num2); // Adds the two numbers together in the fibonacci sequence
                if (file.length() / (1024 * 1024) < 1024)
                    System.out.println("Printing Fibonacci #" + printCount + " (File Size: " + df.format((double)file.length() / (1024 * 1024)) + " MB)");
                else if (file.length() / (1024 * 1024) >= 1024)
                    System.out.println("Printing Fibonacci #" + printCount + " (File Size: " + df.format((double)file.length() / (1024 * 1024 * 1024)) + " GB)");
                else
                    System.out.println("Printing Fibonacci #" + printCount + " (File Size: " + df.format((double)file.length() / (1024 * 1024 * 1024 * 1024)) + " TB)");
                writer.println();
                writer.println(num1);
                writer.println();

                ///////////////
                num3 = num1; ///////////////////////////////////////////////////////////////////////////////////////////////////////
                num1 = num2; // This is where the numbers are prepared for the next arithmetic sequence so the results are valid ///
                num2 = num3; ///////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////////////
                printCount++; // Adds the counter so the console will print the correct number it is on
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
